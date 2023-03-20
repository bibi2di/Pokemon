package Modelo;

public class CampoDeBatalla {
	private static CampoDeBatalla miCampoDeBatalla;

	private CampoDeBatalla() {
		
	}
	
	public static CampoDeBatalla getCampoBatalla() {
		if (miCampoDeBatalla==null) {
			miCampoDeBatalla = new CampoDeBatalla();
		}
		return miCampoDeBatalla;
	}
	
	public void realizarAtaques() {
		
	}
	
	public void jugarUnaPartida() {
		
	}
}
