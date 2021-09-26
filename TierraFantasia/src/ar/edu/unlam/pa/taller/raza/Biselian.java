package ar.edu.unlam.pa.taller.raza;

/*
 * Una Biselian tiene una salud inicial de 57. Utiliza sus dientes, y su rango de ataque es de menos de 2 metros. 
 * Ocasiona un daño básico de 114 puntos. Cuando ataca, se cura un 3 por ciento de su salud inicial. Al recibir un ataque lo hace normalmente. 
 * Cuando descansa, medita, y como considera la violencia como algo malo, se rehúsa a atacar hasta que lo ataquen. 
 * Gracias a ésto, aumenta su salud y su salud máxima en 33.
 */

public class Biselian extends Raza {
	
	private static final String RAZA = "Biselian";
	private static final double SALUD_INICIAL= 57;
	private static final double DANIO_BASICO = 114;
	private static final double RANGO_ATAQUE_MIN = 0;
	private static final double RANGO_ATAQUE_MAX = 2;
	private boolean meditando = false;

	public Biselian(Posicion posicionActual) {
		super(RAZA,SALUD_INICIAL, SALUD_INICIAL, RANGO_ATAQUE_MIN, RANGO_ATAQUE_MAX, DANIO_BASICO, posicionActual);
	}

	@Override
	public void atacar(Raza enemigo) {
		
		if(estaVivo() && enemigo.estaVivo() && enemigo != this) {
			
			double distancia = posicionActual.distancia(enemigo.posicionActual);
	
			if(meditando == false && distancia <= rangoAtaqueMax && distancia >= rangoAtaqueMin) {
				saludActual += (SALUD_INICIAL*3)/100;
				enemigo.recibirAtaque(this);
			}
			
		}
		
		if(estaEnvenenado() == true) {
			venenoRestaSalud();
		}
		
	}

	@Override
	public void descansar() {
		
		if(estaVivo()) {
			
			envenenado = false;
			meditando = true;
			saludMax += 33;
			saludActual += 33;
			
		}
		
	}

	@Override
	public void recibirAtaque(Raza enemigo) {
		
		saludActual -= enemigo.danioBasico;
		if(estaVivo() == false)
			saludActual = 0;
		meditando = false;
		
		if(estaEnvenenado() == true)
			venenoRestaSalud();
		
	}
	
	

}
