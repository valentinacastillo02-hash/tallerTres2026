package App;

import App.miniJuego;
import Dominio.Momia;
import Dominio.Zombie;
import Dominio.hombreLobo;
import Dominio.vampiro;

public class LanzamientoLápidasImpl implements miniJuego{

	@Override
	public double miniJuegoZombie(Zombie z) {
		// Lanza una lápida lo más lejos posible.
		//Fuerza × Resistencia / 100
		double puntaje=z.getFuerza() * z.getResistencia() / 100;
		return puntaje;
	}

	@Override
	public double miniJuegoVampiro(vampiro v) {
		// Fuerza + VelocidadDeVuelo / 4
		double puntaje=v.getFuerza() + v.getVelocidadDeVuelo() / 4;
		return puntaje;
	}

	@Override
	public double miniJuego(hombreLobo h) {
		//Ferocidad × FaseLunar / 4 + Velocidad / 4
		double puntaje=h.getFerocidad() * h.getFaseLunar() / 4 + h.getVelocidad() / 4;
		return puntaje;
	}

	@Override
	public double miniJuegoMomia(Momia m) {
		// Fuerza + LongitudVendajes / 10
		double puntaje = m.getFuerza() + m.getLongitudVendajes() / 10;
		return puntaje;
	}

	public int HabilidadMonstruo(Double pot, boolean act, String string) {
		// Si es la momia o hombre Lobo, se le aplica la bonificación.
		int puntaje=0;
		if(act == true) {
			//System.out.println("¡La habilidad fue efectiva! Puntaje x1.5");
			puntaje=calculoPuntaje(pot,act,1.5);
		}
		return puntaje;
	}

	public int calculoPuntaje(Double pot, boolean act, double d) {
		int puntajeCal=0;
		
		if( act == true) {
			d=1.5;
		}else {
			d=1;
		}
		puntajeCal=(int) Math.round(pot*10* d);
		return puntajeCal;
	}
}

	
