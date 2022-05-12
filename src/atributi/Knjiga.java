package atributi;

public class Knjiga {
	
	 public Knjiga() {
			this.id = 0;
			this.naslovKnjige = "";
			this.originalniNaslovKnjige = "";
			this.pisac = "";
			this.godinaPublikacije = 0;
			this.jezikOriginala = "";
			this.opis = "";
		}
	
  
    public Knjiga(int id, String naslovKnjige, String originalniNaslovKnjige, String pisac, int godinaPublikacije,
			String jezikOriginala, String opis) {
		super();
		this.id = id;
		this.naslovKnjige = naslovKnjige;
		this.originalniNaslovKnjige = originalniNaslovKnjige;
		this.pisac = pisac;
		this.godinaPublikacije = godinaPublikacije;
		this.jezikOriginala = jezikOriginala;
		this.opis = opis;
	}

	protected int id;
    protected String naslovKnjige;
    protected String originalniNaslovKnjige;
    protected String pisac;
    protected int godinaPublikacije;
    protected String jezikOriginala;
    protected String opis;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaslovKnjige() {
		return naslovKnjige;
	}
	public void setNaslovKnjige(String naslovKnjige) {
		this.naslovKnjige = naslovKnjige;
	}
	public String getOriginalniNaslovKnjige() {
		return originalniNaslovKnjige;
	}
	public void setOriginalniNaslovKnjige(String originalniNaslovKnjige) {
		this.originalniNaslovKnjige = originalniNaslovKnjige;
	}
	public String getPisac() {
		return pisac;
	}
	public void setPisac(String pisac) {
		this.pisac = pisac;
	}
	public int getGodinaPublikacije() {
		return godinaPublikacije;
	}
	public void setGodinaPublikacije(int godinaPublikacije) {
		this.godinaPublikacije = godinaPublikacije;
	}
	public String getJezikOriginala() {
		return jezikOriginala;
	}
	public void setJezikOriginala(String jezikOriginala) {
		this.jezikOriginala = jezikOriginala;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}


	@Override
	public String toString() {
		return "Knjiga [id=" + id + ", naslovKnjige=" + naslovKnjige + ", originalniNaslovKnjige="
				+ originalniNaslovKnjige + ", pisac=" + pisac + ", godinaPublikacije=" + godinaPublikacije
				+ ", jezikOriginala=" + jezikOriginala + ", opis=" + opis + "]";
	}


}
