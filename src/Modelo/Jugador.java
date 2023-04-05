package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")

public class Jugador extends Observable {
	
	private int id; /*Si no se pueden meter en visibilidad protected se mete como privado y getter protected*/
	private ArrayList<Pokemon> lPokemon; /*Si no se pueden meter en visibilidad protected se mete como privado y getter protected*/
	private boolean turno; /*Si no se pueden meter en visibilidad protected se mete como privado y getter protected*/
	private boolean bot;

	/**
	 * 
	 * @param pNumPoke
	 */
	
	public Jugador(int pNumPoke, int pId) {
		lPokemon = new ArrayList<>();
		id = pId;
		turno = false;
		bot = this instanceof Bot;
		for (int i=0;i<pNumPoke;i++) {
			Pokemon pokeAct = this.createPokemon(i);
			lPokemon.add(pokeAct);
			//System.out.println("el pokemon tiene "+ pokeAct.getAtaque()+ " de ataque");
		}
		
	}

	protected boolean getTurno() {
		return this.turno;
	}
	
	private Iterator<Pokemon> getIterador() {
		return lPokemon.iterator();
	}
	
	/*public ArrayList<Integer> getAtaques()
	{
		ArrayList<Integer> ataques = new ArrayList<>();
		while (this.getIterador().hasNext()) {
			ataques.add(this.getIterador().next().getAtaque());
		}
		return ataques;
	}*/
	
	public boolean tieneElMismoId(int pId) {
		return pId==this.id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setTurno(boolean pTurno) {
		this.turno = pTurno;
		setChanged();
		notifyObservers(new Object[] {pTurno});
		System.out.println("Ha cambiado el turno a" + pTurno);
	}
	
	
	
	/**
	 * 
	 * @param int numPoke,Pokemon pokJuega
	 */
	
	public boolean esSuTurno() {
		return this.turno;	
		
	}
	
	/*public boolean realizarAtaque(int numPoke,Pokemon pokJuega) { 
		Pokemon atacante = lPokemon.get(numPoke);
		boolean haRealizadoAtaque = false;
		if(atacante != null && !haRealizadoAtaque && turno) {
			 haRealizadoAtaque = CampoDeBatalla.getCampoBatalla().realizarAtaques(atacante, pokJuega); 
		}
		return haRealizadoAtaque;
	}*/
	
	/*REALIZAR ATAQUES*/

	/**
	 * 
	 * @param tipo
	 */
	private Pokemon createPokemon(int i) {
		Pokemon p = PokemonFactory.getPokemonFactory().create(i);
		return p;
	}
	
	public boolean haPerdido() {
		boolean haPerdido = lPokemon.stream().allMatch(p -> p.seHaDebilitado());
		setChanged();
		notifyObservers(new boolean[] {haPerdido});
		return haPerdido;
	}
	
	public Pokemon getPokemon(int numPok) {
		/*int i = 0;
		Pokemon poke = null;
		
		while (i != numPok) {
			poke = this.getIterador().next();
		}*/
		Pokemon poke = null;
		poke = lPokemon.get(numPok-1);
		
		return poke;
	}
	
	public boolean esBot() {
		return this.bot;
	}
	
	public void resetearPokemon() {
		for(Pokemon p: lPokemon) {
			p.haAtacadoYa(false);
		}
	}
	
	public boolean hanAtacadoTodos() {
		//this.eliminarPokemon();
		//boolean hanAtacadoTodos = lPokemon.stream().allMatch(p->p.haAtacado());
		boolean hanAtacadoTodos = lPokemon.stream().filter(p->!p.seHaDebilitado()).allMatch(p->p.haAtacado());
		return hanAtacadoTodos;
	}
	
	public boolean terminarTurno() {
	 return ((esSuTurno() && hanAtacadoTodos()));
	}
	
	public void eliminarPokemon() {
		ArrayList<Pokemon> lpDebilitados = (ArrayList<Pokemon>) lPokemon.stream().filter(p->p.seHaDebilitado()).collect(Collectors.toList());
		if (lpDebilitados.size()>=1) {
			for (int i=0;i<lpDebilitados.size();i++) {
				lPokemon.remove(lpDebilitados.get(i));
			}
			
		}
	}
	public int tamainoLista () {
		return lPokemon.size();
	}

}