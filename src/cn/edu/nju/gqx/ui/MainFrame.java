package cn.edu.nju.gqx.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import org.dom4j.Element;
import cn.edu.nju.gqx.action.TurnAction;
import cn.edu.nju.gqx.bean.MapAttributeBean;
import cn.edu.nju.gqx.util.XmlUtil;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

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

	private JPanel jPanel2;
	private JScrollPane jScrollPane2;
	private JPanel jPanel1;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem viewPressureMenuItem;
	private JMenuItem viewPumpMenuItem;
	private JMenuItem viewTurnMenuItem;
	private JMenuItem viewDataMenuItem;
	private JMenuItem editMenuItem;
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
	
	private boolean infoFlag = true;
	
	
//	private JButton selectGprsButton;
	private HashMap<String,MapAttributeBean> mapAttrBeanMap = new HashMap<String,MapAttributeBean>();

	private ArrayList<JButton> buttonList = new ArrayList<JButton>();
	private HashMap<String,JLabel> inforLabelMap = new HashMap<String, JLabel>();
	
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
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(infoFlag){
					try {
						Thread.sleep(1000*2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					refreshSystemState();		
				}
			}
		});
		t.start();
	}

	private void initGUI() {
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		{
			jPanel1 = new JPanel();
			getContentPane().add(jPanel1, BorderLayout.CENTER);
			AnchorLayout jPanel1Layout = new AnchorLayout();
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.setBackground(new java.awt.Color(192,192,192));
			
			{
				jScrollPane2 = new JScrollPane();
				jPanel1.add(jScrollPane2, new AnchorConstraint(27, 986, 873, 4, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jScrollPane2.setBackground(new java.awt.Color(255,255,255));
				jScrollPane2.setPreferredSize(new java.awt.Dimension(966, 548));
				{
					jPanel2 = new JPanel();
					jPanel2.setLayout(null);
					jScrollPane2.setViewportView(jPanel2);
					jPanel2.setBackground(new java.awt.Color(0,128,0));
					//						jPanel2.setPreferredSize(new java.awt.Dimension(1000, 1000));
					
				}
			}

		}
		this.addWindowListener(new CloseHandler());
		try {
			this.setSize(1000, 708);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("文件");
					{
						newFileMenuItem = new JMenuItem();
						jMenu3.add(newFileMenuItem);
						newFileMenuItem.setText("添加gprs");
						newFileMenuItem.addActionListener(new AddGrpsListener());
					}
					{
						openFileMenuItem = new JMenuItem();
						jMenu3.add(openFileMenuItem);
						openFileMenuItem.setText("初始化轮灌任务");
						openFileMenuItem.addActionListener(new initTurnTaskListener());
					}
					{
						saveMenuItem = new JMenuItem();
						jMenu3.add(saveMenuItem);
//						saveMenuItem.setText("Save");
					}
					{
						saveAsMenuItem = new JMenuItem();
						jMenu3.add(saveAsMenuItem);
//						saveAsMenuItem.setText("Save As ...");
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
//						closeFileMenuItem.setText("Close");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
//						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
					}
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("界面");
					{
						editMenuItem = new JMenuItem();
						jMenu4.add(editMenuItem);
						editMenuItem.setText("开关列表");
						editMenuItem.addActionListener(new Editlistener());
					}
					{
						viewDataMenuItem = new JMenuItem();
						jMenu4.add(viewDataMenuItem);
						viewDataMenuItem.setText("查看温湿度");
						viewDataMenuItem.addActionListener(new ViewDatalistener());
					}
					{
						viewTurnMenuItem = new JMenuItem();
						jMenu4.add(viewTurnMenuItem);
						viewTurnMenuItem.setText("查看轮灌");
						viewTurnMenuItem.addActionListener(new ViewGoupTaskListener());
					}
					{
						viewPumpMenuItem = new JMenuItem();
						jMenu4.add(viewPumpMenuItem);
						viewPumpMenuItem.setText("查看水泵");
						viewPumpMenuItem.addActionListener(new ViePumpTaskListener());
					}
					{
						viewPressureMenuItem = new JMenuItem();
						jMenu4.add(viewPressureMenuItem);
						viewPressureMenuItem.setText("查看压力");
						viewPressureMenuItem.addActionListener(new ViewPressureTaskListener());
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
//						deleteMenuItem.setText("Delete");
					}
				}
//				{
//					jMenu5 = new JMenu();
//					jMenuBar1.add(jMenu5);
//					jMenu5.setText("Help");
//					{
//						helpMenuItem = new JMenuItem();
//						jMenu5.add(helpMenuItem);
//						helpMenuItem.setText("Help");
//					}
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		initButtonByConfig();
	}
	
	private void initButtonByConfig(){
		Iterator<?> i = XmlUtil.readXml("map.xml");
		int height = 350;//在mainframe的地图的高
		int width = 455;//在mainframe的地图的宽
		final int widthInterval = 45;//左右两个地图间距
		final int heightInterval = 50;//上下两个地图间距
		int x = 0;
		int y = 0;
	
		
		int mapNum = 0;
		while (i.hasNext()) {
//			System.out.println("======");
			Element map = (Element) i.next();
			String id = map.attributeValue("id");
			height = Integer.parseInt(map.attributeValue("y"));
			width = Integer.parseInt(map.attributeValue("x"));
			String sysname = map.attributeValue("sysname");
			
			int iId = Integer.parseInt(id);
			x = (iId-1)%2 == 0?widthInterval: widthInterval*2+width;
			y = (iId-1)/2*(height+heightInterval)+5;
			String background = map.attributeValue("background");
			System.out.println(background);
			addMapPanel(id,sysname,x,y,width,height,background);	
			MapAttributeBean mb = new MapAttributeBean();
			mb.setMapId(id);
			mb.setSysname(sysname);
			mb.setXmlPath(map.attributeValue("xmlPath"));
			mb.setBgImgPath(background);
			mb.setRealHeight(Integer.parseInt(map.attributeValue("realHeight")));
			mb.setRealWidth(Integer.parseInt(map.attributeValue("realWidth")));
			mapAttrBeanMap.put(id, mb);
			mapNum ++;
		}
		
		int panelHeight = (mapNum+1)/2*(height+heightInterval);
		int panleWidth = (width+widthInterval)*2;
		jPanel2.setPreferredSize(new java.awt.Dimension(panleWidth, panelHeight));
	}
	
	private void addMapPanel(String id,String sysname,int x,int y,int width,int height,String background){
		JPanel jPanel = new JPanel();
		jPanel.setPreferredSize(new java.awt.Dimension(width, height+50));
		jPanel.setBounds(x, y, width, height+50);
		jPanel.setBackground(Color.WHITE);
		BoxLayout jPanelLayout = new BoxLayout(jPanel, javax.swing.BoxLayout.Y_AXIS);
		jPanel.setLayout(jPanelLayout);
		
		jPanel2.add(jPanel);

		JButton jButton = new JButton();
		jButton.setText(id);
		jButton.setBounds(x, y, width, height);
		Font f=new Font("Arial",Font.PLAIN,12);
		jButton.setBorder(null);
		jButton.setFont(f);
		jButton.addActionListener(new OperationListener());
		jButton.setBorderPainted(false);
		jButton.setContentAreaFilled(false);
		System.out.println("*"+background);
		ImageIcon icon=new ImageIcon(background);
		icon=new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		jButton.setIcon(icon);
		jPanel.add(jButton);
		buttonList.add(jButton);
		
		String blank ="                          ";
		JLabel label = new JLabel(blank+sysname);
		label.setPreferredSize(new java.awt.Dimension(width, 59));
//		label.setBounds(x, y, 897, 19);
		label.setBackground(Color.BLUE);
		jPanel.add(label);
		inforLabelMap.put(sysname, label);
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

			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					MapAttributeBean mb = mapAttrBeanMap.get(itemName);
					MapFrame mapFrame  = MapFrame.getInstance(mb.getXmlPath());
					mapFrame.setBackgroundImg(mb.getBgImgPath());System.out.println(mb.getBgImgPath());
					mapFrame.setIconHeight(mb.getRealHeight());System.out.println(mb.getRealHeight());
					mapFrame.setIconWidth(mb.getRealWidth());
					mapFrame.setLocationRelativeTo(null);
					mapFrame.setVisible(true);
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
					new TurnAction().stopTaskBySysname("all");
					infoFlag = false;
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
	
	class ViewGoupTaskListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					GroupTaskFrame inst =GroupTaskFrame.getInstance();
					inst.setVisible(true);
				}
			});
		}		
	}
	
	class initTurnTaskListener  implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			TurnAction action = new TurnAction();
			action.initTurnTask();
		}
	}
	
	class ViePumpTaskListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					PumpFrame inst =PumpFrame.getInstance();
					inst.setVisible(true);
				}
			});
		}
	}
	
	class ViewPressureTaskListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					ViewPressureFrame inst =ViewPressureFrame.getInstance();
					inst.setVisible(true);
				}
			});
		}
	}
	
	//系统状态
	private void refreshSystemState(){
		TurnAction action = new TurnAction();
		
		Iterator<String> i = inforLabelMap.keySet().iterator();
		while(i.hasNext()){
			String sysname = (String) i.next();
			String[][] state = action.getSystemStateBySysname(sysname);
			if(state != null){
				JLabel label = inforLabelMap.get(sysname);
				label.setText(state[0][0]);
				label.setForeground(state[0][1].equals("ok")?Color.black:Color.red);
			}
		}
	}
}
