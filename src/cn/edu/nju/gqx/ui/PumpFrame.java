package cn.edu.nju.gqx.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import cn.edu.nju.gqx.action.SwitchAction;
import cn.edu.nju.gqx.action.ZigbeeAction;
import cn.edu.nju.gqx.bean.ZigbeeBean;
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
public class PumpFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JButton onButton;
	private JButton offButton;
	private JButton refreshButton;
	private JTable jTable1;
	private JLabel jLabel1;

	private String[] tableHeader = { "水泵", "状态", "选中" };
	private String[][] tableData;

	private static PumpFrame frame;
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PumpFrame inst = new PumpFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	private PumpFrame() {
		super();
		initGUI();
	}
	
	public static PumpFrame getInstance(){
		if(frame == null){
			frame = new PumpFrame();
		}
		return frame;
	}

	private void initGUI() {
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
					jPanel1.add(refreshButton, new AnchorConstraint(216, 965,
							308, 810, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					refreshButton.setText("\u5237\u65b0");
					refreshButton.setPreferredSize(new java.awt.Dimension(83,
							24));
					refreshButton.addActionListener(new RefreshListener());
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1, new AnchorConstraint(216, 776,
							955, 55, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jScrollPane1.setPreferredSize(new java.awt.Dimension(386,
							193));
					{
						TableModel jTable1Model = new DefaultTableModel(
								tableData, tableHeader){
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};;
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setModel(jTable1Model);
						setTableCheckBox();
						DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
						tcr.setHorizontalAlignment(JLabel.CENTER);
						jTable1.setDefaultRenderer(Object.class, tcr);
					}
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(70, 688, 136,
							361, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("水泵控制界面");
					jLabel1.setPreferredSize(new java.awt.Dimension(175, 17));
				}
				{
					onButton = new JButton();
					jPanel1.add(onButton, new AnchorConstraint(408, 965, 500,
							810, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					onButton.setText("\u6253\u5f00");
					onButton.setPreferredSize(new java.awt.Dimension(83, 24));
					onButton.addActionListener(new OnListener());
				}
				{
					offButton = new JButton();
					jPanel1.add(offButton, new AnchorConstraint(591, 965,
							683, 810, AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL,
							AnchorConstraint.ANCHOR_REL));
					offButton.setText("\u5173\u95ed");
					offButton.setPreferredSize(new java.awt.Dimension(83, 24));
					offButton.addActionListener(new OffListener());
				}
			}
			pack();
			this.setSize(551, 300);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void initTableData(){
		ZigbeeAction action = new ZigbeeAction();
		ArrayList<Switch> beanlist = (ArrayList<Switch>) action.getSwitchesByZigbeeType(AttributeName.ZIGBEE_TYPE_WATER_PUMP);
		
		if(beanlist != null){
			tableData = new String[beanlist.size()][3];
			for(int i = 0;i < beanlist.size();i++){
				Switch s = beanlist.get(i);
				tableData[i][0] = s.getName();
				tableData[i][1] = s.getState() == 0?"关":"开";
			}
		}
		
			
	}

	private void setTableCheckBox() {
		jTable1.getColumnModel().getColumn(2)
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
	
	class OnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int[] selectRows = jTable1.getSelectedRows();
			for (int i = 0; i < selectRows.length; i++) {
				SwitchAction switchAction = new SwitchAction();
				switchAction.switchOn(tableData[selectRows[i]][0]);
			}
			updateTable();
		}
	}
	
	class OffListener implements ActionListener{
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
	
	private void updateTable(){
		initTableData();
		TableModel jTable1Model = new DefaultTableModel(
				tableData, tableHeader){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	
		jTable1.setModel(jTable1Model);
		setTableCheckBox();
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		jTable1.setDefaultRenderer(Object.class, tcr);
	}
	
	class RefreshListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					updateTable();
				}
			});
			
		}	
	}
	
}
