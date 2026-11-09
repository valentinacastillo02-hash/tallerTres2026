package Dominio;

public class Monstrous {
	private String Tipo;
	private int Vida;
	private int Velocidad;
	private int Fuerza;
	private int Resistencia;
	public Monstrous(String tipo, int vida, int velocidad, int fuerza, int resistencia) {
		
		this.Tipo = tipo;
		this.Vida = vida;
		this.Velocidad = velocidad;
		this.Fuerza = fuerza;
		this.Resistencia = resistencia;
	}
	@Override
	public String toString() {
		return "Monstrous [Tipo=" + Tipo + ", Vida=" + Vida + ", Velocidad=" + Velocidad + ", Fuerza=" + Fuerza
				+ ", Resistencia=" + Resistencia + "]";
	}
	
	
	
	
	
	//Tipo;Vida;Velocidad;Fuerza;Resistencia;
}
