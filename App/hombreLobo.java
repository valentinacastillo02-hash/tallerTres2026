public class hombreLobo extends monstruoExistente{
	private int Ferocidad;
	private int faceLunar;
	public hombreLobo(String tipomonstruos, int vidam, int velocidadm, int fuerzam, int resistenciam, int ferocidad,
			int faceLunar) {
		super(tipomonstruos, vidam, velocidadm, fuerzam, resistenciam);
		Ferocidad = ferocidad;
		this.faceLunar = faceLunar;
	}
	
	

}