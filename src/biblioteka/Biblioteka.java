package biblioteka;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import atributi.IzdavanjeKnjige;
import atributi.Knjiga;
import atributi.PrimerakKnjige;
import atributi.TipClanarine;
import atributi.ZanrKnjige;
import osobe.Administrator;
import osobe.Bibliotekar;
import osobe.ClanBiblioteke;
import osobe.EnumPol;
import osobe.EnumZaposleni;
import osobe.Zaposleni;

public class Biblioteka {
	
	public Biblioteka() {
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.radnoVreme = "";
		this.sviZaposleni = new ArrayList<Zaposleni>();
		this.administratori = new ArrayList<Administrator>();
		this.bibliotekari = new ArrayList<Bibliotekar>();
		this.clanoviBiblioteke = new ArrayList<ClanBiblioteke>();
		this.izdavanjeKnjiga = new ArrayList<IzdavanjeKnjige>();
		this.tipoviClanarine = new ArrayList<TipClanarine>();
		this.knjige = new ArrayList<Knjiga>();
		this.primerciKnjiga = new ArrayList<PrimerakKnjige>();
		this.zanroviKnjige = new ArrayList<ZanrKnjige>();
	}
	

	 
		


		public Biblioteka( String naziv, String adresa, String telefon, String radnoVreme, ArrayList<Zaposleni> sviZaposleni,ArrayList<Administrator> administratori, ArrayList<Bibliotekar> bibliotekari,
			ArrayList<ClanBiblioteke> clanoviBiblioteke, ArrayList<IzdavanjeKnjige> izdavanjeKnjiga,
			ArrayList<TipClanarine> tipoviClanarine, ArrayList<Knjiga> knjige, ArrayList<PrimerakKnjige> primerciKnjiga,
			ArrayList<ZanrKnjige> zanroviKnjige) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		this.sviZaposleni = sviZaposleni;
		this.administratori = administratori;
		this.bibliotekari = bibliotekari;
		this.clanoviBiblioteke = clanoviBiblioteke;
		this.izdavanjeKnjiga = izdavanjeKnjiga;
		this.tipoviClanarine = tipoviClanarine;
		this.knjige = knjige;
		this.primerciKnjiga = primerciKnjiga;
		this.zanroviKnjige = zanroviKnjige;
	}







	    protected String naziv;
	    protected String adresa;
	    protected String telefon;
	    protected String radnoVreme;
	    protected ArrayList<Zaposleni> sviZaposleni;
	    protected ArrayList<Administrator> administratori;
	    protected ArrayList<Bibliotekar> bibliotekari;
	    protected ArrayList<ClanBiblioteke> clanoviBiblioteke;
	    protected ArrayList<IzdavanjeKnjige> izdavanjeKnjiga;
	    protected ArrayList<TipClanarine> tipoviClanarine;
	    protected ArrayList<Knjiga> knjige;
	    protected ArrayList<PrimerakKnjige> primerciKnjiga;
	    protected ArrayList<ZanrKnjige> zanroviKnjige;
	    
	





		

		public ArrayList<Zaposleni> getSviZaposleni() {
			return sviZaposleni;
		}


		public void setSviZaposleni(ArrayList<Zaposleni> sviZaposleni) {
			this.sviZaposleni = sviZaposleni;
		}


		public String getNaziv() {
			return naziv;
		}

		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}

		public String getAdresa() {
			return adresa;
		}

		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}

		public String getTelefon() {
			return telefon;
		}

		public void setTelefon(String telefon) {
			this.telefon = telefon;
		}

		public String getRadnoVreme() {
			return radnoVreme;
		}

		public void setRadnoVreme(String radnoVreme) {
			this.radnoVreme = radnoVreme;
		}

		public ArrayList<Administrator> getAdministratori() {
			return administratori;
		}

		public void setAdministratori(ArrayList<Administrator> administratori) {
			this.administratori = administratori;
		}

		public ArrayList<Bibliotekar> getBibliotekari() {
			return bibliotekari;
		}

		public void setBibliotekari(ArrayList<Bibliotekar> bibliotekari) {
			this.bibliotekari = bibliotekari;
		}

		public ArrayList<ClanBiblioteke> getClanoviBiblioteke() {
			return clanoviBiblioteke;
		}

		public void setClanoviBiblioteke(ArrayList<ClanBiblioteke> clanoviBiblioteke) {
			this.clanoviBiblioteke = clanoviBiblioteke;
		}

		public ArrayList<IzdavanjeKnjige> getIzdavanjeKnjiga() {
			return izdavanjeKnjiga;
		}

		public void setIzdavanjeKnjiga(ArrayList<IzdavanjeKnjige> izdavanjeKnjiga) {
			this.izdavanjeKnjiga = izdavanjeKnjiga;
		}

		public ArrayList<TipClanarine> getTipoviClanarine() {
			return tipoviClanarine;
		}

		public void setTipoviClanarine(ArrayList<TipClanarine> tipoviClanarine) {
			this.tipoviClanarine = tipoviClanarine;
		}

		public ArrayList<Knjiga> getKnjige() {
			return knjige;
		}

		public void setKnjige(ArrayList<Knjiga> knjige) {
			this.knjige = knjige;
		}

		public ArrayList<PrimerakKnjige> getPrimerciKnjiga() {
			return primerciKnjiga;
		}

		
		public void setPrimerciKnjiga(ArrayList<PrimerakKnjige> primerciKnjiga) {
			this.primerciKnjiga = primerciKnjiga;
		}


		public ArrayList<ZanrKnjige> getZanroviKnjige() {
			return zanroviKnjige;
		}

		public void setZanroviKnjige(ArrayList<ZanrKnjige> zanroviKnjige) {
			this.zanroviKnjige = zanroviKnjige;
		}






	


		
	    
	    
		
		
		
	   




		public void snimiKnjige(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				String content = "";
				for (Knjiga knjiga : knjige) {
					content += knjiga.getId() + "|" + knjiga.getNaslovKnjige() + "|"
							+ knjiga.getOriginalniNaslovKnjige() + "|" + knjiga.getPisac() + "|"
							+ knjiga.getGodinaPublikacije() + "|" + knjiga.getJezikOriginala() + "|" + knjiga.getOpis() + "|" + knjiga.getZanr() + "|" + knjiga.isObrisan() + "\n";
				}
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom snimanja knjiga.");
			}
		}

		
		public void snimiZanrove(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				String content = "";
				for (ZanrKnjige zanr : zanroviKnjige) {
					content += zanr.getOznaka() + "|" + zanr.getOpis() + "|" + zanr.isObrisan() + "\n";
				}

				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom snimanja zanrova.");
			}
		}
		
		
		public void snimiClanove(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				String content = "";
				for (ClanBiblioteke clan : clanoviBiblioteke) {
					content += clan.getId() + "|" + clan.getIme() + "|" 
							+ clan.getPrezime() + "|" + clan.getJMBG() + "|"
							+ clan.getAdresa() + "|" + clan.getPol() + "|" + clan.getBrClanskeKarte()
							+ "|" + clan.getDatumPoslednjeUplate() + "|" + clan.getBrojMeseciClanarine() 
							+ "|" + clan.isAktivan() + "|" + clan.getTip() + "|" + clan.isObrisan() + "\n";
				}

				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom snimanja clanova.");
			}
		}

		
		public void snimiPrimerkeKnjiga(String imeFajla) {

			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				String content = "";
				for (PrimerakKnjige primerak : primerciKnjiga) {
					content += primerak.getId() + "|" + primerak.getBrStrana() + "|" 
							+ primerak.isMekPovez() + "|" + primerak.getGodinaStampanja() + "|"
							+ primerak.getJezikSatmpanja() + "|" + primerak.isIznajmljena() + "|" + primerak.getKnjiga() + "|" + primerak.isObrisan() +  "\n";
				}

				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom snimanja primeraka knjiga.");
			}
		}


		public void snimiTipClanarine(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				String content = "";
				for (TipClanarine tip : tipoviClanarine) {
					content += tip.getId() + "|" + tip.getNaziv() + "|" + tip.getCena() + "|" + tip.isObrisan() + "\n";
				}

				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom snimanja tipa clanarine.");
			}
		}

		
		public void snimiAdministratore(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				String content = "";
				for (Administrator sviadministratori : administratori) {
					content += sviadministratori.getId() + "|" + sviadministratori.getIme() + "|" 
							+ sviadministratori.getPrezime() + "|" + sviadministratori.getJMBG() + "|"
							+ sviadministratori.getAdresa() + "|" + sviadministratori.getPol() + "|" + sviadministratori.getKorisnickoIme() + "|" 
							+ sviadministratori.getKorisnickaSifra() + "|" + sviadministratori.getPlata() + "|" + sviadministratori.isObrisan() + "|" + sviadministratori.getZaposleni() + "\n";
				}

				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom snimanja zaposlenih.");
			}
		}

		public void snimiBibliotekare(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				String content = "";
				for (Bibliotekar svibibliotekari : bibliotekari) {
					content += svibibliotekari.getId() + "|" + svibibliotekari.getIme() + "|" 
							+ svibibliotekari.getPrezime() + "|" + svibibliotekari.getJMBG() + "|"
							+ svibibliotekari.getAdresa() + "|" + svibibliotekari.getPol() + "|" + svibibliotekari.getKorisnickoIme() +  "|" 
							+ svibibliotekari.getKorisnickaSifra() + "|" + svibibliotekari.getPlata() + "|" + svibibliotekari.isObrisan() + "|" + svibibliotekari.getZaposleni() +"\n";
				}

				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom snimanja zaposlenih.");
			}
		}
		
		
		public void snimiIzdavanje(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				String content = "";
				for (IzdavanjeKnjige izdavanje : izdavanjeKnjiga) {
					content += izdavanje.getDatumIznajmljivanja() + "|" + izdavanje.getDatumVracanja() + "|" 
							+ izdavanje.getZaposleni() + "|" + izdavanje.getClan() + "|"
							+ izdavanje.getPrimerak() + "|" +izdavanje.isObrisan() + "\n";
				}

				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom snimanja iznajmljivanja.");
			}
		}
		
		public void snimiZaposlene(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				String content = "";
				for (Zaposleni zaposlenI : sviZaposleni) {
					content += zaposlenI.getId() + "|" + zaposlenI.getIme() + "|" 
							+ zaposlenI.getPrezime() + "|" + zaposlenI.getJMBG() + "|"
							+ zaposlenI.getAdresa() + "|" + zaposlenI.getPol() + "|" + zaposlenI.getKorisnickoIme() + "|" 
							+ zaposlenI.getKorisnickaSifra() + "|" + zaposlenI.getPlata() + "|" + zaposlenI.isObrisan() + "|" + zaposlenI.getZaposleni() +"\n";
				}

				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(content);
				writer.close();
			} catch (Exception e) {
				System.out.println("Greska prilikom snimanja zaposlenih.");
			}
		}
		
		
		
		public void ucitajKnjige(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					
					String[] split = line.split("\\|");
					
					int id = Integer.parseInt(split[0]);
					String naslovKnjige = split[1];
					String originalniNaslovKnjige = split[2];
					String pisac = split[3];
					int godinaPublikacije = Integer.parseInt(split[4]);
					String jezikOriginala = split[5];
					
					String opis = split[6];
					
					String zanrId = split[7];
					ZanrKnjige zanr = (ZanrKnjige) pronadjiZanr(zanrId);
					
					boolean obrisan = Boolean.parseBoolean(split[8]);
					
					
					Knjiga knjiga = new Knjiga(id, naslovKnjige, originalniNaslovKnjige, pisac, godinaPublikacije, jezikOriginala, opis, zanr, obrisan);
					knjige.add(knjiga);
					
				}
				reader.close();
			}catch(FileNotFoundException e) {
				System.out.printf("ERROR - A %s occurred: %s", e.getClass().toString(), e.getMessage());
			}
			catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o knjigama");
				e.printStackTrace();
			}
		}

	





		public void ucitajZanrove(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					
					String[] split = line.split("\\|");
					
					String oznaka = split[0];
					String opis = split[1];
					boolean obrisan = Boolean.parseBoolean(split[2]);
					
					
					ZanrKnjige zanr = new ZanrKnjige(oznaka, opis, obrisan);
					zanroviKnjige.add(zanr);
					
				}
				reader.close();
			}catch(FileNotFoundException e) {
				System.out.printf("ERROR - A %s occurred: %s", e.getClass().toString(), e.getMessage());
			}
			catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o zanrovima");
				e.printStackTrace();
			}
		}

		
		public void ucitajClanove(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					
					String[] split = line.split("\\|");
					
					String id = split[0];
					String ime = split[1];
					String prezime = split[2];
					String JMBG = split[3];
					String adresa = split[4];
					int polInt = Integer.parseInt(split[5]);
					EnumPol pol = EnumPol.values()[polInt];
					String brClanskeKarte = split[6];
					LocalDate datumPoslednjeUplate = LocalDate.parse(split[7]);
					int brojMeseciClanarine = Integer.parseInt(split[8]);
					boolean aktivan = Boolean.parseBoolean(split[9]);
					
					int tipClanarineId = Integer.parseInt(split[10]);
					TipClanarine tipClanarine = (TipClanarine) pronadjiTipClanarine(tipClanarineId);
					
					boolean obrisan = Boolean.parseBoolean(split[11]);
					
					

					ClanBiblioteke clan = new ClanBiblioteke(id, ime, prezime, JMBG, adresa, pol, brClanskeKarte, datumPoslednjeUplate, brojMeseciClanarine, aktivan, tipClanarine, obrisan);
					clanoviBiblioteke.add(clan);
					
				}
				reader.close();
			}catch(FileNotFoundException e) {
				System.out.printf("ERROR - A %s occurred: %s", e.getClass().toString(), e.getMessage());
			}
			catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o clanovima");
				e.printStackTrace();
			}
		}

		
		






		public void ucitajPrimerkeKnjiga(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					
					String[] split = line.split("\\|");
					
					String id = split[0];
					int brStrana = Integer.parseInt(split[1]);
					boolean mekPovez = Boolean.parseBoolean(split[2]);
					int godinaStampanja = Integer.parseInt(split[3]);
					String jezikStampanja = split[4];
					boolean iznajmljena = Boolean.parseBoolean(split[5]);
					
					int KnjigaId = Integer.parseInt(split[6]);
					Knjiga knjiga = (Knjiga) pronadjiKnjigu(KnjigaId);
					
					boolean obrisan = Boolean.parseBoolean(split[7]);
					
					
					
					PrimerakKnjige primerak = new PrimerakKnjige(id, brStrana, mekPovez, godinaStampanja, jezikStampanja, iznajmljena, knjiga, obrisan);
					primerciKnjiga.add(primerak);
					
				}
				reader.close();
			}catch(FileNotFoundException e) {
				System.out.printf("ERROR - A %s occurred: %s", e.getClass().toString(), e.getMessage());
			}
			catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o primercima knjiga");
				e.printStackTrace();
			}
		}

		
	





		public void ucitajTipClanarine(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					
					String[] split = line.split("\\|");
					
					int id = Integer.parseInt(split[0]);
					String naziv = split[1];
					double cena = Double.parseDouble(split[2]);
					boolean obrisan = Boolean.parseBoolean(split[3]);
					
					
					TipClanarine tip = new TipClanarine(id, naziv, cena, obrisan);
					tipoviClanarine.add(tip);
					
				}
				reader.close();
			}catch(FileNotFoundException e) {
				System.out.printf("ERROR - A %s occurred: %s", e.getClass().toString(), e.getMessage());
			}
			catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o tipu clanarine");
				e.printStackTrace();
			}
		}

		
		
		public void ucitajAdministratore(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					
					String[] split = line.split("\\|");
					
					String id = split[0];
					String ime = split[1];
					String prezime = split[2];
					String JMBG = split[3];
					String adresa = split[4];
					int polInt = Integer.parseInt(split[5]);
					EnumPol pol = EnumPol.values()[polInt];
					String korisnickoIme = split[6];
					String korisnickaSifra = split[7];
					double plata = Double.parseDouble(split[8]);
					boolean obrisan = Boolean.parseBoolean(split[9]);
					int zaposleniInt = Integer.parseInt(split[10]);
					EnumZaposleni zaposleni = EnumZaposleni.values()[zaposleniInt ];
					
					
					Administrator sviadministratori = new Administrator(id, ime, prezime, JMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata, obrisan, zaposleni);
					administratori.add(sviadministratori);
					
				}
				reader.close();
			}catch(FileNotFoundException e) {
				System.out.printf("ERROR - A %s occurred: %s", e.getClass().toString(), e.getMessage());
			}
			catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o zaposlenom");
				e.printStackTrace();
			}
		}
		
		
		public void ucitajBibliotekare(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					
					String[] split = line.split("\\|");
					
					String id = split[0];
					String ime = split[1];
					String prezime = split[2];
					String JMBG = split[3];
					String adresa = split[4];
					int polInt = Integer.parseInt(split[5]);
					EnumPol pol = EnumPol.values()[polInt];
					String korisnickoIme = split[6];
					String korisnickaSifra = split[7];
					double plata = Double.parseDouble(split[8]);
					boolean obrisan = Boolean.parseBoolean(split[9]);
					int zaposleniInt = Integer.parseInt(split[10]);
					EnumZaposleni zaposleni = EnumZaposleni.values()[zaposleniInt ];
					
					
					Bibliotekar svibibliotekari = new Bibliotekar(id, ime, prezime, JMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata, obrisan, zaposleni);
					bibliotekari.add(svibibliotekari);
					
				}
				reader.close();
			}catch(FileNotFoundException e) {
				System.out.printf("ERROR - A %s occurred: %s", e.getClass().toString(), e.getMessage());
			}
			catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o zaposlenom");
				e.printStackTrace();
			}
		}


		
		public void ucitajIzdavanje(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					
					String[] split = line.split("\\|");
					
					LocalDate datumIznajmljivanja = LocalDate.parse(split[0]);
					LocalDate datumVracanja = LocalDate.parse(split[1]);
					
					String ZaposleniId = split[2];
					Zaposleni zaposleni = (Zaposleni) pronadjiZaposlenog(ZaposleniId);
					
					String ClanId = split[3];
					ClanBiblioteke clan = (ClanBiblioteke) pronadjiClana(ClanId);
					
					String PrimerakKnjigeId = split[4];
					PrimerakKnjige primerak = (PrimerakKnjige) pronadjiPrimerak(PrimerakKnjigeId);
					
					boolean obrisan = Boolean.parseBoolean(split[5]);
					
					
					IzdavanjeKnjige izdavanje = new IzdavanjeKnjige(datumIznajmljivanja, datumVracanja, zaposleni, clan, primerak, obrisan);
					izdavanjeKnjiga.add(izdavanje);
					
				}
				reader.close();
			}catch(FileNotFoundException e) {
				System.out.printf("ERROR - A %s occurred: %s", e.getClass().toString(), e.getMessage());
			}
			catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o iznajmljivanju");
				e.printStackTrace();
			}
		}
		
		
		public void ucitajZaposlene(String imeFajla) {
			try {
				File file = new File("C://Users/natas/eclipse-workspace/projekat/SR22-2021-UOP-projekat/src/fajlovi/" + imeFajla);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line;
				while ((line = reader.readLine()) != null) {
					
					String[] split = line.split("\\|");
					
					String id = split[0];
					String ime = split[1];
					String prezime = split[2];
					String JMBG = split[3];
					String adresa = split[4];
					int polInt = Integer.parseInt(split[5]);
					EnumPol pol = EnumPol.values()[polInt];
					String korisnickoIme = split[6];
					String korisnickaSifra = split[7];
					double plata = Double.parseDouble(split[8]);
					boolean obrisan = Boolean.parseBoolean(split[9]);
					int zaposleniInt = Integer.parseInt(split[10]);
					EnumZaposleni zaposleni = EnumZaposleni.values()[zaposleniInt ];
					
					
					Zaposleni zaposlenI = new Zaposleni(id, ime, prezime, JMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata, obrisan, zaposleni);
					sviZaposleni.add(zaposlenI);
					
				}
				reader.close();
			}catch(FileNotFoundException e) {
				System.out.printf("ERROR - A %s occurred: %s", e.getClass().toString(), e.getMessage());
			}
			catch (IOException e) {
				System.out.println("Greska prilikom snimanja podataka o zaposlenom");
				e.printStackTrace();
			}
		}

		

		public Knjiga pronadjiKnjigu(int id) {
			for (Knjiga knjiga : knjige) {
				if(knjiga.getId() == id) {
					return knjiga;
				}
			}
			return null;
		}

		

			public ZanrKnjige pronadjiZanr(String id) {
			for (ZanrKnjige zanr : zanroviKnjige) {
				if(zanr.getOznaka().equals(id)) {
					return zanr;
				}
			}
			return null; 
		}



		public PrimerakKnjige pronadjiPrimerak(String id) {
			for (PrimerakKnjige primerak : primerciKnjiga) {
				if(primerak.getId().equals(id)) {
					return primerak;
				}
			}
			return null;
		}






		public ClanBiblioteke pronadjiClana(String id) {
			for (ClanBiblioteke clan : clanoviBiblioteke) {
				if(clan.getId().equals(id)) {
					return clan;
				}
			}
			return null;
		}




		public Administrator pronadjiAdministartora(String administratorId) {
			for (Administrator sviadministartori : administratori) {
				if(sviadministartori.getId().equals(administratorId)) {
					return sviadministartori;
				}
			}
			return null;
		}
		
		public Bibliotekar pronadjiBibliotekara(String bibliotekarId) {
			for (Bibliotekar svibibliotekari : bibliotekari) {
				if(svibibliotekari.getId().equals(bibliotekarId)) {
					return svibibliotekari;
				}
			}
			return null;
		}
		
		public TipClanarine pronadjiTipClanarine(int id) {
			for (TipClanarine tip : tipoviClanarine) {
				if(tip.getId() == id) {
					return tip;
				}
			}
			return null;
		}
		
		public Zaposleni pronadjiZaposlenog(String id) {
			for (Zaposleni zaposlenI : sviZaposleni) {
				if(zaposlenI.getId().equals(id)) {
					return zaposlenI;
				}
			}
			return null;
		}



