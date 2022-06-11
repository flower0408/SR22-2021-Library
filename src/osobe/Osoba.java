package osobe;


public abstract class Osoba {
	
	public Osoba() {
    	this.id = "";
    	this.ime = "";
    	this.prezime = "";
    	this.JMBG = "";
    	this.adresa = "";
    	this.pol = EnumPol.ZENSKI;
    }

	 
    protected String id;
    protected String ime;
    protected String prezime;
    protected String JMBG;
    protected String adresa;
    protected EnumPol pol;
    
    public Osoba(String id, String ime, String prezime, String JMBG, String adresa, EnumPol pol) {
    	super();
    	this.id = id;
    	this.ime = ime;
    	this.prezime = prezime;
    	this.JMBG = JMBG;
    	this.adresa = adresa;
    	this.pol = pol;
    }



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public EnumPol getPol() {
		return pol;
	}

	public void setPol(EnumPol pol) {
		this.pol = pol;
	}

	@Override
	public String toString() {
		return "Osoba [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa
				+ ", pol=" + pol + "]";
	}


			
	}

    


