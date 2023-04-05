package Modelo;

import java.util.Observable;

@SuppressWarnings("deprecation")
public /*abstract*/ class Pokemon extends Observable {

	private int id;
	private int ataque;
	private int defensa;
	private int vida;
	private int vidaIni;
	private String tipo;
	private boolean yaHaAtacado;
	private String tipoEfectivo; 

	/**
	 * 
	 * @param pTipo
	 */
	public Pokemon(int pId) {
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
		int r = (int)(Math.random()*4); 
		String nombre = new String[] {"Agua", "Fuego", "Planta", "Electrico"}[r]; //tipo aleatorio
		yaHaAtacado = false;
		tipo = nombre;
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

	/**
	 * 
	 * @param pTipo
	 */
	public void recibirAtaque(Pokemon pPokemon) {
		int multiplicador = 1;
		this.vida = this.vida -(pPokemon.ataque*multiplicador) - this.defensa;
		setChanged();
		if (this.vida<0) {
			this.vida = 0;
		}
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
		
	}
	
	public boolean haAtacado () {
		//System.out.println("El pokemon " + this.id + " ya ha atacado");
		return this.yaHaAtacado;
		
	}
	
	public void haAtacadoYa (boolean pHaAtacado) {
		this.yaHaAtacado = pHaAtacado;
	}
	
	public void estadoEuforia() {
		
	}
	
}