public void dodajTipClanarine(TipClanarine tip) {
	this.tipoviClanarine.add(tip);
}

public void dodajZaposlenog(Zaposleni zaposlenI) {
	this.sviZaposleni.add(zaposlenI);
}

public void dodajAdministratora(Administrator sviadministratori) {
	this.administratori.add(sviadministratori);
}
public void dodajBibliotekara(Bibliotekar svibibliotekari) {
	this.bibliotekari.add(svibibliotekari);
}

public void dodajZanr(ZanrKnjige zanr) {
	this.zanroviKnjige.add(zanr);
}

public void dodajKnjigu(Knjiga knjiga) {
	this.knjige.add(knjiga);
	
}

public void dodajClana(ClanBiblioteke clan) {
	this.clanoviBiblioteke.add(clan);
	
}

public void dodajPrimerakKnjige(PrimerakKnjige primerak) {
	this.primerciKnjiga.add(primerak);
	
}

public void dodajIzdavanje(IzdavanjeKnjige izdavanje) {
	this.izdavanjeKnjiga.add(izdavanje);
	
}

public void obrisiTipClanarine(TipClanarine tip) {
	this.tipoviClanarine.remove(tip);
}

public void obrisiZaposlenog(Zaposleni zaposlenI) {
	this.sviZaposleni.remove(zaposlenI);
}

