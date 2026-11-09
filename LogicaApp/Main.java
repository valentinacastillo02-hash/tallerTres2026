package App;
//Valentina Castillo rut=15.166.692-2   Carrera:ITI

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Dominio.contratoPrincipal;
import Dominio.interfaceImple;

public class Main {
	static int contadorElementos=0;
	static int contInterface=0;
	static contratoPrincipal interf=null;
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		if(contInterface == 0) {
			interf= new interfaceImple();
			contInterface++;
		}
		
		
		File archivo=new File("Registros.txt");
		leerArchivosRegistro(archivo);
		
		File arch=new File("Monsturos.txt");
		
		leerArchivoMonstruos(arch);
		menu();
		menuMiniJuego();
	
	}

	private static void menuMiniJuego() {
		// Se presenta el minijuego
		int opc=0;
		while(opc !=6) {
		System.out.println(""
				+ "1) Jugar un minijuego\r\n"
				+ "2) Ver catálogo de monstruos\r\n"
				+ "3) Ver historial de la sesión\r\n"
				+ "4) Ver ranking de jugadores\r\n"
				+ "5) Terminar sesión\r\n"
				+ "6) Salir");
		
		System.out.println();
		System.out.println("Ingrese la opción que desee:");
		opc=s.nextInt();
		
		switch(opc) {
		case 1:
			jugarMiniJuego();
			break;
		case 2:
			
			break;
		}
		
		
		
		
		}
	}

	private static void jugarMiniJuego() {
		boolean inicioSesión=true;
		String completado1="Pendiente";
		String completado2="Pendiente";
		String completado3="Pendiente";
		String completado4="Pendiente";
		int puntaje1=0;
		int puntaje2=0;
		int puntaje3=0;
		int puntaje4=0;
		// Escoger las el juego que quiera jugar;
		System.out.println(""
				+ " Minijuegos");
		System.out.println();
		System.out.println(
				  "1) Carrera del Cementerio. Ha sido Jugado:"+completado1+"Puntaje obtenido:"+puntaje1//Recorre el cementerio de punta a punta antes de que el sepulturero te vea.
				+ "2) Caza de Calabazas. Ha sido Jugado:"+ completado2 +"Puntaje obtenido:" + puntaje2//Muerde la mayor cantidad de calabazas del huerto en 60 segundos.
				+ "3) Lanzamiento de Lápidas. Ha sido Jugado:" + completado3 + "Puntaje obtenido:"+puntaje3//Lanza una lápida lo más lejos posible.
				+ "4) Sobrevivir al Amanecer. Ha sido Jugado:"+completado4+"Puntaje obtenido:"+puntaje4);//Aguanta en pie cuando salgan los primeros rayos de sol.
	System.out.println("Escoja el juego que desee usar:");
		
	}

	private static void leerArchivoMonstruos(File arch) {
		// TODO Auto-generated method stub
		
			if(interf.existeRecorrido(arch)) {
			
			Scanner scanner=null;
			
			try {
				scanner=new Scanner(arch);
			}catch(Exception e) {
				
				System.out.println("Error al leer el archivo");
			}
			while(scanner.hasNextLine()) {
				String linea=scanner.nextLine();
				crearMonstruos(linea);
				System.out.println(linea);
				
				
				}
			}else {
			System.out.println("Termino carga");	
			}
			
	}

	private static void menu() {
		// Se empieza en menu de usuario luego de leer los archivos y que exista el archivo monstruo.txt
		String nombreIngresado="";
		System.out.println("=========================================\r\n"
				+ "             SPOOKY SEASON\r\n"
				+ "=========================================");
		
		System.out.println();
		try {
		boolean sigue=false;
		System.out.print("Ingrese su nombre de usuario:");
		nombreIngresado=s.nextLine();   
		while(nombreIngresado.isBlank()) {
			System.out.println("No se pueden ingresar datos vacios ni Datos invalidos. Ingrese un valor válido");
			nombreIngresado=s.nextLine();
			
			}
		while(!sigue) {
			sigue=corroborarEspacioS(nombreIngresado,sigue);
			if(!sigue) {
				System.out.println("Ingrese nuevo nombre");
				nombreIngresado=s.nextLine();
			}
			
			}
		
		
		}catch(NumberFormatException e) {
			System.out.println("Formato no válido");
		}
		
		nombreisExiste(nombreIngresado);
	}

	private static void nombreisExiste(String nombreIngresado) {
		// Comparar este nombre, con los ya ingresados
		
		System.out.println(interf.buscarNombre(nombreIngresado));
		
	}

	private static boolean corroborarEspacioS(String nombreIngresado, boolean sigue) {
		// Una vez que sabemos que el nombre no está en blanco,
		//Se corrobora que no hay espacios entre ellos:
		boolean linea;
		linea = interf.corroborarEspacioS(nombreIngresado);
		System.out.println();
		
		if(linea) {
			sigue =true;
			System.out.println("Se termino de comprobar, correcto");
			return sigue;
		}
		
		return sigue;
		
	}     

	private static void leerArchivosRegistro(File archivo ) throws IOException {
		if(interf.existeRecorrido(archivo)) {
			
			Scanner scanner=null;
			
			try {
				scanner=new Scanner(archivo);
			}catch(Exception e) {
				
				System.out.println("Error al leer el archivo");
			}
			while(scanner.hasNextLine()){
				String linea=scanner.nextLine();
				crearRegistro(linea);
				
				System.out.println(linea);
					}
		}else {
			System.out.println("Archivo no existe, se creará al guardar las nuevas puntaciones.");
			archivo.createNewFile();//Se crea el archivo si no existe
			//FileWriter write =new FileWriter("Registros.txt");, guardar para sobreescribir
		}
	}

	private static void crearMonstruos(String Linea) {
		interf.crearMonstruo(Linea);
	}
	

	private static void crearRegistro(String linea) {
		System.out.println(interf.leerRegistro(linea));
		
		
	}

}

