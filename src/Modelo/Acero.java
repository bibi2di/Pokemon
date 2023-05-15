package Modelo;

public class Acero extends Pokemon {

	protected Acero(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Hielo") || pTipo.equals("Hada") || pTipo.equals("Roca");
		
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Fuego") || pTipo.equals("Agua") || pTipo.equals("Electrico");
	}

}