public void obrisiZanr(ZanrKnjige zanr) {
	this.zanroviKnjige.remove(zanr);
}

public void obrisiKnjigu(Knjiga knjiga) {
	this.knjige.remove(knjiga);
	
}

public void obrisiClana(ClanBiblioteke clan) {
	this.clanoviBiblioteke.remove(clan);
	
}

public void obrisiPrimerakKnjige(PrimerakKnjige primerak) {
	this.primerciKnjiga.remove(primerak);
	
}

public void obrisiIzdavanje(IzdavanjeKnjige izdavanje) {
	this.izdavanjeKnjiga.remove(izdavanje);
	
	
}

public void obrisiAdministratora(Administrator sviadministratori) {
	this.administratori.remove(sviadministratori);
	
	
}

public void obrisiBibliotekara(Bibliotekar svibibliotekari) {
	this.bibliotekari.remove(svibibliotekari);
	
	
}



/******************************************************************************************************/

public ArrayList<TipClanarine> sviNeobrisaniTipovi() {
	ArrayList<TipClanarine> neobrisani = new ArrayList<TipClanarine>();
	for(TipClanarine tip : tipoviClanarine) {
		if(!tip.isObrisan()) {
			neobrisani.add(tip);
		}
	}
	return neobrisani;
}

public ArrayList<Zaposleni> sviNeobrisaniZaposleni() {
	ArrayList<Zaposleni> neobrisani = new ArrayList<Zaposleni>();
	for(Zaposleni zaposlenI : sviZaposleni) {
		if(!zaposlenI.isObrisan()) {
			neobrisani.add(zaposlenI);
		}
	}
	return neobrisani;
}

