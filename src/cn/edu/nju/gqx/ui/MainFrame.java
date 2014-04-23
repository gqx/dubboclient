package cn.edu.nju.gqx.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

import cn.edu.nju.gqx.action.GprsAction;
import cn.edu.nju.gqx.bean.GprsBean;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MainFrame extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private int operationNum = 0;
	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JButton jButton2;
	private JButton jButton1;
	private JPanel jPanel2;
	private JScrollPane jScrollPane2;
	private JLabel jLabel1;
	private JComboBox jComboBox1;
	private JPanel jPanel1;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem closeFileMenuItem;
	private JMenuItem saveAsMenuItem;
	private JMenuItem saveMenuItem;
	private JMenuItem openFileMenuItem;
	private JMenuItem newFileMenuItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
//	private JButton selectGprsButton;
	private String[] gprsName;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MainFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		initDate();
		this.addWindowListener(new CloseHandler());
		try {
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				jPanel1.setBackground(new java.awt.Color(192,192,192));
				{
					jScrollPane2 = new JScrollPane();
					jPanel1.add(jScrollPane2);
					jScrollPane2.setBounds(24, 49, 762, 335);
					jScrollPane2.setBackground(new java.awt.Color(255,255,255));
					{
						jPanel2 = new JPanel();
						jPanel2.setLayout(null);
						jScrollPane2.setViewportView(jPanel2);
						jPanel2.setBackground(new java.awt.Color(0,128,0));
						jPanel2.setPreferredSize(new java.awt.Dimension(631, 325));
						{
							jButton1 = new JButton();
							jPanel2.add(jButton1);
							jButton1.setText("A");
							jButton1.setBounds(60, 66, 73, 30);
							jButton1.addActionListener(new OperationListener());
						}
						{
							jButton2 = new JButton();
							jPanel2.add(jButton2);
							jButton2.setText("B");
							jButton2.setBounds(234, 66, 73, 30);
							jButton2.addActionListener(new OperationListener());
						}
//						{
//							jButton1 = new JButton();
//							jPanel2.add(jButton1);
//							jButton1.setText("A1");
//							jButton1.setBounds(17, 27, 62, 24);
//							jButton1.setOpaque(false);
//							jButton1.setContentAreaFilled(false);
//							jButton1.setBorder(null);
//							jButton1.addActionListener(new OperationListener());
//						}
//						{
//							jButton2 = new JButton();
//							jPanel2.add(jButton2);
//							jButton2.setText("A2");
//							jButton2.setBounds(17, 62, 62, 24);
//							jButton2.setOpaque(false);
//							jButton2.setContentAreaFilled(false);
//							jButton2.setBorder(null);
//							jButton2.addActionListener(new OperationListener());
//						}
					}
				}
//				{
//					ComboBoxModel jComboBox1Model = 
//							new DefaultComboBoxModel(gprsName);
//					jComboBox1 = new JComboBox();
//					jPanel1.add(jComboBox1);
//					jComboBox1.setModel(jComboBox1Model);
//					jComboBox1.setBounds(93, 12, 43, 24);
//				}
//				{
//					jLabel1 = new JLabel();
//					jPanel1.add(jLabel1);
//					jLabel1.setText("gprs名称");
//					jLabel1.setBounds(30, 16, 58, 17);
//				}
//				{
//					selectGprsButton = new JButton();
//					jPanel1.add(selectGprsButton);
//					selectGprsButton.setText("选择gprs");
//					selectGprsButton.setBounds(147, 12, 81, 24);
//					selectGprsButton.addActionListener(new ChangeGprsListener());
//				}
			}
			this.setSize(830, 495);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("File");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("添加gprs");
						newFileMenuItem.addActionListener(new AddGrpsListener());
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("Open");
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
						saveMenuItem.setText("Save");
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
						saveAsMenuItem.setText("Save As ...");
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
						closeFileMenuItem.setText("Close");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Edit");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("批量操作");
						cutMenuItem.addActionListener(new Editlistener());
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("查看温湿度");
						copyMenuItem.addActionListener(new ViewDatalistener());
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Paste");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Delete");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Help");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initDate(){
		GprsAction gprsAction = new GprsAction();
		ArrayList<GprsBean> gprsList = (ArrayList<GprsBean>) gprsAction.getAllGprsBeans();
		if(gprsList != null){
			gprsName = new String[gprsList.size()];
			for(int i = 0;i < gprsList.size();i++){

				gprsName[i] = gprsList.get(i).getName();
			}
		}
	
	}
	
	class EditActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					
				}
			});
		}
	}
	
	class OffActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
	}
	
	class OperationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			final String itemName = e.getActionCommand(); 
			System.out.println("itemName:"+itemName);
			
//			OperationFrame opFrame = new OperationFrame(itemName);
//			opFrame.setLocationRelativeTo(null);
//			opFrame.setVisible(true);
			
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					//选择每块地的具体图像
					if(itemName.equals("A")){
						Gprs1Frame inst = Gprs1Frame.getInstance();
//						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}else if(itemName.equals("B")){
						Gprs2Frame inst = Gprs2Frame.getInstance();
//						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				}
			});
		}
	}

	/**
	 * 关闭主窗口处理
	 */
	protected class CloseHandler extends WindowAdapter {
		public void windowClosing(final WindowEvent e) {
			int option = JOptionPane.showConfirmDialog(MainFrame.this, "确定退出系统?", "提示",
					JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				if (e.getWindow() == MainFrame.this) {
					
					
					
					MainFrame.this.dispose();
					System.exit(0);
				} else {
					return;
				}
			} else if (option == JOptionPane.NO_OPTION) {
				if (e.getWindow() == MainFrame.this) {
					return;
				}
			}
		}
	}
	
	class AddGrpsListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					AddNewGprsFrame inst = new AddNewGprsFrame();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
			});
		}
		
	}
	
	class Editlistener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					EditFrame inst = EditFrame.getInstance();
					inst.setVisible(true);
				}
			});
		}	
	}
	
	class ViewDatalistener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					ViewDataFrame inst =ViewDataFrame.getInstance();
					inst.setVisible(true);
				}
			});
		}		
	}
	
//	class ChangeGprsListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			final String name = (String) jComboBox1.getSelectedItem();
//			
//				SwingUtilities.invokeLater(new Runnable() {
//					@Override
//					public void run() {
//						if(name.equals("A")){
//							
//						}else if(name.equals("B")){
////							System.out.println("select B");
//							
//						}
//						MainFrame.this.validate();
//					}
//				});	
//				
//			
//		}
//	}
}
