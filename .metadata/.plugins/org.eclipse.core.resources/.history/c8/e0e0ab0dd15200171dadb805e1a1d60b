package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PanelMatriz extends JPanel {

	private static final long serialVersionUID = 807382255841989475L;

	private JTextField[][] textfields;
	
	public PanelMatriz(int n) {
		setLayout(new GridLayout(n, n, 1, 1));
		iniciarTextfields(n);
	}
	
	private void iniciarTextfields(int n) {
		textfields = new JTextField[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				textfields[i][j] = new JTextField();
				textfields[i][j].setHorizontalAlignment(JTextField.CENTER);
				add(textfields[i][j]);
			}
		}
	}
	
	public boolean validarValores() {
		boolean seguir = true;
		
		Border rojo = new LineBorder(Color.RED);
		Border negro = UIManager.getBorder("TextBox.border");
		
		for (int i = 0; i < textfields.length; i++) {
			for (int j = 0; j < textfields.length; j++) {
				boolean esNumero = Pattern.compile("^([+-]?[0-9]\\d*|0)$")
						.matcher(textfields[i][j].getText())
						.matches();
				
				textfields[i][j].setBorder(esNumero ? negro : rojo);
				if (!esNumero) seguir = false;
			}
		}
		
		if (!seguir) {
			JOptionPane.showMessageDialog(Ventana.getVentana(), 
					"La matriz no tiene los siguientes números o no tienen el formato adecuado", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	public long[][] toArreglo() {
		long[][] matriz = new long[textfields.length][textfields.length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = Long.parseLong(textfields[i][j].getText());
			}
		}
		
		return matriz;
	}
}
