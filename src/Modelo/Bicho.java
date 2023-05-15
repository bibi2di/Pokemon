package Modelo;

public class Bicho extends Pokemon {
	

	public Bicho(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean recibeAtaqueEfectivo(String pTipo){
		return pTipo.equals("Planta") || pTipo.equals("Psiquico") || pTipo.equals("Siniestro");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Fuego") || pTipo.equals("Volador") || pTipo.equals("Roca") || pTipo.equals("Lucha") || pTipo.equals("Veneno") || pTipo.equals("Fantasma") || pTipo.equals("Acero") || pTipo.equals("Hada") ;
	}

}
