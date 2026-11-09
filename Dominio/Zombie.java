package Dominio;

public class Zombie  extends Monstrous{
	private int FuerzaMordida;

	public Zombie(String tipo, int vida, int velocidad, int fuerza, int resistencia, int fuerzaMordida) {
		super(tipo, vida, velocidad, fuerza, resistencia);
		this.FuerzaMordida = fuerzaMordida;
	}

	@Override
	public String toString() {
		return "Zombie [=" + super.toString() + ",Fuerza de mordida =" + this.FuerzaMordida + "]";
	}
}
