package cn.edu.nju.gqx.ui;

import java.awt.BorderLayout;
import java.awt.Component;
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
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import cn.edu.nju.gqx.action.TurnAction;
import cn.edu.nju.gqx.db.po.Turngroup;
import cn.edu.nju.gqx.db.po.Turntask;

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
public class GroupTaskFrame extends javax.swing.JFrame {

	private static GroupTaskFrame frame = null;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JLabel taskLabel;
	private JButton refreshButton;
	private JButton selectButton;
	private JButton stopButton;
	private JButton resumeButton;
	private JButton startButton;
	private JComboBox jComboBox1;
	private JTable jTable1;
	private String[] tableHeader = { "轮灌组编号", "工作支管编号", "开始时间","结束时间","持续时间", "工作状态" };
	private String[][] tableData;
	private String[] sysnames;
	private String selectedSysname = "all";
	private final String defaultSysname = "全部任务";
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GroupTaskFrame inst = new GroupTaskFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public static GroupTaskFrame getInstance() {
		if (frame == null) {
			frame = new GroupTaskFrame();
		}

		return frame;
	}

	public GroupTaskFrame() {
		super();
		initGUI();
	}

	private void initGUI() {
		initTableData("all");
		initComboxData();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().add(getJPanel1(), BorderLayout.CENTER);
			pack();
			setSize(1000, 650);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}

	}
	
	private void initComboxData(){
		TurnAction action = new TurnAction();
		sysnames = action.getSysnames();
	}
	
	private void initTableData(String sysname) {
		TurnAction action = new TurnAction();
		ArrayList<Turntask> tasklist = action.getRunnableTurntaskBySysname(sysname);
		
		tableData = new String[tasklist.size()][6];
		for(int i = 0; i < tasklist.size();i++){
			Turntask turntask = tasklist.get(i);
			//if grpid == -1, it means that the group has no switches
			if(turntask.getGrpid() != -1){
				ArrayList<Turngroup> grouplist = action.getTurngroupByGrpid(turntask.getGrpid());
				StringBuilder switchNames = new StringBuilder();
				for(Turngroup tg : grouplist){
					switchNames.append(tg.getSname()+" | ");
				}
				
				tableData[i][0] = turntask.getSysname()+turntask.getTtname();
				tableData[i][1] = switchNames.toString();
				tableData[i][2] = turntask.getStart_time();
				tableData[i][3] = turntask.getEnd_time();
				tableData[i][4] = turntask.getDuration();
				tableData[i][5] = turntask.getState() == 1?"运行":"停止";
				
			}
		}
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			AnchorLayout jPanel1Layout = new AnchorLayout();
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.add(getTaskLabel(), new AnchorConstraint(41, 68, 69, 26,
					AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL,
					AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			jPanel1.add(getSelectButton(), new AnchorConstraint(35, 422, 76, 333, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			jPanel1.add(getStartButton(), new AnchorConstraint(35, 579, 76, 478, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			jPanel1.add(getJComboBox1(), new AnchorConstraint(35, 316, 74, 72,
					AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL,
					AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			jPanel1.add(getJScrollPane1(), new AnchorConstraint(110, 979, 963,
					17, AnchorConstraint.ANCHOR_REL,
					AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL,
					AnchorConstraint.ANCHOR_REL));
			jPanel1.add(getJButton1(), new AnchorConstraint(35, 709, 76, 609, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			jPanel1.add(getJButton1x(), new AnchorConstraint(35, 842, 76, 738, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
			jPanel1.add(getJButton1xx(), new AnchorConstraint(35, 979, 76, 875, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
		}
		return jPanel1;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setPreferredSize(new java.awt.Dimension(946, 521));
			jScrollPane1.setViewportView(getJTable1());
		}
		return jScrollPane1;
	}

	private JTable getJTable1() {
		if (jTable1 == null) {
			TableModel jTable1Model = new DefaultTableModel(tableData,
					tableHeader);
			jTable1 = new JTable();
			jTable1.setModel(jTable1Model);
			
			setTableColumAndRow();			
		}
		return jTable1;
	}
	
	private void setTableColumAndRow(){
		jTable1.setRowHeight(30);
		jTable1.setAutoscrolls(true);
		TableColumn column1 = jTable1.getColumnModel().getColumn(0);
		column1.setPreferredWidth(128);
		// column1.setMaxWidth(100);
		// column1.setMinWidth(100);

		TableColumn column2 = jTable1.getColumnModel().getColumn(1);
		column2.setPreferredWidth(658);
		column2.setCellRenderer(new TextAreaCellRenderer());
		// column2.setMaxWidth(685);
		// column2.setMinWidth(685);

		TableColumn column3 = jTable1.getColumnModel().getColumn(2);
		column3.setPreferredWidth(60);
		// column3.setMaxWidth(80);
		// column3.setMinWidth(80);

		TableColumn column4 = jTable1.getColumnModel().getColumn(3);
		column4.setPreferredWidth(60);
		// column4.setMaxWidth(80);
		// column4.setMinWidth(80);
		
		TableColumn column5 = jTable1.getColumnModel().getColumn(4);
		column5.setPreferredWidth(60);
		
		TableColumn column6 = jTable1.getColumnModel().getColumn(5);
		column6.setPreferredWidth(60);
	}

	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(sysnames);
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(jComboBox1Model);
			jComboBox1.setPreferredSize(new java.awt.Dimension(240, 24));
			jComboBox1.setSelectedItem(defaultSysname);
		
		}
		return jComboBox1;
	}

	private JButton getStartButton() {
		if (startButton == null) {
			startButton = new JButton();
			startButton.setText("\u91cd\u65b0\u5f00\u59cb");
			startButton.setPreferredSize(new java.awt.Dimension(100, 25));
			startButton.addActionListener(new RestartListener());
		}
		return startButton;
	}

	private JButton getJButton1() {
		if (resumeButton == null) {
			resumeButton = new JButton();
			resumeButton.setText("\u7ee7\u7eed\u6267\u884c");
			resumeButton.setPreferredSize(new java.awt.Dimension(100, 25));
			resumeButton.addActionListener(new ResumeListener());
		}
		return resumeButton;
	}

	private JButton getJButton1x() {
		if (stopButton == null) {
			stopButton = new JButton();
			stopButton.setText("\u7ed3\u675f\u4efb\u52a1");
			stopButton.setPreferredSize(new java.awt.Dimension(100, 25));
			stopButton.addActionListener(new StopListener());
		}
		return stopButton;
	}

	private JButton getSelectButton() {
		if (selectButton == null) {
			selectButton = new JButton();
			selectButton.setText("\u9009\u62e9");
			selectButton.setPreferredSize(new java.awt.Dimension(87, 25));
			selectButton.addActionListener(new SelectListener());
		}
		return selectButton;
	}

	private JLabel getTaskLabel() {
		if (taskLabel == null) {
			taskLabel = new JLabel();
			taskLabel.setText("\u8f6e\u704c:");
			taskLabel.setPreferredSize(new java.awt.Dimension(41, 17));
		}
		return taskLabel;
	}
	
	private JButton getJButton1xx() {
		if(refreshButton == null) {
			refreshButton = new JButton();
			refreshButton.setText("刷新状态 ");
			refreshButton.setPreferredSize(new java.awt.Dimension(102, 25));
			refreshButton.addActionListener(new SelectListener());
		}
		return refreshButton;
	}

	//设置table行高自适应
	private class TextAreaCellRenderer extends JTextArea implements
			TableCellRenderer {

		public TextAreaCellRenderer() {
			setLineWrap(true);
			setWrapStyleWord(true);
		}

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			// 计算当下行的最佳高度
			int maxPreferredHeight = 0;
			for (int i = 0; i < table.getColumnCount(); i++) {
				setText("" + table.getValueAt(row, i));
				setSize(table.getColumnModel().getColumn(column).getWidth(), 0);
				maxPreferredHeight = Math.max(maxPreferredHeight,
						getPreferredSize().height);
			}

			if (table.getRowHeight(row) != maxPreferredHeight) // 少了这行则处理器瞎忙
				table.setRowHeight(row, maxPreferredHeight);

			setText(value == null ? "" : value.toString());
			return this;
		}
	}
	
	class SelectListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String selected = (String)jComboBox1.getSelectedItem();
			String sysname = selected.equals(defaultSysname)?"all":selected;
			
			initTableData(sysname);
			
			TableModel jTable1Model = new DefaultTableModel(tableData,
					tableHeader);
			jTable1.setModel(jTable1Model);
			setTableColumAndRow();	
			jTable1.validate();
			selectedSysname = selected;
		}
	}
	
	class RestartListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			TurnAction action = new TurnAction();
			String sysname = selectedSysname.equals(defaultSysname)?"all":selectedSysname;
			action.restartTaskBySysname(sysname);
			
		}
	}
	
	class ResumeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			TurnAction action = new TurnAction();
			String sysname = selectedSysname.equals(defaultSysname)?"all":selectedSysname;
			action.resumeTaskBySysname(sysname);
		}
	}
	
	class StopListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			TurnAction action = new TurnAction();
			String sysname = selectedSysname.equals(defaultSysname)?"all":selectedSysname;
			action.stopTaskBySysname(sysname);
		}
	}
	
}
