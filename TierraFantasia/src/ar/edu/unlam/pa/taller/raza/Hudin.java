package ar.edu.unlam.pa.taller.raza;

/*
 * Un Hudin tiene una salud inicial de 93. Utiliza un hueso, y su rango de ataque es de menos de 4 metros. Ocasiona un daño básico de 82 puntos. 
 * Cuando ataca, envenena a su enemigo y éste pierde 4 adicionales de salud por turno. 
 * Al recibir un ataque recibe 2 veces el daño, ya que no lleva armadura. 
 * Cuando descansa, reduce el daño del siguiente ataque recibido en 2/3 de su valor neto.
 */

public class Hudin extends Raza {
	
	private static final String RAZA = "Hudin";
	private static final double SALUD_MAX = 93;
	private static final double DANIO_BASICO = 82;
	private static final double RANGO_ATAQUE_MIN = 0;
	private static final double RANGO_ATAQUE_MAX = 4;
	public static final double DANIO_VENENO = 4;
	private boolean reduceSigAtaque = false;

	public Hudin(Posicion posicionActual) {
		super(RAZA,SALUD_MAX, SALUD_MAX, RANGO_ATAQUE_MIN, RANGO_ATAQUE_MAX, DANIO_BASICO, posicionActual);
	}

	@Override
	public void atacar(Raza enemigo) {

		if(estaVivo() && enemigo.estaVivo() && enemigo != this) {
			
			double distancia = posicionActual.distancia(enemigo.posicionActual);
			
			if (distancia <= rangoAtaqueMax && distancia >= rangoAtaqueMin) {
				enemigo.recibirAtaque(this);
				enemigo.envenenado = true;
			}
			
		}
		
		if(estaEnvenenado() == true)
			venenoRestaSalud();

	}

	@Override
	public void descansar() {
		
		if(estaVivo()) {
			reduceSigAtaque = true;
			envenenado = false;
		}
	
	}	

	@Override
	public void recibirAtaque(Raza enemigo) {
		
		double danio_entrante = enemigo.danioBasico*2;
		if (reduceSigAtaque == true) 
			danio_entrante *= 1/3;
			
		saludActual -= danio_entrante;
		if(estaVivo() == false)
			saludActual = 0;
		
		reduceSigAtaque = false;
		
		if(estaEnvenenado() == true)
			venenoRestaSalud();
	}

}
