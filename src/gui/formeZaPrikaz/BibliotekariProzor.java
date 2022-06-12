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
import osobe.Bibliotekar;
import gui.formeZaDodavanje.AdministratoriForma;
import gui.formeZaDodavanje.BibliotekariForma;
import main.BibliotekaMain;


public class BibliotekariProzor extends JFrame {
	
		private JToolBar mainToolbar = new JToolBar();
		private JButton btnAdd = new JButton();
		private JButton btnEdit = new JButton();
		private JButton btnDelete = new JButton();
		
		private DefaultTableModel tableModel;
		private JTable bibliotekariTabela;
		
     
		
		private Biblioteka biblioteka;
		
		public BibliotekariProzor(Biblioteka biblioteka) {
			this.biblioteka = biblioteka;
			setTitle("Bibliotekari");
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
			Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniBibliotekari().size()][zaglavlja.length];	
			
			for(int i=0; i<biblioteka.sviNeobrisaniBibliotekari().size(); i++) {
				Bibliotekar bibliotekar = biblioteka.sviNeobrisaniBibliotekari().get(i);
				sadrzaj[i][0] = bibliotekar.getId();
				sadrzaj[i][1] = bibliotekar.getIme();
				sadrzaj[i][2] = bibliotekar.getPrezime();
				sadrzaj[i][3] = bibliotekar.getJMBG();
				sadrzaj[i][4] = bibliotekar.getAdresa();
				sadrzaj[i][5] = bibliotekar.getPol();
				sadrzaj[i][6] = bibliotekar.getKorisnickoIme();
				sadrzaj[i][7] = bibliotekar.getKorisnickaSifra();
				sadrzaj[i][8] = bibliotekar.getPlata();
				sadrzaj[i][9] = bibliotekar.isObrisan();
				sadrzaj[i][10] = bibliotekar.getZaposleni();
				
			}
			
			tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
			bibliotekariTabela = new JTable(tableModel);
			
			bibliotekariTabela.setRowSelectionAllowed(true);
			bibliotekariTabela.setColumnSelectionAllowed(false);
			bibliotekariTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			bibliotekariTabela.setDefaultEditor(Object.class, null);
			bibliotekariTabela.getTableHeader().setReorderingAllowed(false);
			
			JScrollPane scrollPane = new JScrollPane(bibliotekariTabela);
			add(scrollPane, BorderLayout.CENTER);
		}
		
		private void initActions() {
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = bibliotekariTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String bibliotekarId = tableModel.getValueAt(red, 0).toString();
						Bibliotekar bibliotekar = biblioteka.pronadjiBibliotekara(bibliotekarId);
						int izbor = JOptionPane.showConfirmDialog(null, 
								"Da li ste sigurni da zelite da obrisete disk?", 
								bibliotekarId + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							bibliotekar.setObrisan(true);
							tableModel.removeRow(red);
							biblioteka.snimiBibliotekare(BibliotekaMain.BIBLIOTEKARI_FAJL);
						}
					}
				}
			});
			
			btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					BibliotekariForma df = new BibliotekariForma(biblioteka, null);
					df.setVisible(true);
				}
			});
			
			btnEdit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = bibliotekariTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String bibliotekarId = tableModel.getValueAt(red, 0).toString();
						Bibliotekar bibliotekar = biblioteka.pronadjiBibliotekara(bibliotekarId);
						BibliotekariForma df = new BibliotekariForma(biblioteka, bibliotekar);
						df.setVisible(true);
					}
				}
			});
		}
		

}
