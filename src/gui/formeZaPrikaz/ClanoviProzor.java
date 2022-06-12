package gui.formeZaPrikaz;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import biblioteka.Biblioteka;
import gui.formeZaDodavanje.ClanoviForma;
import atributi.Knjiga;

import main.BibliotekaMain;
import osobe.ClanBiblioteke;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Toolkit;

public class ClanoviProzor extends JFrame {

	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable clanoviTabela;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	

	public ClanoviProzor(Biblioteka biblioteka) {
		
		this.biblioteka = biblioteka;
		setTitle("Članovi biblioteke");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initAction();
		
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
		
		
		
		String[] zaglavlja = new String[] {"ID", "Ime", "Prezime", "JMBG", "Adresa", "Pol", "Broj članske karte", "Datum poslednje uplate", "Broj meseci članarine", "Aktivan", "Tip članarine", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniClanovi().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniClanovi().size(); i++) {
			ClanBiblioteke clan = biblioteka.sviNeobrisaniClanovi().get(i);
			sadrzaj[i][0] = clan.getId();
			sadrzaj[i][1] = clan.getIme();
			sadrzaj[i][2] = clan.getPrezime();
			sadrzaj[i][3] = clan.getJMBG();
			sadrzaj[i][4] = clan.getAdresa();
			sadrzaj[i][5] = clan.getPol();
			sadrzaj[i][6] = clan.getBrClanskeKarte();
			sadrzaj[i][7] = clan.getDatumPoslednjeUplate();
			sadrzaj[i][8] = clan.getBrojMeseciClanarine();
			sadrzaj[i][9] = clan.isAktivan();
			sadrzaj[i][10] = clan.getTip();
			sadrzaj[i][11] = clan.isObrisan();
			
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		clanoviTabela = new JTable(tableModel);
		
		clanoviTabela.setRowSelectionAllowed(true);
		clanoviTabela.setColumnSelectionAllowed(false);
		clanoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clanoviTabela.setDefaultEditor(Object.class, null);
		clanoviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(clanoviTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		
	}
	
	private void initAction() {
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClanoviForma cf = new ClanoviForma(biblioteka, null);
				cf.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = clanoviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					String clanId = tableModel.getValueAt(red, 0).toString();
					ClanBiblioteke c = biblioteka.pronadjiClana(clanId);
					ClanoviForma cf = new ClanoviForma(biblioteka, c);
					cf.setVisible(true);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = clanoviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					String clanId = (String) tableModel.getValueAt(red, 0);
					ClanBiblioteke c = biblioteka.pronadjiClana(clanId);
					
					int select = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete clana?", 
							clanId + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(select == JOptionPane.YES_OPTION) {
						c.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiClanove(main.BibliotekaMain.CLANOVI_FAJL);
					}
				}
			}
		});
		
	}



}