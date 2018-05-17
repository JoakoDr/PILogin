package LogiN;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import LogiN.controller;
import LogiN.Vista;

public class Vista extends JFrame {
	private controller miControlador;
	private Model miModelo;
	
	private JTable miTabla;
	private JPanel contentPane;
	
	public Vista() {
		setTitle("Tabla en Base de Datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 32, 362, 115);
		contentPane.add(scrollPane);
		
		miTabla = new JTable();
		miTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(miTabla);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				miTabla.setModel(miModelo.getTabla());
			}
		});
	}

	public void setControlador(controller miControlador) {
		this.miControlador = miControlador;
	}

	public void setModelo(Model miModelo) {
		this.miModelo = miModelo;
	}
	
}
