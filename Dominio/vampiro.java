package Dominio;

import App.CazaCalabasasImpl;
import App.LanzamientoLápidasImpl;
import App.Mordedor;
import App.SobrevivirAmanecerImpl;
import App.Volador;
import App.calculoCarreraCementerio;

public class vampiro extends Monstrous implements Mordedor, Volador {
	private int velocidadDeVuelo;
	private int resistenciaAlSol;
	private boolean Mordedor;
	private boolean Volador;
	public vampiro(String tipo, int vida, int velocidad, int fuerza, int resistencia, int velocidadDeVuelo,
			int resistenciaAlSol) {
		super(tipo, vida, velocidad, fuerza, resistencia);
		this.velocidadDeVuelo = velocidadDeVuelo;
		this.resistenciaAlSol = resistenciaAlSol;
		this.Mordedor=false;
		this.Volador=false;
	}
	
	
	public int getVelocidadDeVuelo() {
		return velocidadDeVuelo;
	}


	public int getResistenciaAlSol() {
		return resistenciaAlSol;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Vampiro [=" + super.toString()+" velocidadDeVuelo=" + velocidadDeVuelo + ", resistenciaAlSol=" + resistenciaAlSol+ "]";
	}


	@Override
	public void accept(calculoCarreraCementerio visitor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean Volar() {
		// preguntar de que si ya ha sido usado
		if(this.Volador ==false) {
			this.Volador =true;
			activadoVolador();
			return true;
		}else {
			usadoVolador();		
		}
		return false;
	}


	public String usadoVolador() {
		// Dice que ha se ha usado
		return "Ya ha sido usado ateriormente.No se puede usar el multiplicxador.";
		
	}


	public String activadoVolador() {
		// Se notifica que se ha activado
		return "Activada habilidad de la Vamprio: Volar";
		
	}


	@Override
	public boolean Mordedor() {
		// preguntar de que si ya ha sido usado
				if(this.Mordedor ==false) {
					this.Mordedor =true;
					activadoMorder();
					return true;
				}else {
					usadoMorder();		
				}
				return false;
	}


	public String usadoMorder() {
		// Dice que ha se ha usado
		return "Ya ha sido usado ateriormente.No se puede usar el multiplicxador.";
		
	}


	public String activadoMorder() {
		// Se notifica que se ha activado
		return "Activada habilidad de la Vamprio: Morder";
		
	}
	
	
	
}
