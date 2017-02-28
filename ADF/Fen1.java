package ADF;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Fen1 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	DefaultListModel DM=new DefaultListModel();
	/**
	 * Launch the application.
	 */
	

	static int j=0;
	static ArrayList<String> l=new ArrayList<String>();
	
	
	
	
	public Fen1(FenitrePrinc f) {
		super();
		
		
		  
	
		setBounds(100, 100, 360, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		JLabel lblAjoutAlphabet = new JLabel("Ajout Alphabet :");
		lblAjoutAlphabet.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblAjoutAlphabet.setForeground(new Color(255, 0, 204));
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			private String s;
			
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")|| textField.getText().equals(" ")){
					JOptionPane.showMessageDialog(null,"vous avez oublié d'entrer un alphabet");
				
			}else {
			  
			  	l.add(textField.getText());
			  j++;
				
			
				String ss="Les alphabets de l'atomate :" ;
				if(j==l.size()){
				for(int r=0;r<l.size();r++ ){
					ss=ss+"\n"+l.get(r);
					 
				}
				f.textField.setText(ss);
				}
				femer();
			}
			}

					
			

			private void femer() {
				// TODO Auto-generated method stub
				dispose() ;
			}
		});
		
		
		
		
		btnValider.setForeground(new Color(255, 0, 0));
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField = new JTextField();
		textField.setColumns(10);
		JLabel lblEnterVotreAlpha = new JLabel("Enter votre ALPHA");
		
		JLabel lblNewLabel = new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("/pap.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(lblAjoutAlphabet)
					.addContainerGap(59, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(101, Short.MAX_VALUE)
					.addComponent(lblEnterVotreAlpha)
					.addGap(28)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(228, Short.MAX_VALUE)
					.addComponent(btnValider)
					.addGap(29))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAjoutAlphabet)
							.addGap(27)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterVotreAlpha))
					.addGap(45)
					.addComponent(btnValider)
					.addGap(19))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
