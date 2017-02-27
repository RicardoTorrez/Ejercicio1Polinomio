
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ventana extends JFrame {

	public Ventana(){
		//add(Polinomio1);
		//add(Boton);

		prin pn = new prin();
		this.add(pn);
		setTitle("Polinomios");
		this.setBounds(300, 300, 400, 350);
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	JTextField Polinomio1 = new JTextField("Poli1");
	JButton Boton = new JButton("Btn1");	
}
