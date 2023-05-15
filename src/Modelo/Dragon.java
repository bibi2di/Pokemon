package Modelo;

public class Dragon extends Pokemon {

	protected Dragon(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Dragon");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Hada") || pTipo.equals("Hielo") || pTipo.equals("Acero");
	}

}
