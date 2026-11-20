package App;

import App.miniJuego;
import Dominio.Momia;
import Dominio.Zombie;
import Dominio.hombreLobo;
import Dominio.vampiro;

public class CazaCalabasasImpl  implements miniJuego{
	public double calculPuntaje(double potencial, boolean efectiva) {
		// Se calcula el puntaje
		double puntajeCal=0;
		double multiplicador=0;
		if( efectiva == true) {
			multiplicador=1.5;
		}else {
			multiplicador=1;
		}
		puntajeCal=Math.round(potencial*10*multiplicador);
		return puntajeCal;
		
	}
	@Override
	public double miniJuegoMomia(Momia m) {
		// Muerde la mayor cantidad de calabazas del huerto en 60 segundos 
		//Habilidad premiada: Mordedor.
		//LongitudVendajes × Fuerza / 200
		String tipo="Momia";
		boolean efectiva=false;
		double potencial=(m.getLongitudVendajes() * m.getFuerza())/200;
		//double puntaje=calculPuntaje(potencial,efectiva);
		return potencial;
		
	}

	@Override
	public double miniJuegoZombie(Zombie z) {
		// Muerde la mayor cantidad de calabazas del huerto en 60 segundos 
		//Habilidad premiada: Mordedor.
		//FuerzaDeMordida × Vida / 100 + Resistencia / 2
		String tipo="Zombie";
		boolean efectiva=false;
		double potencial=(z.getFuerzaMordida() * z.getVida())/100 + (z.getResistencia()/2);
		//double puntaje=calculPuntaje(potencial,efectiva);
		return potencial;
	}
	@Override
	public double miniJuegoVampiro(vampiro v) {
		// Muerde la mayor cantidad de calabazas del huerto en 60 segundos 
		//Habilidad premiada: Mordedor.
		//(Fuerza + Velocidad) / 3
		String tipo="Zombie";
		boolean efectiva=false;
		double potencial=(v.getFuerza() + v.getVelocidad())/3;
		return potencial;
	}
	@Override
	public double miniJuego(hombreLobo h) {
		// Muerde la mayor cantidad de calabazas del huerto en 60 segundos 
		//Habilidad premiada: Mordedor.
		//Ferocidad × FaseLunar / 4 + Velocidad / 4
		String tipo="Zombie";
		boolean efectiva=false;
		double potencial=h.getFerocidad() * h.getFaseLunar() /4 + h.getVelocidad() /4;
		return potencial;
	}
	public double HabilidadMonstruo(Double pot, boolean act, String string) {
		// Muerde la mayor cantidad de calabazas del huerto en 60 segundos 
		//Habilidad premiada: Mordedor. 
		Double puntaje=0.0;
		if( act == true) {
			//System.out.println("¡La habilidad fue efectiva! Puntaje x1.5");
			puntaje=calculPuntaje(pot,act);
		}
		return puntaje;
		
	}

	

}
