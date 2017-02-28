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
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Fen4 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	static int j=0;
	static public ArrayList<String> l=new ArrayList<String>();
	
	public Fen4(FenitrePrinc f ) {
		setBounds(100, 100, 338, 245);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.add(panel);
			JLabel label = new JLabel("Entrer Etat :");
			textField = new JTextField();
			textField.setColumns(10);
			JLabel lblLesEtatsFinaux = new JLabel("Les Etats finaux  de L'atomate :");
			lblLesEtatsFinaux.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblLesEtatsFinaux.setForeground(new Color(255, 0, 255));
			JButton button = new JButton("Valider");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					if (textField.getText().equals("")|| textField.getText().equals(" ")){
						JOptionPane.showMessageDialog(null,"vous avez oublié d'entrer un Etat");
					
				}else {
				  
				  	l.add(textField.getText());
				  
				    j++;
					
				
					String ss="Les Etats  Finaux de l'atomate: " ;
					if(j==l.size()){
					for(int r=0;r<l.size();r++ ){
						ss=ss+l.get(r)+" ";
						 
					}
					
					f.textField_2.setText(ss);
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
			
			JLabel lblNewLabel = new JLabel("");
			
	Image img =new ImageIcon(this.getClass().getResource("/pap.png")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(321, Short.MAX_VALUE)
						.addComponent(button)
						.addGap(254))
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(247)
						.addComponent(label)
						.addGap(26)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(233, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addContainerGap(189, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblLesEtatsFinaux)
						.addGap(194))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(41)
								.addComponent(lblLesEtatsFinaux))
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label))
						.addGap(32)
						.addComponent(button)
						.addGap(90))
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
