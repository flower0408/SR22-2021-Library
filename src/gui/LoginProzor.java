package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import osobe.EnumZaposleni;
import osobe.Zaposleni;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import biblioteka.Biblioteka;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class LoginProzor extends JFrame {
	
	Image icon = Toolkit.getDefaultToolkit().getImage("src/slike/61457.png");    
	
	private JLabel lbPoruka = new JLabel("MOLIMO DA SE PRIJAVITE:");
	private JLabel lbKorisnickoIme = new JLabel("Korisničko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lbSifra = new JLabel("Šifra");
	private JPasswordField pfSifra = new JPasswordField(20);
	private JLabel lblZaposleni = new JLabel("Tip zaposlenog");
	private JComboBox<EnumZaposleni> cbZaposleni = new JComboBox<EnumZaposleni>();
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	private Biblioteka biblioteka;
	
	
	
	public LoginProzor(Biblioteka biblioteka) {
		setResizable(false);
		getContentPane().setBackground(new Color(240, 248, 255));
		this.biblioteka = biblioteka;
		setTitle("PRIJAVA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(icon);
		initGUI();
		initActions();
		pack();
		
	}

	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]10[][]");
		getContentPane().setLayout(mig);
		
		getContentPane().add(lbPoruka, "cell 0 0 2 1");
		getContentPane().add(lbKorisnickoIme, "cell 0 1");
		getContentPane().add(txtKorisnickoIme, "cell 1 1");
		getContentPane().add(lbSifra, "cell 0 2");
		getContentPane().add(pfSifra, "cell 1 2");
		
		getContentPane().add(lblZaposleni, "cell 0 3");
		cbZaposleni.setModel(new DefaultComboBoxModel(EnumZaposleni.values()));
		
		getContentPane().add(cbZaposleni, "cell 1 3");
	
		
		
		
		getContentPane().add(new JLabel(), "flowx,cell 0 4");
		getContentPane().add(btnOk, "cell 1 4");
		getContentPane().add(btnCancel, "cell 1 4");
		
		
		txtKorisnickoIme.setText("petarp");
		pfSifra.setText("1234");
	
		getRootPane().setDefaultButton(btnOk);
	}
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzor.this.dispose();
				LoginProzor.this.setVisible(false);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnikoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(pfSifra.getPassword()).trim();
				EnumZaposleni zaposleni = (EnumZaposleni)cbZaposleni.getSelectedItem();
				
				
				if(korisnikoIme.equals("") || sifra.equals("") || zaposleni.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					Zaposleni prijavljeni = biblioteka.login(korisnikoIme, sifra, zaposleni);
					if(prijavljeni == null) {
						JOptionPane.showMessageDialog(null, "Pogrešni login podaci.", "Greška", JOptionPane.WARNING_MESSAGE);
					}else {
						LoginProzor.this.dispose();
						LoginProzor.this.setVisible(false);
						GlavniProzor gp = new GlavniProzor(biblioteka, prijavljeni);
						gp.setVisible(true);
					}
				}
			}
		});
		
	}


		
	}


	

