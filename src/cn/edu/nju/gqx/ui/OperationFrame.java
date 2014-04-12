package cn.edu.nju.gqx.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import cn.edu.nju.gqx.action.GetSwitchAction;
import cn.edu.nju.gqx.action.SwitchAction;
import cn.edu.nju.gqx.db.po.Switch;


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
public class OperationFrame extends javax.swing.JFrame {
	private String itemName;
	private Switch swc;
	private JPanel jPanel1;
	private JButton offButton;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton onButton;
	private JButton cancelButton;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				OperationFrame inst = new OperationFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public OperationFrame() {
		super();
		initGUI();
	}
	
	public OperationFrame(String itemName) {	
		super();
		this.itemName = itemName;
		swc = new GetSwitchAction().getSwitchBySid(itemName);
		initGUI();
	}
	
	private void initGUI() {
		this.addWindowListener(new CloseHandler());
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				{
					cancelButton = new JButton();
					jPanel1.add(cancelButton);
					cancelButton.setText("取消");
					cancelButton.setBounds(255, 150, 63, 24);
				}
				{
					offButton = new JButton();
					jPanel1.add(offButton);
					offButton.setText("关阀");
					offButton.setBounds(151, 150, 63, 24);
					offButton.addActionListener(new SwitchOffListener());
				}
				{
					onButton = new JButton();
					jPanel1.add(onButton);
					onButton.setText("开阀");
					onButton.setBounds(50, 150, 63, 24);
					onButton.addActionListener(new SwitchOnListener());
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("阀    状     态:");
					jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI",0,20));
					jLabel2.setBounds(50, 74, 132, 37);
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("正在操作的阀:");
					jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI",0,20));
					jLabel1.setBounds(50, 25, 132, 37);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText(this.itemName);
					jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI",0,20));
					jLabel3.setBounds(186, 25, 132, 37);
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText(swc.getState() == 1?"开":"关");
					jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI",0,20));
					jLabel4.setBounds(186, 74, 132, 37);
				}
			}
			pack();
			this.setSize(504, 258);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	/**
	 * 关闭主窗口处理
	 */
	protected class CloseHandler extends WindowAdapter {
		public void windowClosing(final WindowEvent e) {
			OperationFrame.this.dispose();
		}
	}
	
	private class SwitchOnListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwitchAction action = new SwitchAction();
			action.switchOn(itemName);
			swc = new GetSwitchAction().getSwitchBySid(itemName);
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					jLabel4.setText(swc.getState() == 1?"开":"关");
				}
			});
		}	
	}
	
	private class SwitchOffListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwitchAction action = new SwitchAction();
			action.switchOff(itemName);
			swc = new GetSwitchAction().getSwitchBySid(itemName);
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					jLabel4.setText(swc.getState() == 1?"开":"关");
				}
			});
		}	
	}
}
