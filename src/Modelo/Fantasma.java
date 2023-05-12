package Modelo;

public class Fantasma extends Pokemon {
	
	public Fantasma (int i) {
		super(i);
	}


	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return (pTipo.equals("Planta") || pTipo.equals("Electrico")||pTipo.equals("Tierra") );
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return (pTipo.equals("Fuego") || pTipo.equals("Volador") || pTipo.equals("Veneno") || pTipo.equals("Hielo"));
	}

}