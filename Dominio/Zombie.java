package Dominio;

import App.CazaCalabasasImpl;
import App.LanzamientoLápidasImpl;
import App.Mordedor;
import App.Regenerable;
import App.SobrevivirAmanecerImpl;
import App.calculoCarreraCementerio;

public class Zombie  extends Monstrous implements Regenerable, Mordedor{
	private int FuerzaMordida;
	private boolean Morder;
	private boolean Regenerarse;

	public Zombie(String tipo, int vida, int velocidad, int fuerza, int resistencia, int fuerzaMordida) {
		super(tipo, vida, velocidad, fuerza, resistencia);
		this.FuerzaMordida = fuerzaMordida;
		this.Morder=false;
		this.Regenerarse=false;
	}
	

	public int getFuerzaMordida() {
		return FuerzaMordida;
	}


	@Override
	public String toString() {
		return "Zombie [=" + super.toString() + ",Fuerza de mordida =" + this.FuerzaMordida + "]";
	}


	@Override
	public void accept(calculoCarreraCementerio visitor) {
		// TODO Auto-generated method stub
		
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
		return "Activada habilidad de la Zombie: Morder";
		
	}


	@Override
	public boolean Regenerarse() {
		// preguntar de que si ya ha sido usado
		if(this.Regenerarse ==false) {
			Regenerarse =true;
			activadoRegenerar();
			return true;
		}else {
			usadoRegenerar();
		}
		return false;
	}


	public String usadoRegenerar() {
		// Se notifica que se ha activado
		return "Activada habilidad de la Zombie: Regenerar";
		
	}


	public String activadoRegenerar() {
		// Dice que ha se ha usado
		return "Ya ha sido usado ateriormente.No se puede usar el multiplicxador.";
		
	}


	

	
}
