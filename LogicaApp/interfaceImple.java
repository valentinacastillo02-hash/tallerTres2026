package App;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Dominio.Jugador;
import Dominio.Momia;
import Dominio.Monstrous;
import Dominio.Zombie;
import Dominio.hombreLobo;
import Dominio.vampiro;


public class interfaceImple implements contratoPrincipal{
	
static LinkedList listaPuntajeSesión=new LinkedList<>();
static List <Monstrous>listaMonstruos=new ArrayList<>();//Secrea la lista de Monstruos.
static List <Jugador>listaJugador=new ArrayList<>();//Se crea lista donde irán  los jugadores y sus puntajes historicos
static List <Monstrous>listaMonsEscogido=new ArrayList<>();//
static List <Jugador>listaJugadorOriginal=new ArrayList<>();
	@Override
	public void Ejecutar() {
		// TODO Auto-generated method stub
		System.out.println("Creando elementos --- Espere");
	}

	
	public void crearZombie(int vida, int velocidad, int fuerza, int resistencia, int fuerzaMordida) {
		Zombie zombie=new Zombie("Zombi",vida,velocidad,fuerza,resistencia,fuerzaMordida);
		zombie.toString();
		listaMonstruos.add(zombie);
		
	}

	
	public void crearVampiro(int vida, int velocidad, int fuerza, int resistencia, int velocidadDeVuelo,
			int resistenciaAlSol) {
		// crear y gruardar en lista clase vampiro
		vampiro Vampiro=new vampiro("Vampiro",vida,velocidad,fuerza,resistencia,velocidadDeVuelo,resistenciaAlSol);
		Vampiro.toString();
		listaMonstruos.add(Vampiro);
	}

	
	public void crearMomia(int vida, int velocidad, int fuerza, int resistencia, int longitudVendajes) {
		Momia momia=new Momia("Momia",vida,velocidad,fuerza,resistencia,longitudVendajes);
		momia.toString();
		listaMonstruos.add(momia);
	}

	
	public void crearHombreLobo(int vida, int velocidad, int fuerza, int resistencia, int ferocidad, float faseLunar) {
		// Se crea hombre lobo
		hombreLobo HombreLobo = new hombreLobo("HombreLobo",vida,velocidad,fuerza,resistencia,ferocidad,faseLunar);
		HombreLobo.toString();
		listaMonstruos.add(HombreLobo);
	}

	
	public boolean DatoValido(int vida, int velocidad, int fuerza, int resistencia) {
		// Validan que los datos 
		if(vida<201 && 0<vida && (0<velocidad && velocidad<101 && 0<fuerza && fuerza<101 && 0<resistencia && resistencia<101)) {
			//1 – 200
			return true;
		}
		return false;
	}
	public boolean DatoValidoZombie(int fuerzaMordida) {
		if(0<fuerzaMordida && fuerzaMordida>100) {
			return true;
		}
		
		return false;
	}
	public boolean datovalidoVampiro(int velocidadDeVuelo, int resistenciaAlSol) {
		if((0<velocidadDeVuelo && velocidadDeVuelo< 101)) {
			if(resistenciaValido(resistenciaAlSol)) {
				return true;
			}
			
		}
		return false;
	}

	
	public boolean resistenciaValido(int resistenciaAlSol) {
		// TODO Auto-generated method stub
		if(0<resistenciaAlSol && resistenciaAlSol<101) {
			return true;
		}
		return false;
	}


	public void crearJugador(String nombre, int puntaje) {
		//Se crea a la instancia de jugadoe y se agrega a la lista
		Jugador jug=new Jugador(nombre,puntaje);
		jug.toString();
		listaJugador.add(jug);
		listaJugadorOriginal.add(jug);
		
	}

	@Override
	public boolean existeRecorrido(File string) {
		// Se verifica que el archivo ta ni este vacio
		if (string.length() != 0  && string.exists()) {
			System.out.println("Se puede leer existe");
			return true;
		}
		return false;
	}

	@Override
	public String leerRegistro(String linea) {
		String Partes[]=linea.split(";");
		String Jugador="";
		if(Partes.length == 2) {
		if(!Partes[0].isEmpty()) {
		Jugador=Partes[0];
		
		if(!Partes[1].isEmpty()) {
		int puntHistorico=0;
		try {
		puntHistorico=Integer.parseInt(Partes[1]);
		}catch(NumberFormatException e) {
			return "Formato no válido";
		}
		crearJugador(Jugador,puntHistorico );
		return "Jugador ingresado";
		}else {
			return "El dato de puntaje no es válido";
			}
		}else {
			return "El nombre no puede estar en blanco, dato inválido";
			}
		}else {
			return "Cantidad de datos no válidos";
		}
		
	}

	


