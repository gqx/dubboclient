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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.edu.nju.gqx.action.SwitchAction;
import cn.edu.nju.gqx.action.TaskAction;
import cn.edu.nju.gqx.db.po.Switch;
import cn.edu.nju.gqx.db.po.Task;
import cn.edu.nju.gqx.provider.TaskService;


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
public class EditTaskFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JLabel jLabel5;
	private JTable jTable1;
	private JLabel timeLabel;
	private JLabel jLabel7;
	private JButton okButton;
	private JButton deleteButton;
	private JButton editButton;
	private JLabel jLabel3;
	private JComboBox onHourComboBox;
	private JLabel jLabel8;
	private JLabel jLabel2;
	private JComboBox onMinuteComboBox;
	private JLabel jLabel6;
	private JComboBox offHourComboBox;
	private JLabel jLabel4;
	private JComboBox offMinuteComboBox;
	private JComboBox taskComboBox;
	private JLabel jLabel1;

	private String[] taskNameList;
	private ArrayList<Task> taskList;
	private String[][] tableList;
	private String timeStr;
	private int currentTid;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				EditTaskFrame inst = new EditTaskFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public EditTaskFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		initData();
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(35, 82, 661, 328);
					{
						TableModel jTable1Model = 
								new DefaultTableModel(
										tableList,
										new String[] { "任务编号", "开关" });
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setModel(jTable1Model);
					}
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("\u9009\u62e9\u4efb\u52a1\uff1a");
					jLabel1.setBounds(35, 17, 66, 17);
				}
				{
					ComboBoxModel taskComboBoxModel = 
							new DefaultComboBoxModel(taskNameList);
					taskComboBox = new JComboBox();
					jPanel1.add(taskComboBox);
					taskComboBox.setModel(taskComboBoxModel);
					taskComboBox.setBounds(101, 13, 237, 24);
				}
				{
					String[] strs = new String[60];
					for(int i = 0;i < strs.length;i++){
						strs[i] = i+"";
					}
					ComboBoxModel offMinuteComboBoxModel = 
							new DefaultComboBoxModel(strs);
					offMinuteComboBox = new JComboBox();
					jPanel1.add(offMinuteComboBox);
					offMinuteComboBox.setModel(offMinuteComboBoxModel);
					offMinuteComboBox.setBounds(517, 50, 50, 24);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("\u5206\uff1a");
					jLabel4.setBounds(494, 53, 24, 17);
				}
				{
					String[] strs = new String[24];
					for(int i = 0;i < strs.length;i++){
						strs[i] = i+"";
					}
					ComboBoxModel offHourComboBoxModel = 
							new DefaultComboBoxModel(strs);
					offHourComboBox = new JComboBox();
					jPanel1.add(offHourComboBox);
					offHourComboBox.setModel(offHourComboBoxModel);
					offHourComboBox.setBounds(429, 50, 50, 24);
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5);
					jLabel5.setText("\u65f6\uff1a");
					jLabel5.setBounds(407, 53, 24, 17);
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6);
					jLabel6.setText("\u7ed3\u675f\u65f6\u95f4");
					jLabel6.setBounds(345, 53, 48, 17);
				}
				{
					String[] strs = new String[60];
					for(int i = 0;i < strs.length;i++){
						strs[i] = i+"";
					}
					ComboBoxModel onMinuteComboBoxModel = 
							new DefaultComboBoxModel(strs);
					onMinuteComboBox = new JComboBox();
					jPanel1.add(onMinuteComboBox);
					onMinuteComboBox.setModel(onMinuteComboBoxModel);
					onMinuteComboBox.setBounds(268, 49, 50, 24);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u5206\uff1a");
					jLabel2.setBounds(246, 52, 24, 17);
				}
				{
					String[] strs = new String[24];
					for(int i = 0;i < strs.length;i++){
						strs[i] = i+"";
					}
					ComboBoxModel onHourComboBoxModel = 
							new DefaultComboBoxModel(strs);
					onHourComboBox = new JComboBox();
					jPanel1.add(onHourComboBox);
					onHourComboBox.setModel(onHourComboBoxModel);
					onHourComboBox.setBounds(184, 49, 50, 24);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("\u65f6\uff1a");
					jLabel3.setBounds(161, 53, 24, 17);
				}
				{
					editButton = new JButton();
					jPanel1.add(editButton);
					editButton.setText("\u786e\u5b9a\u4fee\u6539");
					editButton.setBounds(598, 51, 85, 24);
					editButton.addActionListener(new EditListener());
				}
				{
					deleteButton = new JButton();
					jPanel1.add(deleteButton);
					deleteButton.setText("\u5220\u9664\u4efb\u52a1");
					deleteButton.setBounds(598, 13, 85, 24);
					deleteButton.addActionListener(new DeleteListener());
				}
				{
					okButton = new JButton();
					jPanel1.add(okButton);
					okButton.setText("\u9009\u62e9");
					okButton.setBounds(344, 13, 76, 24);
					okButton.addActionListener(new SelectListener());
				}
				{
					jLabel7 = new JLabel();
					jPanel1.add(jLabel7);
					jLabel7.setText("\u7f16\u8f91\u4efb\u52a1\uff1a");
					jLabel7.setBounds(35, 53, 66, 17);
				}
				{
					timeLabel = new JLabel();
					jPanel1.add(timeLabel);
					timeLabel.setBounds(437, 16, 143, 17);
					timeLabel.setText(timeStr);
				}
				{
					jLabel8 = new JLabel();
					jPanel1.add(jLabel8);
					jLabel8.setText("\u5f00\u59cb\u65f6\u95f4");
					jLabel8.setBounds(105, 53, 48, 17);
				}
			}
			pack();
			setSize(830, 495);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	private void initData(){
		TaskAction action = new TaskAction();
		
		ArrayList<Task> tasks = (ArrayList<Task>) action.getAllTasks();
		taskList = tasks;
		if(tasks != null && tasks.size() != 0){
			//初始化任务列表
			 
			taskNameList = new String[tasks.size()];
			for(int i = 0;i < taskNameList.length;i++){
				taskNameList[i] = tasks.get(i).getTname();
			}
			
//			taskComboBox.setSelectedIndex(0);
			//初始化时间标签
			Task t = tasks.get(0);
			timeStr = "时间："+t.getStart_time()+"~"+t.getStop_time();
			//设置当前task的id
			currentTid = t.getId();
			//获得task对应的所有switch
			SwitchAction switchAction = new SwitchAction();
			ArrayList<Switch> switchList = (ArrayList<Switch>) switchAction.getSiwitchsByTid(t.getId());
			if(switchList == null || switchList.size() == 0){
				return;
			}
			
			tableList = new String[switchList.size()][2];
			for(int i = 0;i < switchList.size();i++){
				tableList[i][0] = t.getId()+"";
				tableList[i][1] = switchList.get(i).getName();
			}
			
		}else{
			taskNameList = new String[0];
		}	
	}
	
	private void updateData(){
		initData();
		jPanel1.remove(taskComboBox);
		ComboBoxModel taskComboBoxModel = 
				new DefaultComboBoxModel(taskNameList);
		taskComboBox = new JComboBox();
		jPanel1.add(taskComboBox);
		taskComboBox.setModel(taskComboBoxModel);
		taskComboBox.setBounds(101, 13, 237, 24);
		
		updateTable(currentTid);
		timeLabel.setText(timeStr);
		jPanel1.updateUI();
	}
	
	private void updateTable(int tid){
		SwitchAction switchAction = new SwitchAction();
		ArrayList<Switch> switchList = (ArrayList<Switch>) switchAction.getSiwitchsByTid(tid);
		if(switchList == null || switchList.size() == 0){
			tableList = new String[0][0];
		}else{
			tableList = new String[switchList.size()][2];
			for(int i = 0;i < switchList.size();i++){
				tableList[i][0] = tid+"";
				tableList[i][1] = switchList.get(i).getName();
			}
		}
			
		TableModel jTable1Model = 
				new DefaultTableModel(tableList,new String[] { "任务编号", "开关" });
		jTable1.setModel(jTable1Model);
		jTable1.validate();
		
	}
	
	private void updateTime(String onTime,String offTime){
		timeStr ="时间："+onTime+"~"+offTime;
		timeLabel.setText(timeStr);
	}
	
	private class SelectListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int tid = taskList.get(taskComboBox.getSelectedIndex()).getId();
			TaskAction action = new TaskAction();
			Task t = action.getTaskById(tid);
			currentTid = tid;
			updateTable(tid);
			updateTime(t.getStart_time(),t.getStop_time());
		}	
	}
	
	private class EditListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String onHour = (String)onHourComboBox.getSelectedItem();
			String onMinute = (String)onMinuteComboBox.getSelectedItem();
			String offHour = (String)offHourComboBox.getSelectedItem();
			String offMinute = (String)offMinuteComboBox.getSelectedItem();
			final String onTime = onHour+":"+onMinute;
			final String offTime = offHour+":"+offMinute;
			
			TaskAction action = new TaskAction();
			action.modifyTask(currentTid, onTime, offTime);
			//再次刷新界面
			updateTable(currentTid);
			updateTime(onTime,offTime);
			
		}	
	}
	
	private class DeleteListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TaskAction action  = new TaskAction();
			action.deleteTask(currentTid);
			
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					updateData();
				}
			});
		}		
	}
}
