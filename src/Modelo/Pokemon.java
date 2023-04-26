package Modelo;

import java.util.Observable;

@SuppressWarnings("deprecation")
public abstract class Pokemon extends Observable {

	private int id;
	private int ataque;
	private int defensa;
	private int vida;
	private int vidaIni;
	private String tipo;
	private boolean yaHaAtacado;
	private int euforia = /*(int) (Math.random()*5+3)*/3; 
	private int ataquesEuforiaAcumulados;
	private Evolucion stateEvo;
	private Estado stateEuforia;
	private boolean haAtacadoEuforico;
	/**
	 * 
	 * @param pTipo
	 */
	protected Pokemon(int pId) {
		// TODO - implement Pokemon.Pokemon
		ataque = 0;
		defensa = 0;
		vida = 0;
		tipo = "Nada";
		vidaIni =0;
		//establecerValores();
		this.id = pId;
		
	}
	
	public void setAquesEuforiaAcumulados(int pAtaque) {
		ataquesEuforiaAcumulados = pAtaque;
	}
	
	public void setHaAtacadoEuforico(boolean pHaAtacadoEuforico) {
		this.haAtacadoEuforico = pHaAtacadoEuforico;
	}
	
	public void establecerValores() {
		ataque = 11 + (int)(Math.random()*7+1); //11 + número aleatorio entre 1-7
		defensa = 3 + (int)(Math.random()*4+1); //11 + número aleatorio entre 1-4
		vida = 200 + (int)(Math.random()*20+1); //200 + número aleatorio entre 1-20
		vidaIni = vida;
		yaHaAtacado = false;
		if (this instanceof Planta) {
			tipo = "Planta";
		}
		else if (this instanceof Fuego) {
			tipo = "Fuego";
		}
		else if (this instanceof Agua) {
			tipo = "Agua";
		}
		else if(this instanceof Electrico) {
			tipo = "Electrico";
		}
		stateEvo = null;
		stateEuforia = null;
		setChanged();
		notifyObservers(new Object [] {this.vida,this.defensa,this.ataque,this.tipo, this.vidaIni});
		//System.out.println("Se han inicializado valores");
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getAtaque() {
		return this.ataque;
	}
	
	public int getVidaIni() {
		return this.vidaIni;
	}
	
	public int getDefensa() {
		return this.defensa;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void setAtaque(int pAtaque) {
		this.ataque = pAtaque;
	}
	
	public void setDefensa (int pDefensa) {
		this.defensa = pDefensa;
	}
	
	public boolean estaEuforico() { 
		setChanged();
		notifyObservers(new boolean[] {this.stateEuforia instanceof EstadoEuforia});
		return this.stateEuforia instanceof EstadoEuforia;
	}
	

	/**
	 * 
	 * @param pTipo
	 */
	public void recibirAtaque(Pokemon pPokemon) {
		this.ataquesEuforiaAcumulados++;
		double multiplicador = 1;
		if(pPokemon.recibeAtaqueEfectivo(this.tipo)) {
			multiplicador = 2;
		}
		else if(pPokemon.recibeAtaquePocoEfectivo(this.tipo)) {
			multiplicador = 0.5;
		}
		this.vida = (int)(this.vida -(pPokemon.ataque*multiplicador) - this.defensa);
		if (pPokemon.stateEuforia instanceof EstadoEuforia) {
			pPokemon.setHaAtacadoEuforico(true);
		}		
		
		double vidaRestante = (double)this.vida/this.vidaIni;
		if (vidaRestante <=0.5 && (!(stateEvo instanceof Evolucion1)) && (!(stateEvo instanceof Evolucion2))) {
			this.cambiarEvolucion(new Evolucion1());
			this.evolucionar();
		}
		if (vidaRestante <=0.2 && (!(stateEvo instanceof Evolucion2))) {
			this.cambiarEvolucion(new Evolucion2());
			this.evolucionar();
		}
		
		boolean euforico = (this.stateEuforia instanceof EstadoEuforia);
		if (!euforico) {
			this.estadoEuforia();
		}
		
		if(pPokemon.haAtacadoEuforico) {
			this.cambiarEstado(new EstadoNormal());
			this.quitarEstadoEuforia(pPokemon);
		}
		
		if (this.vida<0) {
			this.vida = 0;
		}
		
		if (this.ataquesEuforiaAcumulados>this.euforia) {
			this.ataquesEuforiaAcumulados = this.euforia;
		}
		System.out.println("Id del pokemon atacante: "+ pPokemon.id);
		System.out.println("Ataque del pokemon atacante: " + pPokemon.ataque);
		System.out.println("Defensa del pokemon atacante: " + pPokemon.defensa);
		
		setChanged();
		notifyObservers(new int [] {this.vida,this.defensa,this.ataque,this.euforia,this.ataquesEuforiaAcumulados});
	}

	public boolean seHaDebilitado() {
		boolean debilitado = false;
		if (vida == 0)
			debilitado = true;
		return debilitado;
		/*setChanged();
		notifyObservers(new Object[] {debilitado});*/
	}
	
	public void evolucionar() {
		stateEvo.evolucionar(this);
		setChanged();
		notifyObservers(new Evolucion[] {this.stateEvo});
	}
	
	public void cambiarEvolucion(Evolucion pEv) {
		this.stateEvo = pEv;
	}
	
	public boolean haAtacado () {
		//System.out.println("El pokemon " + this.id + " ya ha atacado");
		return this.yaHaAtacado;
		
	}
	
	public void haAtacadoYa (boolean pHaAtacado) {
		this.yaHaAtacado = pHaAtacado;
		if (yaHaAtacado) {
			System.out.println("Hola soy el pokemon: " + id + " y ya he atacado" );
		}
	}
	
	public void estadoEuforia() {
		if (ataquesEuforiaAcumulados >= euforia) {
			this.cambiarEstado(new EstadoEuforia());
			stateEuforia.estadoEuforia(this);
			System.out.println("Esta euforico");
			
			
		}
	}
	
	public void cambiarEstado(Estado pEst) {
		this.stateEuforia = pEst;
	}
	
	public void quitarEstadoEuforia(Pokemon pPokemon) {
		if (pPokemon.ataque>=100 && pPokemon.defensa>=100) {
			pPokemon.setAtaque(pPokemon.ataque-100);
			pPokemon.setDefensa(pPokemon.defensa-100);
			pPokemon.ataquesEuforiaAcumulados = 0;
			pPokemon.setHaAtacadoEuforico(false);
		}
	}
	
	public abstract boolean recibeAtaqueEfectivo(String pTipo);
	
	public abstract boolean recibeAtaquePocoEfectivo(String pTipo);
	
}