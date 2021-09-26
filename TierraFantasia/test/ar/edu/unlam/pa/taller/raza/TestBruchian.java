package ar.edu.unlam.pa.taller.raza;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class TestBruchian {
	Raza uno, dos;

	@Test
	public void unoFallaADos() {
		uno = new Bruchian(new Posicion(4, 4));
		dos = new Bruchian(new Posicion(27, 37));
		uno.atacar(dos);
		Assert.assertEquals(dos.saludMax, dos.saludActual, 00);
	}

	@Test
	public void unoAtacaADos() {
		uno = new Bruchian(new Posicion(4, 4));
		dos = new Bruchian(new Posicion(20, 20));
		uno.atacar(dos);
		Assert.assertEquals(117, dos.saludActual, 00);
	}

	@Test
	public void dosAtacaAUno() {
		uno = new Bruchian(new Posicion(4, 4));
		dos = new Bruchian(new Posicion(20, 20));
		dos.atacar(uno);
		Assert.assertEquals(117, uno.saludActual, 00);
	}
	
	@Test
	public void dosContraAtacaAUno() {
		uno = new Bruchian(new Posicion(4, 4));
		dos = new Bruchian(new Posicion(20, 20));
		uno.atacar(dos);
		uno.atacar(dos);
		dos.atacar(uno);
		Assert.assertEquals(108, uno.saludActual, 00);
	}
	
	@Test
	public void dosDescansaYRecuperaVida(){
		uno = new Bruchian(new Posicion(4, 4));
		dos = new Bruchian(new Posicion(20, 20));
		
		uno.atacar(dos);
		uno.atacar(dos);
		uno.atacar(dos);
		uno.atacar(dos);
		
		dos.descansar();
		Assert.assertEquals(95.5, dos.saludActual, 00);
	}

	@Test
	public void autoataqueFalla() {
		uno = new Bruchian(new Posicion(4, 4));
		
		uno.atacar(uno);
		assertEquals(uno.saludMax, uno.saludActual, 0.0);
	}
	
	@After
	public void Annihilate() {
		this.uno = null;
		this.dos = null;
	}

}
