package atributi;

public class PrimerakKnjige {
	
	public PrimerakKnjige() {
		this.id = 0;
		this.brStrana = 0;
		this.mekPovez = false;
		this.godinaStampanja = 0;
		this.jezikSatmpanja = "";
		this.iznajmljena = false;
		this.knjiga = new Knjiga();
	}

	    

		public PrimerakKnjige(int id, int brStrana, boolean mekPovez, int godinaStampanja, String jezikSatmpanja,
			boolean iznajmljena, Knjiga knjiga) {
		super();
		this.id = id;
		this.brStrana = brStrana;
		this.mekPovez = mekPovez;
		this.godinaStampanja = godinaStampanja;
		this.jezikSatmpanja = jezikSatmpanja;
		this.iznajmljena = iznajmljena;
		this.knjiga = knjiga;
	}



		protected int id;
	    protected int brStrana;
	    protected boolean mekPovez;
	    protected int godinaStampanja;
	    protected String jezikSatmpanja;
	    protected boolean iznajmljena;
	    protected Knjiga knjiga;
		public int getId() {
			return id;
		}



		public void setId(int id) {
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
					+ iznajmljena + ", knjiga=" + knjiga + "]";
		}
	    
		
	
	 

}
