package emploiDuTemps_java;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Interface1 extends JFrame {
	Statement st;
	ConnexionBD con=new ConnexionBD();
	ResultSet rst;
	JTable table,table2;
	JScrollPane scroll,scroll2;
	JLabel lbtitre,lbtitre2,lbmatricule,lbnom,lbcontact,lbclasse,lbmatiere,lbjour,lbheure,lbmatri_ens;
	JTextField tfmatricule,tfnom,tfcontact,tfmatiere,tfmatri_ens;
	JButton btrech,btenrg,btmodif,btsupp,btenrg2,btreq;
	JComboBox comboclasse,combojour,comboheure;
	public Interface1(){
		
		this.setTitle("emploi du temps");
		this.setSize(900,665);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		add(pn);
		pn.setBackground(new Color(255, 255, 234));
		
		HeaderLogo headerLogo = new HeaderLogo("ISI emploi du temps");
        headerLogo.setBounds(0, 0, 900, 100); 
        pn.add(headerLogo);
         
		lbtitre=new JLabel("Formulaire d'enregistrement des enseignants");
		lbtitre.setBounds(20,110,500,30);
		lbtitre.setForeground(new Color(221, 118, 28)); 
		lbtitre.setFont(new Font("Times New Roman",Font.BOLD,18));
		pn.add(lbtitre);
		
		lbtitre2=new JLabel("Formulaire d'enregistrement des seances de cours");
		lbtitre2.setBounds(20,350,500,30);
		lbtitre2.setForeground(new Color(221, 118, 28)); 
		lbtitre2.setFont(new Font("Times New Roman",Font.BOLD,18));
		pn.add(lbtitre2);
		
		//Matricule
	    lbmatricule=new JLabel("Matricule");
		lbmatricule.setBounds(60,150,170,25);
		lbmatricule.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(lbmatricule);
						
		tfmatricule=new JTextField();
		tfmatricule.setBounds(143,150,100,25);
		tfmatricule.setBorder(new StyleTextFiled(6));
		tfmatricule.addFocusListener(new StyleTextFiled(6));
		pn.add(tfmatricule);
		//bouton recherche matricule
		btrech=new JButton("CHERCHER");
        btrech.setUI(new StyleButton());
		btrech.setBounds(245,150,100,25);
		btrech.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				String matricule=tfmatricule.getText(),
						nom=tfnom.getText(),
						contact=tfcontact.getText();
		String rq="select * from enseignant where nom like '%"+nom+"%'";
		try{
			st=con.FConnection().createStatement();
			rst=st.executeQuery(rq);
			if(rst.next()){
				tfmatricule.setText(rst.getString("matricule"));
				tfnom.setText(rst.getString("nom"));
				tfcontact.setText(rst.getString("contact"));		
			}
			else{
				JOptionPane.showMessageDialog(null,"Enregistrement inexistant!",null,JOptionPane.ERROR_MESSAGE);
			}
					
			
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
	    }
				
			}
		});
		pn.add(btrech);
		//nom
		lbnom=new JLabel("Nom");
		lbnom.setBounds(91,180,100,25);
		lbnom.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(lbnom);
				
		tfnom=new JTextField();
		tfnom.setBorder(new StyleTextFiled(6));
		tfnom.addFocusListener(new StyleTextFiled(6));
		tfnom.setBounds(143,180,200,25);
		pn.add(tfnom);
		//contact
	
		lbcontact=new JLabel("Contact");
		lbcontact.setBounds(68,210,100,25);
		lbcontact.setFont(new Font("Times New Roman",Font.BOLD,16));
		pn.add(lbcontact);
		
		tfcontact=new JTextField();
		tfcontact.setBorder(new StyleTextFiled(6));
		tfcontact.addFocusListener(new StyleTextFiled(6));
		tfcontact.setBounds(143,210,200,25);
		pn.add(tfcontact);
		
		//Classe
				lbclasse=new JLabel("Classe");
				lbclasse.setBounds(35,390,150,25);
				lbclasse.setFont(new Font("Times New Roman",Font.BOLD,16));
				pn.add(lbclasse);
				
				comboclasse=new JComboBox();
				comboclasse.setRenderer(new StyleComboBox( new Color(255,228,181)));
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


				comboclasse.setBounds(120,390,150,25);
				pn.add(comboclasse);
		//matiere
				lbmatiere=new JLabel("Matiere");
				lbmatiere.setBounds(35,420,150,25);
				lbmatiere.setFont(new Font("Times New Roman",Font.BOLD,16));
				pn.add(lbmatiere);
				
				tfmatiere=new JTextField();
				tfmatiere.setBorder(new StyleTextFiled(6));
				tfmatiere.addFocusListener(new StyleTextFiled(6));
				tfmatiere.setBounds(120,420,150,25);
				pn.add(tfmatiere);
		//jour
				lbjour=new JLabel("Jour");
				lbjour.setBounds(50,450,150,25);
				lbjour.setFont(new Font("Times New Roman",Font.BOLD,16));
				pn.add(lbjour);
				
				combojour=new JComboBox();
				combojour.setRenderer(new StyleComboBox( new Color(255,228,181)));
				combojour.addItem("");
				combojour.addItem("LUNDI");
				combojour.addItem("MARDI");
				combojour.addItem("MERCREDI");
				combojour.addItem("JEUDI");
				combojour.addItem("VENDREDI");
				combojour.addItem("SAMEDI");
				combojour.setBounds(120,450,150,25);
				pn.add(combojour);
				//heure
				lbheure=new JLabel("Heure");
				lbheure.setBounds(40,480,150,25);
				lbheure.setFont(new Font("Times New Roman",Font.BOLD,16));
				pn.add(lbheure);
				
				comboheure=new JComboBox();
				comboheure.setRenderer(new StyleComboBox( new Color(255,228,181)));
				comboheure.addItem("");
				comboheure.addItem("08:00-10:00");
				comboheure.addItem("10:00-12:00");
				comboheure.addItem("13:00-15:00");
				comboheure.addItem("15:00-17:00");
				
				comboheure.setBounds(120,480,150,25);
				pn.add(comboheure);
				//matricule de l'enseignant
				lbmatri_ens=new JLabel("Matricule enseignant");
				lbmatri_ens.setBounds(10,510,170,25);
				lbmatri_ens.setFont(new Font("Times New Roman",Font.BOLD,16));
				pn.add(lbmatri_ens);
				
				tfmatri_ens=new JTextField();
				tfmatri_ens.setBorder(new StyleTextFiled(6));
				tfmatri_ens.addFocusListener(new StyleTextFiled(6));
				tfmatri_ens.setBounds(190,510,80,25);
				pn.add(tfmatri_ens);
				
		
		//bouton enregistrement enseignant
				btenrg=new JButton("ENREGISTRER");
		        btenrg.setUI(new StyleButton());
				btenrg.setBounds(35,260,120,25);
	btenrg.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ev){
			String matricule,nom,contact;
			matricule=tfmatricule.getText();
			nom=tfnom.getText();
			contact=tfcontact.getText();
			String rq1="insert into enseignant(matricule,nom,contact) values('"+matricule+"','"+nom+"','"+contact+"')";
			try{
				st=con.FConnection().createStatement();
				if(!matricule.equals("")&&!nom.equals("")&&!contact.equals("")){
				st.executeUpdate(rq1);
	    		JOptionPane.showMessageDialog(null,"Insertion reussie!",null,JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null,"Completez le formulaire!",null,JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
		    }
			dispose();
			Interface1 crs=new Interface1();
			crs.setVisible(true);
		}
		
	});
				pn.add(btenrg);
		//bouton modification enseignant
				btmodif=new JButton("MODIFIER");
		        btmodif.setUI(new StyleButton());
				btmodif.setBounds(170,260,120,25);
				btmodif.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ev){
						String matricule=tfmatricule.getText(),
								nom=tfnom.getText(),
								contact=tfcontact.getText();
			String rq="update enseignant set nom='"+nom+"',contact='"+contact+"' where matricule='"+matricule+"'";
			try{
				st=con.FConnection().createStatement();
				if(!matricule.equals("")&&!nom.equals("")&&!contact.equals("")){
				st.executeUpdate(rq);
	    		JOptionPane.showMessageDialog(null,"Modification reussie!",null,JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null,"Completez le formulaire!",null,JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
		    }	
			dispose();
			Interface1 crs=new Interface1();
			crs.setVisible(true);	}
				});
				pn.add(btmodif);
		//bouton suppression enseignant
				btsupp=new JButton("SUPPRIMER");
		        btsupp.setUI(new StyleButton());
				btsupp.setBounds(100,300,120,25);
				btsupp.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ev){
						String matricule=tfmatricule.getText();
			String rq="delete from enseignant where matricule='"+matricule+"'";
			try{
				if(!matricule.equals("")){
					st=con.FConnection().createStatement();
					if(JOptionPane.showConfirmDialog(null,"Voulez vous supprimer? ",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
						st.executeUpdate(rq);
						JOptionPane.showMessageDialog(null,"La suppression de l'enseignant portant le numéro matricule "+matricule+" a été accomplie avec succès!",null,JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null,"Erreur! Saisir le matricule d'un enseignant!",null,JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null,"Erreur !",null,JOptionPane.ERROR_MESSAGE);	
		    }	
			dispose();
			Interface1 crs=new Interface1();
			crs.setVisible(true);	}
				});
				pn.add(btsupp);
				//bouton enregistrement seance cours
				btenrg2=new JButton("ENREGISTRER");
		        btenrg2.setUI(new StyleButton());
				btenrg2.setBounds(120,550,120,25);
				btenrg2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ev){
						String classe,matiere,jour,heure,matri_ens;
						classe=comboclasse.getSelectedItem().toString();
						matiere=tfmatiere.getText();
						jour=combojour.getSelectedItem().toString();
						heure=comboheure.getSelectedItem().toString();
						matri_ens=tfmatri_ens.getText();
			String rq1="insert into cours(classe,matiere,jour,heure,matricule_ens) values('"+classe+"','"+matiere+"','"+jour+"','"+heure+"','"+matri_ens+"')";
						try{
							st=con.FConnection().createStatement();
							if(!matiere.equals("")&&!classe.equals("")&&!jour.equals("")&&!heure.equals("")){
							st.executeUpdate(rq1);
				    		JOptionPane.showMessageDialog(null,"Insertion reussie!",null,JOptionPane.INFORMATION_MESSAGE);
							}
							else{
								JOptionPane.showMessageDialog(null,"Completez le formulaire!",null,JOptionPane.ERROR_MESSAGE);
							}
						}
						catch(SQLException ex){
					    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
					    }
						String rq2="update cours set num_jour=1 where jour='LUNDI'";
						String rq3="update cours set num_jour=2 where jour='MARDI'";
						String rq4="update cours set num_jour=3 where jour='MERCREDI'";
						String rq5="update cours set num_jour=4 where jour='JEUDI'";
						String rq6="update cours set num_jour=5 where jour='VENDREDI'";
						String rq7="update cours set num_jour=6 where jour='SAMEDI'";
						try{
							st=con.FConnection().createStatement();
							st.executeUpdate(rq2);
							st.executeUpdate(rq3);
							st.executeUpdate(rq4);
							st.executeUpdate(rq5);
							st.executeUpdate(rq6);
							st.executeUpdate(rq7);
						}
						catch(SQLException ex){
					    	JOptionPane.showMessageDialog(null,"Erreur!",null,JOptionPane.ERROR_MESSAGE);	
					    }
						dispose();
						Interface1 crs=new Interface1();
						crs.setVisible(true);
					}
					
				});
				pn.add(btenrg2);
				//bouton pour afficher l'interface des requetes
				btreq=new JButton("REQUETES");
		        btreq.setUI(new StyleButton());
				btreq.setBounds(120,585,120,25);
				btreq.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ev){
						Interface2 rq=new Interface2();
						rq.setVisible(true);
					}
				});
				pn.add(btreq);
				
				///liste enseignant
				 DefaultTableModel df=new  DefaultTableModel();
				  init();
				  pn.add(scroll);
				 df.addColumn("Matricule");
				 df.addColumn("Nom");
				 df.addColumn("Contact");
				 table.setModel(df);
				 String rq="select * from enseignant order by nom";
				 try{
					 st=con.FConnection().createStatement();
					 rst=st.executeQuery(rq);
					 while(rst.next()){
						 df.addRow(new Object[]{
		rst.getString("matricule"),rst.getString("nom"),rst.getString("contact")
								 });
						 
					   } 
					 }
					 
				 catch(SQLException ex){
				    	JOptionPane.showMessageDialog(null,"Erreur !",null,JOptionPane.ERROR_MESSAGE);	
				    }
				 ///liste seance cours
				 DefaultTableModel df2=new  DefaultTableModel();
				  init2();
				  pn.add(scroll2);
				 df2.addColumn("Classe");
				 df2.addColumn("Matiere");
				 df2.addColumn("Jour");
				 df2.addColumn("Heure");
				 df2.addColumn("Enseignant");
				 table2.setModel(df2);
				 String rq2="select * from cours";
				 try{
					 st=con.FConnection().createStatement();
					 rst=st.executeQuery(rq2);
					 while(rst.next()){
						 df2.addRow(new Object[]{
		rst.getString("classe"),rst.getString("matiere"),rst.getString("jour"),rst.getString("heure"),
		rst.getString("matricule_ens")
								 });
						 
					   } 
					 }
					 
				 catch(SQLException ex){
				    	JOptionPane.showMessageDialog(null,"Erreur !",null,JOptionPane.ERROR_MESSAGE);	
				    }
		
	}
	private void init(){
		table=new JTable();
		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(new StyleHeaderTable());
		table.setDefaultRenderer(Object.class, new StyleCellTable());
		int rowHeight = 20;
        table.setRowHeight(rowHeight);

		scroll=new JScrollPane();
		scroll.setBounds(400,140,460,200);
		scroll.setViewportView(table);
		
	}
	private void init2(){
		table2=new JTable();
		JTableHeader header = table2.getTableHeader();
	    header.setDefaultRenderer(new StyleHeaderTable());
	    table2.setDefaultRenderer(Object.class, new StyleCellTable());
		int rowHeight = 25;
        table2.setRowHeight(rowHeight);
        
		scroll2=new JScrollPane();
		scroll2.setBounds(320,400,540,200);
		scroll2.setViewportView(table2);
		
	}
}

