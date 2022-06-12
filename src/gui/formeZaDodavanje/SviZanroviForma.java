package gui.formeZaDodavanje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import atributi.TipClanarine;
import atributi.ZanrKnjige;
import main.BibliotekaMain;
import net.miginfocom.swing.MigLayout;
import osobe.Administrator;
import osobe.ClanBiblioteke;
import osobe.EnumPol;

public class SviZanroviForma extends JFrame {
	
	private JLabel lbOznaka = new JLabel ("Oznaka");
	private JTextField txtOznaka = new JTextField(25);
	private JLabel lbOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(25);
	private JLabel lbObrisan = new JLabel("Obrisan");
	private JComboBox<Boolean> boxObrisan = new JComboBox<Boolean>();
	
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private ZanrKnjige zanr;
	private Biblioteka biblioteka;
	
	
	public SviZanroviForma(Biblioteka biblioteka, ZanrKnjige zanr) {
		
		this.biblioteka = biblioteka;
		this.zanr = zanr;
		if(zanr == null) {
			setTitle("Dodavanje žanra knjige :");
		}else {
			setTitle("Izmena podataka žanra [" + zanr.getOznaka() + "]");
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initAction();
		setResizable(false);
		pack();

	}
	
	


	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
	
		boxObrisan.addItem(true);
		boxObrisan.addItem(false);
		

		if(zanr != null) {
			txtOznaka.setEnabled(false);
			popuniPolja();
		}
		
		
		add(lbOznaka);
		add(txtOznaka);
		add(lbOpis);
		add(txtOpis);
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
				SviZanroviForma.this.dispose();
				SviZanroviForma.this.setVisible(false);
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String oznaka = txtOznaka.getText().trim();	
					String opis = txtOpis.getText().trim();
					Boolean obrisan = (Boolean) boxObrisan.getSelectedItem();
					
					if(zanr == null) {
						ZanrKnjige novi = new ZanrKnjige (oznaka, opis, obrisan);
						biblioteka.dodajZanr(novi);
					}else {
						zanr.setOznaka(oznaka);
						zanr.setOpis(opis);
						zanr.setObrisan(obrisan);
						
					}
					biblioteka.snimiZanrove(BibliotekaMain.ZANROVI_FAJL);
					SviZanroviForma.this.dispose();
					SviZanroviForma.this.setVisible(false);
				
					
					
				}
			}
		});
		
	}
	
	
	
	
	private void popuniPolja() {
		
		txtOznaka.setText(String.valueOf(zanr.getOznaka()));
		txtOpis.setText(zanr.getOpis());
		boxObrisan.setSelectedItem(zanr.isObrisan());
		
		
	}
	
	
	private boolean validacija() {
		
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
	
		
		if(txtOznaka.getText().trim().equals("")) {
			poruka += "- Morate uneti id\n";
			ok = false;
		}
		
		if(txtOpis.getText().trim().equals("")) {
			poruka += "- Morate uneti ime\n";
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
		
	
	}
}



