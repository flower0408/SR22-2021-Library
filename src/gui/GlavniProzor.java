package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteka.Biblioteka;
import gui.formeZaPrikaz.AdministratoriProzor;
import gui.formeZaPrikaz.BibliotekaProzor;
import gui.formeZaPrikaz.BibliotekariProzor;
import gui.formeZaPrikaz.ClanoviProzor;
import gui.formeZaPrikaz.IzdavanjeProzor;
import gui.formeZaPrikaz.KnjigeProzor;
import gui.formeZaPrikaz.PrimerciKnjigaProzor;
import gui.formeZaPrikaz.SpisakZaposlenihProzor;
import gui.formeZaPrikaz.SviZanroviProzor;
import gui.formeZaPrikaz.SviZaposleniProzor;
import gui.formeZaPrikaz.ZanroviProzor;
import net.miginfocom.swing.MigLayout;
import osobe.Zaposleni;

import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;


public class GlavniProzor extends JFrame {

		
		private JMenuBar mainMenu = new JMenuBar();
		private JMenu zaposleniMenu = new JMenu("Zaposleni");
		private JMenuItem sviZaposleniItem = new JMenuItem("Svi zaposleni");
		private JMenuItem administratoriItem = new JMenuItem("Administratori");
		private JMenuItem bibliotekariItem = new JMenuItem("Bibliotekari");
		private JMenu podaciOKnjigamaMenu = new JMenu("Podaci o knjigama");
		private JMenuItem knjigeItem = new JMenuItem("Knjige");
		private JMenuItem primerciKnjigaItem = new JMenuItem("Primerci knjiga");
		private JMenuItem zanroviKnjigaItem = new JMenuItem("Žanrovi knjiga");
		private JMenu podaciOClanovimaMenu = new JMenu("Podaci o članovima");
		private JMenuItem clanoviItem = new JMenuItem("Članovi");
		private JMenu podaciOIzdavanjuMenu = new JMenu("Podaci o izdavanju");
		private JMenuItem izdavanjeItem = new JMenuItem("Izdavanje ");
		private JMenu bibliotekaMenu = new JMenu("Biblioteka");
		private JMenuItem izmenaPodatakaItem = new JMenuItem("Izmena podataka");
		private JLabel lblNewLabel = new JLabel("New label");
		
		private Biblioteka biblioteka;
		private Zaposleni prijavljeniKorisnik;
		
		public GlavniProzor(Biblioteka biblioteka, Zaposleni prijavljeniKorisnik) {
			this.biblioteka = biblioteka;
			this.prijavljeniKorisnik = prijavljeniKorisnik;
			setTitle("Zaposleni: " + prijavljeniKorisnik.getKorisnickoIme());
			setSize(500, 500);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			initMenu();
			initActions();
		}
		private void initMenu() {
			setJMenuBar(mainMenu);
			mainMenu.add(zaposleniMenu);
			zaposleniMenu.add(sviZaposleniItem);
			zaposleniMenu.add(administratoriItem);
			zaposleniMenu.add(bibliotekariItem);
			mainMenu.add(podaciOKnjigamaMenu);
			podaciOKnjigamaMenu.add(knjigeItem);
			podaciOKnjigamaMenu.add(primerciKnjigaItem);
			podaciOKnjigamaMenu.add(zanroviKnjigaItem);
			mainMenu.add(podaciOClanovimaMenu);
			podaciOClanovimaMenu.add(clanoviItem);
			mainMenu.add(podaciOIzdavanjuMenu);
			podaciOIzdavanjuMenu.add(izdavanjeItem);
			mainMenu.add(bibliotekaMenu);
			bibliotekaMenu.add(izmenaPodatakaItem);
			
		}
	
		private void initActions() {
			sviZaposleniItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SviZaposleniProzor pp = new SviZaposleniProzor(biblioteka);
					pp.setVisible(true);
				}
			});
			
			administratoriItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					AdministratoriProzor kp = new AdministratoriProzor(biblioteka);
					kp.setVisible(true);
				}
			});
			
			bibliotekariItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					BibliotekariProzor dp = new BibliotekariProzor(biblioteka);
					dp.setVisible(true);
				}
			});
			
			knjigeItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					KnjigeProzor kp = new KnjigeProzor(biblioteka);
					kp.setVisible(true);
				}
			});
			
			
			primerciKnjigaItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					PrimerciKnjigaProzor kp = new PrimerciKnjigaProzor(biblioteka);
					kp.setVisible(true);
				}
			});
			
			zanroviKnjigaItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SviZanroviProzor kp = new SviZanroviProzor(biblioteka);
					kp.setVisible(true);
				}
			});
			
			clanoviItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ClanoviProzor kp = new ClanoviProzor(biblioteka);
					kp.setVisible(true);
				}
			});
			
			izdavanjeItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					IzdavanjeProzor kp = new IzdavanjeProzor(biblioteka);
					kp.setVisible(true);
				}
			});
			
			izmenaPodatakaItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					BibliotekaProzor kp = new BibiotekaProzor(biblioteka);
					kp.setVisible(true);
				}
			});
			
		}
		
	

	
}
