package Modelo;

public class Siniestro extends Pokemon {

	protected Siniestro(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Fantasma") || pTipo.equals("Psiquico");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Lucha") || pTipo.equals("Hada");
	}

}
