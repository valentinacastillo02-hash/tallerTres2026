package App;

import Dominio.Momia;
import Dominio.Monstrous;
import Dominio.Zombie;
import Dominio.hombreLobo;
import Dominio.vampiro;

public interface miniJuego {
	
	double miniJuegoZombie(Zombie z);
	double miniJuegoVampiro(vampiro v);
	double miniJuego(hombreLobo h);
	double miniJuegoMomia(Momia m);
	
	
}
