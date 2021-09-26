package ar.edu.unlam.pa.taller.raza;

/*
 * Una Stonnulopes tiene una salud inicial de 70. Utiliza granadas, y su rango de ataque es de 13 a 34 metros. 
 * Ocasiona un daño básico de 64 puntos. Cuando ataca, lo hace cada vez con más fuerza (2 de daño extra x la cantidad de ataques dados). 
 * Al recibir un ataque recibe 1/2 del daño, ya que tiene mucha armadura. 
 * Cuando descansa, recupera toda su salud, pero se vuelve de piedra por 3 turnos, lo que hace que no pueda atacar, pero reduce el daño entrante en 2/3.
 */

public class Stonnulopes extends Raza{

	private static final String RAZA = "Stonnulopes";
	private static final double SALUD_MAX = 70;
	private static final double DANIO_BASICO = 64;
	private static final double RANGO_ATAQUE_MIN = 13;
	private static final double RANGO_ATAQUE_MAX = 34;
	private int ataquesDados = 0;
	private boolean dePiedra = false;
	private int contDePiedra = 0;
	
	public Stonnulopes(Posicion posicionActual) {
		super(RAZA,SALUD_MAX, SALUD_MAX, RANGO_ATAQUE_MIN, RANGO_ATAQUE_MAX, DANIO_BASICO, posicionActual);
	}

	@Override
	public void atacar(Raza enemigo) {
		
		if(estaVivo() && enemigo.estaVivo() && dePiedra == false && enemigo != this) {
			
			double distancia = posicionActual.distancia(enemigo.posicionActual);
			if (distancia <= rangoAtaqueMax && distancia >= rangoAtaqueMin){
				danioBasico = DANIO_BASICO + 2*ataquesDados;
				enemigo.recibirAtaque(this); 
				ataquesDados++;
			}
		
		}
		
		if(estaEnvenenado()) 
			venenoRestaSalud();	
		
		contDePiedra--;
		if(contDePiedra == 0)
			dePiedra = false;
		
	}

	@Override
	public void descansar() {
		
		if(estaVivo() && dePiedra == false) {
		
			dePiedra = true;
			contDePiedra = 3;
			saludActual = saludMax;
			
		}else {
			contDePiedra--;
			if(contDePiedra == 0)
				dePiedra = false;
		} 
		
	}

	@Override
	protected void recibirAtaque(Raza enemigo) {

		saludActual -= enemigo.danioBasico*0.5;
		if(estaVivo() == false)
			saludActual = 0;
			
		if(estaEnvenenado()) 
			venenoRestaSalud();
		
		
		contDePiedra--;
		if(contDePiedra == 0)
			dePiedra = false;
		
	}
	
	@Override
	public void venenoRestaSalud() {
		double modificador = 1;
		if(dePiedra) {
			modificador = 1/3;
		}
		saludActual -= Hudin.DANIO_VENENO * modificador ;
		if(estaVivo() == false)
			saludActual = 0;
	}

}
