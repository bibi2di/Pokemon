package Modelo;

public class Psiquico extends Pokemon {

	public Psiquico(int i) {
		super(i);
	}
	
	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Lucha") || pTipo.equals("Veneno");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Bicho") || pTipo.equals("Siniestro") || pTipo.equals("Acero");
	}

}
