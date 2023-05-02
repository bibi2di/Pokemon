package Modelo;

public class Psiquico extends Pokemon {

	public Psiquico(int i) {
		super(i);
	}
	
	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Bicho");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Psiquico");
	}

}
