package Modelo;

public class Bicho extends Pokemon {
	

	public Bicho(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean recibeAtaqueEfectivo(String pTipo){
		return pTipo.equals("Planta") || pTipo.equals("Psiquico");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Fuego") || pTipo.equals("Volador") || pTipo.equals("Roca");
	}

}
