package Dominio;

import App.CazaCalabasasImpl;
import App.Furioso;
import App.LanzamientoLápidasImpl;
import App.Mordedor;
import App.SobrevivirAmanecerImpl;
import App.calculoCarreraCementerio;
import App.miniJuego;

public class hombreLobo extends Monstrous implements Furioso,Mordedor{
	private int Ferocidad;
	private float FaseLunar;
	private boolean Furia;
	private boolean Morder;
	public hombreLobo(String tipo, int vida, int velocidad, int fuerza, int resistencia, int ferocidad, float faseLunar) {
		super(tipo, vida, velocidad, fuerza, resistencia);
		this.Ferocidad = ferocidad;
		this.FaseLunar = faseLunar;
		this.Furia=false;
		this.Morder=false;
	}
	
	
	public int getFerocidad() {
		return Ferocidad;
	}


	public float getFaseLunar() {
		return FaseLunar;
	}


	@Override
	public boolean enfurecerse() {
		// preguntar de que si ya ha sido usado
		if(this.Furia == false) {
			Furia =true;
			activadoFuria();
			return true;
		}else {
			usadoFuria();
			
		}
		return false;
	}


	public String  activadoFuria() {
		// Se notifica que se ha activado
		return "Activada habilidad de la Hombre Lobo: Furia";
	}


	public String usadoFuria() {
		// Dice que ha se ha usado
		return "Ya ha sido usado ateriormente.No se puede usar el multiplicxador.";
		
	}


	@Override
	public boolean Mordedor() {
		// preguntar de que si ya ha sido usado
		if(this.Morder ==false) {
			this.Morder =true;
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
		return "Activada habilidad de la Momia: Morder";
		
	}


	@Override
	public void accept(calculoCarreraCementerio visitor) {
		// TODO Auto-generated method stub
		
	}


	
	
}
