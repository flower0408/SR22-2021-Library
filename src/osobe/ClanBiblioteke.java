package osobe;

import java.time.LocalDate;

public class ClanBiblioteke extends Osoba {
	
	public ClanBiblioteke() {
		this.brClanskeKarte = "";
		this.datumPoslednjeUplate = null;
		this.brojMeseciClanarine = 0;
		this.aktivan = false;
	}
	
    

    protected String brClanskeKarte;
    protected LocalDate datumPoslednjeUplate;
    protected int brojMeseciClanarine;
    protected boolean aktivan;
    
    public ClanBiblioteke(int id, String ime, String prezime, String JMBG, String adresa, EnumPol pol, String brClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseciClanarine, boolean aktivan) {
		super(id, ime, prezime, JMBG, adresa, pol);
		this.brClanskeKarte = brClanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciClanarine = brojMeseciClanarine;
		this.aktivan = aktivan;
	}

	
	
	public String getBrClanskeKarte() {
		return brClanskeKarte;
	}



	public void setBrClanskeKarte(String brClanskeKarte) {
		this.brClanskeKarte = brClanskeKarte;
	}



	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}



	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}



	public int getBrojMeseciClanarine() {
		return brojMeseciClanarine;
	}



	public void setBrojMeseciClanarine(int brojMeseciClanarine) {
		this.brojMeseciClanarine = brojMeseciClanarine;
	}



	public boolean isAktivan() {
		return aktivan;
	}



	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}



	@Override
	public String toString() {
		return "ZAPOSLENI " + super.toString() +  
				"\nBrClanskeKarte: " + this.brClanskeKarte +
				"\nDatumPoslednjeUplate: " + this.datumPoslednjeUplate +
				"\nBrojMeseciClanarine: " + this.brojMeseciClanarine + 
				"\nAktivan: " + this.aktivan;
		
	}

}
