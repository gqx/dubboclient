package cn.edu.nju.gqx.ui;
import java.awt.BorderLayout;

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
public class Gprs2Frame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JPanel jPanel2;
	private static Gprs2Frame frame;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Gprs2Frame inst = new Gprs2Frame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private Gprs2Frame() {
		super();
		initGUI();
	}
	
	public static Gprs2Frame getInstance(){
		if(frame == null){
			frame = new Gprs2Frame();
			frame.setLocationRelativeTo(null);
		}
		return frame;
	}
	
	private void initGUI() {
		try {
			setTitle("BµØ");
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

}
