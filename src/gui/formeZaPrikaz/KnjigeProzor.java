package gui.formeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
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
import atributi.Knjiga;
import gui.formeZaDodavanje.KnjigeForma;
import main.BibliotekaMain;
import osobe.ClanBiblioteke;

public class KnjigeProzor extends JFrame {

	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable knjigeTabela;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	public KnjigeProzor(Biblioteka biblioteka) {
		
	
		this.biblioteka = biblioteka;
		setTitle("Knjige");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		gui();
		initAction();
	}

	


	private void gui() {
		
		
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
		
		
		String[] zaglavlja = new String[] {"ID", "Naslov", "Originalni naslov", "Pisac", "Godina publikacije","Jezik originala", "Opis knjige", "Žanr", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sveNeobrisaneKnjige().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sveNeobrisaneKnjige().size(); i++) {
			Knjiga knjiga = biblioteka.sveNeobrisaneKnjige().get(i);
			sadrzaj[i][0] = knjiga.getId();
			sadrzaj[i][1] = knjiga.getNaslovKnjige();
			sadrzaj[i][2] = knjiga.getOriginalniNaslovKnjige();
			sadrzaj[i][3] = knjiga.getPisac();
			sadrzaj[i][4] = knjiga.getGodinaPublikacije();
			sadrzaj[i][5] = knjiga.getJezikOriginala();
			sadrzaj[i][6] = knjiga.getOpis();
			sadrzaj[i][7] = knjiga.getZanr();
			sadrzaj[i][8] = knjiga.isObrisan();
	
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		knjigeTabela = new JTable(tableModel);
		
		knjigeTabela.setRowSelectionAllowed(true);
		knjigeTabela.setColumnSelectionAllowed(false);
		knjigeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		knjigeTabela.setDefaultEditor(Object.class, null);
		knjigeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(knjigeTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	}
		
	
	private void initAction() {
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigeForma kf = new KnjigeForma(biblioteka, null);
				kf.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = knjigeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					String knjigaId = tableModel.getValueAt(red, 0).toString();
					Knjiga k = biblioteka.pronadjiKnjigu(Integer.parseInt(knjigaId));
					KnjigeForma kf = new KnjigeForma(biblioteka, k);
						kf.setVisible(true);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = knjigeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					int knjigaID = (int) tableModel.getValueAt(red, 0);
					Knjiga k = biblioteka.pronadjiKnjigu(knjigaID);
					
					int select = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete knjigu?", 
							knjigaID + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(select == JOptionPane.YES_OPTION) {
						k.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiKnjige(BibliotekaMain.KNJIGE_FAJL);
					}
				}
			}
		});
		
	}

}
