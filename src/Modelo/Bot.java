package Modelo;

import java.util.Collection;

public class Bot extends Jugador {

	public Bot(int pNumPoke, int id) {
		super(pNumPoke,id);

	}
	
	public void setTurno(boolean pTurno) {
		this.turno = pTurno;

		System.out.println("Ha cambiado el turno a" + pTurno);

		
		setChanged();
		notifyObservers(new Object[] {pTurno});

		// atacarBot elige atacante aleatorio que no sea this
	
	}
	
	private void atacarBot(){
		{
			for(int i=1;i<=ListaJugadores.getListaJugadores().buscarJugador(id).tamainoLista();i++) {
				batalla[0]=ListaJugadores.getListaJugadores().buscarJugador(id).getPokemon(i);
				/*int numJug = ListaJugadores.getListaJugadores().tamainoLista();
				int jugadorAtac = (int)(Math.random()*(numJug));*/
				int jugadorAtacado = 0; // aki tendríamos que hacer una adjudicación con random && !bot
				int numPok = ListaJugadores.getListaJugadores().buscarJugador(jugadorAtacado).tamainoLista();
				int pokAtacado = (int)(Math.random()*(numPok));
				if (jugadorAtacado != id) { // esto desaparece cuando se adjudique el nº random de nobot
					batalla[1] = ListaJugadores.getListaJugadores().buscarJugador(jugadorAtacado).getPokemon(pokAtacado);
					if (!batalla[0].haAtacado() && !batalla[0].seHaDebilitado() && !batalla[1].seHaDebilitado()) {
						realizarAtaques(batalla[0], batalla[1]);
						batalla[0].haAtacadoYa(true);
						batalla = new Pokemon[2];
					}
				}
			}
		}
	}

	
}