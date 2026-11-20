package App;
import App.miniJuego;
import Dominio.Momia;
import Dominio.Zombie;
import Dominio.hombreLobo;
import Dominio.vampiro;


public class calculoCarreraCementerio implements miniJuego {
	
	@Override
	public double miniJuegoMomia(Momia m) {
		// Se calcula el recorrer la distancia de punto a punto antes de que los vea
		//el supulturero y que se premia la habilidad volador
		//Velocidad × 100 / (100 + LongitudVendajes)
		String tipo="Momia";
		boolean efectiva=false;
		double potencial=m.getVelocidad()*100/(100 + m.getLongitudVendajes());
		//potencial=HabilidadMonstruo(potencial,efectiva,tipo);
		return potencial;
	}

	public double calculoPuntaje(double potencial, boolean efectiva,double multiplicador) {
		// Se calcula el puntaje
		double puntajeCal=0;
		
		if( efectiva == true) {
			multiplicador=1.5;
		}else {
			multiplicador=1;
		}
		puntajeCal=Math.round(potencial*10*multiplicador);
		return puntajeCal;
		
	}

	@Override
	public double miniJuegoZombie(Zombie z) {
		// Se calcula el recorrer la distancia de punto a punto antes de que los vea
		//el supulturero y que se premia la habilidad volador
		//Velocidad × Resistencia / 100
		boolean efectiva=false;
		String tipo="Zombie";
		double potencial=z.getVelocidad() * z.getResistencia()/100;
		//potencial=HabilidadMonstruo(potencial,efectiva,tipo);
		//double puntaje=calculoPuntaje(potencial,efectiva);
		return potencial;
	}

	public double HabilidadMonstruo(double potencial, boolean efectiva, String tipo) {
		Double puntaje=0.0;
		if(efectiva == true) {
			//System.out.println("¡La habilidad fue efectiva! Puntaje x1.5");
			puntaje=calculoPuntaje(potencial,efectiva,1.5);
		}
		return puntaje;
		// Se ve 
		
	}

	@Override
	public double miniJuegoVampiro(vampiro v) {
		// Se calcula el recorrer la distancia de punto a punto antes de que los vea
		//el supulturero y que se premia la habilidad volador
		//(Velocidad + 2 × VelocidadDeVuelo) / 2
		//Habilidad Premiada, Volador
		boolean efectiva=false;
		String tipo="Vampiro";
		double potencial=(v.getVelocidad() + 2*v.getVelocidadDeVuelo())/2; 
		//potencial=HabilidadMonstruo(potencial,efectiva,tipo);
		return potencial;
	}

	@Override
	public double miniJuego(hombreLobo h) {
		// Se calcula el recorrer la distancia de punto a punto antes de que los vea
		//el supulturero y que se premia la habilidad volador
		//(Velocidad + Ferocidad / 5) × FaseLunar / 4
		String tipo="HombreLobo";
		boolean efectiva=false;
		double potencial=(h.getVelocidad() + h.getFerocidad()/5)*h.getFaseLunar()/4;
		//potencial=HabilidadMonstruo(potencial,efectiva,tipo);
		return potencial;
	}

	
	
}
