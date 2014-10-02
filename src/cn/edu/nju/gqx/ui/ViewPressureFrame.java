package cn.edu.nju.gqx.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.edu.nju.gqx.action.PressureAction;
import cn.edu.nju.gqx.action.ZigbeeAction;
import cn.edu.nju.gqx.db.po.Pressure;
import cn.edu.nju.gqx.db.po.Switch;
import cn.edu.nju.gqx.util.AttributeName;

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
public class ViewPressureFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton refreshButton;
	private JButton selectButton;
	private JComboBox jComboBox1;
	private String[] tableHeader = { "序号", "时间", "压力值" };
	private String[][] tableData;
	private String selectedName;
	private String[] comboxData;
	private ArrayList<Switch> switchList;
	private ArrayList<Pressure> pressureList;

	private static ViewPressureFrame frame;
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewPressureFrame inst = new ViewPressureFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public static ViewPressureFrame getInstance(){
		if(frame == null){
			frame = new ViewPressureFrame();
		}
		return frame;
	}
	
	private ViewPressureFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		initComboxData();
		initTableData();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				AnchorLayout jPanel1Layout = new AnchorLayout();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(jPanel1Layout);
				{
					refreshButton = new JButton();
					jPanel1.add(refreshButton, new AnchorConstraint(75, 931,
							152, 804, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					refreshButton.setText("\u5237\u65b0");
					refreshButton.setPreferredSize(new java.awt.Dimension(55,
							24));
					refreshButton.addActionListener(new RefreshListener());
				}
				{
					selectButton = new JButton();
					jPanel1.add(selectButton, new AnchorConstraint(75, 596,
							152, 452, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					selectButton.setText("\u9009\u62e9");
					selectButton
							.setPreferredSize(new java.awt.Dimension(62, 24));
					selectButton.addActionListener(new SelectListener());
				}
				{
					ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
							comboxData);
					jComboBox1 = new JComboBox();
					jPanel1.add(jComboBox1, new AnchorConstraint(72, 410, 149,
							61, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jComboBox1.setModel(jComboBox1Model);
					jComboBox1
							.setPreferredSize(new java.awt.Dimension(151, 24));
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1, new AnchorConstraint(209, 940,
							963, 61, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(380,
							235));
					{
						TableModel jTable1Model = new DefaultTableModel(
								tableData, tableHeader);
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setModel(jTable1Model);
					}
				}
			}
			pack();
			this.setSize(502, 351);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void initComboxData() {
		ZigbeeAction action = new ZigbeeAction();
		switchList = (ArrayList<Switch>) action
				.getSwitchesByZigbeeType(AttributeName.ZIGBEE_TYPE_PRESSURE_SENSOR);
		if (switchList != null) {
			comboxData = new String[switchList.size()];
			for (int i = 0; i < switchList.size(); i++) {
				comboxData[i] = switchList.get(i).getName();
			}
		}
	}

	private void initTableData() {
		if(switchList == null || switchList.size() == 0)
			return;
		
		int sid = switchList.get(0).getId();
		if(jComboBox1 != null){
			sid = switchList.get(jComboBox1.getSelectedIndex()).getId();
		}
	

		PressureAction action = new PressureAction();
		pressureList = action.getPressureBySid(sid);

		if (pressureList != null) {
			tableData = new String[pressureList.size()][3];
			for (int i = 0; i < pressureList.size(); i++) {
				tableData[i][0] = i + 1 + "";
				tableData[i][1] = pressureList.get(i).getUpdate_time() + "";
				tableData[i][2] = pressureList.get(i).getPvalue() + "";
			}
		}

	}

	class SelectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					initComboxData();
					initTableData();
					updateTable();
				}
			});			
		}	
	}
	
	class RefreshListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					initComboxData();
					initTableData();
					updateTable();
				}
			});
		}	
	}
	
	private void updateTable(){
		TableModel jTable1Model = new DefaultTableModel(tableData,
				tableHeader);
		jTable1.setModel(jTable1Model);
		jTable1.validate();
//		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
//		tcr.setHorizontalAlignment(JLabel.CENTER);
//		jTable1.setDefaultRenderer(Object.class, tcr);
	}
}
