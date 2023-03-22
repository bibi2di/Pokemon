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
	
	public Boolean realizarAtaques(Pokemon pPokemonAtaka , Pokemon pPokemonAtacado){
		
		return true;
	
	}
	
	public void jugarUnaPartida() {
		
		// emplea jugador.haperdido() booblean
		
	}
}
