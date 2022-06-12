package gui.formeZaDodavanje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import osobe.Bibliotekar;
import osobe.EnumPol;
import osobe.EnumZaposleni;

import main.BibliotekaMain;

import net.miginfocom.swing.MigLayout;
import biblioteka.Biblioteka;


public class BibliotekariForma extends JFrame{
	
	private JLabel lbId = new JLabel ("ID");
	private JTextField txtId = new JTextField(25);
	private JLabel lbIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(25);
	private JLabel lbPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(25);
	private JLabel lbJMBG = new JLabel("JMBG");
	private JTextField txtJMBG = new JTextField(25);
	private JLabel lbAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(25);
	private JLabel lbPol = new JLabel("Pol");
	private JComboBox<String> cbPol = new JComboBox<String>();
	private JLabel lbKorisnickoIme = new JLabel("Korisnicko me");
	private JTextField txtKorisnickoIme = new JTextField(25);
	private JLabel lbKorisnickaSifra = new JLabel("Korisnicka sifra");
	private JTextField txtKorisnickaSifra = new JTextField(25);
	private JLabel lbPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(25);
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> cbObrisan = new JComboBox<Boolean>();
	private JLabel lbEnumZap = new JLabel("Tip Zaposlenog");
	private JComboBox<String> cbEnumZap = new JComboBox<String>();
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	


	private Biblioteka biblioteka;
	private Bibliotekar bibliotekar;
	
	public BibliotekariForma(Biblioteka biblioteka, Bibliotekar bibliotekar) {
		this.biblioteka = biblioteka;
		this.bibliotekar = bibliotekar;
		if (bibliotekar == null) {
			setTitle("Dodavanje bibliotekara");
		}
		else {
			setTitle("Izmena podataka bibliotekara - [" + bibliotekar.getId() + "]");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
		
	}



	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		if(bibliotekar != null) {
			txtId.setEnabled(false);
			popuniPolja();
			
		}
		
		add(lbId);
		add(txtId);
		add(lbIme);
		add(txtIme);
		add(lbPrezime);
		add(txtPrezime);
		add(lbJMBG);
		add(txtJMBG);
		add(lbAdresa);
		add(txtAdresa);
		add(lbPol);
		add(cbPol);
		add(lbKorisnickoIme);
		add(txtKorisnickoIme);
		add(lbKorisnickaSifra);
		add(txtKorisnickaSifra);
		add(lbPlata);
		add(txtPlata);
		add(lbObrisan);
		add(cbObrisan);
		add(lbEnumZap);
		add(cbEnumZap);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
		
		cbObrisan.addItem(true);
		cbObrisan.addItem(false);
		cbPol.addItem("MUSKI");
		cbPol.addItem("ZENSKI");
		cbEnumZap.addItem("ADMINISTRATOR");
		cbEnumZap.addItem("BIBLIOTEKAR");
		
	}
	
	private void popuniPolja() {
		txtId.setText(String.valueOf(bibliotekar.getId()));
		txtIme.setText(bibliotekar.getIme());
		txtPrezime.setText(bibliotekar.getPrezime());
		txtJMBG.setText(bibliotekar.getJMBG());
		txtAdresa.setText(bibliotekar.getAdresa());
		txtKorisnickoIme.setText(bibliotekar.getKorisnickoIme());
		txtKorisnickaSifra.setText(bibliotekar.getKorisnickaSifra());
		txtPlata.setText(String.valueOf(bibliotekar.getPlata()));
		cbObrisan.setSelectedItem(bibliotekar.isObrisan());
	
	
		
	}



	private void initActions() {
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String id = txtId.getText().trim();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String JMBG = txtJMBG.getText().trim();
					String adresa = txtAdresa.getText().trim();
					String pol =  (String) cbPol.getSelectedItem();
					String korisnickoIme  = txtKorisnickoIme.getText().trim();
					String korisnickaSifra  = txtKorisnickaSifra.getText().trim();
					double plata = Double.parseDouble(txtPlata.getText().trim());
					Boolean obrisan = (Boolean) cbObrisan.getSelectedItem();
					String zaposleni = (String) cbEnumZap.getSelectedItem();
					
					
					if(bibliotekar == null) { // DODAVANJE:
						Bibliotekar novi = new Bibliotekar(id, ime, prezime, JMBG, adresa, EnumPol.valueOf(pol), korisnickoIme, korisnickaSifra, plata, obrisan, EnumZaposleni.valueOf(zaposleni));
						biblioteka.dodajBibliotekara(novi);
					}else {
						bibliotekar.setIme(ime);
						bibliotekar.setPrezime(prezime);
						bibliotekar.setJMBG(JMBG);
						bibliotekar.setAdresa(adresa);
						bibliotekar.setPol(EnumPol.valueOf(pol));
						bibliotekar.setKorisnickoIme(korisnickoIme);
						bibliotekar.setKorisnickaSifra(korisnickaSifra);
						bibliotekar.setPlata(plata);
						bibliotekar.setObrisan(obrisan);
						bibliotekar.setZaposleni(EnumZaposleni.valueOf(zaposleni));
						}
					
					biblioteka.snimiBibliotekare(BibliotekaMain.BIBLIOTEKARI_FAJL);
					BibliotekariForma.this.dispose();
					BibliotekariForma.this.setVisible(false);
				}
			}
		});
	};
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Morate uneti ID\n";
			ok = false;
		}else if(bibliotekar == null) {
			String id = txtId.getText().trim();
			Bibliotekar pronadjen = biblioteka.pronadjiBibliotekara(id);
			if(pronadjen != null) {
				poruka += "- Bibliotekar sa unetim ID vec postoji\n";
				ok = false;
			}
		}
		if(txtId.getText().trim().equals("")) {
			poruka += "- Morate uneti id\n";
			ok = false;
		}
		
		if(txtIme.getText().trim().equals("")) {
			poruka += "- Morate uneti ime\n";
			ok = false;
		}
		
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "- Morate uneti prezime\n";
			ok = false;
		}
		
		if(txtJMBG.getText().trim().equals("")) {
			poruka += "- Morate uneti JMBG\n";
			ok = false;
		}
		
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "- Morate uneti adresu\n";
			ok = false;
		}
		
		
		
		if(txtKorisnickoIme.getText().trim().equals("")) {
			poruka += "- Morate uneti korisnicko ime\n";
			ok = false;
		}
		
		if(txtKorisnickaSifra.getText().trim().equals("")) {
			poruka += "- Morate uneti sifru\n";
			ok = false;
		}
		
		try {
			Double.parseDouble(txtPlata.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Plata mora biti broj\n";
			ok = false;
		}
		

		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}