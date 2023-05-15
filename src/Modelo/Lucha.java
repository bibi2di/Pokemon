package Modelo;
public class Lucha extends Pokemon {

	protected Lucha(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Roca") || pTipo.equals("Acero") || pTipo.equals("Siniestro") || pTipo.equals("Normal") || pTipo.equals("Hielo");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return  pTipo.equals("Hada") || pTipo.equals("Psiquico") || pTipo.equals("Fantasma") || pTipo.equals("Volador");
	}

}
