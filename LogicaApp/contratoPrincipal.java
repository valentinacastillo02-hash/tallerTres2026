package App;

import java.io.File;

import Dominio.Monstrous;

public interface contratoPrincipal {
	void Ejecutar();
	
	boolean existeRecorrido(File archivo);
	String leerRegistro(String linea);
	

	boolean corroborarEspacioS(String nombreIngresado);

	String buscarNombre(String nombreIngresado);

	String escogerMonstruos(int lugar);

	int obtTamañoMons();

	Monstrous obtenerMonstruo(int lugar);
