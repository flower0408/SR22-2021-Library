package gui.formeZaDodavanje;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import atributi.Knjiga;
import atributi.PrimerakKnjige;
import atributi.ZanrKnjige;
import gui.LoginProzor;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;


public class PrimerciForma extends JFrame {

	private JLabel lbId = new JLabel ("ID");
	private JTextField txtId = new JTextField(25);
	private JLabel lbBrStrana = new JLabel("Broj strana");
	private JTextField txtBrStrana = new JTextField(25);
	private JLabel lbPovez = new JLabel("Tip poveza");
	private JComboBox<Boolean> cbPovez = new JComboBox<Boolean>();
	private JLabel lbGodStampanja = new JLabel("Godina štampanja");
	private JTextField txtGodStampanja = new JTextField(25);
	private JLabel lbJezikStampanja = new JLabel("Jezik Stampanja");
	private JTextField txtJezikStampanja = new JTextField(25);
	private JLabel lbIznajmljena = new JLabel("Iznajmljena");
	private JComboBox<Boolean> cbIznajmljena = new JComboBox<Boolean>();
	private JLabel lbKnjiga= new JLabel("Knjiga primerka");
	private JComboBox<String> cbKnjiga = new JComboBox<String>();
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> cbObrisan = new JComboBox<Boolean>();
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private PrimerakKnjige primerak;
	private Biblioteka biblioteka;
	
	
	public PrimerciForma(Biblioteka biblioteka, PrimerakKnjige primerak) {
		
		this.biblioteka = biblioteka;
		this.primerak = primerak;
		if(primerak == null) {
			setTitle("Dodavanje knjige :");
		}else {
			setTitle("Izmena podataka knjige [" + primerak.getId() + "]");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450,420);
		setLocationRelativeTo(null);
		gui();
		initAction();

	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		cbPovez.addItem(true);
		cbPovez.addItem(false);
		cbIznajmljena.addItem(true);
		cbIznajmljena.addItem(false);
		cbObrisan.addItem(true);
		cbObrisan.addItem(false);
		
		
		
		cbKnjiga.addItem(" ");
		for(PrimerakKnjige primerak : biblioteka.sviNeobrisaniPrimerci()) {
			cbKnjiga.addItem(primerak.getId());
		}
		
		if(primerak != null) {
			txtId.setEnabled(false);
			popuniPolja();
		}
		
		
		add(lbId);
		add(txtId);
		add(lbBrStrana);
		add(txtBrStrana);
		add(lbPovez);
		add(cbPovez);
		add(lbGodStampanja);
		add(txtGodStampanja);
		add(lbJezikStampanja);
		add(txtJezikStampanja);
		add(lbIznajmljena);
		add(cbIznajmljena);
		add(lbKnjiga);
		add(cbKnjiga);
		add(lbObrisan);
		add(cbObrisan);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	
	
	private void initAction() {
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerciForma.this.dispose();
				PrimerciForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String id = txtId.getText().trim();	
					int brStrana = Integer.parseInt(txtBrStrana.getText().trim());	
					Boolean povez = (Boolean) cbPovez.getSelectedItem();
					int godStampanja = Integer.parseInt(txtGodStampanja.getText().trim());	
					String jezik = txtJezikStampanja.getText().trim();
					Boolean iznajmljena = (Boolean) cbIznajmljena.getSelectedItem();
					Knjiga knjiga = biblioteka.pronadjiKnjigu(Integer.parseInt(id));
					Boolean obrisan = (Boolean) cbObrisan.getSelectedItem();
					
					if(primerak == null) {
						PrimerakKnjige nova = new PrimerakKnjige (id, brStrana, povez, godStampanja, jezik, iznajmljena,  knjiga, obrisan);
						biblioteka.dodajPrimerakKnjige(nova);
					}else {
						primerak.setId(id);
						primerak.setBrStrana(brStrana);
						primerak.setMekPovez(povez);
						primerak.setGodinaStampanja(godStampanja);
						primerak.setJezikSatmpanja(jezik);
						primerak.setIznajmljena(iznajmljena);
						primerak.setKnjiga(knjiga);
						primerak.setObrisan(obrisan);
					}
					biblioteka.snimiKnjige(BibliotekaMain.KNJIGE_FAJL);
					PrimerciForma.this.dispose();
					PrimerciForma.this.setVisible(false);
				
					
					
				}
			}
		});
		
	}
	
	
	
	
	private void popuniPolja() {
		
		txtId.setText(primerak.getId());
		txtBrStrana.setText(String.valueOf(primerak.getBrStrana()));
		txtGodStampanja.setText(String.valueOf(primerak.getGodinaStampanja()));
		txtJezikStampanja.setText(primerak.getJezikSatmpanja());
		if(primerak == null) {
			cbKnjiga.setSelectedItem(" ");
		}else {
			cbKnjiga.setSelectedItem(primerak.getKnjiga().getId());
		}
		if(primerak == null) {
			cbPovez.setSelectedItem(" ");
		}else {
			cbPovez.setSelectedItem(primerak.isMekPovez());
		}
		if(primerak == null) {
			cbIznajmljena.setSelectedItem(" ");
		}else {
			cbIznajmljena.setSelectedItem(primerak.isIznajmljena());
		}
		if(primerak == null) {
			cbObrisan.setSelectedItem(false);
		}else {
			cbObrisan.setSelectedItem(primerak.isObrisan());
		}
		
		
		
	}
	
	
	private boolean validacija() {
		
		boolean ok = true;
		String poruka = "";
		
		
		try {
			Integer.parseInt(txtId.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "ID mora biti broj\n";
			ok = false;
		}
		
		if(primerak == null) {
			String id = txtId.getText().trim();
			PrimerakKnjige pronadjena = biblioteka.pronadjiPrimerak(id);
			if(pronadjena != null) {
				poruka += "Primerak sa unetim ID već postoji\n";
				ok = false;
			}
		}
		
		try {
			Integer.parseInt(txtBrStrana.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "Broj strana mora biti broj\n";
			ok = false;
		}
		
		if(cbPovez.getSelectedItem() == " ") {
			poruka += "Morate da označite povez\n";
			ok = false;
		}
		
		try {
			Integer.parseInt(txtGodStampanja.getText().trim());
		} catch (NumberFormatException e) {
			poruka += "Godina mora biti broj\n";
			ok = false;
		}
		
		if(txtJezikStampanja.getText().trim().equals("")) {
			poruka += "Morate uneti jezik \n";
			ok = false;
		}
		if(cbIznajmljena.getSelectedItem() == " ") {
			poruka += "Morate da označite iznajmljivanje\n";
			ok = false;
		}
		
		if(cbKnjiga.getSelectedItem() == " ") {
			poruka += "Morate da označite knjigu\n";
			ok = false;
		}
		
		if(cbObrisan.getSelectedItem() == " ") {
			poruka += "Morate da označite obrisan\n";
			ok = false;
		}
		
		
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
}