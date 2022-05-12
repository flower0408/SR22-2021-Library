package osobe;



public class Zaposleni extends Osoba {
	
	public Zaposleni() {
		this.korisnickoIme = "";
		this.korisnickaSifra = "";
		this.plata = 0;
	}

   
    protected String korisnickoIme;
    protected String korisnickaSifra;
    protected double plata;
    
    public Zaposleni(int id, String ime, String prezime, String JMBG, String adresa, EnumPol pol, String korisnickoIme, String korisnickaSifra, double plata) {
		super(id, ime, prezime, JMBG, adresa, pol);
		this.korisnickoIme = korisnickoIme;
		this.korisnickaSifra = korisnickaSifra;
		this.plata = plata;
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

	@Override
	public String toString() {
		return "ZAPOSLENI " + super.toString() +  
				"\nKorisnickoIme: " + this.korisnickoIme +
				"\nKorisnickaSifra: " + this.korisnickaSifra +
				"\nPlata: " + this.plata;
		
	}

}
