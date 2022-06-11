package osobe;



public class Zaposleni extends Osoba {
	
	public Zaposleni() {
		this.korisnickoIme = "";
		this.korisnickaSifra = "";
		this.plata = 0;
		this.obrisan = false;
		this.zaposleni = EnumZaposleni.ADMINISTRATOR;
	}

   
    protected String korisnickoIme;
    protected String korisnickaSifra;
    protected double plata;
    protected boolean obrisan;
    protected EnumZaposleni zaposleni;
    
    public Zaposleni(String id, String ime, String prezime, String JMBG, String adresa, EnumPol pol, String korisnickoIme, String korisnickaSifra, double plata, boolean obrisan, EnumZaposleni zaposleni) {
		super(id, ime, prezime, JMBG, adresa, pol);
		this.korisnickoIme = korisnickoIme;
		this.korisnickaSifra = korisnickaSifra;
		this.plata = plata;
		this.obrisan = obrisan;
		this.zaposleni = zaposleni;
		
	}
    
    

	public EnumZaposleni getZaposleni() {
		return zaposleni;
	}



	public void setZaposleni(EnumZaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}



	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getKorisnickaSifra() {
		return korisnickaSifra;
	}

	public void setKorisnickaSifra(String korisnickaSifra) {
		this.korisnickaSifra = korisnickaSifra;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}
	public boolean isObrisan() {
		return obrisan;
	}


	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Zaposleni [korisnickoIme=" + korisnickoIme + ", korisnickaSifra=" + korisnickaSifra + ", plata=" + plata
				+ ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa
				+ ", pol=" + pol + ", obrisan=" + obrisan + ", zaposleni=" + zaposleni + "]";
	
	}
	
}
