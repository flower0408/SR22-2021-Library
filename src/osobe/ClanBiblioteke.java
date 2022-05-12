package osobe;

import java.time.LocalDate;

import atributi.TipClanarine;

public class ClanBiblioteke extends Osoba {


	protected String brClanskeKarte;
    protected LocalDate datumPoslednjeUplate;
    protected int brojMeseciClanarine;
    protected boolean aktivan;
    protected TipClanarine tipClanarine;
    
	
    public ClanBiblioteke() {
		super();
		this.brClanskeKarte = "";
		this.datumPoslednjeUplate = null;
		this.brojMeseciClanarine = 0;
		this.aktivan = false;
		this.tipClanarine = new TipClanarine();
	}



	public ClanBiblioteke(String brClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseciClanarine,
			boolean aktivan, TipClanarine tip) {
		super();
		this.brClanskeKarte = brClanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseciClanarine = brojMeseciClanarine;
		this.aktivan = aktivan;
		this.tipClanarine = tip;
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

	public TipClanarine getTip() {
		return tipClanarine;
	}

	public void setTip(TipClanarine tip) {
		this.tipClanarine = tip;
	}




	@Override
	public String toString() {
		return "ClanBiblioteke [brClanskeKarte=" + brClanskeKarte + ", datumPoslednjeUplate=" + datumPoslednjeUplate
				+ ", brojMeseciClanarine=" + brojMeseciClanarine + ", aktivan=" + aktivan + ", tip=" + tipClanarine + ", id="
				+ id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol="
				+ pol + "]";
	}




    

	
	
	

}
