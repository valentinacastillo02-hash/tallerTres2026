package Dominio;

public class Momia extends Monstrous{
	private int longitudVendajes;

	public Momia(String tipo, int vida, int velocidad, int fuerza, int resistencia, int longitudVendajes) {
		super(tipo, vida, velocidad, fuerza, resistencia);
		this.longitudVendajes = longitudVendajes;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
