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
							+ knjiga.getGodinaPublikacije() + "|" + knjiga.getJezikOriginala() + "|" + knjiga.getOpis() + knjiga.getZanr()  + "\n";
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
					content += zanr.getOznaka() + "|" + zanr.getOpis() + "\n";
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
							+ "|" + clan.isAktivan() + "|" + clan.getTip() + "\n";
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
							+ primerak.getJezikSatmpanja() + "|" + primerak.isIznajmljena() + "|" + primerak.getKnjiga()  + "\n";
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
					content += tip.getId() + "|" + tip.getNaziv() + "|" + tip.getCena() + "\n";
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
							+ sviadministratori.getKorisnickaSifra() + sviadministratori.getPlata() + "\n";
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
							+ svibibliotekari.getAdresa() + "|" + svibibliotekari.getPol() + "|" + svibibliotekari.getKorisnickoIme() + "|" 
							+ svibibliotekari.getKorisnickaSifra() + svibibliotekari.getPlata() + "\n";
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
							+ izdavanje.getPrimerak() + "\n";
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
				for (Zaposleni zaposleni : sviZaposleni) {
					content += zaposleni.getId() + "|" + zaposleni.getIme() + "|" 
							+ zaposleni.getPrezime() + "|" + zaposleni.getJMBG() + "|"
							+ zaposleni.getAdresa() + "|" + zaposleni.getPol() + "|" + zaposleni.getKorisnickoIme() + "|" 
							+ zaposleni.getKorisnickaSifra() + zaposleni.getPlata() + "\n";
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
					
					
					
					
					Knjiga knjiga = new Knjiga(id, naslovKnjige, originalniNaslovKnjige, pisac, godinaPublikacije, jezikOriginala, opis, zanr);
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
					
					
					ZanrKnjige zanr = new ZanrKnjige(oznaka, opis);
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
					
					int id = Integer.parseInt(split[0]);
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
					
					

					ClanBiblioteke clan = new ClanBiblioteke(id, ime, prezime, JMBG, adresa, pol, brClanskeKarte, datumPoslednjeUplate, brojMeseciClanarine, aktivan, tipClanarine);
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
					
					int id = Integer.parseInt(split[0]);
					int brStrana = Integer.parseInt(split[1]);
					boolean mekPovez = Boolean.parseBoolean(split[2]);
					int godinaStampanja = Integer.parseInt(split[3]);
					String jezikStampanja = split[4];
					boolean iznajmljena = Boolean.parseBoolean(split[5]);
					
					int KnjigaId = Integer.parseInt(split[6]);
					Knjiga knjiga = (Knjiga) pronadjiKnjigu(KnjigaId);
					
					
					
					PrimerakKnjige primerak = new PrimerakKnjige(id, brStrana, mekPovez, godinaStampanja, jezikStampanja, iznajmljena, knjiga);
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
					
					
					TipClanarine tip = new TipClanarine(id, naziv, cena);
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
					
					int id = Integer.parseInt(split[0]);
					String ime = split[1];
					String prezime = split[2];
					String JMBG = split[3];
					String adresa = split[4];
					int polInt = Integer.parseInt(split[5]);
					EnumPol pol = EnumPol.values()[polInt];
					String korisnickoIme = split[6];
					String korisnickaSifra = split[7];
					double plata = Double.parseDouble(split[8]);
					
					
					Administrator sviadministratori = new Administrator(id, ime, prezime, JMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata);
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
					
					int id = Integer.parseInt(split[0]);
					String ime = split[1];
					String prezime = split[2];
					String JMBG = split[3];
					String adresa = split[4];
					int polInt = Integer.parseInt(split[5]);
					EnumPol pol = EnumPol.values()[polInt];
					String korisnickoIme = split[6];
					String korisnickaSifra = split[7];
					double plata = Double.parseDouble(split[8]);
					
					
					Bibliotekar svibibliotekari = new Bibliotekar(id, ime, prezime, JMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata);
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
					
					int ZaposleniId = Integer.parseInt(split[2]);
					Zaposleni zaposleni = (Zaposleni) pronadjiZaposlenog(ZaposleniId);
					
					int ClanId = Integer.parseInt(split[3]);
					ClanBiblioteke clan = (ClanBiblioteke) pronadjiClana(ClanId);
					
					int PrimerakKnjigeId = Integer.parseInt(split[4]);
					PrimerakKnjige primerak = (PrimerakKnjige) pronadjiPrimerak(PrimerakKnjigeId);
					
					
					IzdavanjeKnjige izdavanje = new IzdavanjeKnjige(datumIznajmljivanja, datumVracanja, zaposleni, clan, primerak);
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
					
					int id = Integer.parseInt(split[0]);
					String ime = split[1];
					String prezime = split[2];
					String JMBG = split[3];
					String adresa = split[4];
					int polInt = Integer.parseInt(split[5]);
					EnumPol pol = EnumPol.values()[polInt];
					String korisnickoIme = split[6];
					String korisnickaSifra = split[7];
					double plata = Double.parseDouble(split[8]);
					
					
					Zaposleni zaposleni = new Zaposleni(id, ime, prezime, JMBG, adresa, pol, korisnickoIme, korisnickaSifra, plata);
					sviZaposleni.add(zaposleni);
					
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



		public PrimerakKnjige pronadjiPrimerak(int id) {
			for (PrimerakKnjige primerak : primerciKnjiga) {
				if(primerak.getId() == id) {
					return primerak;
				}
			}
			return null;
		}






		public ClanBiblioteke pronadjiClana(int id) {
			for (ClanBiblioteke clan : clanoviBiblioteke) {
				if(clan.getId() == id) {
					return clan;
				}
			}
			return null;
		}




		public Administrator pronadjiAdministartora(int id) {
			for (Administrator sviadministartori : administratori) {
				if(sviadministartori.getId() == id) {
					return sviadministartori;
				}
			}
			return null;
		}
		
		public Bibliotekar pronadjiBibliotekara(int id) {
			for (Bibliotekar svibibliotekari : bibliotekari) {
				if(svibibliotekari.getId() == id) {
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
		
		public Zaposleni pronadjiZaposlenog(int id) {
			for (Zaposleni zaposleni : sviZaposleni) {
				if(zaposleni.getId() == id) {
					return zaposleni;
				}
			}
			return null;
		}



public void dodajTipClanarine(TipClanarine tip) {
	this.tipoviClanarine.add(tip);
}

public void dodajZaposlenog(Zaposleni zaposleni) {
	this.sviZaposleni.add(zaposleni);
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

public void dodajIznajmljivanje(IzdavanjeKnjige izdavanje) {
	this.izdavanjeKnjiga.add(izdavanje);
	
}


}

