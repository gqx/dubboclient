package cn.edu.nju.gqx.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.dom4j.Element;

import cn.edu.nju.gqx.action.GprsAction;
import cn.edu.nju.gqx.action.SwitchAction;
import cn.edu.nju.gqx.action.TurnAction;
import cn.edu.nju.gqx.bean.GprsBean;
import cn.edu.nju.gqx.bean.MapAttributeBean;
import cn.edu.nju.gqx.checkboxtree.CheckBoxTreeCellRenderer;
import cn.edu.nju.gqx.checkboxtree.CheckBoxTreeNode;
import cn.edu.nju.gqx.db.po.Switch;
import cn.edu.nju.gqx.util.XmlUtil;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MapFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JLabel taskTextLabel;
	private JLabel taskLabel;
	private JLabel switchNameTextLabel;
	private JLabel switchNameLabel;
	private JButton onButton;
	private JButton offButton;
	private JPanel jPanel2;
	private JButton refreshButton;

	private JTree tree;
	private ArrayList<String> gprsnames;
	private HashMap<String,CheckBoxTreeNode> gprsNodeMap = new HashMap<String,CheckBoxTreeNode>();
	private JButton stopGroupTaskButton;
	private JButton resumeGroupTaskButton;
	private JButton startGroupTaskButton;
	private HashMap<String,CheckBoxTreeNode> zigbeeNodeMap = new HashMap<String,CheckBoxTreeNode>();
	private HashMap<String,CheckBoxTreeNode> switchNodeMap = new HashMap<String,CheckBoxTreeNode>();

//	private HashMap<String,Switch> swithMap = new HashMap<String, Switch>();
	
	private ArrayList<JButton> buttonList = new ArrayList<JButton>();
	private Map<String,JButton> buttonMap = new HashMap<String,JButton>();
	private Border borderIn = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.black,Color.black, Color.black,Color.black); 
	private static MapFrame instance;