	public boolean datoValidoHombreLobo(int ferocidad, float faseLunar) {
		// Corrroborar que los datos sean válidos  
		//Ferocidad =1-100;
		//FaseLunar = 1-4 
		
		if(0<ferocidad && ferocidad <101) {
			if(0<faseLunar && faseLunar<5) {
				return true;
			}
			
		}
		return false;
	}


	public boolean datoValidoMomia(int longitudVendajes) {
		// TODO Auto-generated method stub
		if(0<longitudVendajes && longitudVendajes<301) {
			return true;
		}
		return false;
	}


	@Override
	public boolean corroborarEspacioS(String nombreIngresado) {
		// Una vez que sabemos que el nombre no está en blanco,
		//Se corrobora que no hay espacios entre ellos:
		
		String[] Partes=nombreIngresado.split(" ",-1);
		if(Partes.length >=2) {
				return false;
				
			}else {
				Partes=nombreIngresado.split(";",-1);
				if(Partes.length >=2) {
					return false;
					
				}
			}
		return true;
		}


	@Override
	public String buscarNombre(String nombreIngresado) {
		// Primero buscar si el nombre existe:
		for (int i = 0; i < listaJugador.size(); i++) {
			if(listaJugador.get(i).getNombre().equalsIgnoreCase(nombreIngresado)) {
				return "El jugador ya está ingresado."
						+ "El jugador se llama: "+nombreIngresado+"\r\n "
						+ "El puntaje máximo que tuvo fue: " + listaJugador.get(i).getPuntajeHistorico();
			}
			
		}
		//El nombre no se encuentra ingresado.Guardarlo en la lista
		Jugador jug=new Jugador(nombreIngresado,0);
		listaJugador.add(jug);
		return "El jugador no había estado ingresado. Se guarda en el registro";
		
		
	}


	@Override
	public String escogerMonstruos( int lugar) {
		// Se muestran los monstruos que están disponibles.
		Monstrous esco=null;
		listaMonsEscogido.add(listaMonstruos.get(lugar));
		listaMonstruos.get(lugar).setDispo(false);
		esco=listaMonsEscogido.get(lugar);
		
		return esco.toString();
	}


	@Override
	public int obtTamañoMons() {
		// Obtenerel tamaño para conf el recorrido 
		
		return listaMonstruos.size();
	}


	@Override
	public Monstrous obtenerMonstruo(int lugar) {
		// Se retorna desde la lista al que se ha seleccionada.
		if(listaMonstruos.size() == 0) {
			return null;
		}
		return listaMonstruos.get(lugar);
	}


