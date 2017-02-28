package ADF;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Fen3 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox;
	private JPanel panel_2;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;


	
	
	
	
	
	
	
	
	
	
	
	public Fen3(FenitrePrinc f ,Fen2 ff,Fen1 fff, Fen4 ffff) {

		setBounds(100, 100, 450, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.add(panel);
			JLabel lblAlphabetDeTransition = new JLabel("Alphabet de Transition");
			lblAlphabetDeTransition.setHorizontalAlignment(SwingConstants.LEFT);
			JLabel lblAjoutTransition = new JLabel("Ajout Transition");
			lblAjoutTransition.setHorizontalAlignment(SwingConstants.CENTER);
			lblAjoutTransition.setForeground(new Color(255, 0, 255));
			lblAjoutTransition.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			JButton button = new JButton("Valider");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					
					if (comboBox.getSelectedItem()== null ||  comboBox_1.getSelectedItem()== null || comboBox_2.getSelectedItem()== null){
						JOptionPane.showMessageDialog(null,"vous avez oublié de selectionner une de tous les champs ");
					}else {
				  int nC=f.table.getModel().getColumnCount();
				 Object [] tab= new Object[nC];
					tab[0]=comboBox.getSelectedItem();
					tab[2]=comboBox_1.getSelectedItem();
					tab[1]=comboBox_2.getSelectedItem();
				
					 ((DefaultTableModel)f.table.getModel()).addRow(tab);
				
					
				
					femer();
					}
				}

						
				private void femer() {
					// TODO Auto-generated method stub
					dispose() ;
				}
				
				
			});
			button.setForeground(Color.RED);
			button.setFont(new Font("Tahoma", Font.BOLD, 13));
			JLabel lblEtatInitial = new JLabel("Etat initial");
			JLabel lblEtatFinale = new JLabel("Etat finale");
			
			JPanel panel_1 = new JPanel();
			
			panel_2 = new JPanel();
			
			comboBox_1 = new JComboBox();
			panel_2.add(comboBox_1);
			
			JPanel panel_3 = new JPanel();
			
			comboBox_2 = new JComboBox();
			panel_3.add(comboBox_2);
			
			JLabel lblNewLabel = new JLabel("");
			
			Image img =new ImageIcon(this.getClass().getResource("/pap.png")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(91, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblEtatFinale, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblAlphabetDeTransition))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblEtatInitial, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblAjoutTransition, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))))
						.addGap(134))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(207)
						.addComponent(button)
						.addContainerGap(256, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblAjoutTransition, Alignment.LEADING)
							.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addGap(12))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblEtatInitial)
								.addGap(18)))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblEtatFinale)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(24)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblAlphabetDeTransition)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGap(51)
						.addComponent(button)
						.addGap(115))
			);
			
			comboBox = new JComboBox();
			
			panel_1.add(comboBox);
			panel.setLayout(gl_panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

	
	
		for(int i=0; i< ff.l.size();i++){
			comboBox.addItem(ff.l.get(i));
			}
			
			for(int i=0; i<ffff.l.size();i++){
				comboBox.addItem(ffff.l.get(i));
				}
			
			
			for(int i=0; i< ff.l.size();i++){
				comboBox_1.addItem(ff.l.get(i));
				}
				
				for(int i=0; i<ffff.l.size();i++){
					comboBox_1.addItem(ffff.l.get(i));
					}
			
			
				for(int i=0; i<fff.l.size();i++){
					comboBox_2.addItem(fff.l.get(i));
					}  	
	
	}

	
	
}
