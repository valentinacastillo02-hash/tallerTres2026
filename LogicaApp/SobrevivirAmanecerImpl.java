package App;

import App.miniJuego;
import Dominio.Momia;
import Dominio.Zombie;
import Dominio.hombreLobo;
import Dominio.vampiro;

public class SobrevivirAmanecerImpl implements miniJuego{

	@Override
	public double miniJuegoZombie(Zombie z) {
		// Resistencia × Vida / 100
		double potencial= z.getResistencia() * z.getVida() /100;
		return potencial;
	}

	@Override
	public double miniJuegoVampiro(vampiro v) {
		// Resistencia × ResistenciaAlSol / 100
		double potencial = v.getResistencia() * v.getResistenciaAlSol() / 100;
		return potencial;
	}

	@Override
	public double miniJuego(hombreLobo h) {
		// (Resistencia + Vida) / 2 × (5 − FaseLunar) / 4
		double potencial =(h.getResistencia() + h.getVida()) / 2 * (5-h.getFaseLunar()) / 4; 
		return potencial;
	}

	@Override
	public double miniJuegoMomia(Momia m) {
		// (Resistencia + Vida) / 2 × (1 + LongitudVendajes / 300)
		double potencial = (m.getResistencia() + m.getVida()) / 2 * ( 1 + m.getLongitudVendajes() / 300); 
		return potencial;
	}

	public int HabilidadMonstruo(Double pot, boolean act, double d) {
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


