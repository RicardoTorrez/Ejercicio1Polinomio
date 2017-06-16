package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelCombo extends JPanel {

	private static final long serialVersionUID = 8990177830929347220L;
	private final Integer[] datos = {3, 4, 5, 6, 7, 8, 9, 10};
	private JComboBox<Integer> combo;
	
	public PanelCombo() {
		setLayout(new BorderLayout());
		
		combo = new JComboBox<>(datos);
		combo.addActionListener(this::eventoCombo); 
		
		add(combo, BorderLayout.CENTER);
	}
	
	private void eventoCombo(ActionEvent e) {
		Integer valor = (Integer) combo.getSelectedItem();
		
		Ventana ventana = Ventana.getVentana();
		ventana.nuevosValores(valor);
		ventana.revalidate();
		ventana.repaint();
	}
	
	
}