//	private static String xmlPath;
//	private static HashMap<String,String> pathlist = new HashMap<String, String>();
	private static MapAttributeBean mb;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MapFrame inst = new MapFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private MapFrame() {
		super();
//		pathlist.put("1", "button.xml");
//		pathlist.put("2", "button2.xml");
		initGUI();
	}
	
	public static MapFrame getInstance(MapAttributeBean mb){
//		MapFrame.xmlPath = xmlPath;	
		MapFrame.mb = mb;
		if(instance == null){
			instance = new MapFrame();
		}else{
			//repaint
			instance.dispose();
			instance = new MapFrame();
		}
		return instance;
	}
	
	private void initGUI() {
		System.out.println("initGUI");
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				AnchorLayout jPanel1Layout = new AnchorLayout();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBackground(new java.awt.Color(192,192,192));
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(getTaskTextLabel(), new AnchorConstraint(922, 501, 944, 440, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jPanel1.add(getTaskLabel(), new AnchorConstraint(922, 434, 945, 381, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jPanel1.add(getSwitchNameTextLabel(), new AnchorConstraint(922, 380, 944, 313, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jPanel1.add(getSwitchNameLabel(), new AnchorConstraint(923, 305, 945, 252, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jPanel1.add(jScrollPane2, new AnchorConstraint(89, 988, 882, 253, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jScrollPane2.setPreferredSize(new java.awt.Dimension(723, 535));
					{
						jPanel2 = new JPanel(){
							 @Override  
					            protected void paintComponent(Graphics g) {  
								    ImageIcon icon = new ImageIcon(mb.getBgImgPath());  
					                Image img = icon.getImage();
					                
//					                System.out.println("jpanel2"+icon.getIconWidth()+"  "+icon.getIconHeight());
					                g.drawImage(img, 0, 0, mb.getRealWidth(), mb.getRealHeight(), icon.getImageObserver());  
					             // 细致渲染、绘制背景，可控制截取图片，显示于指定的JPanel位置  
//					              g.drawImage(img, 0, 0, frameSize.width, frameSize.height,   
//					                          0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());  
					            this.setPreferredSize(new java.awt.Dimension(mb.getRealHeight(), mb.getRealHeight()));							 }
						};
						jPanel2.setBackground(new java.awt.Color(0,128,0));
						jPanel2.setLayout(null);
						jScrollPane2.setViewportView(jPanel2);
					}
				}
				{
					refreshButton = new JButton();
					jPanel1.add(refreshButton, new AnchorConstraint(24, 351, 70, 250, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					refreshButton.setText("\u5237\u65b0\u754c\u9762");
					refreshButton.setPreferredSize(new java.awt.Dimension(99, 31));
					refreshButton.addActionListener(new RefreshListener());
				}
				{
					onButton = new JButton();
					jPanel1.add(onButton, new AnchorConstraint(913, 97, 965, 12, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					onButton.setText("\u6253\u5f00");
					onButton.setPreferredSize(new java.awt.Dimension(83, 35));
					onButton.addActionListener(new OnListener());
				}
				{
					offButton = new JButton();
					jPanel1.add(offButton, new AnchorConstraint(913, 225, 965, 140, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					offButton.setText("\u5173\u95ed");
					offButton.setPreferredSize(new java.awt.Dimension(83, 35));
					offButton.addActionListener(new OffListener());
				}
			}
			pack();
			this.setSize(1000, 714);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		
		initButtonByConfig();
		initTree();
	}
	
	private void initTree(){
		ArrayList<GprsBean> gbeans = new ArrayList<GprsBean>();
		GprsAction action = new GprsAction();
		gbeans = (ArrayList<GprsBean>) action.getGprsBeans(gprsnames);
		
		tree = new JTree();  
        CheckBoxTreeNode rootNode = new CheckBoxTreeNode("所有");
        Iterator i = XmlUtil.readXml(mb.getTreeXmlPath());
    	while (i.hasNext()) {
//			System.out.println("======");
			Element eday = (Element) i.next();
			String day = "第"+eday.attributeValue("id")+"天";
			
			CheckBoxTreeNode dNode = new CheckBoxTreeNode(day);
			rootNode.add(dNode);
			
			Iterator igroup = eday.elementIterator();
			while(igroup.hasNext()){
				Element egroup = (Element) igroup.next();
				String group = "第"+egroup.attributeValue("id")+"组";
				
				CheckBoxTreeNode gNode = new CheckBoxTreeNode(group);
				dNode.add(gNode);
				
				Iterator iswitch = egroup.elementIterator();
				while(iswitch.hasNext()){
					Element eswitch = (Element) iswitch.next();
					String sname = eswitch.attributeValue("name");
					CheckBoxTreeNode sNode = new CheckBoxTreeNode(sname);
					gNode.add(sNode);
					switchNodeMap.put(sname, sNode);
				}
			}
    	}
			

        
        	
//        Iterator i = buttonMap.keySet().iterator();
//        while(i.hasNext()){
//        	String switchName = (String) i.next();
//        	CheckBoxTreeNode sNode = new CheckBoxTreeNode(switchName);
//			rootNode.add(sNode);
//			switchNodeMap.put(switchName, sNode);
//        }
	
        DefaultTreeModel model = new DefaultTreeModel(rootNode);  
        tree.addMouseListener(new TreeNodeListener());  
        tree.setModel(model);  
        tree.setCellRenderer(new CheckBoxTreeCellRenderer()); 
//        tree.setPreferredSize(new java.awt.Dimension(172, 438));
//		expandAll(tree,new TreePath(rootNode),true);
		jScrollPane1 = new JScrollPane(tree);
		jPanel1.add(jScrollPane1, new AnchorConstraint(89, 230, 882, 11, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		jPanel1.add(getStartGroupTaskButton(), new AnchorConstraint(914, 650, 965, 530, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		jPanel1.add(getResumeGroupTaskButton(), new AnchorConstraint(914, 800, 965, 680, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		jPanel1.add(getStopGroupTaskButton(), new AnchorConstraint(914, 950, 965, 830, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		jScrollPane1.setPreferredSize(new java.awt.Dimension(215, 535));

	}
	
/*	private void initTree(){
		ArrayList<GprsBean> gbeans = new ArrayList<GprsBean>();
		GprsAction action = new GprsAction();
		gbeans = (ArrayList<GprsBean>) action.getGprsBeans(gprsnames);
		
		tree = new JTree();  
        CheckBoxTreeNode rootNode = new CheckBoxTreeNode("root");
		
        	//gprsbean中包含zigbeebean,zigbeebean中包含switch，依次循环取出，并new出node
    		for(GprsBean gbean : gbeans){	
    			CheckBoxTreeNode gNode = new CheckBoxTreeNode(gbean.getName());
    			rootNode.add(gNode);
    			for(ZigbeeBean zbean: gbean.getZigbeelist()){
    				if(zbean.getZtype() == 0){
    					String zname = gbean.getName()+"-"+zbean.getName();
    					CheckBoxTreeNode zNode = new CheckBoxTreeNode(zname);
    					gNode.add(zNode);
    					zigbeeNodeMap.put(zname, zNode);
    					for(Switch s : (ArrayList<Switch>)zbean.getSwitchList()){
    						CheckBoxTreeNode sNode = new CheckBoxTreeNode(s.getName());
    						zNode.add(sNode);
    						switchNodeMap.put(s.getName(), sNode);
    					}
    				}
    				
    			}
    		}
		
        DefaultTreeModel model = new DefaultTreeModel(rootNode);  
        tree.addMouseListener(new TreeNodeListener());  
        tree.setModel(model);  
        tree.setCellRenderer(new CheckBoxTreeCellRenderer()); 
//        tree.setPreferredSize(new java.awt.Dimension(172, 438));
//		expandAll(tree,new TreePath(rootNode),true);
		jScrollPane1 = new JScrollPane(tree);
		jPanel1.add(jScrollPane1, new AnchorConstraint(89, 230, 882, 11, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		jScrollPane1.setPreferredSize(new java.awt.Dimension(215, 535));

	}
*/	
	private void expandAll(JTree tree, TreePath parent, boolean expand) {
//		System.out.println("path:"+parent);
	     TreeNode node = (TreeNode) parent.getLastPathComponent();
	         if (node.getChildCount() > 0) {
	              for (Enumeration e = node.children(); e.hasMoreElements();) {
	            	  CheckBoxTreeNode n = (CheckBoxTreeNode) e.nextElement();
	                     TreePath path = parent.pathByAddingChild(n);
	                     expandAll(tree, path, expand);
	                    //set button border
	                    //在选中父元素时，同时也选中了子元素
	                    boolean isSelected = n.isSelected();
	  					JButton button = buttonMap.get(n.getName());
	  					if(button != null)
	  						button.setBorder(isSelected?borderIn:null);
	  					
	  					
	                }
	          }
	      if (expand) {
	         tree.expandPath(parent);
	      } else {
	          tree.collapsePath(parent);
	     }
	}
	
	private void initButtonByConfig(){
		Iterator i = XmlUtil.readXml(mb.getXmlPath());
		final int lenght = 20;
		final int width = 35;
		int x = 0;
		int y = 0;
		String name = null;
		
		gprsnames = new ArrayList<String>();
		while (i.hasNext()) {
//			System.out.println("======");
			Element egprs = (Element) i.next();
//			System.out.println(egprs.attributeValue("name"));
			gprsnames.add(egprs.attributeValue("name"));
			Iterator iswitch = egprs.elementIterator();
			while(iswitch.hasNext()){
//				System.out.println("********");
				Element ezigbee = (Element) iswitch.next();
				name = ezigbee.attributeValue("name");
				x = Integer.parseInt(ezigbee.attributeValue("x"));
				y = Integer.parseInt(ezigbee.attributeValue("y"));
//				System.out.println(name+" "+x+" "+y);
				addButton(name,x,y,width,lenght);
				
			}
		}
	}
	
	private void addButton(String name,int x,int y,int width,int height){
		JButton jButton = new JButton();
		jPanel2.add(jButton);
		jButton.setText(name);
		jButton.setBounds(x, y, width, height);
		Font f=new Font("Arial",Font.PLAIN,9);
		jButton.setBorder(null);
		jButton.setFont(f);
		jButton.addActionListener(new OperationListener());
		jButton.addMouseListener(new MyMouseListener());
		
		SwitchAction action = new SwitchAction();
		Switch s = action.getSwitchByName(name);
		if(s.getState() == Switch.ON_STATE){
			jButton.setBackground(Color.green);
		}else{
			jButton.setBackground(Color.red);
		}
		buttonList.add(jButton);
		buttonMap.put(name, jButton);
	}
	
	class RefreshListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			for(JButton button : buttonList){
				SwitchAction action = new SwitchAction();
				Switch s = action.getSwitchByName(button.getText());
//				System.out.println(button.getText()+"  "+s.getName()+" "+s.getState());
				if(s.getState() == Switch.ON_STATE){
					button.setBackground(Color.green);
				}else{
					button.setBackground(Color.red);
				}
			}
		}
	}
	
	class OperationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			final String itemName = e.getActionCommand(); 
//			System.out.println("itemName:"+itemName);
			
			JButton button = (JButton)e.getSource();
			
			CheckBoxTreeNode node = switchNodeMap.get(itemName);
			
			if(node != null)
			{
				boolean isSelected = !node.isSelected();
				node.setSelected(isSelected);
				((DefaultTreeModel)tree.getModel()).nodeStructureChanged(node);
				CheckBoxTreeNode parentNode = (CheckBoxTreeNode) node.getParent();
				expandAll(tree, new TreePath(parentNode.getPath()), true);
				button.setBorder(isSelected?borderIn:null);
			}
		}
	}
	
	class OnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<String> list = getSelectedNodeName();
			SwitchAction action = new SwitchAction();
			action.switchesOn(list);
		}
	}
	
	class OffListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<String> list = getSelectedNodeName();
			SwitchAction action = new SwitchAction();
			action.switchesOff(list);
		}
	}
	
	//nodename 就是swith 的name，唯一标识switch
	private ArrayList<String> getSelectedNodeName(){
		ArrayList<String> list = new ArrayList<String>();
		Iterator iterator = switchNodeMap.keySet().iterator();
		while(iterator.hasNext()){
			String name = (String)iterator.next();
			if(switchNodeMap.get(name).isSelected()){
				list.add(name);
			}
		}
		return list;
	}
	
	private JLabel getSwitchNameLabel() {
		if(switchNameLabel == null) {
			switchNameLabel = new JLabel();
			switchNameLabel.setText("\u5f00\u5173\u540d\u79f0:");
			switchNameLabel.setPreferredSize(new java.awt.Dimension(52, 16));
			
			switchNameLabel.setTransferHandler(new TransferHandler("text"));
			MouseListener listener = new MouseAdapter() {  
                public void mousePressed(MouseEvent event) {  
                    JComponent comp = (JComponent)event.getSource();  
//                    System.out.println(11);
                    TransferHandler handler = comp.getTransferHandler();  
                    handler.exportAsDrag(comp, event, TransferHandler.COPY);  
                }  
            };
            switchNameLabel.addMouseListener(listener);
		}
		return switchNameLabel;
	}
	
	private JLabel getSwitchNameTextLabel() {
		if(switchNameTextLabel == null) {
			switchNameTextLabel = new JLabel();
			switchNameTextLabel.setText("jLabel1");
			switchNameTextLabel.setPreferredSize(new java.awt.Dimension(66, 15));
		}
		return switchNameTextLabel;
	}
	
	private JLabel getTaskLabel() {
		if(taskLabel == null) {
			taskLabel = new JLabel();
			taskLabel.setText("\u4efb\u52a1\u7f16\u53f7:");
			taskLabel.setPreferredSize(new java.awt.Dimension(52, 16));
		}
		return taskLabel;
	}
	
	private JLabel getTaskTextLabel() {
		if(taskTextLabel == null) {
			taskTextLabel = new JLabel();
			taskTextLabel.setText("jLabel1");
			taskTextLabel.setPreferredSize(new java.awt.Dimension(60, 15));
		}
		return taskTextLabel;
	}

	class TreeNodeListener extends  MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent event){
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
					
					//set button border
					JButton button = buttonMap.get(node.getName());
					if(button != null)
						button.setBorder(isSelected?borderIn:null);
				}
			}
			
		}
	}
	
	class MyMouseListener extends MouseAdapter {

		@Override
        public void mouseEntered(MouseEvent e) {
			 JButton button = (JButton) e.getSource();
			 String switchName = button.getText();
			 SwitchAction action = new SwitchAction();
			
			 Switch swc = action.getSwitchByName(switchName);
			 if(swc != null){
				 switchNameTextLabel.setText(swc.getName());
				 String turntaskName = new TurnAction().getTurnTaskNameBySwitchName(switchName);
				 if(turntaskName != null){
					 taskTextLabel.setText(turntaskName);
				 }else{
					 taskTextLabel.setText("无");
				 }
				 
			 }
			 
			 
//			 System.out.println(switchName);
        }

        @Override
        public void mouseExited(MouseEvent e) {
        
        }
		
	}

	public MapAttributeBean getMb() {
		return mb;
	}

	public void setMb(MapAttributeBean mb) {
		this.mb = mb;
	};
	
	private JButton getStartGroupTaskButton() {
		if(startGroupTaskButton == null) {
			startGroupTaskButton = new JButton();
			startGroupTaskButton.setText("\u4ece\u5934\u5f00\u59cb\u4efb\u52a1");
			startGroupTaskButton.setPreferredSize(new java.awt.Dimension(120, 36));
			startGroupTaskButton.addActionListener(new StartGroupTaskListener());
		}
		return startGroupTaskButton;
	}
	
	private JButton getResumeGroupTaskButton() {
		if(resumeGroupTaskButton == null) {
			resumeGroupTaskButton = new JButton();
			resumeGroupTaskButton.setText("\u4ece\u5f53\u524d\u5f00\u59cb\u4efb\u52a1");
			resumeGroupTaskButton.setPreferredSize(new java.awt.Dimension(120, 36));
			resumeGroupTaskButton.addActionListener(new ResumeGroupTaskListener());
		}
		return resumeGroupTaskButton;
	}
	
	private JButton getStopGroupTaskButton() {
		if(stopGroupTaskButton == null) {
			stopGroupTaskButton = new JButton();
			stopGroupTaskButton.setText("\u7ed3\u675f\u4efb\u52a1");
			stopGroupTaskButton.setPreferredSize(new java.awt.Dimension(120, 36));
			stopGroupTaskButton.addActionListener(new StopGroupTaskListener());
		}
		return stopGroupTaskButton;
	}

	private class StartGroupTaskListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			TurnAction action = new TurnAction();
			action.startTaskBySysname(mb.getSysname());
		}	
	}
	
	private class ResumeGroupTaskListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int option = JOptionPane.showConfirmDialog(MapFrame.this, "开启任务后请开启水泵！", "提示",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				TurnAction action = new TurnAction();
				action.resumeTaskBySysname(mb.getSysname());
			} else if (option == JOptionPane.NO_OPTION) {
				return;			
			}
		}	
	}
	
	private class StopGroupTaskListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int option = JOptionPane.showConfirmDialog(MapFrame.this, "请确保水泵已经关闭！", "提示",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				TurnAction action = new TurnAction();
				action.stopTaskBySysname(mb.getSysname());
			} else if (option == JOptionPane.NO_OPTION) {
				return;			
			}
		}	
	}
	
}
