package Modelo;

public class Psiquico extends Pokemon {

	public Psiquico(int i) {
		super(i);
	}
	
	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return /*pTipo.equals("Lucha");*/ false;
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Bicho") || pTipo.equals("Psiquico");
	}

}
