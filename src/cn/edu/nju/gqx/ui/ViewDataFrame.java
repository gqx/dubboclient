package cn.edu.nju.gqx.ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.edu.nju.gqx.action.GprsAction;
import cn.edu.nju.gqx.db.po.Gprs;
import cn.edu.nju.gqx.ui.MainFrame.CloseHandler;


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
public class ViewDataFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JButton refreshButton;
	private JTable jTable1;
	
	
	private String[][] tableData;
	private String[] refreshButtonName = {"自动刷新","停止刷新"};
	private String[] tableHead = new String[] { "GPRS", "温度", "湿度","电压" };
	private boolean refreshFlag = false;
	private boolean closeFlag = false;
	private static ViewDataFrame frame;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewDataFrame inst = new ViewDataFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private ViewDataFrame() {
		super();
		initGUI();
	}
	
	public static ViewDataFrame getInstance(){
		if(frame == null){
			frame = new ViewDataFrame();
			frame.setLocationRelativeTo(null);
		}
		return frame;
	}
	
	private void initGUI() {
		initData();
		try {
			this.addWindowListener(new CloseHandler());
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(38, 47, 607, 381);
					{
						TableModel jTable1Model = 
								new DefaultTableModel( tableData,tableHead);
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setModel(jTable1Model);
					}
				}
				{
					refreshButton = new JButton();
					jPanel1.add(refreshButton);
					refreshButton.setText("\u81ea\u52a8\u5237\u65b0");
					refreshButton.setBounds(680, 47, 88, 24);
					refreshButton.addActionListener(new RefreshListener());
				}
			}
			pack();
			setSize(830, 495);
		} catch (Exception e) {
		    //add your error handling code here
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
	
	private void initData(){
		GprsAction action = new GprsAction();
		ArrayList<Gprs> list = (ArrayList<Gprs>) action.getAllGprs();
		tableData = new String[list.size()][4];
		if(list != null){
			for(int i = 0;i < list.size();i++){
				Gprs g = list.get(i);
				tableData[i][0] = g.getName();
				tableData[i][1] = g.getTemperature()+"";
				tableData[i][2] = g.getHumidity()+"";
				tableData[i][3] = g.getVoltage()+"";
			}
		}
		
	}
	
	private void updateTable() {
		initData();
		TableModel jTable1Model = new DefaultTableModel(tableData, tableHead) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		jTable1.setModel(jTable1Model);
		jScrollPane1.validate();

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
			if (e.getWindow() == ViewDataFrame.this) {
				closeFlag = true;
				ViewDataFrame.this.dispose();
			}
			
		}
	}

}
