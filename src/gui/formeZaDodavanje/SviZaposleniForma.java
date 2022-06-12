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


import osobe.EnumPol;
import osobe.EnumZaposleni;
import osobe.Zaposleni;
import main.BibliotekaMain;

import net.miginfocom.swing.MigLayout;
import biblioteka.Biblioteka;


public class SviZaposleniForma extends JFrame{
	
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
	
	

	private Zaposleni svizaposleni;
	private Biblioteka biblioteka;
	
	public SviZaposleniForma(Biblioteka biblioteka, Zaposleni svizaposleni) {
		this.biblioteka = biblioteka;
		this.svizaposleni = svizaposleni;
		if(svizaposleni == null) {
			setTitle("Dodavanje zaposlenog");
		}
		else {
			setTitle("Izmena podataka zaposlenog - " + svizaposleni.getId());
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
		
		if(svizaposleni != null) {
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
		txtId.setText(String.valueOf(svizaposleni.getId()));
		txtIme.setText(svizaposleni.getIme());
		txtPrezime.setText(svizaposleni.getPrezime());
		txtJMBG.setText(svizaposleni.getJMBG());
		txtAdresa.setText(svizaposleni.getAdresa());
		txtKorisnickoIme.setText(svizaposleni.getKorisnickoIme());
		txtKorisnickaSifra.setText(svizaposleni.getKorisnickaSifra());
		txtPlata.setText(String.valueOf(svizaposleni.getPlata()));
		cbObrisan.setSelectedItem(svizaposleni.isObrisan());
	
	
		
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
					
					
					if(svizaposleni == null) { // DODAVANJE:
						Zaposleni novi = new Zaposleni(id, ime, prezime, JMBG, adresa, EnumPol.valueOf(pol), korisnickoIme, korisnickaSifra, plata, obrisan, EnumZaposleni.valueOf(zaposleni));
						biblioteka.dodajZaposlenog(novi);
					}else {
						svizaposleni.setIme(ime);
						svizaposleni.setPrezime(prezime);
						svizaposleni.setJMBG(JMBG);
						svizaposleni.setAdresa(adresa);
						svizaposleni.setPol(EnumPol.valueOf(pol));
						svizaposleni.setKorisnickoIme(korisnickoIme);
						svizaposleni.setKorisnickaSifra(korisnickaSifra);
						svizaposleni.setPlata(plata);
						svizaposleni.setObrisan(obrisan);
						svizaposleni.setZaposleni(EnumZaposleni.valueOf(zaposleni));
						}
					
						biblioteka.snimiZaposlene(BibliotekaMain.ZAPOSLENI_FAJL);
						SviZaposleniForma.this.dispose();
						SviZaposleniForma.this.setVisible(false);
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
		}else if(svizaposleni == null) {
			String id = txtId.getText().trim();
			Zaposleni pronadjen = biblioteka.pronadjiZaposlenog(id);
			if(pronadjen != null) {
				poruka += "- Zaposleni sa unetim ID vec postoji\n";
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
