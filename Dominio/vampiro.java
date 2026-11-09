package Dominio;

public class vampiro extends Monstrous{
	private int velocidadDeVuelo;
	private int resistenciaAlSol;
	public vampiro(String tipo, int vida, int velocidad, int fuerza, int resistencia, int velocidadDeVuelo,
			int resistenciaAlSol) {
		super(tipo, vida, velocidad, fuerza, resistencia);
		this.velocidadDeVuelo = velocidadDeVuelo;
		this.resistenciaAlSol = resistenciaAlSol;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Vampiro [=" + super.toString()+" velocidadDeVuelo=" + velocidadDeVuelo + ", resistenciaAlSol=" + resistenciaAlSol+ "]";
	}
}
