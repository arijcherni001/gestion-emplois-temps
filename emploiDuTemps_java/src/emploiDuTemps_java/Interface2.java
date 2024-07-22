package emploiDuTemps_java;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Interface2 extends JFrame {
	Statement st;
	ConnexionBD con=new ConnexionBD();
	ResultSet rst;
	JTable table,table2;
	JScrollPane scroll,scroll2;
	JLabel lbclasse,lbmatiere,lbtitre,lbtitre2,lbid,lbclasse2;
	JTextField tfmatiere,tfid;
	JComboBox comboclasse,comboclasse2;
	JButton btrech,btsupp,btrech2;
	public Interface2(){
		this.setTitle("emploi du temps");
		this.setSize(900,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		add(pn);
		pn.setBackground(new Color(255, 255, 234));
		
		HeaderLogo headerLogo = new HeaderLogo("ISI emploi du temps");
        headerLogo.setBounds(0, 0, 900, 100); 
        pn.add(headerLogo);
		
		lbtitre=new JLabel("Les seances de cours dans la semaine d'une matiere dans une classe");
		lbtitre.setBounds(20,105,800,30);
		lbtitre.setForeground(new Color(221, 118, 28)); 
		lbtitre.setFont(new Font("Times New Roman",Font.BOLD,18));
		pn.add(lbtitre);
		
		lbtitre2=new JLabel("Emploi du temps de la semaine par classe");
		lbtitre2.setBounds(20,480,800,30);
		lbtitre2.setForeground(new Color(221, 118, 28)); 
		lbtitre2.setFont(new Font("Times New Roman",Font.BOLD,18));
		pn.add(lbtitre2);
		
		//classe
		lbclasse=new JLabel("Classe");
		lbclasse.setBounds(30,140,150,25);
		lbclasse.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(lbclasse);
		
		comboclasse=new JComboBox();
		comboclasse.setRenderer(new StyleComboBox(new Color(255,228,181)));
		comboclasse.addItem("");
		comboclasse.addItem("1L_CS");
		comboclasse.addItem("1L_SE");
		comboclasse.addItem("1L_IRS");
		comboclasse.addItem("2L_CS");
		comboclasse.addItem("2L_SE");
		comboclasse.addItem("2L_IRS");
		comboclasse.addItem("3L_CS");
		comboclasse.addItem("3L_SE");
		comboclasse.addItem("3L_IRS");
		
		comboclasse.setBounds(30,170,150,25);
		pn.add(comboclasse);
		//classe2
				lbclasse2=new JLabel("Classe");
				lbclasse2.setBounds(30,520,150,25);
				lbclasse2.setFont(new Font("Times New Roman",Font.BOLD,16));
				pn.add(lbclasse2);
				
				comboclasse2=new JComboBox();
				comboclasse2.setRenderer(new StyleComboBox( new Color(255,228,181)));
				comboclasse2.addItem("");
				comboclasse2.addItem("1L_CS");
				comboclasse2.addItem("1L_SE");
				comboclasse2.addItem("1L_IRS");
				comboclasse2.addItem("2L_CS");
				comboclasse2.addItem("2L_SE");
				comboclasse2.addItem("2L_IRS");
				comboclasse2.addItem("3L_CS");
				comboclasse2.addItem("3L_SE");
				comboclasse2.addItem("3L_IRS");
				comboclasse2.setBounds(100,520,150,25);
				pn.add(comboclasse2);
		//matiere
		lbmatiere=new JLabel("Matiere");
		lbmatiere.setBounds(200,140,150,25);
		lbmatiere.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(lbmatiere);
		
		tfmatiere=new JTextField();
		tfmatiere.setBorder(new StyleTextFiled(6));
		tfmatiere.addFocusListener(new StyleTextFiled(6));
		tfmatiere.setBounds(200,170,150,25);
		pn.add(tfmatiere);
		//id
		
				lbid=new JLabel("ID");
				lbid.setBounds(20,440,150,25);
				lbid.setFont(new Font("Times New Roman",Font.BOLD,16));
				pn.add(lbid);
				
				tfid=new JTextField();
				tfid.setBorder(new StyleTextFiled(6));
				tfid.addFocusListener(new StyleTextFiled(6));
				tfid.setBounds(50,440,90,25);
				pn.add(tfid);
			//bouton supprimer
				btsupp=new JButton("SUPPRIMER");
		        btsupp.setUI(new StyleButton());
				btsupp.setBounds(150,440,110,25);
				btsupp.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ev){
						String id=tfid.getText();
						String rq="delete from cours where id='"+id+"'";
						try{
							st=con.FConnection().createStatement();
		if(JOptionPane.showConfirmDialog(null,"voulez vous Supprimer? ",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
							 st.executeUpdate(rq);
							 JOptionPane.showMessageDialog(null,"Suppression effectuee avec succes !",null,JOptionPane.INFORMATION_MESSAGE);
		}
						}
						catch(SQLException ex){
					    	JOptionPane.showMessageDialog(null,"Erreur !",null,JOptionPane.ERROR_MESSAGE);	
					    }
						
					}
					
				});
				pn.add(btsupp);
		//bouton recherche
		btrech=new JButton("CHERCHER");
        btrech.setUI(new StyleButton());
		btrech.setBounds(360,170,120,25);
		btrech.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				String classe=comboclasse.getSelectedItem().toString(),
						matiere=tfmatiere.getText();
				DefaultTableModel df2=new  DefaultTableModel();
				  init2();
				  pn.add(scroll2);
				 df2.addColumn("ID");
				 df2.addColumn("Classe");
				 df2.addColumn("Matiere");
				 df2.addColumn("Jour");
				 df2.addColumn("Heure");
				 df2.addColumn("Nom enseignant");
				 df2.addColumn("Contact enseignant");
				 table2.setModel(df2);
				 String rq2="select * from enseignant_cours where classe='"+classe+"' and matiere='"+matiere+"' order by num_jour";
				 try{
					 st=con.FConnection().createStatement();
					 rst=st.executeQuery(rq2);
					 while(rst.next()){
						 df2.addRow(new Object[]{
		rst.getString("id"),rst.getString("classe"),rst.getString("matiere"),rst.getString("jour"),rst.getString("heure"),
		rst.getString("nom"),rst.getString("contact")
								 });
						 
					   } 
					 }
					 
				 catch(SQLException ex){
				    	JOptionPane.showMessageDialog(null,"Erreur !",null,JOptionPane.ERROR_MESSAGE);	
				    }
				
			}
		});
		pn.add(btrech);
		//bouton recherche
				btrech2=new JButton("CHERCHER");
		        btrech2.setUI(new StyleButton());
				btrech2.setBounds(260,520,120,25);
				btrech2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ev){
						String classe=comboclasse2.getSelectedItem().toString();
						DefaultTableModel df2=new  DefaultTableModel();
						  init2();
						  pn.add(scroll2);
						 df2.addColumn("ID");
						 df2.addColumn("Classe");
						 df2.addColumn("Jour");
						 df2.addColumn("Matiere");
						 df2.addColumn("Heure");
						 df2.addColumn("Nom enseignant");
						 df2.addColumn("Contact enseignant");
						 table2.setModel(df2);
						 String rq2="select * from enseignant_cours where classe='"+classe+"' order by num_jour,heure";
						 try{
							 st=con.FConnection().createStatement();
							 rst=st.executeQuery(rq2);
							 while(rst.next()){
								 df2.addRow(new Object[]{
				rst.getString("id"),rst.getString("classe"),rst.getString("jour"),rst.getString("matiere"),rst.getString("heure"),
				rst.getString("nom"),rst.getString("contact")
										 });
								 
							   } 
							 }
							 
						 catch(SQLException ex){
						    	JOptionPane.showMessageDialog(null,"Erreur !",null,JOptionPane.ERROR_MESSAGE);	
						    }
						
					}
				});
				pn.add(btrech2);
		
	}
	private void init2(){
		table2=new JTable();
		 
	    JTableHeader header = table2.getTableHeader();
	    header.setDefaultRenderer(new StyleHeaderTable());
	    table2.setDefaultRenderer(Object.class, new StyleCellTable());
	    int rowHeight = 25;
        table2.setRowHeight(rowHeight);
        
		scroll2=new JScrollPane();
		scroll2.setBounds(10,220,850,200);
		scroll2.setViewportView(table2);
		
	}
}
