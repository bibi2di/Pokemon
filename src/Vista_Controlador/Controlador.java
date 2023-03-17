package Vista_Controlador;

public class Controlador {
	private Controler controler = null;
	
	private Controler getControler() {
		if (controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	private class Controler {
		
		
	}
}
