
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class prin extends JPanel{
	
    ListaDoble listaPrueba= new ListaDoble();
    ListaDoble listaPrueba2= new ListaDoble();
   ListaCircular contra = new ListaCircular();
   ListaCircular contra2 = new ListaCircular();
   ListaDoble Resultado= new ListaDoble();
     ListaDoble Resultado2= new ListaDoble();
     
	
	private JLabel contraseniaLa;
	

	private JTextField contrasenia;
	
	private JButton Encriptar;
	private JButton Desencriptar;
	
	public prin(){

		this.setLayout(null);
		
		this.contrasenia=  new JTextField("");
		this.contrasenia.setBounds(70, 50, 300, 40);
		this.contraseniaLa= new JLabel("Ingrese la Contrasenia minimo 3 digitos");
		this.contraseniaLa.setBounds(75, 20, 300, 40);
		

		this.Encriptar= new JButton("Encriptar");
		this.Encriptar.setBounds(70,100, 200,30);
		this.Desencriptar= new JButton("Desencriptar");
		this.Desencriptar.setBounds(70, 150, 200, 30);
		
		

	
		

		this.add(Desencriptar);
		this.add(Encriptar);
		this.add(contrasenia);
		this.add(contraseniaLa);
		
		
		
		
		
		Encriptar.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				String coef;
				try
				{
					if(contrasenia.getText().trim().length() == 0){
						JOptionPane.showMessageDialog(null, "Ingresa una contrasenia");
					}else{
						
						
						coef = contrasenia.getText().trim();
						
						
						listaPrueba.LeerStream(listaPrueba);
						 
						contra=contra.LeerPass(coef);
			               
			            Resultado.Suma(listaPrueba, contra);
			                
			            Resultado.SacarStream(Resultado);

						JOptionPane.showMessageDialog(null, "Encriptacion hecha");
						
					}
				}catch (Exception ex){
					JOptionPane.showMessageDialog( null, ""+ ex.getMessage());
				}
			
			}
		});
		
		Desencriptar.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				String coef, expo;
				try
				{
					if(contrasenia.getText().trim().length() == 0){
						JOptionPane.showMessageDialog(null, "Ingresa una contrasenia");
					}else{
						
						
						coef = contrasenia.getText().trim();
						
					
				        listaPrueba2.LeerStream(listaPrueba2);
				        contra2=contra2.LeerPass(coef);
				        Resultado2.Resta(listaPrueba2, contra2);
				        Resultado2.SacarStream(Resultado2);
			            

						JOptionPane.showMessageDialog(null, "Desencriptacion hecha");
						
						
					}
				}catch (Exception ex){
					JOptionPane.showMessageDialog( null, ""+ ex.getMessage());
				}
			
			}
		});

		
	
	}
}




