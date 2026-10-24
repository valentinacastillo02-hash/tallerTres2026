
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Interface.Iiinterface;
import Interface.interfaceImplementado;
import Interface.visitorInterface;
import Interface.visitorInterfaceImpl;
import Sistema.monstruoExistente;

public class Main{
	Scanner scan=new Scanner(System.in);
	static visitorInterfaceImpl visitor= new visitorInterfaceImpl();
	static interfaceImplementado in=new interfaceImplementado();
    public static void main(String[] args) {
    	leerArchivos("Monstruos.txt");
        

    }
	public static void leerArchivos(String string) {
		if(string.equalsIgnoreCase("Monstruos.txt")) {
			File file=new File(string);
			Scanner scanner=null;
			
			try {
				scanner=new Scanner(file);
			}catch(IOException e) {
				System.out.println("Archivo no encontrado");
				
			}
			
			while(scanner.hasNextLine()) {
				String linea=scanner.nextLine();
				String[] Partes=linea.split(";");
				String tipoMonstruo=Partes[0];
				int vida=Integer.parseInt(Partes[1]);
				int velocidad=Integer.parseInt(Partes[2]);
				int fuerza=Integer.parseInt(Partes[3]);
				int resistencia=Integer.parseInt(Partes[4]);
				switch(tipoMonstruo) {
				case "Zombi":
					clasificarZombie(tipoMonstruo,vida,velocidad,fuerza,resistencia,Partes);
					break;
				case "Vampiro":
					clasificarVampiro(tipoMonstruo,vida,velocidad,fuerza,resistencia,Partes);
					break;
				case "Momia":
					clasificarMomia(tipoMonstruo,vida,velocidad,fuerza,resistencia,Partes);
					break;
				case "HombreLobo":
					clasificarHombreLobo(tipoMonstruo,vida,velocidad,fuerza,resistencia,Partes);
					break;
						}		
					}
				}
	}
			
			
		public static void clasificarHombreLobo(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			String[] partes) {
			int Ferocidad=Integer.parseInt(partes[5]);
			int faceLunar=Integer.parseInt(partes[6]);
			crearHombreLobo(tipoMonstruo,vida,velocidad,fuerza,resistencia,Ferocidad,faceLunar);
		
	}
		public static void crearHombreLobo(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
				int ferocidad, int faceLunar) {
			in.crearHomberLobo(tipoMonstruo,vida,velocidad,fuerza,resistencia,ferocidad,faceLunar);
			
		}
		public static void clasificarMomia(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			String[] partes) {
			int longitudVendaje=Integer.parseInt(partes[5]);
			crearMomia(tipoMonstruo,vida,velocidad,fuerza,resistencia,longitudVendaje);
		
	}

		
		
	public static void clasificarVampiro(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			String[] partes) {
		int velocidadVuelo =Integer.parseInt(partes[5]);
		int resistenciaSol=Integer.parseInt(partes[6]);
		crearVampiro(tipoMonstruo,vida,velocidad,fuerza,resistencia,velocidadVuelo,resistenciaSol);
		
		
	}

	
	public static void clasificarZombie(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia, String[] partes) {
		int fuerzaMordida=Integer.parseInt(partes[5]);
		crearInstancia(tipoMonstruo,vida,velocidad,fuerza,resistencia,fuerzaMordida);
		
		
	}
	public static void crearMomia(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int longitudVendaje) {
		in.crearMomia(tipoMonstruo,vida,velocidad,fuerza,resistencia,longitudVendaje);
	}
	public static void crearVampiro(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int velocidadVuelo, int resistenciaSol) {
		in.crearVampiro(tipoMonstruo,vida,velocidad,fuerza,resistencia,velocidadVuelo,resistenciaSol);
		
	}
	public  static void crearInstancia(String tipoMonstruo, int vida, int velocidad, int fuerza, int resistencia,
			int fuerzaMordida) {
		if(tipoMonstruo.equalsIgnoreCase("Zombi")) {
		
		in.crearZombie(tipoMonstruo ,vida ,velocidad,fuerza, resistencia,
				fuerzaMordida);
		}
		
	}
	
}
