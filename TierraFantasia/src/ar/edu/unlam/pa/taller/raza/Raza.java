package ar.edu.unlam.pa.taller.raza;

public abstract class Raza {

	protected String raza;
	protected double saludActual;
	protected double saludMax;
	protected double rangoAtaqueMin;
	protected double rangoAtaqueMax;
	protected double danioBasico;
	protected Posicion posicionActual;
	protected boolean envenenado;
	private boolean turno;

	public abstract void atacar(Raza enemigo);

	public abstract void descansar();

	protected abstract void recibirAtaque(Raza enemigo);

	public Raza(String raza,double saludActual, double saludMax, double rangoAtaqueMin, double rangoAtaqueMax, Double danioBasico,
			Posicion posicionActual) {
		super();
		this.raza = raza;
		this.saludActual = saludActual;
		this.saludMax = saludMax;
		this.rangoAtaqueMin = rangoAtaqueMin;
		this.rangoAtaqueMax = rangoAtaqueMax;
		this.danioBasico = danioBasico;
		this.posicionActual = posicionActual;
		this.envenenado = false;
	}

	public boolean estaVivo() {
		return saludActual>0;
	}
	
	public boolean estaEnvenenado() {
		if(estaVivo() == false)
			return false;
		return envenenado;
	}
	
	public void venenoRestaSalud() {
		saludActual -= Hudin.DANIO_VENENO;
		if(estaVivo() == false)
			saludActual = 0;
	}
	

}
