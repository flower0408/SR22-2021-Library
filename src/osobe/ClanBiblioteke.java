package osobe;

import java.time.LocalDate;

import atributi.TipClanarine;

public class ClanBiblioteke extends Osoba {


	protected String brClanskeKarte;
    protected LocalDate datumPoslednjeUplate;
    protected int brojMeseciClanarine;
    protected boolean aktivan;
    protected TipClanarine tipClanarine;
    protected boolean obrisan;
    
	
    public ClanBiblioteke() {
		super();
		this.brClanskeKarte = "";
		this.datumPoslednjeUplate = LocalDate.of(0,0,0);
		this.brojMeseciClanarine = 0;
		this.aktivan = false;
		this.tipClanarine = new TipClanarine();
		this.obrisan = false;
	}



	public ClanBiblioteke(int id, String ime, String prezime, String JMBG, String adresa, EnumPol pol,String brClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseciClanarine,
			boolean aktivan, TipClanarine tip, boolean obrisan) {
		super(id, ime, prezime, JMBG, adresa, pol);
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
	
	public boolean isObrisan() {
		return obrisan;
	}


	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}



	@Override
	public String toString() {
		return "ClanBiblioteke [brClanskeKarte=" + brClanskeKarte + ", datumPoslednjeUplate=" + datumPoslednjeUplate
				+ ", brojMeseciClanarine=" + brojMeseciClanarine + ", aktivan=" + aktivan + ", tip=" + tipClanarine + ", id="
				+ id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", pol="
				+ pol + ", obrisan=" + obrisan + "]";
	}




    

	
	
	

}
