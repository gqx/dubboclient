package cn.edu.nju.gqx.ui;

import java.awt.Dimension;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.JFrame;


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
public class Gprs1Panel extends javax.swing.JPanel {
	private JButton jButton1;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Gprs1Panel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public Gprs1Panel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setBackground(new java.awt.Color(0,128,0));
			setPreferredSize(new java.awt.Dimension(631, 325));
			this.setLayout(null);
			{
				jButton1 = new JButton();
				this.add(jButton1);
				jButton1.setText("jButton1");
				jButton1.setBounds(65, 41, 62, 24);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
