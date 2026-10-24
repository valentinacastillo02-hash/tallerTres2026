package Interface;

import java.util.ArrayList;

import Sistema.hombreLobo;
import Sistema.momia;
import Sistema.monstruoExistente;
import Sistema.vampiro;
import Sistema.zombie;

public class interfaceImplementado implements Iiinterface{
	ArrayList<monstruoExistente> listaMounstrous= new ArrayList<>();

	public void crearZombie(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int fuerzaMordida) {
		
			zombie Zombie=new zombie(tipoMonstruo,vida,velocidad,fuerza,resistencia,fuerzaMordida);
			listaMounstrous.add(Zombie);
	}

	public void crearVampiro(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int velocidadVuelo, int resistenciaSol) {
		vampiro Vampiro=new vampiro(tipoMonstruo,vida,velocidad,fuerza,resistencia,velocidadVuelo,resistenciaSol);
		listaMounstrous.add(Vampiro);
		
	}

	public void crearHomberLobo(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int ferocidad, int faceLunar) {
		hombreLobo HombreLobo=new hombreLobo(tipoMonstruo,vida,velocidad,fuerza,resistencia,ferocidad,faceLunar);
		listaMounstrous.add(HombreLobo);
	}

	public void crearMomia(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int longitudVendaje) {
		momia Momia=new momia(tipoMonstruo,vida,velocidad,fuerza,resistencia,longitudVendaje);
		listaMounstrous.add(Momia);
	}

	
	
	

}

