package atributi;

import java.time.LocalDateTime;

import osobe.ClanBiblioteke;
import osobe.Zaposleni;

public class IzdavanjeKnjige {

    
	public IzdavanjeKnjige() {
		super();
		this.datumIznajmljivanja = null;
		this.datumVracanja = null;
		this.zaposleni = new Zaposleni();
		this.clan = new ClanBiblioteke();
		this.primerak = new PrimerakKnjige();
	}
	public IzdavanjeKnjige(LocalDateTime datumIznajmljivanja, LocalDateTime datumVracanja, Zaposleni zaposleni,
			ClanBiblioteke clan, PrimerakKnjige primerak) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.primerak = primerak;
	}
	protected LocalDateTime datumIznajmljivanja;
    protected LocalDateTime datumVracanja;
    protected Zaposleni zaposleni;
    protected ClanBiblioteke clan;
    protected PrimerakKnjige primerak;
    
    
	public LocalDateTime getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(LocalDateTime datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public LocalDateTime getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(LocalDateTime datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
	public Zaposleni getZaposleni() {
		return zaposleni;
	}
	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}
	public ClanBiblioteke getClan() {
		return clan;
	}
	public void setClan(ClanBiblioteke clan) {
		this.clan = clan;
	}
	public PrimerakKnjige getPrimerak() {
		return primerak;
	}
	public void setPrimerak(PrimerakKnjige primerak) {
		this.primerak = primerak;
	}
	
	@Override
	public String toString() {
		return "IzdavanjeKnjige [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja
				+ ", zaposleni=" + zaposleni + ", clan=" + clan + ", primerak=" + primerak + "]";
	}
    
    
	
	
}
