package Dominio;

import App.CazaCalabasasImpl;
import App.Furioso;
import App.LanzamientoLápidasImpl;
import App.Regenerable;
import App.SobrevivirAmanecerImpl;
import App.calculoCarreraCementerio;


public class Momia extends Monstrous implements Regenerable,Furioso{
	private int longitudVendajes;
	private boolean furia;
	private boolean regenerar;
	public Momia(String tipo, int vida, int velocidad, int fuerza, int resistencia, int longitudVendajes) {
		super(tipo, vida, velocidad, fuerza, resistencia);
		this.longitudVendajes = longitudVendajes;
		this.furia=false;
		this.regenerar=false;
	}
	
	

	public int getLongitudVendajes() {
		return longitudVendajes;
	}
	


	public void setLongitudVendajes(int longitudVendajes) {
		this.longitudVendajes = longitudVendajes;
	}



	@Override
	public boolean enfurecerse() {
		// preguntar de que si ya ha sido usado
		if(this.furia == false) {
			furia =true;
			activadoFuria();
			return true;
		}else {
			usadoFuria();
			
		}
		return false;
	}



	public String activadoFuria() {
		// Se notifica que se ha activado
		return "Activada habilidad de la Momia: Furia";
		
	}



	public String usadoFuria() {
		// Dice que ha se ha usado
		return "Ya ha sido usado ateriormente.No se puede usar el multiplicxador.";
	}



	@Override
	public boolean Regenerarse() {
		// preguntar de que si ya ha sido usado
				if(this.regenerar ==false) {
					regenerar =true;
					activadoRegenerar();
					return true;
				}else {
					usadoRegenerar();
					
				}
				return false;
	}



	public String  activadoRegenerar() {
		// Se notifica que se ha activado
			return "Activada habilidad de la Momia: Regenerar";
		
	}



	public String usadoRegenerar() {
		// Dice que ha se ha usado
		return "Ya ha sido usado ateriormente.No se puede usar el multiplicxador.";
		
	}



	@Override
	public void accept(calculoCarreraCementerio visitor) {
		// TODO Auto-generated method stub
		
	}







}
