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
import osobe.Zaposleni;
import gui.formeZaDodavanje.AdministratoriForma;
import gui.formeZaDodavanje.SviZaposleniForma;
import main.BibliotekaMain;


public class SviZaposleniProzor extends JFrame {
	
		private JToolBar mainToolbar = new JToolBar();
		private JButton btnAdd = new JButton();
		private JButton btnEdit = new JButton();
		private JButton btnDelete = new JButton();
		
		private DefaultTableModel tableModel;
		private JTable svizaposleniTabela;
		
     
		
		private Biblioteka biblioteka;
		
		public SviZaposleniProzor(Biblioteka biblioteka) {
			this.biblioteka = biblioteka;
			setTitle("Svi zaposleni");
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
			Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniZaposleni().size()][zaglavlja.length];	
			
			for(int i=0; i<biblioteka.sviNeobrisaniZaposleni().size(); i++) {
				Zaposleni svizaposleni = biblioteka.sviNeobrisaniZaposleni().get(i);
				sadrzaj[i][0] = svizaposleni.getId();
				sadrzaj[i][1] = svizaposleni.getIme();
				sadrzaj[i][2] = svizaposleni.getPrezime();
				sadrzaj[i][3] = svizaposleni.getJMBG();
				sadrzaj[i][4] = svizaposleni.getAdresa();
				sadrzaj[i][5] = svizaposleni.getPol();
				sadrzaj[i][6] = svizaposleni.getKorisnickoIme();
				sadrzaj[i][7] = svizaposleni.getKorisnickaSifra();
				sadrzaj[i][8] = svizaposleni.getPlata();
				sadrzaj[i][9] = svizaposleni.isObrisan();
				sadrzaj[i][10] = svizaposleni.getZaposleni();
				
			}
			
			tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
			svizaposleniTabela = new JTable(tableModel);
			
			svizaposleniTabela.setRowSelectionAllowed(true);
			svizaposleniTabela.setColumnSelectionAllowed(false);
			svizaposleniTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			svizaposleniTabela.setDefaultEditor(Object.class, null);
			svizaposleniTabela.getTableHeader().setReorderingAllowed(false);
			
			JScrollPane scrollPane = new JScrollPane(svizaposleniTabela);
			add(scrollPane, BorderLayout.CENTER);
		}
		
		private void initActions() {
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = svizaposleniTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String svizaposleniId = tableModel.getValueAt(red, 0).toString();
						Zaposleni svizaposleni = biblioteka.pronadjiZaposlenog(svizaposleniId);
						int izbor = JOptionPane.showConfirmDialog(null, 
								"Da li ste sigurni da zelite da obrisete zaposlenog?", 
								svizaposleniId + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
						if(izbor == JOptionPane.YES_OPTION) {
							svizaposleni.setObrisan(true);
							tableModel.removeRow(red);
							biblioteka.snimiZaposlene(BibliotekaMain.ZAPOSLENI_FAJL);
						}
					}
				}
			});
			
			btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SviZaposleniForma df = new SviZaposleniForma(biblioteka, null);
					df.setVisible(true);
				}
			});
			
			btnEdit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int red = svizaposleniTabela.getSelectedRow();
					if(red == -1) {
						JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						String svizaposleniId = tableModel.getValueAt(red, 0).toString();
						Zaposleni svizaposleni = biblioteka.pronadjiZaposlenog(svizaposleniId);
						SviZaposleniForma df = new SviZaposleniForma(biblioteka, svizaposleni);
						df.setVisible(true);
					}
				}
			});
		}
		

}


