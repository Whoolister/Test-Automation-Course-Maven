package sixth_solvd_assignment.graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ClienteDeChat {
	private JTextArea jtaMensajesEntrantes;
	private JTextField jtfMensajesAEnviar;
	private JButton bEnviar;
	private JButton bSalir;
	private JComboBox<String> nombresUsuarios;
	private JScrollPane jspPanelTexto;
	
	class Escucha implements ActionListener {	
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Enviar") {
				if (jtfMensajesAEnviar.getText().length() != 0) {
					jtaMensajesEntrantes.append("Para : " + nombresUsuarios.getItemAt(nombresUsuarios.getSelectedIndex()) + ">> " +
						jtfMensajesAEnviar.getText() + '\n');
					jtfMensajesAEnviar.setText("");
				}
			} else if (e.getActionCommand() == "Salir") {
				System.exit(0);
			}
		}
	}
	
	public ClienteDeChat() {
		this.jtaMensajesEntrantes = new JTextArea(10, 50);
		this.jtfMensajesAEnviar = new JTextField(50);
		this.bEnviar = new JButton("Enviar");
		this.bSalir = new JButton("Salir");
		this.nombresUsuarios = new JComboBox<String>(new String[] {"Besa","Whoolister","Wren","Coolcat"});
	}
	
	public void launchFrame() {
		JFrame marco = new JFrame("Ventana para Chat");
		JScrollPane jspPanelTexto = new JScrollPane(jtaMensajesEntrantes, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		JMenuBar jmbMenuBar = new JMenuBar();
		JMenu jmMenu1 = new JMenu("Archivo");
		JMenu jmMenu2 = new JMenu("Ayuda");
		JMenuItem m1 = new JMenuItem("Salir");
		JMenuItem m2 = new JMenuItem("Acerca De");
		JPanel p1 = new JPanel();
		
		jmbMenuBar.add(jmMenu1);
		jmbMenuBar.add(jmMenu2);

		m1.addActionListener(new Escucha());
		m2.setToolTipText("Este programa emula un chat room con un numero de otros usuarios. Para seleccionar a"
				+ " quien dirigir los mensajes, utilice el Combo Box ubicado a la derecha");
		
		jmMenu1.add(m1);
		jmMenu2.add(m2);
		
		marco.setJMenuBar(jmbMenuBar);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setLayout(new BorderLayout());
		marco.add(jspPanelTexto, BorderLayout.WEST);
		marco.add(jtfMensajesAEnviar, BorderLayout.SOUTH);
		
		p1.setLayout(new GridLayout(3,1));
		p1.add(nombresUsuarios);
		p1.add(bEnviar);
		p1.add(bSalir);
		
		bEnviar.addActionListener(new Escucha());
		bSalir.addActionListener(new Escucha());
		
		marco.add(p1, BorderLayout.CENTER);
		marco.pack();
		marco.setVisible(true);
	}
	
	public static void main(String[] args) {
		ClienteDeChat prueba = new ClienteDeChat();
		prueba.launchFrame();
	}
}
