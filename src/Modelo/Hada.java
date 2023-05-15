package Modelo;

public class Hada extends Pokemon {

	protected Hada(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Dragon") || pTipo.equals("Lucha") || pTipo.equals("Siniestro");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Acero") || pTipo.equals("Veneno") || pTipo.equals("Fuego");
	}

}
