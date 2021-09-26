package ar.edu.unlam.pa.taller.raza;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class TestBiselian {

	Raza uno, dos;

	@Test
	public void unoFallaADos() {
		uno = new Biselian(new Posicion(4, 4));
		dos = new Biselian(new Posicion(27, 37));
		uno.atacar(dos);
		Assert.assertEquals(dos.saludMax, dos.saludActual, 00);
	}

	@Test
	public void unoAtacaADos() {
		uno = new Biselian(new Posicion(4, 4));
		dos = new Biselian(new Posicion(5, 5));
		uno.atacar(dos);
		Assert.assertEquals(0, dos.saludActual, 00);
	}
	
	@Test
	public void atacaYRecuperaVida() {
		uno = new Biselian(new Posicion(5, 5));
		dos = new Biselian(new Posicion(4, 4));
		Raza atacante = new Bruchian(new Posicion(20, 20));
		
		atacante.atacar(uno); // uno ahora tiene 57-32=25 de vida
		System.out.println(uno.saludActual);
		uno.atacar(dos); // uno recupera 57*3/100=1.71 de vida
		assertEquals(26.71,uno.saludActual, 0.0);
	}
	
	@Test
	public void autoataqueFalla() {
		uno = new Biselian(new Posicion(4, 4));
		
		uno.atacar(uno);
		assertEquals(uno.saludMax, uno.saludActual, 0.0);
	}
	
	@After
	public void Annihilate() {
		this.uno = null;
		this.dos = null;
	}

}
