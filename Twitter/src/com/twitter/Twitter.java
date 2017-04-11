package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa koja predstavlja Twitter
 * 
 * @author Stefan Krstovic
 * @version 1.0.0
 * 
 */
public class Twitter {

	/**
	 * Lista Twitter poruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda koja vraca sve Twitter poruke
	 * 
	 * @return poruke kao listu objakata klase TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	
	/**
	 * Metoda za unosenje nove poruke u listu
	 * @param korisnik naziv korisnika kao String
	 * @param poruka sadrzaj poruke kao String
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		/**tp.setKorisnik("korisnik");
		 * bug 005 -> treba korisnik a ne "korisnik". Napravljena metoda koja resava ovo
		 */
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);

		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda koja u obliku niza objekata TwitterPoruka vraca sve poruke koje sadrze prosledjeni tag
	 * @param maxBroj najveci broj poruka koje je dozvoljeno vratiti
	 * @param tag String koji treba da se nalazi unutar neke poruke
	 * @return odgovarajuce poruke kao niz objekata klase TwitterPoruka
	 * @throws java.lang.RuntimeException ako je unet tag:
	 * 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan string</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag. Ako se nadje
		// neka takva, i ako nije prekoracen maxBroj ona se upisuje u niz. Ako
		// je prekoracen maxBroj,pretraga se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					/**rezultat[brojac + 1] = poruke.get(i);
					 * Bug 004 -> null pointer. Uhvatio ga je testVratiPoruke
					 */
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}

}