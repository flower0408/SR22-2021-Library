package atributi;

public class ZanrKnjige {
	
	public ZanrKnjige() {
		this.oznaka = "";
		this.opis = "";
		this.obrisan = false;
	}
    
    public ZanrKnjige(String oznaka, String opis, boolean obrisan) {
		super();
		this.oznaka = oznaka;
		this.opis = opis;
		this.obrisan = obrisan;
	}
	protected String oznaka;
    protected String opis;
    protected boolean obrisan;
    
    
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "ZanrKnjige [oznaka=" + oznaka + ", opis=" + opis + ", obrisan=" + obrisan + "]";
	}
    
    

}
