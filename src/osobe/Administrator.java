package osobe;

public class Administrator extends Zaposleni{
	
	public Administrator() {
		super();
			}
	

	public Administrator(int id, String ime, String prezime, String JMBG, String adresa, EnumPol pol,
			String korisnickoIme, String korisnickaSifra, double plata, boolean obrisan, EnumZaposleni zaposleni) {
		super(id, ime, prezime, JMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata, obrisan, zaposleni);
			}


	@Override
	public String toString() {
		return "Administrator [korisnickoIme=" + korisnickoIme + ", korisnickaSifra=" + korisnickaSifra + ", plata="
				+ plata + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa="
				+ adresa + ", pol=" + pol + ", obrisan=" + obrisan + ", zaposleni=" + zaposleni + "]";
	}
	
	

}
