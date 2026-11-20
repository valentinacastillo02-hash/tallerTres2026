package Dominio;

import App.CazaCalabasasImpl;
import App.LanzamientoLápidasImpl;
import App.SobrevivirAmanecerImpl;
import App.calculoCarreraCementerio;
import App.miniJuego;

public abstract class Monstrous {
	private String Tipo;
	private int Vida;
	private int Velocidad;
	private int Fuerza;
	private int Resistencia;
	private boolean dispo;
	public Monstrous(String tipo, int vida, int velocidad, int fuerza, int resistencia) {
		
		this.Tipo = tipo;
		this.Vida = vida;
		this.Velocidad = velocidad;
		this.Fuerza = fuerza;
		this.Resistencia = resistencia;
		this.dispo=true;
	}
	
	
	public boolean isDispo() {
		return dispo;
	}


	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}


	public String getTipo() {
		return Tipo;
	}


	public int getVida() {
		return Vida;
	}


	public int getVelocidad() {
		return Velocidad;
	}


	public int getFuerza() {
		return Fuerza;
	}


	public int getResistencia() {
		return Resistencia;
	}


	@Override
	public String toString() {
		if(this.dispo == true) {
		return "Monstrous [Tipo=" + Tipo + ", Vida=" + Vida + ", Velocidad=" + Velocidad + ", Fuerza=" + Fuerza
				+ ", Resistencia=" + Resistencia + "]";
	}
		return "No disponible";
	}
	
	
	
	public abstract void accept(calculoCarreraCementerio visitor);
	

	public void accept(miniJuego visitor) {
		// TODO Auto-generated method stub
		
	}
	
	
	//Tipo;Vida;Velocidad;Fuerza;Resistencia;
}
