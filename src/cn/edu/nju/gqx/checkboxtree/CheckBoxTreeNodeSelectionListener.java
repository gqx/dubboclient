package cn.edu.nju.gqx.checkboxtree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.DefaultTreeModel;

public class CheckBoxTreeNodeSelectionListener extends MouseAdapter
{
	@Override
	public void mouseClicked(MouseEvent event)
	{	
		JTree tree = (JTree)event.getSource();
		int x = event.getX();
		int y = event.getY();
		int row = tree.getRowForLocation(x, y);
		TreePath path = tree.getPathForRow(row);
		if(path != null)
		{
			CheckBoxTreeNode node = (CheckBoxTreeNode)path.getLastPathComponent();
			if(node != null)
			{
				boolean isSelected = !node.isSelected();
				node.setSelected(isSelected);
				((DefaultTreeModel)tree.getModel()).nodeStructureChanged(node);
				expandAll(tree,path,true);
				
			}
		}
	}
	
	private void expandAll(JTree tree, TreePath parent, boolean expand) {
		System.out.println("path2:"+parent);
	     TreeNode node = (TreeNode) parent.getLastPathComponent();
	         if (node.getChildCount() > 0) {
	              for (Enumeration e = node.children(); e.hasMoreElements();) {
	                    TreeNode n = (TreeNode) e.nextElement();
	                     TreePath path = parent.pathByAddingChild(n);
	                      expandAll(tree, path, expand);
	                }
	          }
	      if (expand) {
	         tree.expandPath(parent);
	      } else {
	          tree.collapsePath(parent);
	     }
	} 
	
	public static void main(String[] args)  
    {  
        JFrame frame = new JFrame("CheckBoxTreeDemo");  
        frame.setBounds(200, 200, 400, 400);  
        JTree tree = new JTree();  
        CheckBoxTreeNode rootNode = new CheckBoxTreeNode("root");  
        CheckBoxTreeNode node1 = new CheckBoxTreeNode("node_1");  
        CheckBoxTreeNode node1_1 = new CheckBoxTreeNode("node_1_1");  
        CheckBoxTreeNode node1_2 = new CheckBoxTreeNode("node_1_2");  
        CheckBoxTreeNode node1_3 = new CheckBoxTreeNode("node_1_3");  
        node1.add(node1_1);  
        node1.add(node1_2);  
        node1.add(node1_3);  
        CheckBoxTreeNode node2 = new CheckBoxTreeNode("node_2");  
        CheckBoxTreeNode node2_1 = new CheckBoxTreeNode("node_2_1");  
        CheckBoxTreeNode node2_2 = new CheckBoxTreeNode("node_2_2");  
        node2.add(node2_1);  
        node2.add(node2_2);  
        rootNode.add(node1);  
        rootNode.add(node2);  
        for(int i=0;i < 20;i++){
        	CheckBoxTreeNode node2_21 = new CheckBoxTreeNode("node_2_2"+i); 
        	 node2.add(node2_21);
        }
        DefaultTreeModel model = new DefaultTreeModel(rootNode);  
        tree.addMouseListener(new CheckBoxTreeNodeSelectionListener());  
        tree.setModel(model);  
        tree.setCellRenderer(new CheckBoxTreeCellRenderer());  
        JScrollPane scroll = new JScrollPane(tree);  
        scroll.setBounds(0, 0, 300, 320);  
        frame.getContentPane().add(scroll);  
          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setVisible(true);  
    }  
}

