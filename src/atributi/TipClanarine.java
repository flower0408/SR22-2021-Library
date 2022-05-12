package atributi;

public class TipClanarine {
	
	public TipClanarine() {
		this.id = "";
		this.naziv = "";
		this.cena = 0;
	}
	
	  

	    public TipClanarine(String id, String naziv, double cena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
	}
		protected String id;
	    protected String naziv;
	    protected double cena;
	    
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNaziv() {
			return naziv;
		}
		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}
		public double getCena() {
			return cena;
		}
		public void setCena(double cena) {
			this.cena = cena;
		}



		@Override
		public String toString() {
			return "TipClanarine [id=" + id + ", naziv=" + naziv + ", cena=" + cena + "]";
		}
	    
	    

}
