package ADF;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class Fen5 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	 public static Automate a= new Automate();
	 public static Automate b= new Automate();
	 public static Automate c= new Automate();
	    String table1 = "";
	    public Transformation  atransf = new Transformation ();
	    String table2 = "";
	    String table3 = "";
	    private JPanel buttonPane;
	    private JLabel lblNewLabel;
	    private JLabel Label;
	    private JTextArea textArea;
	    private JLabel lblLatomateDterminste;
	    
	
	public Fen5(FenitrePrinc f ,Fen4 ff,Fen1 fff) {
		
		

		textArea = new JTextArea();
		 int k =f.comboBox_1.getSelectedIndex() + 1;
		
		 a.setEtatInitial(0);
		int nmbrfin=f.comboBox_2.getSelectedIndex()+1;
		 a.setnumEtats(k+nmbrfin);
		
		 for (int i = 0; i <nmbrfin ; i++) {
			 int r=Integer.parseInt(ff.l.get(i));
	            a.ajouterEtatFinal(r);
	           
		}
		
		 int alf = f.comboBox.getSelectedIndex() +1 ;

		 
		 
		 for (int i = 0; i < alf; i++) {
			char g=fff.l.get(i).charAt(0);
		 a.ajouterLettreAlphabet(g);    
		
		 }
		
	 
		 
		 for (int m=0;m<f.table.getRowCount();m++){
			 
				int ei= Integer.parseInt(((String) f.table.getValueAt(m,0)));
				String trans=(String) f.table.getValueAt(m,1);
				char u=trans.charAt(0);
				int ef= Integer.parseInt((String) f.table.getValueAt(m,2));
				
				 
				    
				
				a.ajouterTransition(ei, u, ef);
}
		 
		 
		b=atransf.transformer(a);
		

	        table2 = "\t" + b.getAlphabet().toString() + "\n";
	        table3 = "\t" + b.getAlphabet().toString() + "\n";
	        TreeSet<Integer> table = new TreeSet<Integer>();
	        table.add(0);

	        for (int i = 0; i < b.getTableTransition().length; i++) {
	            for (int j = 0; j < b.getTableTransition()[i].length; j++) {
	                if (b.getTableTransition()[i][j].isEmpty()) {
	                    b.getTableTransition()[i][j] = table;
	                }
	            }
	        }
	            for (int r= 0; r < b.getTableTransition().length; r++) {
	                for (int l = 0; l < b.getTableTransition()[r].length; l++) {
	                    if (l == 0) {
	                        table2 = table2 + r + "\t" + (b.getTableTransition()[r][l].toString());
	                    } else {

	                        table2= table2 + (b.getTableTransition()[r][l].toString());
	                    }
	                }
	                table2 = table2 + "\n";
	            }
	            
	          //  System.out.println(table2);
	            
	                     
	          //  textField.setText(table2);
	            textArea.setText(table2);
	  
		  
		setBounds(100, 100, 450, 300);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.add(contentPanel);
			contentPanel.setLayout(new FlowLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
		
		lblNewLabel = new JLabel();
		
		lblLatomateDterminste = new JLabel("l'atomate d\u00E9terminste :");
		lblLatomateDterminste.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblLatomateDterminste.setForeground(Color.BLUE);
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLatomateDterminste, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
					.addGap(76)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(283))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(lblLatomateDterminste)
							.addGap(28)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
