package Dominio;

public class hombreLobo extends Monstrous{
	private int Ferocidad;
	private int FaseLunar;
	public hombreLobo(String tipo, int vida, int velocidad, int fuerza, int resistencia, int ferocidad, int faseLunar) {
		super(tipo, vida, velocidad, fuerza, resistencia);
		this.Ferocidad = ferocidad;
		this.FaseLunar = faseLunar;
	}
}
