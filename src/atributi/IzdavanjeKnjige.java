package atributi;

import java.time.LocalDateTime;

public class IzdavanjeKnjige {

    public IzdavanjeKnjige(LocalDateTime datumIznajmljivanja, LocalDateTime datumVracanja) {
		super();
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
	}
	protected LocalDateTime datumIznajmljivanja;
    protected LocalDateTime datumVracanja;
    
    
	public LocalDateTime getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(LocalDateTime datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public LocalDateTime getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(LocalDateTime datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
	@Override
	public String toString() {
		return "IzdavanjeKnjige [datumIznajmljivanja=" + datumIznajmljivanja + ", datumVracanja=" + datumVracanja + "]";
	}

	
}
