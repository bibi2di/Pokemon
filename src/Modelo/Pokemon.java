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
	private int euforia;
	private int ataquesEuforiaAcumulados;

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
		this.ataquesEuforiaAcumulados++;
		//System.out.println("Ataques acumulados: " + ataquesEuforiaAcumulados);
		//boolean euforia = this.estadoEuforia();
		//System.out.println("Turnos de euforia: " + this.euforia);
		int multiplicador = 1;
		System.out.println("Tipo pokemon atacante: "+ pPokemon.tipo);
		System.out.println("Tipo pokemon atacado: "+ this.tipo);
		if(this.recibeAtaqueEfectivo(pPokemon.tipo)) {
			multiplicador = 2;
		}
		/*else if(pPokemon.esPocoEfectivo(this.tipo)) {
			multiplicador = 0.5;
		}*/
		System.out.println(multiplicador);
		this.vida = this.vida -(pPokemon.ataque*multiplicador) - this.defensa;
		//euforia = this.estadoEuforia();
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
	
	/*public boolean estadoEuforia() {
		euforia = (int) (Math.random()*5+3);
		boolean euforico = false;
		if (ataquesEuforiaAcumulados == euforia) {
			this.ataque = this.ataque+100;
			this.defensa = this.defensa+100;
			euforico = true;
			System.out.println("Esta euforico");
		}
		else if(ataquesEuforiaAcumulados>euforia) {
			this.ataque = this.ataque-100;
			this.defensa = this.defensa-100;
			ataquesEuforiaAcumulados = 0;
			System.out.println("Deja de estar euforico");
		}
		return euforico;
	}*/
	
	public abstract boolean recibeAtaqueEfectivo(String pTipo);
	
	public abstract boolean recibeAtaquePocoEfectivo(String pTipo);
}