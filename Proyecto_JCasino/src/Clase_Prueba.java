import javax.swing.JFrame;

public class Clase_Prueba extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Clase_Prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(640, 480);
		setTitle("Prueba 1");
		
		setVisible(true);
		
	}
	
	public static void main(String[] arg) {
		new Clase_Prueba();
	}
}
