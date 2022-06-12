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
import atributi.ZanrKnjige;
import gui.formeZaDodavanje.ClanoviForma;
import gui.formeZaDodavanje.SviZanroviForma;
import main.BibliotekaMain;
import osobe.ClanBiblioteke;

public class SviZanroviProzor extends JFrame {
	
	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable zanroviTabela;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	public SviZanroviProzor(Biblioteka biblioteka) {
		
		
		this.biblioteka = biblioteka;
		setTitle("Žanrovi knjiga");
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
		
		String[] zaglavlja = new String[] {"Oznaka", "Opis", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sviNeobrisaniAdministratori().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniZanrovi().size(); i++) {
			ZanrKnjige zanr = biblioteka.sviNeobrisaniZanrovi().get(i);
			sadrzaj[i][0] = zanr.getOznaka();
			sadrzaj[i][1] = zanr.getOpis();
			sadrzaj[i][2] = zanr.isObrisan();
		
	
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		zanroviTabela = new JTable(tableModel);
		
		zanroviTabela.setRowSelectionAllowed(true);
		zanroviTabela.setColumnSelectionAllowed(false);
		zanroviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		zanroviTabela.setDefaultEditor(Object.class, null);
		zanroviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(zanroviTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		initAction();
	}
	
	
	private void initAction() {
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SviZanroviForma zf = new SviZanroviForma(biblioteka, null);
				zf.setVisible(true);
				
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zanroviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					String zanrId = tableModel.getValueAt(red, 0).toString();
					ZanrKnjige z = biblioteka.pronadjiZanr(zanrId);
					SviZanroviForma zf = new SviZanroviForma(biblioteka, z);
						zf.setVisible(true);
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = zanroviTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					String zanrId = (String) tableModel.getValueAt(red, 0);
					ZanrKnjige z = biblioteka.pronadjiZanr(zanrId);
					
					int select = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete zanr?", 
							zanrId + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(select == JOptionPane.YES_OPTION) {
						z.setObrisan(true);
						tableModel.removeRow(red);
						biblioteka.snimiZanrove(BibliotekaMain.ZANROVI_FAJL);
					}
				}
			}
		});
		
	}
}

