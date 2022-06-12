package atributi;

public class PrimerakKnjige {
	
	public PrimerakKnjige() {
		this.id = "";
		this.brStrana = 0;
		this.mekPovez = false;
		this.godinaStampanja = 0;
		this.jezikSatmpanja = "";
		this.iznajmljena = false;
		this.knjiga = new Knjiga();
		this.obrisan = false;
	}

	    

		public PrimerakKnjige(String id, int brStrana, boolean mekPovez, int godinaStampanja, String jezikSatmpanja,
			boolean iznajmljena, Knjiga knjiga, boolean obrisan) {
		super();
		this.id = id;
		this.brStrana = brStrana;
		this.mekPovez = mekPovez;
		this.godinaStampanja = godinaStampanja;
		this.jezikSatmpanja = jezikSatmpanja;
		this.iznajmljena = iznajmljena;
		this.knjiga = knjiga;
		this.obrisan = obrisan;
	}



		protected String id;
	    protected int brStrana;
	    protected boolean mekPovez;
	    protected int godinaStampanja;
	    protected String jezikSatmpanja;
	    protected boolean iznajmljena;
	    protected Knjiga knjiga;
	    protected boolean obrisan;
	    
	


		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}



		public int getBrStrana() {
			return brStrana;
		}



		public void setBrStrana(int brStrana) {
			this.brStrana = brStrana;
		}



		public boolean isMekPovez() {
			return mekPovez;
		}



		public void setMekPovez(boolean mekPovez) {
			this.mekPovez = mekPovez;
		}



		public int getGodinaStampanja() {
			return godinaStampanja;
		}



		public void setGodinaStampanja(int godinaStampanja) {
			this.godinaStampanja = godinaStampanja;
		}



		public String getJezikSatmpanja() {
			return jezikSatmpanja;
		}



		public void setJezikSatmpanja(String jezikSatmpanja) {
			this.jezikSatmpanja = jezikSatmpanja;
		}



		public boolean isIznajmljena() {
			return iznajmljena;
		}



		public void setIznajmljena(boolean iznajmljena) {
			this.iznajmljena = iznajmljena;
		}



		public Knjiga getKnjiga() {
			return knjiga;
		}



		public void setKnjiga(Knjiga knjiga) {
			this.knjiga = knjiga;
		}



		@Override
		public String toString() {
			return "PrimerakKnjige [id=" + id + ", brStrana=" + brStrana + ", mekPovez=" + mekPovez
					+ ", godinaStampanja=" + godinaStampanja + ", jezikSatmpanja=" + jezikSatmpanja + ", iznajmljena="
					+ iznajmljena + ", knjiga=" + knjiga + ", obrisan=" + obrisan + "]";
		}



		public boolean isObrisan() {
			return obrisan;
		}



		public void setObrisan(boolean obrisan) {
			this.obrisan = obrisan;
		}
	    
		
	
	 

}
