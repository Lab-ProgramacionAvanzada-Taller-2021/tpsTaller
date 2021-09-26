package ar.edu.unlam.pa.taller.raza;

/* Un Bruchian tiene una salud inicial de 149. Utiliza shurikens, 
 * y su rango de ataque es de 8 a 33 metros. Ocasiona un daño 
 * básico de 32 puntos. Cuando ataca, lo hace con más fuerza 
 * cada vez que recibe ataques (3 de daño elevados a la cantidad 
 * de ataques recibidos). Al recibir un ataque no sucede nada. 
 * Cuando descansa, recupera hasta el 50 por ciento de su salud inicial.
 */

public class Bruchian extends Raza {
	
	private static final String RAZA = "Bruchian";
	private static final double SALUD_MAX = 149;
	private static final double DANIO_BASICO = 32;
	private static final double RANGO_ATAQUE_MIN = 8;
	private static final double RANGO_ATAQUE_MAX = 33;
	private int ATAQUES_RECIBIDOS = 0;
	
	public Bruchian(Posicion suPosicionActual) {
		super(RAZA,SALUD_MAX, SALUD_MAX, RANGO_ATAQUE_MIN, RANGO_ATAQUE_MAX, DANIO_BASICO, suPosicionActual);
	}

	@Override
	public void atacar(Raza enemigo) {
		
		if(estaVivo() && enemigo.estaVivo()) {
		
			double distancia = posicionActual.distancia(enemigo.posicionActual);
			
			if (distancia <= rangoAtaqueMax && distancia >= rangoAtaqueMin){
				enemigo.recibirAtaque(this); 
			}
			
		}
		
		if(estaEnvenenado() == true)
			venenoRestaSalud();
		
	}

	@Override
	public void descansar() {
		
		if(estaVivo()) {
			envenenado = false;
			saludActual += saludMax*0.5;
			if(saludActual > saludMax)
				saludActual = saludMax;
		}
		
	}

	@Override
	public void recibirAtaque(Raza enemigo) {
		
		saludActual -= enemigo.danioBasico;
		if(estaVivo() == false)
			saludActual = 0;
		
		ATAQUES_RECIBIDOS++;
		danioBasico = DANIO_BASICO + Math.pow(3, ATAQUES_RECIBIDOS);
		//danioBasico = danioBasico + Math.pow(3, ATAQUES_RECIBIDOS); //elegir uno de estos dos modos de incrementar
		
		if(estaEnvenenado() == true)
			venenoRestaSalud();
			
	}
}
