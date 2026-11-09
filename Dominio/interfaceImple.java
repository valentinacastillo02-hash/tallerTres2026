package Dominio;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class interfaceImple implements contratoPrincipal{
static List <Monstrous>listaMonstruos=new ArrayList<>();//Secrea la lista de Monstruos.
static List <Jugador>listaJugador=new ArrayList<>();//Se crea lista donde irán  los jugadores y sus puntajes historicos
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

	
	public void crearHombreLobo(int vida, int velocidad, int fuerza, int resistencia, int ferocidad, int faseLunar) {
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
		
	}

	@Override
	public boolean existeRecorrido(File string) {
		// Se verifica que el archivo ta ni este vacio
		if (string.length() != 0  && string.exists()) {
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

	@Override
	public String crearMonstruo(String linea) {
		//Tipo;Vida;Velocidad;Fuerza;Resistencia
		
		String Partes[]=linea.split(";");
		String tipoMonstuo=Partes[0];
		int Vida=Integer.parseInt(Partes[1]);
		int Velocidad=Integer.parseInt(Partes[2]);
		int Fuerza=Integer.parseInt(Partes[3]);
		int Resistencia=Integer.parseInt(Partes[4]);
		boolean sigue=DatoValido(Vida, Velocidad, Fuerza, Resistencia);
		
		if(sigue) {
		
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
			int FaseLunar=Integer.parseInt(Partes[6]);
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


	public boolean datoValidoHombreLobo(int ferocidad, int faseLunar) {
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
				return "El jugador ya está ingresado.El jugador se llama: "+nombreIngresado+" y el puntaje máximo que tuvo fue: " + listaJugador.get(i).getPuntajeHistorico();
			}
			
		}
		//El nombre no se encuentra ingresado.Guardarlo en la lista
		Jugador jug=new Jugador(nombreIngresado,0);
		listaJugador.add(jug);
		return "El jugador no había estado ingresado. Se guarda en el registro";
		
		
	}
		
		
	


	

}
