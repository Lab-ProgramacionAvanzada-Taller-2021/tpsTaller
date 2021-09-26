package ar.edu.unlam.pa.taller.raza;

public class Posicion {
	private int x;
	private int y;

	public double distancia(Posicion p) {

		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	public Posicion(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Posicion [x=" + x + ", y=" + y + "]";
	}

}
