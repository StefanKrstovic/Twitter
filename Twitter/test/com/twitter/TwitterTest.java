/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Stefan Krstovic
 *
 */
public class TwitterTest {
	
	private Twitter t;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t=new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t=null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		t.vratiSvePoruke().clear();
		t.unesi("Ran", "dd");
		t.unesi("Rand", "om");
		
		//if(t.vratiSvePoruke().get(0).getKorisnik().equals("Ran") && t.vratiSvePoruke().get(0).getPoruka().equals("dd") && t.vratiSvePoruke().get(1).getKorisnik().equals("Rand") && t.vratiSvePoruke().get(1).getPoruka().equals("om"))assertEquals(1,1);
		//else assertEquals(1,0);
		
		assertEquals("RanddRandom", t.vratiSvePoruke().get(0).getKorisnik() + t.vratiSvePoruke().get(0).getPoruka() + t.vratiSvePoruke().get(1).getKorisnik() + t.vratiSvePoruke().get(1).getPoruka());
	}
	
	public void bug005squasher(){
		t.vratiSvePoruke().clear();
		t.unesi("k1", "p1");
		t.unesi("k2", "p2");
		
		
		//if(t.vratiSvePoruke().get(0).getKorisnik().equals(t.vratiSvePoruke().get(1).getKorisnik()))assertEquals(1,0);
		//else assertEquals(1,1);
		assertEquals("k1p1k2p2", t.vratiSvePoruke().get(0).getKorisnik() + t.vratiSvePoruke().get(0).getPoruka() + t.vratiSvePoruke().get(1).getKorisnik() + t.vratiSvePoruke().get(1).getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		t.vratiSvePoruke().clear();
		t.unesi("John", "Doe");
		
		assertEquals("John"+"Doe", t.vratiSvePoruke().get(0).getKorisnik()+t.vratiSvePoruke().get(0).getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		t.unesi("Ime", "Poruka");
		t.unesi("Jos jedno ime", "Pooruka");
		t.unesi("Novo ime", "ruka");
		
		TwitterPoruka[] t2 = t.vratiPoruke(5, "ruka");
		assertEquals("Ime" + "Poruka" + "Jos jedno ime" + "Pooruka"+"Novo ime" + "ruka", t2[0].getKorisnik()+t2[0].getPoruka()+t2[1].getKorisnik()+t2[1].getPoruka()+t2[2].getKorisnik()+t2[2].getPoruka());
	}

}
