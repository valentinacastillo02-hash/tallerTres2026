package Dominio;

import java.io.File;

public interface contratoPrincipal {
	void Ejecutar();
	
	boolean existeRecorrido(File archivo);
	String leerRegistro(String linea);
	String crearMonstruo(String linea);

	boolean corroborarEspacioS(String nombreIngresado);

	String buscarNombre(String nombreIngresado);
}