public ArrayList<ZanrKnjige> sviNeobrisaniZanrovi() {
	ArrayList<ZanrKnjige> neobrisani = new ArrayList<ZanrKnjige>();
	for(ZanrKnjige zanr : zanroviKnjige) {
		if(!zanr.isObrisan()) {
			neobrisani.add(zanr);
		}
	}
	return neobrisani;
}

public ArrayList<Knjiga> sveNeobrisaneKnjige() {
	ArrayList<Knjiga> neobrisane = new ArrayList<Knjiga>();
	for(Knjiga knjiga : knjige) {
		if(!knjiga.isObrisan()) {
			neobrisane.add(knjiga);
		}
	}
	return neobrisane;
}

public ArrayList<ClanBiblioteke> sviNeobrisaniClanovi() {
	ArrayList<ClanBiblioteke> neobrisani = new ArrayList<ClanBiblioteke>();
	for(ClanBiblioteke clan : clanoviBiblioteke) {
		if(!clan.isObrisan()) {
			neobrisani.add(clan);
		}
	}
	return neobrisani;
}

public ArrayList<PrimerakKnjige> sviNeobrisaniPrimerci() {
	ArrayList<PrimerakKnjige> neobrisani = new ArrayList<PrimerakKnjige>();
	for(PrimerakKnjige primerak : primerciKnjiga) {
		if(!primerak.isObrisan()) {
			neobrisani.add(primerak);
		}
	}
	return neobrisani;
}

