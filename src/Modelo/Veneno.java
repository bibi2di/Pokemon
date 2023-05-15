package Modelo;

public class Veneno extends Pokemon {

	protected Veneno(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Planta") || pTipo.equals("Hada");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Tierra") || pTipo.equals("Roca") || pTipo.equals("Fantasma") || pTipo.equals("Acero");
	}

}
