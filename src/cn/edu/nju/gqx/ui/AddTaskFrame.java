package cn.edu.nju.gqx.ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import cn.edu.nju.gqx.action.TaskAction;


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
public class AddTaskFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField jTextField1;
	private JLabel jLabel1;

	private String[] snames;
	private String onTime;
	private String offTime;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddTaskFrame inst = new AddTaskFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AddTaskFrame() {
		super();
		initGUI();
	}
	
	public void setData(String[] snames,String onTime,String offTime){
		this.snames = snames;
		this.onTime = onTime;
		this.offTime = offTime;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				jPanel1.setPreferredSize(new java.awt.Dimension(371, 119));
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("\u4efb\u52a1\u540d\u79f0\uff1a");
					jLabel1.setBounds(47, 28, 60, 17);
				}
				{
					jTextField1 = new JTextField();
					jPanel1.add(jTextField1);
					jTextField1.setBounds(119, 26, 208, 24);
				}
				{
					okButton = new JButton();
					jPanel1.add(okButton);
					okButton.setText("\u786e\u5b9a");
					okButton.setBounds(88, 71, 62, 24);
					okButton.addActionListener(new OkListener());
				}
				{
					cancelButton = new JButton();
					jPanel1.add(cancelButton);
					cancelButton.setText("\u53d6\u6d88");
					cancelButton.setBounds(223, 71, 60, 24);
				}
			}
			pack();
			this.setSize(398, 158);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	private class OkListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String tname = jTextField1.getText();
			TaskAction taskAction = new TaskAction();
			taskAction.setClock(snames,tname, onTime, offTime);
			
			Thread t = new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(3 * 1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			t.start();
			
			AddTaskFrame.this.dispose();
		}	
	}
}
