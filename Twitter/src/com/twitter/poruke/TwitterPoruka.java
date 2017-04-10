package com.twitter.poruke;

/**
 * Klasa koja predstavlja Twitter poruku
 * 
 * @author Bojan Tomic
 * @version 0.0.1
 * 
 * */
public class TwitterPoruka {
	
	/**
	 * Ime korisnika
	 */
	private String korisnik;
	
	/**
	 * Poruka
	*/
	private String poruka;

	/**
	 * Vraca vrednost atributa korisnik
	 * @return ime korisnika kao String
	*/
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Postavlja novu vrednost za atribut korisnik
	 * @param korisnik novo ime korisnika
	 * @throws java.lang.RuntimeException ako je unet korisnik:
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan string</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		/**if (korisnik == null || !korisnik.isEmpty())
		 * Bug 001 -> uzvicnik ispred korisnik.isEmpty() ne treba da stoji tu. Ovo je uhvatila testSetKorisnik metoda
		 */
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Vraca vrednost atributa poruka
	 * @return sadrzaj poruke kao String
	*/
	public String getPoruka() {
		/**return "poruka";
		 * Bug 003 -> Ne treba da vratimo string poruka, nego atribut
		 */
		return poruka;
	}

	/**
	 * Postavlja novu vrednost za atribut poruka
	 * @param poruka novi sadrzaj poruke
	 * @throws java.lang.RuntimeException ako je uneta poruka:
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan string</li>
	 * <li>duza od 140 karaktera</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		/**if (this.poruka == null || this.poruka == new String("") || this.poruka.length() > 140)
		 * Bug 002 -> treba proveravati parametar, a ne atribut objekta. Ovo je uhvatila testSetPoruka metoda
		 */
		if (poruka == null || poruka == "" || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Vraca String sa podacima korisnika i poruke.
	 * @return naziv korisnika i poruku uz odgovarajucu poruku.
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}