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


import osobe.Administrator;
import osobe.EnumPol;
import osobe.EnumZaposleni;

import main.BibliotekaMain;

import net.miginfocom.swing.MigLayout;
import biblioteka.Biblioteka;


public class AdministratoriForma extends JFrame{
	
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
	
	

	private Administrator administrator;
	private Biblioteka biblioteka;
	
	public AdministratoriForma(Biblioteka biblioteka, Administrator administrator) {
		this.biblioteka = biblioteka;
		this.administrator = administrator;
		if(administrator == null) {
			setTitle("Dodavanje administartora");
		}
		else {
			setTitle("Izmena podataka administartora - [" + administrator.getId() + "]");
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
		
		if(administrator != null) {
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
		txtId.setText(String.valueOf(administrator.getId()));
		txtIme.setText(administrator.getIme());
		txtPrezime.setText(administrator.getPrezime());
		txtJMBG.setText(administrator.getJMBG());
		txtAdresa.setText(administrator.getAdresa());
		txtKorisnickoIme.setText(administrator.getKorisnickoIme());
		txtKorisnickaSifra.setText(administrator.getKorisnickaSifra());
		txtPlata.setText(String.valueOf(administrator.getPlata()));
		cbObrisan.setSelectedItem(administrator.isObrisan());
	
	
		
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
					
					
					if(administrator == null) { // DODAVANJE:
						Administrator novi = new Administrator(id, ime, prezime, JMBG, adresa, EnumPol.valueOf(pol), korisnickoIme, korisnickaSifra, plata, obrisan, EnumZaposleni.valueOf(zaposleni));
						biblioteka.dodajAdministratora(novi);
					}else {
						administrator.setIme(ime);
						administrator.setPrezime(prezime);
						administrator.setJMBG(JMBG);
						administrator.setAdresa(adresa);
						administrator.setPol(EnumPol.valueOf(pol));
						administrator.setKorisnickoIme(korisnickoIme);
						administrator.setKorisnickaSifra(korisnickaSifra);
						administrator.setPlata(plata);
						administrator.setObrisan(obrisan);
						administrator.setZaposleni(EnumZaposleni.valueOf(zaposleni));
						}
					
					biblioteka.snimiAdministratore(BibliotekaMain.ADMINISTRATORI_FAJL);
					AdministratoriForma.this.dispose();
					AdministratoriForma.this.setVisible(false);
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
		}else if(administrator == null) {
			String id = txtId.getText().trim();
			Administrator pronadjen = biblioteka.pronadjiAdministartora(id);
			if(pronadjen != null) {
				poruka += "- Administrator sa unetim ID vec postoji\n";
				ok = false;
			}
		}
		try {
			Double.parseDouble(txtPlata.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Cena mora biti broj\n";
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
