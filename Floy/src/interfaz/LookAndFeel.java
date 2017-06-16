package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;

public class LookAndFeel {

	public static void iniciar() {
		Font fuente = new Font("Century Gothic", Font.BOLD, 20);
		Font fuente2 = new Font("Century Gothic", Font.PLAIN, 18);
		
		UIManager.put("TextField.font", fuente);
		UIManager.put("ComboBox.font", fuente2);
		UIManager.put("ComboBox.background", Color.WHITE);
		UIManager.put("Button.background", Color.WHITE);
	}

}