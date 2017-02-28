package ADF;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class FenitrePrinc extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
     public       JComboBox comboBox;
	private JLabel lblNombreDalphabet;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JLabel nombetat;
	 public    JComboBox comboBox_1;
	private JButton btnAjouterEtat;
	private JLabel lblAjouterTransition;
	private JButton btnNewButton_1;
	private FenitrePrinc fenitreP;
	public int i ;
	public JTextField textField;
	public JTable table;
	public JTextField textField_1;
	public JButton button;
	public JTextField textField_2;

    public static Automate a= new Automate();
    String table1 = "";
    public Automate atransf = new Automate();
    String table2 = "";
    private JButton btnTransformer;
    public JComboBox comboBox_2;
	

	/**
	 * Launch the application.
	 */
    

	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenitrePrinc frame = new FenitrePrinc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenitrePrinc() {
		initmethode();
		evenementmethode();
	
		
		
		fenitreP=this ;
	}

	 public FenitrePrinc fen(){
		return this ;
	}
	
	private void evenementmethode() {
		
		btnTransformer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Fen5 f=new Fen5(fen(),null,null);
				f.setModal(true);
				f.setVisible(true);
				
			}
		});
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k=0;
				try{
					i=Integer.parseInt((String)comboBox.getSelectedItem());
				
			while(k<i){
				
				Fen1 f =new Fen1(fen());
				
				f.setModal(true);
				f.setVisible(true);
				k++;
				}
				
				
				
				
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,"erreur");
				}
			}
		});
		
		btnAjouterEtat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i2,k=0;
				try{
					i2=Integer.parseInt((String)comboBox_1.getSelectedItem());
				
			while(k<i2){
				
				Fen2 f=new Fen2(fen());
				f.setModal(true);
				f.setVisible(true);
				k++;
				}
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,"erreur");
				}
			}
				
				
				
		});
		
		
		// ajouter transition 
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Fen3 f=new Fen3(fen(),null,null,null);
				f.setModal(true);
				f.setVisible(true);
				
			}
				
		
			
		});
		
		// ajouter etat Finale :
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i2,k=0;
				try{
					i2=Integer.parseInt((String)comboBox_2.getSelectedItem());
				
			while(k<i2){
				
			
				Fen4 f=new Fen4(fen());
				f.setModal(true);
				f.setVisible(true);
				k++;
			}
				
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null,"erreur");
			}
				
				
				
			}
		});
		
	
	}

	private void initmethode() {
		// TODO Auto-generated method stub
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 598);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAndfAdf = new JLabel("ANDF => ADF");
		lblAndfAdf.setHorizontalAlignment(SwingConstants.CENTER);
		lblAndfAdf.setLabelFor(this);
		lblAndfAdf.setFont(new Font("Microsoft New Tai Lue", Font.BOLD | Font.ITALIC, 16));
		lblAndfAdf.setForeground(new Color(255, 0, 255));
		
		panel = new JPanel();
		
		panel_1 = new JPanel();
		
		nombetat = new JLabel("Nombre d'Etat Normale");
		nombetat.setForeground(new Color(0, 0, 205));
		nombetat.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(nombetat);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		panel_1.add(comboBox_1);
		
		btnAjouterEtat = new JButton("Ajouter Etat");
	
		panel_1.add(btnAjouterEtat);
		
		lblAjouterTransition = new JLabel("Ajouter Transition :");
		lblAjouterTransition.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAjouterTransition.setForeground(new Color(255, 0, 255));
		
		btnNewButton_1 = new JButton("Ajout Trans");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		textField_1 = new JTextField();
		textField_1.setText(" ");
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		
		JLabel lblNombreDetatFinaux = new JLabel("Nombre d'Etat Finaux");
		lblNombreDetatFinaux.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreDetatFinaux.setForeground(new Color(0, 0, 205));
		panel_2.add(lblNombreDetatFinaux);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		panel_2.add(comboBox_2);
		
		button = new JButton("Ajouter Etat");
		
		panel_2.add(button);
		
		textField_2 = new JTextField();
		textField_2.setText(" ");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		Image img =new ImageIcon(this.getClass().getResource("/pap.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		btnTransformer = new JButton("Transformer");
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(171)
					.addComponent(lblAjouterTransition)
					.addGap(50)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(251, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAndfAdf, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(283, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE))
					.addGap(36))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(123)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnTransformer)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(225)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(224, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(228, Short.MAX_VALUE)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addGap(221))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(224)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(227, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAndfAdf, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAjouterTransition)
								.addComponent(btnNewButton_1))
							.addGap(31)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnTransformer)
							.addContainerGap())))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Etat Initial", "Alphabet", "Etat Final"
			}
		));
		scrollPane.setViewportView(table);
		
		
	    
		
		lblNombreDalphabet = new JLabel("Nombre d'Alphabet");
		lblNombreDalphabet.setForeground(new Color(0, 0, 255));
		panel.add(lblNombreDalphabet);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		panel.add(comboBox);
		
		btnNewButton = new JButton("Ajouter Alphabet");
	
		panel.add(btnNewButton);
		contentPane.setLayout(gl_contentPane);
	}
}
