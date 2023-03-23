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
	
	public boolean realizarAtaques(Pokemon pPokemonAtaca, Pokemon pPokemonAtacado){
		boolean haRealizadoAtaque = false;
		if (!pPokemonAtaca.seHaDebilitado() && !pPokemonAtacado.seHaDebilitado()) {
			pPokemonAtaca.atacar(pPokemonAtacado);
			haRealizadoAtaque = true;
		}
		return haRealizadoAtaque;
	}
	
	public void pasarTurno() {
		
	}
	
}
