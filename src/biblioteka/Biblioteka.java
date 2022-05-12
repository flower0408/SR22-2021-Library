package biblioteka;

import java.util.ArrayList;

import atributi.IzdavanjeKnjige;
import atributi.Knjiga;
import atributi.PrimerakKnjige;
import atributi.TipClanarine;
import atributi.ZanrKnjige;
import osobe.Administrator;
import osobe.Bibliotekar;
import osobe.ClanBiblioteke;

public class Biblioteka {
	
	public Biblioteka() {
		this.id = "";
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.radnoVreme = "";
		this.administratori = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.clanoviBiblioteke = new ArrayList<ClanBiblioteke>();
		this.izdavanjeKnjiga = new ArrayList<IzdavanjeKnjige>();
		this.tipoviClanarine = new ArrayList<TipClanarine>();
		this.knjige = new ArrayList<Knjiga>();
		this.primerciKnjiga = new ArrayList<PrimerakKnjige>();
		this.zanroviKnjige = new ArrayList<ZanrKnjige>();
	}
	

	 
		


		public Biblioteka(String id, String naziv, String adresa, String telefon, String radnoVreme,
			ArrayList<Administrator> administratori, ArrayList<Bibliotekar> bibliotekari,
			ArrayList<ClanBiblioteke> clanoviBiblioteke, ArrayList<IzdavanjeKnjige> izdavanjeKnjiga,
			ArrayList<TipClanarine> tipoviClanarine, ArrayList<Knjiga> knjige, ArrayList<PrimerakKnjige> primerciKnjiga,
			ArrayList<ZanrKnjige> zanroviKnjige) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		this.administratori = administratori;
		this.bibliotekari = bibliotekari;
		this.clanoviBiblioteke = clanoviBiblioteke;
		this.izdavanjeKnjiga = izdavanjeKnjiga;
		this.tipoviClanarine = tipoviClanarine;
		this.knjige = knjige;
		this.primerciKnjiga = primerciKnjiga;
		this.zanroviKnjige = zanroviKnjige;
	}






		protected String id;
	    protected String naziv;
	    protected String adresa;
	    protected String telefon;
	    protected String radnoVreme;
	    protected ArrayList<Administrator> administratori;
	    protected ArrayList<Bibliotekar> bibliotekari;
	    protected ArrayList<ClanBiblioteke> clanoviBiblioteke;
	    protected ArrayList<IzdavanjeKnjige> izdavanjeKnjiga;
	    protected ArrayList<TipClanarine> tipoviClanarine;
	    protected ArrayList<Knjiga> knjige;
	    protected ArrayList<PrimerakKnjige> primerciKnjiga;
	    protected ArrayList<ZanrKnjige> zanroviKnjige;
	    
		public String getId() {
			return id;
		}






		

		public String getNaziv() {
			return naziv;
		}






		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}






		public String getAdresa() {
			return adresa;
		}






		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}






		public String getTelefon() {
			return telefon;
		}






		public void setTelefon(String telefon) {
			this.telefon = telefon;
		}






		public String getRadnoVreme() {
			return radnoVreme;
		}






		public void setRadnoVreme(String radnoVreme) {
			this.radnoVreme = radnoVreme;
		}






		public ArrayList<Administrator> getAdministratori() {
			return administratori;
		}






		public void setAdministratori(ArrayList<Administrator> administratori) {
			this.administratori = administratori;
		}






		public ArrayList<Bibliotekar> getBibliotekari() {
			return bibliotekari;
		}






		public void setBibliotekari(ArrayList<Bibliotekar> bibliotekari) {
			this.bibliotekari = bibliotekari;
		}






		public ArrayList<ClanBiblioteke> getClanoviBiblioteke() {
			return clanoviBiblioteke;
		}






		public void setClanoviBiblioteke(ArrayList<ClanBiblioteke> clanoviBiblioteke) {
			this.clanoviBiblioteke = clanoviBiblioteke;
		}






		public ArrayList<IzdavanjeKnjige> getIzdavanjeKnjiga() {
			return izdavanjeKnjiga;
		}






		public void setIzdavanjeKnjiga(ArrayList<IzdavanjeKnjige> izdavanjeKnjiga) {
			this.izdavanjeKnjiga = izdavanjeKnjiga;
		}






		public ArrayList<TipClanarine> getTipoviClanarine() {
			return tipoviClanarine;
		}






		public void setTipoviClanarine(ArrayList<TipClanarine> tipoviClanarine) {
			this.tipoviClanarine = tipoviClanarine;
		}






		public ArrayList<Knjiga> getKnjige() {
			return knjige;
		}






		public void setKnjige(ArrayList<Knjiga> knjige) {
			this.knjige = knjige;
		}






		public ArrayList<PrimerakKnjige> getPrimerciKnjiga() {
			return primerciKnjiga;
		}






		public void setPrimerciKnjiga(ArrayList<PrimerakKnjige> primerciKnjiga) {
			this.primerciKnjiga = primerciKnjiga;
		}






		public ArrayList<ZanrKnjige> getZanroviKnjige() {
			return zanroviKnjige;
		}






		public void setZanroviKnjige(ArrayList<ZanrKnjige> zanroviKnjige) {
			this.zanroviKnjige = zanroviKnjige;
		}






		public void setId(String id) {
			this.id = id;
		}






		@Override
		public String toString() {
			return "Biblioteka [id=" + id + ", naziv=" + naziv + ", adresa=" + adresa + ", telefon=" + telefon
					+ ", radnoVreme=" + radnoVreme + ", administratori=" + administratori + ", bibliotekari="
					+ bibliotekari + ", clanoviBiblioteke=" + clanoviBiblioteke + ", izdavanjeKnjiga=" + izdavanjeKnjiga
					+ ", tipoviClanarine=" + tipoviClanarine + ", knjige=" + knjige + ", primerciKnjiga="
					+ primerciKnjiga + ", zanroviKnjige=" + zanroviKnjige + "]";
		}
	    
	    
		
	    
		
	    
	    

}
