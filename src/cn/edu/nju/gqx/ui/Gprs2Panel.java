package cn.edu.nju.gqx.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JFrame;

import cn.edu.nju.gqx.ui.MainFrame.OperationListener;


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
public class Gprs2Panel extends javax.swing.JPanel {
	private JButton jButton2;
	private JButton jButton1;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new Gprs2Panel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public Gprs2Panel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setBackground(new java.awt.Color(0,128,0));
			setPreferredSize(new java.awt.Dimension(631, 325));
			this.setLayout(null);
			{
				{
					jButton1 = new JButton();
					this.add(jButton1);
					jButton1.setText("A1");
					jButton1.setBounds(17, 27, 62, 24);
					jButton1.setOpaque(false);
					jButton1.setContentAreaFilled(false);
					jButton1.setBorder(null);
					jButton1.addActionListener(new OperationListener());
				}
				{
					jButton2 = new JButton();
					this.add(jButton2);
					jButton2.setText("A2");
					jButton2.setBounds(17, 62, 62, 24);
					jButton2.setOpaque(false);
					jButton2.setContentAreaFilled(false);
					jButton2.setBorder(null);
					jButton2.addActionListener(new OperationListener());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	class OperationListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String itemName = e.getActionCommand(); 
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
