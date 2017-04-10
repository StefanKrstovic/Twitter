/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Stefan Krstovic
 *
 */
public class TwitterPorukaTest {

	private TwitterPoruka t;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for
	 * {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		t.setKorisnik("Misko");
		assertEquals("Misko", t.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		t.setKorisnik(null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmpty() {
		t.setKorisnik("");
	}
	
	
	@Test
	public void bug003Squasher(){
		t.setPoruka("p1");
		TwitterPoruka t2 = new TwitterPoruka();
		t2.setPoruka("p2");
		if(t2.getPoruka().equals(t.getPoruka()))throw new RuntimeException("Bag u getPoruka metodi");
	}
	/**
	 * Test method for
	 * {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		t.setPoruka("prvaporuka");
		assertEquals("prvaporuka", t.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		t.setPoruka(null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaEmpty() {
		t.setPoruka("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaTooLong() {
		t.setPoruka("0123456789 ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz 0123456789 ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz 0123456789+");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		t.setKorisnik("Rand");
		t.setPoruka("Super rand");
		
		assertEquals("KORISNIK:Rand PORUKA:Super rand", t.toString());
	}

}
