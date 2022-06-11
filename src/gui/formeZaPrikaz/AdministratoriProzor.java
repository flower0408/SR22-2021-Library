package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


import biblioteka.Biblioteka;
import osobe.Administrator;
import gui.formeZaDodavanje.AdministratoriForma;

import main.BibliotekaMain;


public class AdministratoriProzor extends JFrame {
	
		private JToolBar mainToolbar = new JToolBar();
		private JButton btnAdd = new JButton();
		private JButton btnEdit = new JButton();
		private JButton btnDelete = new JButton();
		
		private DefaultTableModel tableModel;
		private JTable administartoriTabela;
		
     
		
		private Biblioteka biblioteka;
		
		public AdministratoriProzor(Biblioteka biblioteka) {
			this.biblioteka = biblioteka;
			setTitle("Administratori");
			setSize(500, 300);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			initGUI();
			initActions();
			
		}
		
		private void initGUI() {
			ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
			btnAdd.setIcon(addIcon);
			ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
			btnEdit.setIcon(editIcon);
			ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
			btnDelete.setIcon(deleteIcon);
			
			mainToolbar.add(btnAdd);
			mainToolbar.add(btnEdit);
			mainToolbar.add(btnDelete);
			add(mainToolbar, BorderLayout.NORTH);
			
			String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Korisničko ime", "Korisnicka šifra", "Plata", "Obrisan", "Tip zaposlenog"};
			Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniAdministratori().size()][zaglavlja.length];	
			
			for(int i=0; i<biblioteka.sviNeobrisaniAdministratori().size(); i++) {
				Administrator administartor = biblioteka.sviNeobrisaniAdministratori().get(i);
				sadrzaj[i][0] = administartor.getId();
				sadrzaj[i][1] = administartor.getIme();
				sadrzaj[i][2] = administartor.getPrezime();
				sadrzaj[i][3] = administartor.getJMBG();
				sadrzaj[i][4] = administartor.getAdresa();
				sadrzaj[i][5] = administartor.getPol();
				sadrzaj[i][6] = administartor.getKorisnickoIme();
				sadrzaj[i][7] = administartor.getKorisnickaSifra();
				sadrzaj[i][8] = administartor.getPlata();
				sadrzaj[i][9] = administartor.isObrisan();
				sadrzaj[i][10] = administartor.getZaposleni();
				
			}
			
			tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
			administartoriTabela = new JTable(tableModel);
			
			administartoriTabela.setRowSelectionAllowed(true);
			administartoriTabela.setColumnSelectionAllowed(false);
			administartoriTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			administartoriTabela.setDefaultEditor(Object.class, null);
			administartoriTabela.getTableHeader().setReorderingAllowed(false);
			
			JScrollPane scrollPane = new JScrollPane(administartoriTabela);
			add(scrollPane, BorderLayout.CENTER);
		}
		
		private void initActions() {
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = administartoriTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String administratorId = tableModel.getValueAt(red, 0).toString();
						Administrator administrator = biblioteka.pronadjiAdministartora(administratorId);
						int izbor = JOptionPane.showConfirmDialog(null, 
								"Da li ste sigurni da zelite da obrisete disk?", 
								administratorId + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							administrator.setObrisan(true);
							tableModel.removeRow(red);
							biblioteka.snimiAdministratore(BibliotekaMain.ADMINISTRATORI_FAJL);
						}
					}
				}
			});
			
			btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AdministratoriForma df = new AdministratoriForma(biblioteka, null);
					df.setVisible(true);
				}
			});
			
			btnEdit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = administartoriTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String administratorId = tableModel.getValueAt(red, 0).toString();
						Administrator administrator = biblioteka.pronadjiAdministartora(administratorId);
						AdministratoriForma df = new AdministratoriForma(biblioteka, administrator);
						df.setVisible(true);
					}
				}
			});
		}
		

}

