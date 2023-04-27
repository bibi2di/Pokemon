package Vista_Controlador;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ReadMe extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadMe frame = new ReadMe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReadMe() {
		setTitle("Información del Juego");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReadMe.class.getResource("/sprites/pokebol.png")));
		setBounds(100, 100, 800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

	}
}
