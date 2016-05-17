package gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase AcercaDe. Muestra información acerca del programa.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class AcercaDe extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Constructor
	 */
	public AcercaDe(){
		setTitle("Acerca de...");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 455, 344);
		
		contentPanel.setLayout(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblImagen1 = new JLabel("");
		lblImagen1.setIcon(new ImageIcon(AcercaDe.class.getResource("/imagenes/Componentes.png")));
		lblImagen1.setBounds(90, 36, 128, 128);
		contentPanel.add(lblImagen1);
		
		JLabel lblImagen2 = new JLabel("");
		lblImagen2.setIcon(new ImageIcon(AcercaDe.class.getResource("/imagenes/Tablets.png")));
		lblImagen2.setBounds(228, 36, 128, 128);
		contentPanel.add(lblImagen2);
		
		JLabel lblAutor = new JLabel("Autor: Miguel Angel L\u00F3pez Moyano");
		lblAutor.setBounds(23, 222, 195, 23);
		contentPanel.add(lblAutor);
		
		JLabel lblVersion = new JLabel("Versi\u00F3n: 1.0");
		lblVersion.setBounds(23, 244, 94, 23);
		contentPanel.add(lblVersion);
		
		JLabel lblcCopyright = new JLabel("(c) Copyright 2016.  All rights reserved.");
		lblcCopyright.setBounds(23, 267, 234, 21);
		contentPanel.add(lblcCopyright);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(338, 266, 89, 23);
		contentPanel.add(btnAceptar);
	}
}

