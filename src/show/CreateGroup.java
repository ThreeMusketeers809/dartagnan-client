/**
 * 
 */
package show;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import static util.FunctionsLibrary.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * @author mitchell
 *
 */
public class CreateGroup extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboBoxPeriodo;
	private JComboBox<String> comboBoxNivel;
	private JComboBox<String> comboBoxProfesor;
	private JComboBox<String> comboBoxTanda;
	private JTextField textFieldCodigo;
	
	private JButton btnNuevo;
	private JButton btnGuardar;
	public JButton btnCancelar;
	public JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateGroup frame = new CreateGroup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateGroup() {
		setTitle("Crear Grupo");
		setBounds(100, 100, 399, 300);
		quitarBotonEsquinaIzquierdaJInternalFrame(this);
		
			/*------------------------------------------------------------------------------------------------------------------------------
			 *Creacion del panel Crear Grupos que contiene el formulario para Crear Grupos.
			------------------------------------------------------------------------------------------------------------------------------*/
			JPanel panelCreateGroup = new JPanel();
			getContentPane().add(panelCreateGroup, BorderLayout.CENTER);
			panelCreateGroup.setLayout(null);
		
			/* 
			 * Creacion de las etiquetas del formulario para Crear Grupos.
			------------------------------------------------------------------------------------------------------------------------------*/
			JLabel lblPeriodo = new JLabel("Periodo");
			lblPeriodo.setFont(new Font("SansSerif", Font.BOLD, 14));
			lblPeriodo.setBounds(22, 15, 111, 26);
			panelCreateGroup.add(lblPeriodo);
			
			JLabel lblNivel = new JLabel("Nivel");
			lblNivel.setFont(new Font("SansSerif", Font.BOLD, 14));
			lblNivel.setBounds(22, 50, 111, 26);
			panelCreateGroup.add(lblNivel);
			
			JLabel lblProfesor = new JLabel("Profesor");
			lblProfesor.setFont(new Font("SansSerif", Font.BOLD, 14));
			lblProfesor.setBounds(22, 85, 111, 26);
			panelCreateGroup.add(lblProfesor);
			
			JLabel lblTanda = new JLabel("Tanda");
			lblTanda.setFont(new Font("SansSerif", Font.BOLD, 14));
			lblTanda.setBounds(22, 120, 111, 26);
			panelCreateGroup.add(lblTanda);
			
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setFont(new Font("SansSerif", Font.BOLD, 14));
			lblCodigo.setBounds(22, 155, 111, 26);
			panelCreateGroup.add(lblCodigo);
			/*Final de las estiquetas del formulario para Crear Grupos.
			------------------------------------------------------------------------------------------------------------------------------*/
						
			/*------------------------------------------------------------------------------------------------------------------------------
			 * Creacion de los combo box y JTextField del formulario para Crear Grupos.
			------------------------------------------------------------------------------------------------------------------------------*/
			comboBoxPeriodo = new JComboBox<String>();
			comboBoxPeriodo.setBounds(135, 15, 144, 26);
			panelCreateGroup.add(comboBoxPeriodo);
			
			comboBoxNivel = new JComboBox<String>();
			comboBoxNivel.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Basico 1", "Basico 2", "Intermedio 1", "Intermedio 2", "Avanzado"}));
			comboBoxNivel.setBounds(135, 51, 144, 26);
			panelCreateGroup.add(comboBoxNivel);
			
			comboBoxProfesor = new JComboBox<String>();
			comboBoxProfesor.setBounds(135, 86, 229, 26);
			panelCreateGroup.add(comboBoxProfesor);
			
			comboBoxTanda = new JComboBox<String>();
			comboBoxTanda.setBounds(135, 121, 144, 26);
			panelCreateGroup.add(comboBoxTanda);
			
			textFieldCodigo = new JTextField();
			textFieldCodigo.setBounds(135, 155, 122, 28);
			panelCreateGroup.add(textFieldCodigo);
			textFieldCodigo.setColumns(10);
			/* Final de los jTextField y JFormattedTextField del formulario para Crear Grupos.
			------------------------------------------------------------------------------------------------------------------------------*/
			
		/*------------------------------------------------------------------------------------------------------------------------------
		 *Creacion del panel que contiene los botones del formulario para Crear Grupos.
		------------------------------------------------------------------------------------------------------------------------------*/
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(null);
		panelBotones.setBounds(0, 221, 387, 48);
		panelCreateGroup.add(panelBotones);
		/* Final del panel que contiene los botones del formulario para Crear Grupos.
		------------------------------------------------------------------------------------------------------------------------------*/
		
			/*------------------------------------------------------------------------------------------------------------------------------
			 * Creacion de los Botones del formulario para registro de estudiantes.
			------------------------------------------------------------------------------------------------------------------------------*/
			btnNuevo = new JButton("Nuevo");
			btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnNuevo.setBounds(0, 11, 85, 36);
			panelBotones.add(btnNuevo);
			
			btnGuardar = new JButton("Guardar");
			btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnGuardar.setBounds(100, 11, 85, 36);
			panelBotones.add(btnGuardar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnCancelar.setBounds(203, 11, 85, 36);
			panelBotones.add(btnCancelar);
			
			btnSalir = new JButton("Salir");
			btnSalir.setFont(new Font("SansSerif", Font.BOLD, 12));
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
			btnSalir.setBounds(301, 11, 85, 36);
			panelBotones.add(btnSalir);
			/* Final de  los botones del formulario para Crear Grupos.
			------------------------------------------------------------------------------------------------------------------------------*/
	}
}
