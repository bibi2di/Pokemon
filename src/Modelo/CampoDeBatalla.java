package Modelo;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class CampoDeBatalla extends Observable{
	
	private static CampoDeBatalla miCampoDeBatalla;
	private Pokemon[] batalla;
	private int jugadorAtacante;
	//private int jugadorAtacado;
	
	private CampoDeBatalla() {
		batalla = new Pokemon[2];
	}
	
	public static CampoDeBatalla getCampoBatalla() {
		if (miCampoDeBatalla==null) {
			miCampoDeBatalla = new CampoDeBatalla();
		}
		return miCampoDeBatalla;
	}
	
	public Pokemon[] getBatalla() {
		return this.batalla;
	}
	
	public boolean sePuedeAtacar(int nPok, int nJug) {
		Pokemon pPok = ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(nPok);
		boolean sePuedeAtacar = false;
		
		//primero metemos el jugador atacante y su pokemon en batalla[0] 
		if(ListaJugadores.getListaJugadores().buscarJugador(nJug).esSuTurno() && batalla[0]==null) {
			batalla[0]=pPok; //se introduce 
			jugadorAtacante = nJug;
		//metemos el jugador atacado y su pokemon en batalla[1]
		}else if (!ListaJugadores.getListaJugadores().buscarJugador(nJug).esSuTurno() && batalla[1] == null){
			batalla[1]=pPok;
		}	
		if(batalla[0]!=null && batalla[1]!=null) {
				//si ambos pokemons son aptos, entra
				if (!batalla[0].haAtacado() && !batalla[0].seHaDebilitado() && !batalla[1].seHaDebilitado()) {
					//si el pokemon atacante no ha atacado y ninguno esta debilitado -> ataca
					realizarAtaques(batalla[0], batalla[1]);
					eliminarBatalla();
					sePuedeAtacar=true;
				}
				else 
				{
					//si el pokemon ha atacado con anterioridad, reestablece los valores
					eliminarBatalla();
				}
			}
		this.terminarTurno(jugadorAtacante);
		
		setChanged();
		notifyObservers();
		
		return sePuedeAtacar;
		
	}
	
	public boolean realizarAtaques(Pokemon pPokemonAtaca, Pokemon pPokemonAtacado){
		boolean haRealizadoAtaque = false;
		if (!pPokemonAtaca.seHaDebilitado() && !pPokemonAtacado.seHaDebilitado()) {
			pPokemonAtacado.recibirAtaque(pPokemonAtaca);
			haRealizadoAtaque = true;
			if (pPokemonAtaca.estaEuforico()) { 				
				pPokemonAtacado.quitarEstadoEuforia(pPokemonAtaca);
			}
		}
		setChanged();
		notifyObservers();
		return haRealizadoAtaque;
	}
	
	//Esto hay que gestionarlo desde Jugador con el Observer
	public void terminarTurno(int pJug) {
		if (ListaJugadores.getListaJugadores().buscarJugador(pJug).terminarTurno())
			ListaJugadores.getListaJugadores().terminarTurno();
	}
	
	public void eliminarBatalla() {
		batalla = new Pokemon[2];
	}
	
	
	
}
