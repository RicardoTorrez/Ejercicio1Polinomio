package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.ArchivoControlador;
import modelo.CaminosMinimos;

public class PanelBoton extends JPanel {

	private static final long serialVersionUID = -4969934884591787295L;
	
	private JButton btnCalcular;
	
	public PanelBoton() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnCalcular = new JButton("Calcular Floyd");
		btnCalcular.addActionListener(this::calcular);
		add(btnCalcular);
	}
	
	private void calcular(ActionEvent e) {
		PanelMatriz panelMatriz = Ventana.getVentana().getPanelMatrix();
		
		boolean valido = panelMatriz.validarValores();
		if (valido) {
			long[][] matriz = panelMatriz.toArreglo();
			String resultado = CaminosMinimos.algoritmoFloyd(matriz);
			ArchivoControlador.guardar(resultado);
			JOptionPane.showMessageDialog(Ventana.getVentana(), "Se guardó resultado en resultado.txt", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}