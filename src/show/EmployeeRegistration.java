/**
 * 
 */
package show;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import static util.FunctionsLibrary.*;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


/**
 * @author mitchell
 *
 */

public class EmployeeRegistration extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private JFormattedTextField formattedTextFieldCedulaProfesor;
	private JTextField textFieldPrimerNombreProfesor;
	private JTextField textFieldSegundoNombreProfesor;
	private JTextField textFieldPrimerApellidoProfesor;
	private JTextField textFieldSegundoApellidoProfesor;
	private JTextField textFieldEmailProfesor;
	private JFormattedTextField formattedTextFieldTelefono1Profesor;
	private JFormattedTextField formattedTextFieldTelefono2Profesor;
	private JCheckBox chckbxMorning;
	private JCheckBox chckbxAfternoon;
	private JCheckBox chckbxNight;
	private JComboBox<String> comboBoxPuesto;

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
					EmployeeRegistration frame = new EmployeeRegistration();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public EmployeeRegistration() throws ParseException {
		setTitle("Regristo de Empleados");
		setBounds(100, 100, 471, 422);
		quitarBotonEsquinaIzquierdaJInternalFrame(this);
			
			/*------------------------------------------------------------------------------------------------------------------------------
			 *Creacion del panel Agregar Estudiante que contiene el formulario para registro de estudiantes.
			------------------------------------------------------------------------------------------------------------------------------*/
			JPanel panelAddEmployee = new JPanel();
			panelAddEmployee.setLayout(null);
			getContentPane().add(panelAddEmployee, BorderLayout.CENTER);
			
				/*------------------------------------------------------------------------------------------------------------------------------
				 * Creacion de las etiquetas del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				JLabel lblCedula = new JLabel("Cedula");
				lblCedula.setBounds(20, 15, 111, 26);
				lblCedula.setFont(new Font("SansSerif", Font.BOLD, 14));
				panelAddEmployee.add(lblCedula);
				
				JLabel lblPrimerNombre = new JLabel("Primer Nombre");
				lblPrimerNombre.setBounds(20, 50, 111, 26);
				lblPrimerNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
				panelAddEmployee.add(lblPrimerNombre);
				
				JLabel lblSegundoNombre = new JLabel("Segundo Nombre");
				lblSegundoNombre.setBounds(20, 85, 125, 26);
				lblSegundoNombre.setFont(new Font("SansSerif", Font.BOLD, 14));
				panelAddEmployee.add(lblSegundoNombre);
				
				JLabel lblPrimerApellido = new JLabel("Primer Apellido");
				lblPrimerApellido.setBounds(20, 120, 111, 26);
				lblPrimerApellido.setFont(new Font("SansSerif", Font.BOLD, 14));
				panelAddEmployee.add(lblPrimerApellido);
				
				JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
				lblSegundoApellido.setBounds(20, 155, 125, 26);
				lblSegundoApellido.setFont(new Font("SansSerif", Font.BOLD, 14));	
				panelAddEmployee.add(lblSegundoApellido);
				
				JLabel lblEmail = new JLabel("Email");
				lblEmail.setBounds(20, 190, 111, 26);
				lblEmail.setFont(new Font("SansSerif", Font.BOLD, 14));
				panelAddEmployee.add(lblEmail);
				
				JLabel lblTelefonos = new JLabel("Telefonos");
				lblTelefonos.setBounds(20, 225, 111, 26);
				lblTelefonos.setFont(new Font("SansSerif", Font.BOLD, 14));
				panelAddEmployee.add(lblTelefonos);
				
				JLabel lblTanda = new JLabel("Tanda");
				lblTanda.setBounds(20, 260, 111, 26);
				lblTanda.setFont(new Font("SansSerif", Font.BOLD, 14));
				panelAddEmployee.add(lblTanda);
			
				JLabel lblPuesto = new JLabel("Puesto");
				lblPuesto.setFont(new Font("SansSerif", Font.BOLD, 14));
				lblPuesto.setBounds(243, 260, 76, 26);
				panelAddEmployee.add(lblPuesto);
				
				/*Final de las estiquetas del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
							
				/*------------------------------------------------------------------------------------------------------------------------------
				 * Creacion de los jTextField y JFormattedTextField del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				formattedTextFieldCedulaProfesor = new JFormattedTextField(new MaskFormatter("###-#######-#"));
				formattedTextFieldCedulaProfesor.setFocusLostBehavior(JFormattedTextField.PERSIST);
				formattedTextFieldCedulaProfesor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				formattedTextFieldCedulaProfesor.setColumns(13);
				formattedTextFieldCedulaProfesor.setBounds(147, 15, 141, 28);
				panelAddEmployee.add(formattedTextFieldCedulaProfesor);
				
				textFieldPrimerNombreProfesor = new JTextField();
				textFieldPrimerNombreProfesor.setBounds(145, 50, 292, 28);
				textFieldPrimerNombreProfesor.setColumns(10);
				panelAddEmployee.add(textFieldPrimerNombreProfesor);
				
				textFieldSegundoNombreProfesor = new JTextField();
				textFieldSegundoNombreProfesor.setBounds(145, 85, 292, 28);
				textFieldSegundoNombreProfesor.setColumns(10);
				panelAddEmployee.add(textFieldSegundoNombreProfesor);
				
				textFieldPrimerApellidoProfesor = new JTextField();
				textFieldPrimerApellidoProfesor.setBounds(145, 120, 292, 28);
				textFieldPrimerApellidoProfesor.setColumns(10);
				panelAddEmployee.add(textFieldPrimerApellidoProfesor);
				
				textFieldSegundoApellidoProfesor = new JTextField();
				textFieldSegundoApellidoProfesor.setBounds(145, 155, 292, 28);
				textFieldSegundoApellidoProfesor.setColumns(10);
				panelAddEmployee.add(textFieldSegundoApellidoProfesor);
				
				textFieldEmailProfesor = new JTextField();
				textFieldEmailProfesor.setBounds(145, 190, 292, 28);
				textFieldEmailProfesor.setColumns(10);
				panelAddEmployee.add(textFieldEmailProfesor);
				
				formattedTextFieldTelefono1Profesor = new JFormattedTextField(new MaskFormatter("###-###-####"));
				formattedTextFieldTelefono1Profesor.setFocusLostBehavior(JFormattedTextField.PERSIST);
				formattedTextFieldTelefono1Profesor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				formattedTextFieldTelefono1Profesor.setColumns(12);
				formattedTextFieldTelefono1Profesor.setBounds(147, 225, 141, 28);
				panelAddEmployee.add(formattedTextFieldTelefono1Profesor);
				
				formattedTextFieldTelefono2Profesor = new JFormattedTextField(new MaskFormatter("###-###-####"));
				formattedTextFieldTelefono2Profesor.setFocusLostBehavior(JFormattedTextField.PERSIST);
				formattedTextFieldTelefono2Profesor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				formattedTextFieldTelefono2Profesor.setColumns(12);
				formattedTextFieldTelefono2Profesor.setBounds(293, 225, 141, 28);
				panelAddEmployee.add(formattedTextFieldTelefono2Profesor);
				
				chckbxMorning = new JCheckBox("Ma\u00F1ana");
				chckbxMorning.setBounds(145, 260, 104, 18);
				panelAddEmployee.add(chckbxMorning);
				
				chckbxAfternoon = new JCheckBox("Tarde");
				chckbxAfternoon.setBounds(145, 280, 104, 18);
				panelAddEmployee.add(chckbxAfternoon);
				
				chckbxNight = new JCheckBox("Noche");
				chckbxNight.setBounds(145, 300, 104, 18);
				panelAddEmployee.add(chckbxNight);
				
				comboBoxPuesto = new JComboBox<String>();
				comboBoxPuesto.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Profesor", "Oficinista", "Tecnico", "Coordinador", "Supervisor"}));
				comboBoxPuesto.setBounds(293, 261, 144, 26);
				panelAddEmployee.add(comboBoxPuesto);
													
				/* Final de los jTextField y JFormattedTextField del formulario para registro de estudiantes.
				------------------------------------------------------------------------------------------------------------------------------*/
				
			/*------------------------------------------------------------------------------------------------------------------------------
			 *Creacion del panel que contiene los botones del formulario para registro de estudiantes.
			------------------------------------------------------------------------------------------------------------------------------*/
			JPanel panelBotones = new JPanel();
			panelBotones.setBounds(0, 343, 460, 48);
			panelAddEmployee.add(panelBotones);
			panelBotones.setLayout(null);
			/* Final del panel que contiene los botones del formulario para registro de estudiantes.
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
				btnGuardar.setBounds(129, 11, 85, 36);
				panelBotones.add(btnGuardar);
				
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
				btnCancelar.setBounds(241, 11, 85, 36);
				panelBotones.add(btnCancelar);
				
				btnSalir = new JButton("Salir");
				btnSalir.setFont(new Font("SansSerif", Font.BOLD, 12));
					btnSalir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) 
						{
							dispose();
						}
					});
				btnSalir.setBounds(374, 11, 85, 36);
				panelBotones.add(btnSalir);
		//-------------------------------------------------------------
	}
}