	public String leerMonstruo(String linea) {
		// Se separan los atributos en partes
		String tipoMonstuo="";
		int Vida=0;
		int Velocidad=0;
		int Fuerza=0;
		int Resistencia=0;
		boolean sigue=false;
		String Partes[]=linea.split(";");
		if(Partes.length<5) {
			return "No hay la cantidad mínima de atributos para ser "
					+ "considerado un monstruo";
		}else {
			try {
			tipoMonstuo=Partes[0];
			Vida=Integer.parseInt(Partes[1]);
			Velocidad=Integer.parseInt(Partes[2]);
			Fuerza=Integer.parseInt(Partes[3]);
			Resistencia=Integer.parseInt(Partes[4]);
			sigue=DatoValido(Vida, Velocidad, Fuerza, Resistencia);
			}catch(NumberFormatException e) {
				System.out.println("Error en el formato");
			}
			if(sigue) {
			//Tipo;Vida;Velocidad;Fuerza;Resistencia;
				if(Partes.length == 7 || Partes.length==6) {
				switch(tipoMonstuo) {
				case "Vampiro":
					//VelocidadDeVuelo;ResistenciaAlSol
					int VelocidadDeVuelo=Integer.parseInt(Partes[5]);
					int ResistenciaAlSol=Integer.parseInt(Partes[6]);
					sigue=datovalidoVampiro(VelocidadDeVuelo,ResistenciaAlSol);
					if(sigue) {
					crearVampiro(Vida,Velocidad,Fuerza,Resistencia,VelocidadDeVuelo,ResistenciaAlSol);
					}else {
						return "Problema con los datos ingresados.";
					}
					break;
				
				case "Zombi":
					int fuerzaMordida=Integer.parseInt(Partes[5]);
					sigue=DatoValidoZombie(fuerzaMordida);
					if(sigue) {
						crearZombie(Vida,Velocidad,Fuerza,Resistencia,fuerzaMordida);
					}else {
						return "Valores no válidos para crear un zombie";
					}
					
					break;
				
				case "Momia":
					int LongitudVendajes=Integer.parseInt(Partes[5]);
					sigue=datoValidoMomia(LongitudVendajes);
					if(sigue) {
					crearMomia(Vida,Velocidad,Fuerza,Resistencia,LongitudVendajes);
					}else {
						return "Problema con los datos ingresados.";
					}
					break;
					
				case "HombreLobo":
					int Ferocidad=Integer.parseInt(Partes[5]);;
					float FaseLunar=Float.parseFloat(Partes[6]);
					sigue=datoValidoHombreLobo(Ferocidad,FaseLunar);
					if(sigue) {
					crearHombreLobo(Vida,Velocidad,Fuerza,Resistencia,Ferocidad,FaseLunar);
					}else {
						return "Los datos ingresados no están dentro del rango permitido";
					}
					//Ferocidad;FaseLunar:
					//Crear mounstruo
					break;
					
				default:
					return "Tipo de mounstruo no válido";
						}
					
					}
				
				return "Mounstruo cargado";
				
				}
				return "Ya no quedan más registros";
			}
		}


	public int largoUsa() {
		// TODO Auto-generated method stub
		return listaMonsEscogido.size();
	}


	public String mostrarListaTotal(int i) {
		// se puestra la lista de monstruo.
		return listaMonstruos.get(i).toString();
		
	}


	public String mostrarListaUsados(int i) {
		// Se muestran los monstruos ya convocados,
		return listaMonsEscogido.get(i).toString();
		
	}


	public void ordenarRegistros() {
		// Se van ordenandop lkos registros de maypor a menois
		for (int i = 0; i < listaJugador.size(); i++) {
			for (int j = i; j < listaJugador.size(); j++) {
				if(listaJugador.get(i).getPuntajeHistorico()<listaJugador.get(j).getPuntajeHistorico()) {
					
					Jugador aux=listaJugador.get(i);
					listaJugador.set(i,listaJugador.get(j));
					listaJugador.set(j,aux);
				}
			}
		}
		
	}


	public int cantJugadores() {
		// Regresar la cantidad de jugadores:
		return listaJugador.size();
	}


	public String imprimJugadores(int i) {
		// TODO Auto-generated method stub
		return listaJugador.get(i).toString();
	}


	public String guardarPartidajugNuevo(BufferedWriter escritor) {
		// Se revisa si es que el jugador ya existía o no primero.
		for (int i = 0; i < listaJugador.size(); i++) {
			String dato=""+listaJugador.get(i).getNombre()+";"+listaJugador.get(i).getPuntajeHistorico();
			try {
				escritor.write(dato);
				escritor.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Error al momento de sobrescribir";
			}
		}
		
			
		
		return "Se guardo la partida";
	}


	public boolean esNuevo(String jugadorActual) {
		//  Se recorre la lista. Si no posee puntaje, se devuelve true
		for (int i = 0; i < listaJugador.size(); i++) {
			if(listaJugador.get(i).getNombre().equalsIgnoreCase(jugadorActual)) {
				if(listaJugador.get(i).getPuntajeHistorico() ==0) {
					return true;
				}
			}
				
			}
		return false;
	}


	public boolean mismaPuntuacion(String jugadorActual, int puntuacionMax) {
		// Se busca si es que el nombre esta con la misma puntación que habia
		for (int i = 0; i < listaJugador.size(); i++) {
			for (int j = i; j < listaJugadorOriginal.size(); j++) {
				if(listaJugador.get(i).getNombre().equalsIgnoreCase(listaJugadorOriginal.get(j).getNombre())) {
					if(listaJugador.get(i).getPuntajeHistorico()< listaJugadorOriginal.get(j).getPuntajeHistorico()) {
						listaJugador.get(i).setPuntajeHistorico( listaJugadorOriginal.get(j).getPuntajeHistorico());
						return true;
					}
					
				}
			}
		}
		return false;
	}

	}



