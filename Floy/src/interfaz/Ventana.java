package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -3030099236595355215L;
	
	private static Ventana ventana = null;
	
	public static Ventana getVentana() {
		if (ventana == null) {
			ventana = new Ventana();
		}
		return ventana;
	}
	
	private PanelMatriz panelMatrix;
	private PanelCombo panelCombo;
	private PanelBoton panelBoton;
	
	private Ventana() {
		super("Algoritmo de Floyd");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(600, 600);
		
		iniciar();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void iniciar() {
		panelCombo = new PanelCombo();
		add(panelCombo, BorderLayout.NORTH);
		
		panelMatrix = new PanelMatriz(3);
		add(panelMatrix, BorderLayout.CENTER);
		
		panelBoton = new PanelBoton();
		add(panelBoton, BorderLayout.SOUTH);
	}
	
	public void nuevosValores(int n) {
		remove(panelMatrix);
		
		panelMatrix = new PanelMatriz(n);
		add(panelMatrix, BorderLayout.CENTER);
	}

	public PanelMatriz getPanelMatrix() {
		return panelMatrix;
	}

	public PanelCombo getPanelCombo() {
		return panelCombo;
	}

	public PanelBoton getPanelBoton() {
		return panelBoton;
	}

}