package cn.edu.nju.gqx.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import cn.edu.nju.gqx.action.ZigbeeAction;
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
	private JLabel jLabel1;
	private JComboBox jComboBox1;
	private JButton selectGprsButton;
	private JTable jTable1;
	private String[][] data;
	private String[] gprsName;
	private ArrayList<GprsBean> gprsList;

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

	public EditFrame() {
		super();
		initGUI();
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
						TableModel jTable1Model = new DefaultTableModel(data,
								new String[] { "gprs", "zigbee", "开关", "状态",
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
					onButton.setText("\u6253\u5f00");
					onButton.setBounds(718, 51, 60, 24);
					onButton.addActionListener(new OnActionistener());
				}
				{
					offButton = new JButton();
					jPanel1.add(offButton);
					offButton.setText("\u5173\u95ed");
					offButton.setBounds(718, 97, 60, 24);
					offButton.addActionListener(new OffActionistener());
				}
				{
					selectGprsButton = new JButton();
					jPanel1.add(selectGprsButton);
					selectGprsButton.setText("选择gprs");
					selectGprsButton.setBounds(143, 12, 81, 24);
				}
				{
					ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
							new String[] { "Item One", "Item Two" });
					jComboBox1 = new JComboBox();
					jPanel1.add(jComboBox1);
					jComboBox1.setModel(jComboBox1Model);
					jComboBox1.setBounds(88, 12, 43, 24);
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("gprs名称");
					jLabel1.setBounds(25, 16, 58, 17);
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
				while (true) {
					try {
						Thread.sleep(10 * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					updateTable();
				}
			}
		});
		t.start();
	}

	void initData() {
		GprsAction gprsAction = new GprsAction();
		gprsList = (ArrayList<GprsBean>) gprsAction.getAllGprs();
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
		System.out.println("switchNum"+switchNum);
		for (GprsBean gprsbean : gprsList) {
			for (ZigbeeBean zigbee : gprsbean.getZigbeelist()) {
				switchNum += zigbee.getSwitchList().size();
			}
		}

		data = new String[switchNum][4];

		int i = 0;
		for (GprsBean gprsbean : gprsList) {
			for (ZigbeeBean zigbee : gprsbean.getZigbeelist()) {
				for (int j = 0; j < zigbee.getSwitchList().size(); j++) {
					data[i][0] = gprsbean.getName();
					data[i][1] = zigbee.getName();
					Switch s = (Switch) zigbee.getSwitchList().get(j);
					data[i][2] = s.getName();
					data[i][3] = s.getState() == 0 ? "关" : "开";
					i++;
				}
			}
		}

		for (String[] s : data) {
			System.out.println(s[0] + " " + s[1] + " " + s[2]);
		}
	}

	class OnActionistener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int[] selectRows = jTable1.getSelectedRows();
			for (int i = 0; i < selectRows.length; i++) {
				SwitchAction switchAction = new SwitchAction();
				switchAction.switchOn(data[selectRows[i]][2]);
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
				switchAction.switchOff(data[selectRows[i]][1]);
			}
			updateTable();
		}
	}

	private void updateTable() {
		initData();
		TableModel jTable1Model = new DefaultTableModel(data, new String[] {
				"gprs","zigbee", "开关", "状态", "选中" }) {
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
		jTable1.getColumnModel().getColumn(4)
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

}
