package Dominio;

public class Jugador {
	private String Nombre;
	private  int PuntajeHistorico;
	public Jugador(String nombre, int puntajeHistorico) {
		this.Nombre = nombre;
		this.PuntajeHistorico = puntajeHistorico;
	}
	@Override
	public String toString() {
		return "Jugador [Nombre=" + Nombre + ", PuntajeHistorico=" + PuntajeHistorico + "]";
	}
	public String getNombre() {
		return Nombre;
	}
	public int getPuntajeHistorico() {
		return PuntajeHistorico;
	}
	
	
}
