package cn.edu.nju.gqx.ui;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
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
public class NewJFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTable jTable1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewJFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(290, 256));
					{
						TableModel jTable1Model = 
								new DefaultTableModel(
										new String[][] { { "One", "Two" }, { "Three", "Four" },{ "Three", "Four" } },
										new String[] { "Column 1", "Column 2" }){
							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}
						};
						jTable1 = new JTable();
						jScrollPane1.setViewportView(jTable1);
						jTable1.setModel(jTable1Model);
						jTable1.getColumnModel().getColumn(1)
						.setCellRenderer(new TableCellRenderer() {

							/*
							 * (non-Javadoc)
							 * �˷��������򷽷������߷���ĳһ��Ԫ�����Ⱦ��������ʾ���ݵ��齨--��ؼ���
							 * ����ΪJCheckBox JComboBox JTextArea ��
							 * 
							 * @see javax.swing.table.TableCellRenderer#
							 * getTableCellRendererComponent
							 * (javax.swing.JTable, java.lang.Object,
							 * boolean, boolean, int, int)
							 */
							@Override
							public Component getTableCellRendererComponent(
									JTable table, Object value,
									boolean isSelected,
									boolean hasFocus, int row,
									int column) {
								// �������ڷ��ص���Ⱦ���
								JCheckBox ck = new JCheckBox();
								// ʹ���н�����ж�Ӧ�ĸ�ѡ��ѡ��
								ck.setSelected(isSelected);
								// ���õ�ѡbox.setSelected(hasFocus);
								// ʹ��ѡ���ڵ�Ԫ���ھ�����ʾ
								ck.setHorizontalAlignment((int) 0.5f);
								return ck;
							}
						});
					}
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
