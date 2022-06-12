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
import gui.formeZaDodavanje.KnjigeForma;
import gui.formeZaDodavanje.PrimerciForma;
import main.BibliotekaMain;
import atributi.Knjiga;
import atributi.PrimerakKnjige;

public class PrimerciKnjigaProzor extends JFrame {

	private Biblioteka biblioteka;
	private DefaultTableModel tableModel;
	private JTable primerciTabela;
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	

	public PrimerciKnjigaProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Primerci knjiga");
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
		
		
		String[] zaglavlja = new String[] {"ID", "Broj strana", "Tip poveza", "Godina stampanja", "Jezik stampanja", "Iznajmljena", "Knjiga", "Obrisan"};
		Object[][] sadrzaj = new Object[biblioteka.sveNeobrisaneKnjige().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.sviNeobrisaniPrimerci().size(); i++) {
			PrimerakKnjige primerak = biblioteka.sviNeobrisaniPrimerci().get(i);
			sadrzaj[i][0] = primerak.getId();
			sadrzaj[i][1] = primerak.getBrStrana();
			sadrzaj[i][2] = primerak.isMekPovez();
			sadrzaj[i][3] = primerak.getGodinaStampanja();
			sadrzaj[i][4] = primerak.getJezikSatmpanja();
			sadrzaj[i][5] = primerak.isIznajmljena();
			sadrzaj[i][6] = primerak.getKnjiga();
			sadrzaj[i][7] = primerak.isObrisan();
			
	
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		primerciTabela = new JTable(tableModel);
		
		primerciTabela.setRowSelectionAllowed(true);
		primerciTabela.setColumnSelectionAllowed(false);
		primerciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primerciTabela.setDefaultEditor(Object.class, null);
		primerciTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primerciTabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
private void initAction() {
	
	btnAdd.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			PrimerciForma kf = new PrimerciForma(biblioteka, null);
			kf.setVisible(true);
			
		}
	});
	
	btnEdit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int red = primerciTabela.getSelectedRow();
			if(red == -1) {
				JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli !", "Greska", JOptionPane.WARNING_MESSAGE);
			}else {
				
				String primerciId = tableModel.getValueAt(red, 0).toString();
				PrimerakKnjige p = biblioteka.pronadjiPrimerak(primerciId);
				PrimerciForma kf = new PrimerciForma(biblioteka, p);
					kf.setVisible(true);
			}
		}
	});
	
	btnDelete.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int red = primerciTabela.getSelectedRow();
			if(red == -1) {
				JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
			}else {
				
				String primerciId = tableModel.getValueAt(red, 0).toString();
				PrimerakKnjige k = biblioteka.pronadjiPrimerak(primerciId);
				
				int select = JOptionPane.showConfirmDialog(null, 
						"Da li ste sigurni da zelite da obrisete knjigu?", 
						primerciId + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
				if(select == JOptionPane.YES_OPTION) {
					k.setObrisan(true);
					tableModel.removeRow(red);
					biblioteka.snimiPrimerkeKnjiga(BibliotekaMain.PRIMERCIKNJIGA_FAJL);
				}
			}
		}
	});
	
}

}