public ArrayList<IzdavanjeKnjige> svaNeobrisanaIzdavanja() {
	ArrayList<IzdavanjeKnjige> neobrisana = new ArrayList<IzdavanjeKnjige>();
	for(IzdavanjeKnjige izdavanje : izdavanjeKnjiga) {
		if(!izdavanje.isObrisan()) {
			neobrisana.add(izdavanje);
		}
	}
	return neobrisana;
}

public ArrayList<Administrator> sviNeobrisaniAdministratori() {
	ArrayList<Administrator> neobrisana = new ArrayList<Administrator>();
	for(Administrator i : administratori) {
		if(!i.isObrisan()) {
			neobrisana.add(i);
		}
	}
	return neobrisana;
}

public ArrayList<Bibliotekar> sviNeobrisaniBibliotekari() {
	ArrayList<Bibliotekar> neobrisana = new ArrayList<Bibliotekar>();
	for(Bibliotekar i : bibliotekari) {
		if(!i.isObrisan()) {
			neobrisana.add(i);
		}
	}
	return neobrisana;
}

/******************************************************************************************************/

public Zaposleni login(String korisnickoIme, String sifra, EnumZaposleni tipZaposlenog) {
	for(Zaposleni zaposleni : sviZaposleni) {
		if(zaposleni.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) &&
				zaposleni.getKorisnickaSifra().equals(sifra) && !zaposleni.isObrisan()) {
			return zaposleni;
		}
	}
	return null;
}


}



