package Modelo;

public class Bot extends Jugador {

	private boolean turno;
	
	public Bot(int pNumPoke, int id) {
		super(pNumPoke,id);
		turno = this.getTurno();

	}
	
	@SuppressWarnings("deprecation")
	public void setTurno(boolean pTurno, int longitud) {
		this.turno = pTurno;

		setChanged();
		notifyObservers(new Object[] {pTurno}); 
		//poner en verde
		
		//System.out.println("Ha cambiado el turno a" + pTurno);
		if (this.turno) {
			ataquedeBot(longitud);
			
			// atacarBot elige atacante aleatorio que no sea this
			ListaJugadores.getListaJugadores().asignarTurnoAleatoriamente();

		}
	

	
	}
	
	private void ataquedeBot(int longitud){
		{
			for(int i=1;i<=this.tamainoLista();i++) {
				Pokemon pokAtaque= this.getPokemon(i);
				/*int numJug = ListaJugadores.getListaJugadores().tamainoLista();
				int jugadorAtac = (int)(Math.random()*(numJug));*/
				int jugadorAtacado = (int)(Math.random()*(longitud)); // aki tendríamos que hacer una adjudicación con random && !bot
				int numPok = this.tamainoLista();
				int pokAtacado = (int)(Math.random()*(numPok));
				pokAtacado++;
				if (jugadorAtacado != this.getId()) { // esto desaparece cuando se adjudique el nº random de nobot
					Pokemon pokDefensa = ListaJugadores.getListaJugadores().buscarJugador(jugadorAtacado).getPokemon(pokAtacado);
					if (!pokAtaque.haAtacado() && !pokAtaque.seHaDebilitado() && !pokDefensa.seHaDebilitado()) {
						pokAtaque.haAtacadoYa(true);
						CampoDeBatalla.getCampoBatalla().realizarAtaques(pokAtaque, pokDefensa);
						if (pokAtaque.estaEuforico()) { /*aqui gestiona el bot la euforia*/
							pokAtaque.cambiarEstado(new EstadoNormal());
							pokDefensa.quitarEstadoEuforia(pokAtaque);
							pokAtaque.setAquesEuforiaAcumulados(0);
						}
						CampoDeBatalla.getCampoBatalla().eliminarBatalla();
					}
				}
			}
		}
	}

	
}