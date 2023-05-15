package Modelo;

public class Normal extends Pokemon {

	protected Normal(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return false;
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Roca") || pTipo.equals("Acero") || pTipo.equals("Fantasma");
	}

}
