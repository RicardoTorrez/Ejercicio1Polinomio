package Ficheros;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageFilter;
import javax.swing.*;
import javax.swing.filechooser.*;

public class FileChooserDemo extends JFrame {
    private JTextArea log;
    private JFileChooser filechooser = new JFileChooser();

    private String newline = System.getProperty("line.separator");

    public FileChooserDemo() {
        super("FileChooserDemo2");

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendListener());

        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        JScrollPane logScrollPane = new JScrollPane(log);

        Container contentPane = getContentPane();
        contentPane.add(sendButton, BorderLayout.NORTH);
        contentPane.add(logScrollPane, BorderLayout.CENTER);
    }

    private class SendListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

	    JFileChooser filechooser = new JFileChooser();

/*
	    ExtensionFileFilter imageFilter = new ExtensionFileFilter();
	    imageFilter.addExtension("jpeg");
	    imageFilter.addExtension("jpg");
	    imageFilter.addExtension("tiff");
	    imageFilter.addExtension("tif");
	    imageFilter.addExtension("gif");
	    imageFilter.setDescription("JPEG, TIFF, and GIF images");
	    filechooser.addChoosableFileFilter(imageFilter);
*/

	   // filechooser.addChoosableFileFilter(new ImageFilter());
	   // filechooser.setFileView(new ImageFileView());
	   // filechooser.setAccessory(new ImagePreview(filechooser));

	    int returnVal = filechooser.showDialog(FileChooserDemo.this,
						   "Send");

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = filechooser.getSelectedFile();
                log.append("Sending file: " + file.getName() + "." + newline);
            } else {
                log.append("Send command cancelled by user." + newline);
            }
        }
    }

    public static void main(String s[]) {
        JFrame frame = new FileChooserDemo();

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        frame.addWindowListener(l);

        frame.pack();
        frame.setVisible(true);
    }
}