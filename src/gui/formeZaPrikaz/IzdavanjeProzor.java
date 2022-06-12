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
import gui.formeZaDodavanje.AdministratoriForma;
import gui.formeZaDodavanje.IzdavanjeForma;
import main.BibliotekaMain;
import osobe.Administrator;
import atributi.IzdavanjeKnjige;
import atributi.PrimerakKnjige;

public class IzdavanjeProzor extends JFrame {
	
	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable iznajmljivanjeTabela;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	

	public IzdavanjeProzor(Biblioteka biblioteka) {

		
		this.biblioteka = biblioteka;
		setTitle("Izdavanje");
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
		
		
		String[] zaglavlja = new String[] {"Datum iznajmljivanja", "Datum vracanja", "Zaposleni", "Član", "Primerak knjige", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.svaNeobrisanaIzdavanja().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.svaNeobrisanaIzdavanja().size(); i++) {
			IzdavanjeKnjige iznajmljivanje = biblioteka.svaNeobrisanaIzdavanja().get(i);
			sadrzaj[i][0] = iznajmljivanje.getDatumIznajmljivanja();
			sadrzaj[i][1] = iznajmljivanje.getDatumVracanja();
			sadrzaj[i][2] = iznajmljivanje.getZaposleni();
			sadrzaj[i][3] = iznajmljivanje.getClan();
			sadrzaj[i][4] = iznajmljivanje.getPrimerak();
			sadrzaj[i][5] = iznajmljivanje.isObrisan();
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		iznajmljivanjeTabela = new JTable(tableModel);
		
		iznajmljivanjeTabela.setRowSelectionAllowed(true);
		iznajmljivanjeTabela.setColumnSelectionAllowed(false);
		iznajmljivanjeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		iznajmljivanjeTabela.setDefaultEditor(Object.class, null);
		iznajmljivanjeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(iznajmljivanjeTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
	private void initActions() {
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = iznajmljivanjeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					
					int	izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete administartora?"
							 + " - Porvrda brisanja");
					if(izbor == JOptionPane.YES_OPTION) {
						
						tableModel.removeRow(red);
						biblioteka.snimiIzdavanje(BibliotekaMain.IZNAJMLJIVANJE_FAJL);
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IzdavanjeForma df = new IzdavanjeForma(biblioteka, null);
				df.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = iznajmljivanjeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	

}


