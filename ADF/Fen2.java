package ADF;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.io.*;
public class Fen2 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	static int j=0;
	static  public ArrayList<String> l=new ArrayList<String>();
	private JTextField textField;
	
	
	
	public Fen2(FenitrePrinc f) {
		setBounds(100, 100, 362, 287);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.add(panel);
			JButton button = new JButton("Valider");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
					
						if (textField.getText().equals("")|| textField.getText().equals(" ")){
							JOptionPane.showMessageDialog(null,"vous avez oublié d'entrer un Etat");
						
					}else {
					  
					  	l.add(textField.getText());
					     j++;
					     String ss="Les Etats de l'atomate: " ;
						if(j==l.size()){
						for(int r=0;r<l.size();r++ ){
							ss=ss+l.get(r)+" ";
							 
						}
						
						f.textField_1.setText(ss);
						}
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
			
			JLabel lblEntrerEtat = new JLabel("Entrer Etat :");
			
			textField = new JTextField();
			textField.setColumns(10);
			
			JLabel lblLesEtatsDe = new JLabel("Les Etats Normale  de L'atomate :");
			lblLesEtatsDe.setForeground(new Color(255, 0, 255));
			lblLesEtatsDe.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			JLabel lblKk = new JLabel("");
			
			Image img =new ImageIcon(this.getClass().getResource("/pap.png")).getImage();
			lblKk.setIcon(new ImageIcon(img));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addGap(180)
						.addComponent(lblKk)
						.addGap(27)
						.addComponent(lblLesEtatsDe)
						.addContainerGap(179, Short.MAX_VALUE))
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(301, Short.MAX_VALUE)
						.addComponent(button)
						.addGap(260))
					.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addGap(244)
						.addComponent(lblEntrerEtat)
						.addGap(35)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(213, Short.MAX_VALUE))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblKk)
							.addComponent(lblLesEtatsDe))
						.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblEntrerEtat)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(51)
						.addComponent(button)
						.addGap(75))
			);
			panel.setLayout(gl_panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
