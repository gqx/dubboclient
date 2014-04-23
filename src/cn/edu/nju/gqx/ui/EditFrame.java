package cn.edu.nju.gqx.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import cn.edu.nju.gqx.action.GprsAction;
import cn.edu.nju.gqx.action.SwitchAction;
import cn.edu.nju.gqx.action.TaskAction;
import cn.edu.nju.gqx.bean.GprsBean;
import cn.edu.nju.gqx.bean.ZigbeeBean;
import cn.edu.nju.gqx.db.po.Switch;

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
public class EditFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JButton offButton;
	private JButton onButton;
	private JButton refreshButton;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JComboBox offHourComboBox;
	private JLabel jLabel4;
	private JComboBox offMinuteComboBox;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JComboBox onMinuteComboBox;
	private JLabel jLabel1;
	private JComboBox onHourComboBox;
	private JButton jButton2;
	private JButton jButton1;
	private JTable jTable1;
	private String[][] tableData;
	private String[] gprsName;
	private ArrayList<GprsBean> gprsList;

	private String[] refreshButtonName = {"自动刷新","停止刷新"};
	private boolean refreshFlag = false;
	private boolean closeFlag = false;
	private static EditFrame frame;
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EditFrame inst = new EditFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	private EditFrame() {
		super();
		initGUI();
	}
	
	public static EditFrame getInstance(){
		if(frame == null){
			frame = new EditFrame();
			frame.setLocationRelativeTo(null);
		}
		return frame;
	}

	private void initGUI() {

		initData();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, "Center");
				jPanel1.setLayout(null);
				jPanel1.setBounds(0, 0, 814, 456);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(20, 49, 658, 395);
					{
						TableModel jTable1Model = new DefaultTableModel(tableData,
								new String[] { "gprs", "zigbee", "开关", "状态","任务",
										"选中" }) {
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setModel(jTable1Model);
						setTableCheckBox();
					}
				}
				{
					onButton = new JButton();
					jPanel1.add(onButton);
					onButton.setText("\u6253\u5f00\u5f00\u5173");
					onButton.setBounds(711, 60, 78, 24);
					onButton.addActionListener(new OnActionistener());
				}
				{
					offButton = new JButton();
					jPanel1.add(offButton);
					offButton.setText("\u5173\u95ed\u5f00\u5173");
					offButton.setBounds(711, 105, 78, 24);
					offButton.addActionListener(new OffActionistener());
				}
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("添加任务");
					jButton1.setBounds(510, 15, 81, 24);
					jButton1.addActionListener(new AddTaskListener());
				}
				{
					jButton2 = new JButton();
					jPanel1.add(jButton2);
					jButton2.setText("编辑任务");
					jButton2.setBounds(601, 15, 78, 24);
					jButton2.addActionListener(new EditTaskListener());
				}
				{
					String[] strs = new String[24];
					for(int i = 0;i < strs.length;i++){
						strs[i] = i+"";
					}
					ComboBoxModel jComboBox1Model = 
							new DefaultComboBoxModel(strs);
					onHourComboBox = new JComboBox();
					jPanel1.add(onHourComboBox);
					onHourComboBox.setModel(jComboBox1Model);
					onHourComboBox.setBounds(109, 14, 50, 24);
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("\u65f6\uff1a");
					jLabel1.setBounds(84, 17, 24, 17);
				}
				{
					String[] strs = new String[60];
					for(int i = 0;i < strs.length;i++){
						strs[i] = i+"";
					}
					ComboBoxModel jComboBox2Model = 
							new DefaultComboBoxModel(strs);
					onMinuteComboBox = new JComboBox();
					jPanel1.add(onMinuteComboBox);
					onMinuteComboBox.setModel(jComboBox2Model);
					onMinuteComboBox.setBounds(197, 14, 50, 24);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u5206\uff1a");
					jLabel2.setBounds(171, 17, 24, 17);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("\u5f00\u59cb\u65f6\u95f4");
					jLabel3.setBounds(22, 17, 48, 17);
				}
				{
					String[] strs = new String[60];
					for(int i = 0;i < strs.length;i++){
						strs[i] = i+"";
					}
					ComboBoxModel jComboBox3Model = 
							new DefaultComboBoxModel(strs);
					offMinuteComboBox = new JComboBox();
					jPanel1.add(offMinuteComboBox);
					offMinuteComboBox.setModel(jComboBox3Model);
					offMinuteComboBox.setBounds(444, 15, 50, 24);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("\u5206\uff1a");
					jLabel4.setBounds(419, 18, 24, 17);
				}
				{
					String[] strs = new String[24];
					for(int i = 0;i < strs.length;i++){
						strs[i] = i+"";
					}
					ComboBoxModel jComboBox4Model = 
							new DefaultComboBoxModel(strs);
					offHourComboBox = new JComboBox();
					jPanel1.add(offHourComboBox);
					offHourComboBox.setModel(jComboBox4Model);
					offHourComboBox.setBounds(357, 15, 50, 24);
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5);
					jLabel5.setText("\u65f6\uff1a");
					jLabel5.setBounds(333, 18, 24, 17);
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6);
					jLabel6.setText("\u7ed3\u675f\u65f6\u95f4");
					jLabel6.setBounds(271, 18, 48, 17);
				}
				{
					refreshButton = new JButton();
					jPanel1.add(refreshButton);
					refreshButton.setText(refreshButtonName[0]);
					refreshButton.setBounds(711, 15, 78, 24);
					refreshButton.addActionListener(new RefreshListener());
				}
			}
			pack();
			this.setSize(830, 495);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}

		Thread t = new Thread(new Runnable() {
			public void run() {
				while (closeFlag == false) {
					try {
						
						if(refreshFlag){
							updateTable();					
						}
						Thread.sleep(10 * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		t.start();
	}

	void initData() {
		GprsAction gprsAction = new GprsAction();
		gprsList = (ArrayList<GprsBean>) gprsAction.getAllGprsBeans();
		if (gprsList != null) {
			gprsName = new String[gprsList.size()];
			for (int i = 0; i < gprsList.size(); i++) {

				gprsName[i] = gprsList.get(i).getName();
			}
		}

		// ZigbeeAction action = new ZigbeeAction();

		// ArrayList<ZigbeeBean> zigbeeList = (ArrayList<ZigbeeBean>)
		// action.getAll();
		// System.out.println("size: "+zigbeeList.size());
		// if(zigbeeList == null)
		// return;

		int switchNum = 0;
		for (GprsBean gprsbean : gprsList) {
			for (ZigbeeBean zigbee : gprsbean.getZigbeelist()) {
				switchNum += zigbee.getSwitchList().size();
			}
		}

		tableData = new String[switchNum][5];

		int i = 0;
		for (GprsBean gprsbean : gprsList) {
			for (ZigbeeBean zigbee : gprsbean.getZigbeelist()) {
				for (int j = 0; j < zigbee.getSwitchList().size(); j++) {
					tableData[i][0] = gprsbean.getName();
					tableData[i][1] = zigbee.getName();
					Switch s = (Switch) zigbee.getSwitchList().get(j);
					tableData[i][2] = s.getName();
					tableData[i][3] = s.getState() == 0 ? "关" : "开";
					tableData[i][4] = s.getTid()+"";
					i++;
				}
			}
		}
	}

	class OnActionistener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int[] selectRows = jTable1.getSelectedRows();
			for (int i = 0; i < selectRows.length; i++) {
				SwitchAction switchAction = new SwitchAction();
				switchAction.switchOn(tableData[selectRows[i]][2]);
			}
			updateTable();
		}
	}

	class OffActionistener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int[] selectRows = jTable1.getSelectedRows();
			for (int i = 0; i < selectRows.length; i++) {
				SwitchAction switchAction = new SwitchAction();
				switchAction.switchOff(tableData[selectRows[i]][2]);
			}
			updateTable();
		}
	}
	
	class AddTaskListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int[] selectRows = jTable1.getSelectedRows();
			final String[] snames = new String[selectRows.length];
			for (int i = 0; i < selectRows.length; i++) {
				snames[i] = tableData[selectRows[i]][2];
			}
			String onHour = (String)onHourComboBox.getSelectedItem();
			String onMinute = (String)onMinuteComboBox.getSelectedItem();
			String offHour = (String)offHourComboBox.getSelectedItem();
			String offMinute = (String)offMinuteComboBox.getSelectedItem();
			final String onTime = onHour+":"+onMinute;
			final String offTime = offHour+":"+offMinute;
				
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					AddTaskFrame inst = new AddTaskFrame();
					inst.setData(snames, onTime, offTime);
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
			});
			
			
			
		}
	}
	
	class EditTaskListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					EditTaskFrame inst = new EditTaskFrame();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
			});
		}
		
	}

	private void updateTable() {
		initData();
		TableModel jTable1Model = new DefaultTableModel(tableData, new String[] {
				"gprs","zigbee", "开关", "状态","任务", "选中" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		jTable1.setModel(jTable1Model);
		setTableCheckBox();
		jScrollPane1.validate();

	}

	private void setTableCheckBox() {
		jTable1.getColumnModel().getColumn(5)
				.setCellRenderer(new TableCellRenderer() {

					/*
					 * (non-Javadoc) 此方法用于向方法调用者返回某一单元格的渲染器（即显示数据的组建--或控件）
					 * 可以为JCheckBox JComboBox JTextArea 等
					 * 
					 * @see javax.swing.table.TableCellRenderer#
					 * getTableCellRendererComponent (javax.swing.JTable,
					 * java.lang.Object, boolean, boolean, int, int)
					 */
					@Override
					public Component getTableCellRendererComponent(
							JTable table, Object value, boolean isSelected,
							boolean hasFocus, int row, int column) {
						// 创建用于返回的渲染组件
						JCheckBox ck = new JCheckBox();
						// 使具有焦点的行对应的复选框选中
						ck.setSelected(isSelected);
						// 设置单选box.setSelected(hasFocus);
						// 使复选框在单元格内居中显示
						ck.setHorizontalAlignment((int) 0.5f);
						return ck;
					}
				});
	}
	
	private class RefreshListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String text = refreshButton.getText();
			if(text.endsWith(refreshButtonName[0])){
				//如果点击了“自动刷新”
				refreshButton.setText(refreshButtonName[1]);
				refreshFlag = true;
			}else{
				refreshButton.setText(refreshButtonName[0]);
				refreshFlag = false;
			}
		}	
	}
	
	/**
	 * 关闭主窗口处理
	 */
	protected class CloseHandler extends WindowAdapter {
		public void windowClosing(final WindowEvent e) {
			if (e.getWindow() == EditFrame.this) {
				closeFlag = true;
				EditFrame.this.dispose();
			}
			
		}
	}

}
