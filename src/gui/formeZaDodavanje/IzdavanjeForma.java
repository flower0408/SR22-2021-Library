package gui.formeZaDodavanje;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.LineBreakMeasurer;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import atributi.IzdavanjeKnjige;
import atributi.Knjiga;
import atributi.PrimerakKnjige;
import atributi.TipClanarine;
import atributi.ZanrKnjige;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import osobe.ClanBiblioteke;
import osobe.EnumPol;
import osobe.Zaposleni;

public class IzdavanjeForma extends JFrame {
	
	private JLabel lbDatumIznajmljivanja = new JLabel("Datum iznajmljivanja");
	private JTextField txtDatumIznajmljivanja = new JTextField(25);
	private JLabel lbDatumVracanja = new JLabel("Datum vraćanja");
	private JTextField txtDatumVracanja = new JTextField(25);
	private JLabel lbZaposleni = new JLabel("Zaposleni");
	private JComboBox<String> boxZaposleni = new JComboBox<String>();
	private JLabel lbClan = new JLabel("Član");
	private JComboBox<String> boxClan = new JComboBox<String>();
	private JLabel lbPrimerak = new JLabel("Primerak");
	private JComboBox<String> boxPrimerak = new JComboBox<String>();
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> boxObrisan = new JComboBox<Boolean>();
	
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private IzdavanjeKnjige izdavanje;
	private Biblioteka biblioteka;
	
	
	public IzdavanjeForma(Biblioteka biblioteka, IzdavanjeKnjige izdavanje) {
		
		this.biblioteka = biblioteka;
		this.izdavanje = izdavanje;
		if(izdavanje == null) {
			setTitle("Dodavanje izdavanja :");
		}else {
			setTitle("Izmena podataka izdavanja ");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		gui();
		initAction();
		setResizable(false);
		pack();
	}
	
	

	private void gui() {
		
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		boxObrisan.addItem(true);
		boxObrisan.addItem(false);

		
		for(Zaposleni zaposleni : biblioteka.sviNeobrisaniZaposleni()) {
			boxZaposleni.addItem(zaposleni.getId());
		}
		
		if(izdavanje != null) {
			popuniPolja();
		}
		
		
		add(lbDatumIznajmljivanja);
		add(txtDatumIznajmljivanja);
		add(lbDatumVracanja);
		add(txtDatumVracanja);
		add(lbZaposleni);
		add(boxZaposleni);
		add(lbClan);
		add(boxClan);
		add(lbPrimerak);
		add(boxPrimerak);
		add(lbObrisan);
		add(boxObrisan);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	
	
	private void initAction() {
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IzdavanjeForma.this.dispose();
				IzdavanjeForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					LocalDate iznajmljivanje = LocalDate.parse(txtDatumIznajmljivanja.getText().trim()) ;
					LocalDate vracanje = LocalDate.parse(txtDatumVracanja.getText().trim()) ;
					String zaposleniId = boxZaposleni.getSelectedItem().toString();
					Zaposleni  zaposleni = biblioteka.pronadjiZaposlenog(zaposleniId) ;
					String clanId = boxClan.getSelectedItem().toString();
					ClanBiblioteke  clan = biblioteka.pronadjiClana(clanId) ;
					String primerakId = boxPrimerak.getSelectedItem().toString();
					PrimerakKnjige  primerak = biblioteka.pronadjiPrimerak(primerakId) ;
					Boolean obrisan = (Boolean) boxObrisan.getSelectedItem();
					
					if(izdavanje == null) {
						IzdavanjeKnjige novi = new IzdavanjeKnjige (iznajmljivanje, vracanje, zaposleni, clan, primerak, obrisan );
						biblioteka.dodajIzdavanje(novi);
					}else {
						izdavanje.setDatumIznajmljivanja(iznajmljivanje);
						izdavanje.setDatumVracanja(vracanje);
						izdavanje.setZaposleni(zaposleni);
						izdavanje.setClan(clan);
						izdavanje.setPrimerak(primerak);
						izdavanje.setObrisan(obrisan);
					}
					biblioteka.snimiClanove(main.BibliotekaMain.IZNAJMLJIVANJE_FAJL);
					IzdavanjeForma.this.dispose();
					IzdavanjeForma.this.setVisible(false);
				
					
					
				}
			}
		});
		
	}
	
	
	
	
	private void popuniPolja() {
		
		txtDatumIznajmljivanja.setText(izdavanje.getDatumIznajmljivanja().toString());
		txtDatumVracanja.setText(izdavanje.getDatumVracanja().toString());
		boxZaposleni.setSelectedItem(izdavanje.getZaposleni());
		boxClan.setSelectedItem(izdavanje.getClan());
		boxPrimerak.setSelectedItem(izdavanje.getPrimerak());
		boxObrisan.setSelectedItem(izdavanje.isObrisan());
		
		
	}
	
	
	private boolean validacija() {
		
		return true;
	}
}

