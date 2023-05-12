package Modelo;

public class Fantasma extends Pokemon {
	
	public Fantasma (int i) {
		super(i);
	}


	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return (pTipo.equals("Fantasma") || pTipo.equals("Psiquico"));
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return (pTipo.equals("Veneno") || pTipo.equals("Siniestro"));
	}

}