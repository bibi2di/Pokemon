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
	private int euforia = (int) (Math.random()*5+3);
	private int ataquesEuforiaAcumulados;
	private Evolucion strategy;
	
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
		strategy = null;
		setChanged();
		notifyObservers(new Object [] {this.vida,this.defensa,this.ataque,this.tipo});
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

	/**
	 * 
	 * @param pTipo
	 */
	public void recibirAtaque(Pokemon pPokemon) {
		/*this.ataquesEuforiaAcumulados++;
		System.out.println("Ataques acumulados: " + ataquesEuforiaAcumulados);
		boolean euforia = this.estadoEuforia();
		System.out.println("Turnos de euforia: " + this.euforia);*/
		double multiplicador = 1;
		if(pPokemon.recibeAtaqueEfectivo(this.tipo)) {
			multiplicador = 2;
		}
		else if(pPokemon.recibeAtaquePocoEfectivo(this.tipo)) {
			multiplicador = 0.5;
		}
		System.out.println(multiplicador);
		this.vida = (int)(this.vida -(pPokemon.ataque*multiplicador) - this.defensa);
		
		double vidaRestante = (double)this.vida/this.vidaIni;
		if (vidaRestante <=0.5 && (!(strategy instanceof Evolucion1)) && (!(strategy instanceof Evolucion2))) {
			this.cambiarEvolucion(new Evolucion1());
			this.evolucionar();
		}
		if (vidaRestante <=0.2 && (!(strategy instanceof Evolucion2))) {
			this.cambiarEvolucion(new Evolucion2());
			this.evolucionar();
		}
		
		if (this.vida<0) {
			this.vida = 0;
		}
		setChanged();
		notifyObservers(new int [] {this.vida,this.defensa,this.ataque});
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
		strategy.evolucionar(this);
		setChanged();
		notifyObservers(new Evolucion[] {this.strategy});
	}
	
	public void cambiarEvolucion(Evolucion pEv) {
		this.strategy = pEv;
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
	
	public boolean estadoEuforia() {
		boolean euforico = false;
		if (ataquesEuforiaAcumulados == euforia) {
			this.ataque = this.ataque+100;
			this.defensa = this.defensa+100;
			euforico = true;
			System.out.println("Esta euforico");
		}
		else if(this.yaHaAtacado && (this.euforia>=this.ataquesEuforiaAcumulados)) {
			this.ataque = this.ataque-100;
			this.defensa = this.defensa-100;
			ataquesEuforiaAcumulados = 0;
			euforico = false;
			System.out.println("Deja de estar euforico");
		}
		return euforico;
	}
	
	public abstract boolean recibeAtaqueEfectivo(String pTipo);
	
	public abstract boolean recibeAtaquePocoEfectivo(String pTipo);
	
}