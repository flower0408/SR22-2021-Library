package atributi;

public class TipClanarine {
	
	public TipClanarine() {
		this.id = 0;
		this.naziv = "";
		this.cena = 0;
		this.obrisan = false;
	}
	
	  

	    public TipClanarine(int id, String naziv, double cena, boolean obrisan) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.obrisan = obrisan;
	}
		protected int id;
	    protected String naziv;
	    protected double cena;
	    protected boolean obrisan;
		


	


		public int getId() {
			return id;
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



		public void setId(int id) {
			this.id = id;
		}
		
		
		public boolean isObrisan() {
			return obrisan;
		}



		public void setObrisan(boolean obrisan) {
			this.obrisan = obrisan;
		}



		@Override
		public String toString() {
			return "TipClanarine [id=" + id + ", naziv=" + naziv + ", cena=" + cena + ", obrisan=" + obrisan + "]";
		}
	    
	    
		
	    
	    

}
