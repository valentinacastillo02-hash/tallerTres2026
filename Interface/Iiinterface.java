package Interface;

public interface Iiinterface {
	void crearZombie(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int fuerzaMordida);
	void crearVampiro(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int velocidadVuelo, int resistenciaSol);
	void crearHomberLobo(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int ferocidad, int faceLunar);
	void crearMomia(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int longitudVendaje);
	

}
