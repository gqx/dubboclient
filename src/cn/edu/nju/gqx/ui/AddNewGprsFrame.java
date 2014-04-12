package cn.edu.nju.gqx.ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import cn.edu.nju.gqx.action.AddGprsNameAction;


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
public class AddNewGprsFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton confirmButton;
	private JLabel jLabel2;
	private JTextField gprsNameText;
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddNewGprsFrame inst = new AddNewGprsFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AddNewGprsFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setPreferredSize(new java.awt.Dimension(422, 179));
				jPanel1.setLayout(null);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("gprs\u540d\u79f0\uff1a");
					jLabel1.setBounds(35, 32, 63, 17);
				}
				{
					gprsNameText = new JTextField();
					jPanel1.add(gprsNameText);
					gprsNameText.setBounds(127, 29, 212, 24);
				}
				{
					confirmButton = new JButton();
					jPanel1.add(confirmButton);
					confirmButton.setText("\u786e\u8ba4");
					confirmButton.setBounds(153, 96, 57, 24);
					confirmButton.addActionListener(new ConfirmListener());
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u8bf7\u586b\u5199gprs\u540d\u79f0");
					jLabel2.setBounds(127, 60, 212, 17);
					jLabel2.setForeground(new java.awt.Color(255,0,0));
				}
			}
			pack();
			this.setSize(395, 182);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	class ConfirmListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					String name = gprsNameText.getText();
					if(name != ""){
						AddGprsNameAction action = new AddGprsNameAction();
						boolean result = action.addNewGprsName(name);
						if(result == true){
							jLabel2.setText("添加成功，请启动gprs");
						}else{
							jLabel2.setText("命名不正确");
						}
						
					}
				}
			});
			
			
		}
		
	}

}
