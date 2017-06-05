package Grafico;

import java.awt.*;
import java.io.File;
import javax.swing.*;

import Ficheros.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Grafico{
	JFrame ventana;
	Button btnTxt = new Button("Importar Fichero de texto");
	Button  btnCompr = new Button("Comprimir");
	Button  btnHfm = new Button("Abrir .hfm");
	TextArea result = new TextArea();
	TextArea orig = new TextArea("\n ");
	Huffman hfm;

	public void ventanaPrincipal(){
		this.ventana = new JFrame("                                   Compresor de Txt 1.0 (HUFFMAN)");
		//ventana.setBounds(r);
		ventana.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(480, 320);
		ventana.setResizable(false);
		ventana.setBackground(Color.DARK_GRAY);
	
                  btnHfm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String ubi = "";
                                
                                
				JFileChooser fchH = new JFileChooser();
				fchH.setAcceptAllFileFilterUsed(false);
				fchH.addChoosableFileFilter(new ChooserHfm());
				int valor = fchH.showOpenDialog(null);
				if (valor == JFileChooser.APPROVE_OPTION) {//0 si 1 no
					File fi = fchH.getSelectedFile();
					ubi = fi.getPath();
				}
				if(ubi.length()>1){
					JFrame ventana2 = new JFrame("                                                                             Descomprimido");
					ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ventana2.setLayout(new FlowLayout(FlowLayout.RIGHT,50,50));
					ventana2.setSize(200, 200);
                                        //ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        //ventana.setSize(480, 640);
                                        ventana2.setResizable(true);
					//ventana2.setLocationRelativeTo(null);
                                        //ventana2.setBounds(120, 100, 240, 200);
					Button volver = new Button("Regresar");
					ventana2.add(volver);
					TextArea desencrip = new TextArea();
					desencrip.setText(new Huffman().desComprimir(new Archivos().leer(ubi)));
					desencrip.setEditable(false);
					ventana2.add(desencrip);
					ventana.setVisible(false);
					ventana2.pack();
					ventana2.setVisible(true);
					volver.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae) {
							ventana2.setVisible(false);
							orig.setText("");
							ventana.setVisible(true);
						}
					});

				}else{       JOptionPane.showMessageDialog(null,"Error al abrir, intenta otra vez", " ", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnCompr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(orig.getText().length()<=0){
					JOptionPane.showMessageDialog(ventana, "No hay datos");
				}else{
				                                        
                                         JFrame ventana3 = new JFrame("                                                                             Comprimido");
					  ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ventana3.setLayout(new FlowLayout(FlowLayout.RIGHT,50,50));
					ventana3.setSize(200, 200);
                                         ventana3.setResizable(true);
                                         Button volver2 = new Button("Regresar");
                                         Button  btnGuar = new Button("Exportar .hfm");
					ventana3.add(volver2);
                                        ventana3.add(btnGuar);
                                        hfm = new Huffman(orig.getText());
                                        {
					result.setText(hfm.binaryo);
					result.setEditable(false);
					ventana3.add(result);
					ventana.setVisible(false);
					ventana3.pack();
					ventana3.setVisible(true);
                                        volver2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent ae2) {
							ventana3.setVisible(false);
							
							result.setText("");
							ventana.setVisible(true);
                                                        btnGuar.enable(true);
                                                        btnGuar.setVisible(true);
				}
                                        });
                                        
                                        btnGuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(result.getText().length()<=0){
					JOptionPane.showMessageDialog(ventana3, "Datos insuficientes");
				}else{
					JFileChooser fch = new JFileChooser();
					fch.setAcceptAllFileFilterUsed(false);
					fch.addChoosableFileFilter(new FileNameExtensionFilter(".hfm",".hfm"));
					int numSec = fch.showSaveDialog(null);
					try{
						if (numSec == JFileChooser.APPROVE_OPTION){
							File JFC = fch.getSelectedFile();
							String PATH = JFC.getAbsolutePath();
							new Archivos().crear(hfm.mapita.recorrer()+"////"+hfm.aChar(result.getText()), PATH+".hfm");
							if(!(PATH.endsWith(".hfm"))){
								File faux = new File(PATH+".hfm");
								JFC.renameTo(faux);
							}
							JOptionPane.showMessageDialog(null,"Archivo guardado", "", JOptionPane.INFORMATION_MESSAGE);
						}
					}catch (Exception ex){
						JOptionPane.showMessageDialog(null,"Error al guardar, intenta otra vez", "", JOptionPane.ERROR_MESSAGE);
					} 


				}
			}
		});
                                                }
                                }
                        }
                                        
                });
                                
                        
		btnTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String link = "";
				JFileChooser fchT = new JFileChooser();
                                fchT.addChoosableFileFilter(new ChooserTxt());
				fchT.setAcceptAllFileFilterUsed(false);
				fchT.addChoosableFileFilter(new ChooserBat());
				fchT.addChoosableFileFilter(new ChooserDat());
                                fchT.addChoosableFileFilter(new ChooserHtml());
                                fchT.addChoosableFileFilter(new ChooserIni());
                                fchT.addChoosableFileFilter(new ChooserXml());
				int valo = fchT.showOpenDialog(null);
				if (valo == JFileChooser.APPROVE_OPTION) {
					File cf = fchT.getSelectedFile();//current file
					link = cf.getPath();
				}
				orig.setText(new Archivos().leer(link).replaceAll("EOL","\r"));//EOL evita que la linea se forme en forma vertical(o eso entendí)
				SwingUtilities.updateComponentTreeUI(ventana);//incluye el repaint
			}
		});
		
		
                  
                
                orig.setEditable(false);
		ventana.add(btnTxt);
		ventana.add(orig);
		ventana.add(btnCompr);
		ventana.add(btnHfm);
		ventana.setVisible(true);

                        }}




