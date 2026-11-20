package App;
//Valentina Castillo rut=15.166.692-2   Carrera:ITI

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import Dominio.Momia;
import Dominio.Monstrous;
import Dominio.Zombie;
import Dominio.hombreLobo;

import Dominio.vampiro;


public class Main {
	static String jugadorActual=""; 
	static boolean jugoAlgo=false;
	static SobrevivirAmanecerImpl sobrevivir=new SobrevivirAmanecerImpl();
	static LanzamientoLápidasImpl lanza= new LanzamientoLápidasImpl();
	static interfaceImple interf=null;
	static calculoCarreraCementerio cement=new calculoCarreraCementerio();
	static CazaCalabasasImpl cazas=new CazaCalabasasImpl();
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		if(interf == null) {
			interf= new interfaceImple();
			
		}
		
		
		File archivo=new File("Registros.txt");
		leerArchivosRegistro(archivo);
		
		File arch=new File("Monstruos.txt");
		
		leerArchivoMonstruos(arch);
		menu();
		menuMiniJuego();
	
	}

	public static void menuMiniJuego() {
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
	
		System.out.println("Ingrese la opción que desee:");
		try {
			System.out.println();
			opc=s.nextInt();
		}catch(Exception e) {
			System.out.println("Error al ingresar el valor.");
		}
		while(0>=opc || opc>7) {
			
			System.out.println("Valores fuera del Rango permitido");
			try {
				System.out.print("Escoja el juego que desee usar:");
				System.out.println();
				opc=s.nextInt();
			}catch(Exception e) {
				System.out.println("Error al ingresar el valor.");
			}
		}
		
		switch(opc) {
		case 1:
			jugarMiniJuego(false,jugoAlgo);
			break;
		case 2:
			catalogoMounstros();
			
			break;
		case 3:
			historialSesion();
			break;
		case 4:
			rankingJugadores();
			break;
		case 5:
			terminarSesion();
			break;
		case 6:
			salir();
			break;
		}
		
		}
	}

	public static void salir() {
		// sALIR DE SESIÓN.
		System.out.println("Adios...");
		
	}

	public static void terminarSesion() {
		// Se muestra el puntaje total de la sesión primero.
		int puntuacionMax=0;
		boolean existe=false;
		boolean mismaPuntuacion=false;
		jugarMiniJuego(true,jugoAlgo);
		if(jugoAlgo =true) {
			existe=interf.esNuevo(jugadorActual);
		}
		if (existe == true) {
			guardarPartida();
		}else {
			mismaPuntuacion=interf.mismaPuntuacion(jugadorActual,puntuacionMax);
			if(mismaPuntuacion == true) {
				guardarPartida();
			}else {
				guardarPartida();
			}
		}
		
		
	}

	public static void guardarPartida() {
		// Se llama a los comandos para guardar/sobreescribir documento
		try {
			FileWriter sobreEscribir= new FileWriter("Registros.txt");
			BufferedWriter escritor= new BufferedWriter(sobreEscribir);
			System.out.println(interf.guardarPartidajugNuevo(escritor));
			escritor.close();
			
		}catch(Exception e) {
			System.out.println("Error al sobreescribir el archivo.");
		}
		menu();
	}

	public static void rankingJugadores() {
		// Ordenarlos de mayor a menor.
		interf.ordenarRegistros();
		int cantJugadores=interf.cantJugadores();
		
		for (int i = 0; i < cantJugadores; i++) {
			System.out.println(interf.imprimJugadores(i));
			
		}
		
		
	}

	public static void historialSesion() {
		// TODO Auto-generated method stub
		
	}

	public static void catalogoMounstros() {
		// Muestra los mounstros.
		System.out.println("Monstrar monstruos disponibles: ");
		int largoTotal=buscarTamañoMo();
		int largoUsado=largoUsado();
		for (int i = 0; i < largoTotal; i++) {
			System.out.println(interf.mostrarListaTotal(i));		
		}
		System.out.println();
		System.out.println("Monstruos usados");
		for (int i = 0; i < largoTotal; i++) {
			System.out.println(interf.mostrarListaUsados(i));			
		}
		
	}

	public static int largoUsado() {
		// Obtener la cantidad de mosnturos usados.
		return interf.largoUsa();
	}

	public static void jugarMiniJuego(boolean revisar,boolean jugoAlgo) {
		boolean inicioSesión=true;
		String completado1="Pendiente";
		String completado2="Pendiente";
		String completado3="Pendiente";
		String completado4="Pendiente";
		int puntaje1=0;
		int puntaje2=0;
		int puntaje3=0;
		int puntaje4=0;
		int option=0;
		// Escoger las el juego que quiera jugar;
		if(revisar == false) {
		while(inicioSesión) {
		
		System.out.println(""
				+ " Minijuegos");
		System.out.println();
		System.out.println(
				  "1) Carrera del Cementerio:"+completado1+" Puntaje obtenido:"+puntaje1+"\r\n"+//Recorre el cementerio de punta a punta antes de que el sepulturero te vea.
				  "2) Caza de Calabazas:"+ completado2 +" Puntaje obtenido:" + puntaje2+"\r\n"+//Muerde la mayor cantidad de calabazas del huerto en 60 segundos.
				  "3) Lanzamiento de Lápidas:" + completado3 + " Puntaje obtenido:"+puntaje3+"\r\n"+//Lanza una lápida lo más lejos posible.
				  "4) Sobrevivir al Amanecer:"+completado4+" Puntaje obtenido:"+puntaje4+"\r\n"+
				  "5) Terminar sesión \r\n"+
				  "6)  Salir");//Aguanta en pie cuando salgan los primeros rayos de sol.
		System.out.println();
		try {
			System.out.print("Escoja el juego que desee usar:");
			System.out.println();
			option=s.nextInt();
		}catch(Exception e) {
			System.out.println("Error al ingresar el valor.");
		}
	
	while(0>option || option>7) {
		System.out.println("Valor fuera de rango, escoja alguna opción correcta.");
		try {
			System.out.print("Escoja el juego que desee usar:");
			System.out.println();
			option=s.nextInt();
		}catch(Exception e) {
			System.out.println("Error al ingresar el valor.");
		}
	}
	
	
	switch(option) {
	
		case 1://No se como hacer que se puede imprimir los presenter
			if(completado1.equalsIgnoreCase("Pendiente")) {
				carreraCementerio(completado1,puntaje1);
			}else {
				System.out.println("Este juego ya se a jugado.En esta sesión ya no se puede Jugar");
				System.out.println("El puntaje es "+puntaje1);
			}
		
			break;
		case 2:
			if(completado2.equalsIgnoreCase("Pendiente")) {
				cazaCalabaza(completado2,puntaje2);
			}else {
				System.out.println("Este juego ya se a jugado.En esta sesión ya no se puede Jugar");
				System.out.println("El puntaje es "+puntaje2);
			}
			break;
		
		case 3:
			if(completado3.equalsIgnoreCase("Pendiente")) {
				lanzamientoLapidas(completado3,puntaje3);
			}else {
				System.out.println("Este juego ya se a jugado.En esta sesión ya no se puede Jugar");
				System.out.println("El puntaje es "+puntaje3);
			}
			break;
		
		case 4:
			if(completado4.equalsIgnoreCase("Pendiente")) {
				SobrevivirAmanecer(completado4,puntaje4);
			}else {
				System.out.println("Este juego ya se a jugado.En esta sesión ya no se puede Jugar");
				System.out.println("El puntaje es "+puntaje4);
			}
			break;
		
					}
	if(!completado1.equalsIgnoreCase("Pendiente") || !completado2.equalsIgnoreCase("Pendiente") || !completado3.equalsIgnoreCase("Pendiente") ||!completado4.equalsIgnoreCase("Pendiente")) {
		jugoAlgo = true;
	}
		
				}
			
		}else {
			System.out.println("Puntaje total de la sesión:");
			System.out.println(""
					+ " Minijuegos");
			System.out.println();
			System.out.println(
					  "1) Carrera del Cementerio:"+completado1+" Puntaje obtenido:"+puntaje1+"\r\n"+//Recorre el cementerio de punta a punta antes de que el sepulturero te vea.
					  "2) Caza de Calabazas:"+ completado2 +" Puntaje obtenido:" + puntaje2+"\r\n"+//Muerde la mayor cantidad de calabazas del huerto en 60 segundos.
					  "3) Lanzamiento de Lápidas:" + completado3 + " Puntaje obtenido:"+puntaje3+"\r\n");//Lanza una lápida lo más lejos posible.)
			System.out.println();
			System.out.println("Guardando partida...");
			guardarPartida();
		}
	}
		

	public static void SobrevivirAmanecer(String completado4, int puntaje4) {
		// Aguanta en pie cuando salgan los primeros rayos de sol.
		
		int lugar=-1;
		int cantMonstruos=0;
		cantMonstruos=buscarTamañoMo();
		Monstrous escogido=null; 
		System.out.println("Monstruos disponibles: ");
		for (int i = 0; i < cantMonstruos; i++) {
			System.out.print(i+")");
			System.out.println(interf.escogerMonstruos(i));
		}
		//Muerde la mayor  cantidad de calabazas del huerto en 60 seg.
		while(lugar<=-1) {
			try {
				System.out.println("Escoja el Mounstruo para la caza de calabazas.");
				lugar=s.nextInt();
			}catch(Exception e) {
				System.out.println("Número no ingresable.");
				}
			}
			escogido=interf.obtenerMonstruo(lugar);
			
			if(escogido == null) {
				System.out.println("No quedan monsturos disponibles. No se puede escoger");
				System.out.println("Volviendo al menú principal");
				completado4="Pendiente";
			}else {
				System.out.println("Se ha escogido"+escogido.getTipo());
				System.out.println(escogido.toString());
				calculoSobrevivirAmanecer(escogido,puntaje4);
				completado4="Completado";
			}
		
		
		
	}

	public static void calculoSobrevivirAmanecer(Monstrous escogido, int puntaje4) {
		// Para escoger  con cual monstruo.
		String tipo=escogido.getTipo();
		boolean act=false;
		String habilidad="";
		double puntaje=0;
		Double pot=null;
		double multi=0.0;
		switch(tipo) {
		case "Zombi":
			Zombie e= (Zombie) escogido;
			pot=sobrevivir.miniJuegoZombie(e);
			System.out.println("El zombie tienen un potencial de "+ pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("1)Mordedor.");
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(1,0,"Lanzamiento de Lápidas");
			if(act == true) {
				puntaje4=sobrevivir.HabilidadMonstruo(pot,act,multi);
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje4);
			break;
			
		case "Vampiro":
			
			vampiro v= (vampiro) escogido;
			pot=sobrevivir.miniJuegoVampiro(v);
			System.out.println("El vampiro tienen un potencial de "+ pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("1)Mordedor.");
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(1,0,"Lanzamiento de Lápidas");
			if(act == true) {
				puntaje4=sobrevivir.HabilidadMonstruo(pot,act,multi);
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje4);
			break;
			
		case "Momia"://Furioso
			Momia m= (Momia) escogido;
			pot=sobrevivir.miniJuegoMomia(m);
			System.out.println("La momia tienen un potencial de "+pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println();
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(1,0,"Lanzamiento de Lápidas");
			if(act == true) {
				puntaje4=sobrevivir.HabilidadMonstruo(pot,act,multi);
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje4);
			break;
			
		case "HombreLobo"://Furioso
			hombreLobo h= (hombreLobo) escogido;
			pot=sobrevivir.miniJuego(h);
			System.out.println("El Hombre Lobo tienen un potencial de "+ pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("1)Mordedor.");
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(2,1,"Lanzamiento de Lápidas");
			if(act == true) {
				puntaje4=sobrevivir.HabilidadMonstruo(pot,act,multi);
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje4);
			break;
		}
		
		
	}

	public static void lanzamientoLapidas(String completado3, int puntaje3) {
		// Lanza una lápida lo más lejos posible.
		int lugar=-1;
		int cantMonstruos=0;
		cantMonstruos=buscarTamañoMo();
		Monstrous escogido=null; 
		System.out.println("Monstruos disponibles: ");
		for (int i = 0; i < cantMonstruos; i++) {
			System.out.print(i+")");
			System.out.println(interf.escogerMonstruos(i));
		}
		//Muerde la mayor  cantidad de calabazas del huerto en 60 seg.
		while(lugar<=-1) {
			try {
				System.out.println("Escoja el Mounstruo para la caza de calabazas.");
				lugar=s.nextInt();
			}catch(Exception e) {
				System.out.println("Número no ingresable.");
				}
			}
			escogido=interf.obtenerMonstruo(lugar);
			
			if(escogido == null) {
				System.out.println("No quedan monsturos disponibles. No se puede escoger");
				System.out.println("Volviendo al menú principal");
				completado3="Pendiente";
			}else {
				System.out.println("Se ha escogido"+escogido.getTipo());
				System.out.println(escogido.toString());
				calculolanzaLapidas(escogido,puntaje3);
				completado3="Completado";
			}
		
		
	}

	public static void calculolanzaLapidas(Monstrous escogido, int puntaje3) {//Furioso
		// TODO Auto-generated method stub
		String tipo=escogido.getTipo();
		boolean act=false;
		double puntaje=0;
		Double pot=null;
		switch(tipo) {
		case "Zombi":
			Zombie e= (Zombie) escogido;
			pot=lanza.miniJuegoZombie(e);
			System.out.println("El zombie tienen un potencial de "+ pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("1)Mordedor.");
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(1,0,"Lanzamiento de Lápidas");
			if(act == true) {
				puntaje3=lanza.HabilidadMonstruo(pot,act,"Zombi");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje3);
			break;
			
		case "Vampiro":
			
			vampiro v= (vampiro) escogido;
			pot=lanza.miniJuegoVampiro(v);
			System.out.println("El vampiro tienen un potencial de "+ pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("1)Mordedor.");
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(1,0,"Lanzamiento de Lápidas");
			if(act == true) {
				puntaje3=lanza.HabilidadMonstruo(pot,act,"Vampiro");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje3);
			break;
			
		case "Momia"://Furioso
			Momia m= (Momia) escogido;
			pot=lanza.miniJuegoMomia(m);
			System.out.println("La momia tienen un potencial de "+pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println();
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(1,0,"Lanzamiento de Lápidas");
			if(act == true) {
				puntaje3=lanza.HabilidadMonstruo(pot,act,"Momia");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje3);
			break;
			
		case "HombreLobo"://Furioso
			hombreLobo h= (hombreLobo) escogido;
			pot=lanza.miniJuego(h);
			System.out.println("El Hombre Lobo tienen un potencial de "+ pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("1)Mordedor.");
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(2,1,"Lanzamiento de Lápidas");
			if(act == true) {
				puntaje3=lanza.HabilidadMonstruo(pot,act,"HombreLobo");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje3);
			break;
		}
		
	}

	public static void cazaCalabaza(String completado2, int puntaje2) {
		//Se procede a presentar las opciones de Caza Calabazas.
		//Primero Se tiene que escoger el monstruo
		int lugar=-1;
		int cantMonstruos=0;
		cantMonstruos=buscarTamañoMo();
		Monstrous escogido=null; 
		System.out.println("Monstruos disponibles: ");
		for (int i = 0; i < cantMonstruos; i++) {
			System.out.print(i+")");
			System.out.println(interf.escogerMonstruos(i));
		}
		//Muerde la mayor  cantidad de calabazas del huerto en 60 seg.
		while(lugar<=-1) {
			try {
				System.out.println("Escoja el Mounstruo para la caza de calabazas.");
				lugar=s.nextInt();
			}catch(Exception e) {
				System.out.println("Número no ingresable.");
				}
			}
			escogido=interf.obtenerMonstruo(lugar);
			
			if(escogido == null) {
				System.out.println("No quedan monsturos disponibles. No se puede escoger");
				System.out.println("Volviendo al menú principal");
				completado2="Pendiente";
			}else {
				System.out.println("Se ha escogido"+escogido.getTipo());
				System.out.println(escogido.toString());
				calculocazaCalabazas(escogido,puntaje2);
				completado2="Completado";
			}
			
		
	}
	//Preguntar si es que se tiene que entregar las habilidades que pueden usar aunque no sea efectivo
	public static void calculocazaCalabazas(Monstrous escogido, double puntaje2) {//Zombi, Vampiro, HombreLobo, son los que tienen la habilidad mordedor
		// Escogido el monstruo, se escoge la fórmula dependinedo del tipo de monstruo escogido.
		String tipo=escogido.getTipo();
		boolean act=false;
		double puntaje=0;
		Double pot=null;
		switch(tipo) {
		case "Zombi":
			Zombie e= (Zombie) escogido;
			pot=cazas.miniJuegoZombie(e);
			System.out.println("El zombie tienen un potencial de "+ pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("1)Mordedor.");
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(2,1,"Caza de Calabazas");
			if(act == true) {
				puntaje2=cazas.HabilidadMonstruo(pot,act,"Zombi");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje2);
			break;
			
		case "Vampiro":
			
			vampiro v= (vampiro) escogido;
			pot=cazas.miniJuegoVampiro(v);
			System.out.println("El vampiro tienen un potencial de "+ pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("1)Mordedor.");
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(2,1,"Caza de Calabazas");
			if(act == true) {
				puntaje2=cazas.HabilidadMonstruo(pot,act,"Vampiro");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje2);
			break;
			
		case "Momia":
			Momia m= (Momia) escogido;
			pot=cazas.miniJuegoMomia(m);
			System.out.println("La momia tienen un potencial de "+pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println();
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(1,0,"Caza de Calabazas");
			if(act == true) {
				puntaje2=cazas.HabilidadMonstruo(pot,act,"Momia");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje2);
			break;
			
		case "HombreLobo":
			hombreLobo h= (hombreLobo) escogido;
			pot=cazas.miniJuego(h);
			System.out.println("El Hombre Lobo tienen un potencial de "+ pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println("1)Mordedor.");
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(2,1,"Caza de Calabazas");
			if(act == true) {
				puntaje2=cazas.HabilidadMonstruo(pot,act,"HombreLobo");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje2);
			break;
		}	
	}

	public static void carreraCementerio(String completado1, int puntaje1) {
		// Una vez llamdo se muestran los monstruos
		int lugar=-1;
		int cantMonstruos=0;
		cantMonstruos=buscarTamañoMo();
		System.out.println(cantMonstruos);
		Monstrous escogido=null; 
		System.out.println("Monstruos disponibles:");
		for (int i = 0; i < cantMonstruos; i++) {
			System.out.print(i+")");
			System.out.println(interf.escogerMonstruos(i));
		}
		while(lugar<=-1) {
		try {
			System.out.println("Escoja el Mounstruo para la carrera en el cementerio:");
			
			lugar=s.nextInt();
		}catch(Exception e) {
			System.out.println("Número no ingresable.");
			}
		}
		escogido=interf.obtenerMonstruo(lugar);
		
		
		if(escogido == null) {
			System.out.println("No quedan monsturos disponibles. No se puede escoger");
			System.out.println("Volviendo al menú principal");
			completado1="Pendiente";
		}else {
			System.out.println("Se ha escogido"+escogido.getTipo());
			System.out.println(escogido.toString());
			calculoCarreraCementerio(escogido,puntaje1);
			completado1="Completado";
		}
		
	}

	public static void calculoCarreraCementerio(Monstrous escogido, double puntaje1) {
		// Dependiendo el tipo de monstruo se escoge
		String tipo=escogido.getTipo();
		boolean act=false;
		double puntaje=0;
		switch(tipo) {
		case "Zombi":
			Zombie e= (Zombie) escogido;
			Double pot=cement.miniJuegoZombie(e);
			System.out.println("El zombie tienen un potencial de "+ pot);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println();
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(1,0,"Carrero Cementerio");
			if(act == true) {
				puntaje1=cement.HabilidadMonstruo(pot,act,"Zombi");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje1);
			break;
			
		case "Vampiro":
			
			vampiro v= (vampiro) escogido;
			Double cam=cement.miniJuegoVampiro(v);
			System.out.println("El vampiro tienen un potencial de "+ cam);
			System.out.println();
			System.out.println("1)Volador.");
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(2,1,"Carrero Cementerio");
			if(act == true) {
				puntaje1=cement.HabilidadMonstruo(cam,act,"Vampiro");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje1);
			break;
			
		case "Momia":
			Momia m= (Momia) escogido;
			Double l=cement.miniJuegoMomia(m);
			System.out.println("La momia tienen un potencial de "+ l);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println();
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(1,0,"Carrero Cementerio");
			if(act == true) {
				puntaje1=cement.HabilidadMonstruo(l,act,"Momia");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje1);
			break;
			
		case "HombreLobo":
			hombreLobo h= (hombreLobo) escogido;
			Double k=cement.miniJuego(h);
			System.out.println("El Hombre Lobo tienen un potencial de "+ k);
			System.out.println("¿Quieres usar una habilidad?");
			System.out.println();
			System.out.println("0)No usar Habilidad.");
			act=ingresarOpcion(1,0,"Carrero Cementerio");
			if(act == true) {
				puntaje=cement.HabilidadMonstruo( k,act,"HombreLobo");
			}
			System.out.println();
			System.out.println(">> Puntaje obtenido: "+puntaje);
			break;
			
		
		
		}
		
	}

	public static boolean ingresarOpcion(int cantValor, int PrimerValor, String string) {
		// metodo para escoger opcion
		int valor=-1;
		String habilidad="";
		if(string.equalsIgnoreCase("Carrero Cementerio")) {
			habilidad="1)Volador";
		}else {
			if(string.equalsIgnoreCase("Caza de Calabazas")) {
				habilidad="1)Mordedor";
			}else {
				if(string.equalsIgnoreCase("Lanzamiento de Lápidas")) {
					habilidad="1)Furioso";
				}else {
					habilidad="1)Regenerable  ";
				}
			}
		}
		while(valor<0) {
		if(cantValor==1) {
			System.out.print(">");
			try {
			valor=s.nextInt();
			while(valor !=PrimerValor || valor !=0) {
				System.out.println("Valor fuera de reango.Intente de nuevo");
				System.out.println("¿Quieres usar una habilidad?");
				System.out.println();
				System.out.println("0)No usar Habilidad.");
				valor=s.nextInt();
			}
			}catch(Exception e) {
				System.out.println("Formato no válido");
				}	
			}else {
				
				System.out.print(">");
				try {
				valor=s.nextInt();
				while(valor !=PrimerValor || valor !=0 ) {
					System.out.println("Valor fuera de reango.Intente de nuevo");
					System.out.println("¿Quieres usar una habilidad?");
					System.out.println();
					System.out.println(habilidad);
					System.out.println("0)No usar Habilidad.");
					valor=s.nextInt();
				}
				}catch(Exception e) {
					System.out.println("Formato no válido");
				}
				
			}
		}
		if(valor==0) {
			System.out.println("Habilidad no activada.  ");
			return false;
			
		}else {
			return true;
			
		}
		
	}

	public static int buscarTamañoMo() {
		// Buscar el tamaño de la lista
		return interf.obtTamañoMons();
	}

	public static void leerArchivoMonstruos(File arch) throws IOException {
		
		if(interf.existeRecorrido(arch)) {
			
			Scanner scanner=null;
			
			try {
				scanner=new Scanner(arch);
			}catch(Exception e) {
				
				System.out.println("Error al leer el archivo");
			}
			while(scanner.hasNextLine()){
				String linea=scanner.nextLine();
				crearMonstruos(linea);
				}
		}else {
			System.out.println("Termino carga");	
			}
			
	}

	public static String menu() {
		// Se empieza en menu de usuario luego de leer los archivos y que exista el archivo monstruo.txt
		String nombreIngresado="";
		System.out.println("=========================================\r\n"
				+ "             SPOOKY SEASON\r\n"
				+ "=========================================");
		
		System.out.println();
		try {
		boolean sigue=false;
		System.out.print("Ingrese su nombre de usuario:");
		nombreIngresado=s.nextLine().trim();   
		while(nombreIngresado.isBlank()) {
			System.out.println("No se pueden ingresar datos vacios ni Datos invalidos.\r\n"
					+ " Ingrese un valor válido");
			nombreIngresado=s.nextLine().trim();
			
			}
		while(!sigue) {
			sigue=corroborarEspacioS(nombreIngresado,sigue);
			if(!sigue) {
				System.out.println("Ingrese nuevo nombre");
				nombreIngresado=s.nextLine().trim();
			}
			
			}
		
		
		}catch(NumberFormatException e) {
			System.out.println("Formato no válido");
		}
		
		nombreisExiste(nombreIngresado);
		jugadorActual=nombreIngresado;
		return nombreIngresado;
	}

	public static void nombreisExiste(String nombreIngresado) {
		// Comparar este nombre, con los ya ingresados
		
		System.out.println(interf.buscarNombre(nombreIngresado));
		
	}

	public static boolean corroborarEspacioS(String nombreIngresado, boolean sigue) {
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

	public static void leerArchivosRegistro(File archivo ) throws IOException {
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
					}
			System.out.println("Lord");
		}else {
			System.out.println("Archivo no existe, se creará al guardar las nuevas puntaciones.");
			archivo.createNewFile();//Se crea el archivo si no existe
			//FileWriter write =new FileWriter("Registros.txt");, guardar para sobreescribir
		}
	}

	public static void crearMonstruos(String Linea) {
		
		System.out.println(interf.leerMonstruo(Linea));
	}
	

	public static void crearRegistro(String linea) {
		System.out.println(interf.leerRegistro(linea));
		
		
	}

}
