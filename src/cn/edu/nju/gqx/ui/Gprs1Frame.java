package cn.edu.nju.gqx.ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class Gprs1Frame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JButton jButton2;
	private JPanel jPanel2;
	private static Gprs1Frame frame;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Gprs1Frame inst = new Gprs1Frame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private Gprs1Frame() {
		super();
		initGUI();
	}
	
	public static Gprs1Frame getInstance(){
		if(frame == null){
			frame = new Gprs1Frame();
			frame.setLocationRelativeTo(null);
		}
		return frame;
	}
	
	private void initGUI() {
		try {
			setTitle("AµØ");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(27, 51, 752, 379);
					{
						jPanel2 = new JPanel();
						jScrollPane1.setViewportView(jPanel2);
						jPanel2.setLayout(null);
						jPanel2.setBackground(new java.awt.Color(0,128,0));
						{
							jButton1 = new JButton();
							jPanel2.add(jButton1);
							jButton1.setText("A-1-1");
							jButton1.setBounds(79, 56, 73, 30);
							jButton1.setOpaque(false);
							jButton1.setContentAreaFilled(false);
							jButton1.setBorder(null);
							jButton1.addActionListener(new OperationListener());
						}
						{
							jButton2 = new JButton();
							jPanel2.add(jButton2);
							jButton2.setText("A-1-2");
							jButton2.setBounds(79, 110, 73, 30);
							jButton2.setOpaque(false);
							jButton2.setContentAreaFilled(false);
							jButton2.setBorder(null);
							jButton2.addActionListener(new OperationListener());
						}

					}
				}
			}
			pack();
			this.setSize(830, 495);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	class OperationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			final String itemName = e.getActionCommand(); 
			System.out.println("itemName:"+itemName);
			
			OperationFrame opFrame = new OperationFrame(itemName);
			opFrame.setLocationRelativeTo(null);
			opFrame.setVisible(true);
			
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {

				}
			});
		}
	}

}
