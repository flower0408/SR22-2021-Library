package main;
import java.time.LocalDate;

import atributi.IzdavanjeKnjige;
import atributi.Knjiga;
import atributi.PrimerakKnjige;
import atributi.TipClanarine;
import atributi.ZanrKnjige;
import biblioteka.Biblioteka;
import gui.LoginProzor;
import osobe.ClanBiblioteke;
import osobe.EnumPol;
import osobe.Zaposleni;



public class BibliotekaMain {
	
	
	
	public static String KNJIGE_FAJL = "knjige.txt";
	public static String ZANROVI_FAJL = "zanroviKnjige.txt";
	public static String CLANOVI_FAJL = "clanoviBiblioteke.txt";
	public static String PRIMERCIKNJIGA_FAJL = "primerciKnjiga.txt";
	private static String TIPOVICLANARINE_FAJL = "tipoviClanarine.txt";
	public static String ADMINISTRATORI_FAJL = "administratori.txt";
	public static String BIBLIOTEKARI_FAJL = "bibliotekari.txt";
	private static String IZNAJMLJIVANJE_FAJL = "izdavanjeKnjiga.txt";
	public static String ZAPOSLENI_FAJL = "sviZaposleni.txt";
	
	


public static void main(String[] args) {

	
	Biblioteka biblioteka = new Biblioteka();
	
	biblioteka.ucitajTipClanarine(TIPOVICLANARINE_FAJL);
	biblioteka.ucitajAdministratore(ADMINISTRATORI_FAJL);
	biblioteka.ucitajBibliotekare(BIBLIOTEKARI_FAJL);
	biblioteka.ucitajClanove(CLANOVI_FAJL);
	biblioteka.ucitajZanrove(ZANROVI_FAJL);
	biblioteka.ucitajKnjige(KNJIGE_FAJL);
	biblioteka.ucitajPrimerkeKnjiga(PRIMERCIKNJIGA_FAJL);
	biblioteka.ucitajIzdavanje(IZNAJMLJIVANJE_FAJL);
	biblioteka.ucitajZaposlene(ZAPOSLENI_FAJL);
	
	
	LoginProzor lp = new LoginProzor(biblioteka);
	lp.setVisible(true);
	
	
	//System.out.println("PODACI UCITANI IZ DATOTEKA:");
	//System.out.println("----------------------------------------------");
	//ispisiSvePodatke(biblioteka);
	//System.out.println("----------------------------------------------");
	
	
	
	
	
	//System.out.println("Dodavanje test podataka: ");
	
	
	//ClanBiblioteke testClan = new ClanBiblioteke(5,"Marko","Peric","6551546542","test adresa",EnumPol.ZENSKI,"006", LocalDate.of(2022, 02, 19), 24, true, biblioteka.pronadjiTipClanarine(2), false);
	//biblioteka.dodajClana(testClan);
	
	//ZanrKnjige testZanr = new ZanrKnjige("R", "roman", false);
	//biblioteka.dodajZanr(testZanr);
	
	
	
	//System.out.println("Snimanje dodanih podataka: ");
	//biblioteka.snimiClanove(CLANOVI_FAJL);
	//biblioteka.snimiZanrove(ZANROVI_FAJL);
	
	

}
/*public static void ispisiSvePodatke(Biblioteka biblioteka) {
	
	
	for(Zaposleni zaposlen : biblioteka.getSviZaposleni()) {
		System.out.println(zaposlen + "\n");
	}
	
	for(TipClanarine tip : biblioteka.getTipoviClanarine()) {
		System.out.println(tip + "\n");
	}
	
	for(ClanBiblioteke clan : biblioteka.getClanoviBiblioteke()) {
		System.out.println(clan + "\n");
	}
	
	for(ZanrKnjige zanr : biblioteka.getZanroviKnjige()) {
		System.out.println(zanr + "\n");
	}
	
	for(Knjiga knjiga : biblioteka.getKnjige()) {
		System.out.println(knjiga + "\n");
	}
	
	for(PrimerakKnjige primerci : biblioteka.getPrimerciKnjiga()) {
		System.out.println(primerci + "\n");
	}
	
	for(IzdavanjeKnjige iznajmljivanje : biblioteka.getIzdavanjeKnjiga()) {
		System.out.println(iznajmljivanje + "\n");
	}
	
}
*/
/**************************************************************************************************************************/



}


