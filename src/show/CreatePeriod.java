/**
 * 
 */
package show;

import java.awt.EventQueue;
import static util.FunctionsLibrary.*;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author mitchell
 *
 */
public class CreatePeriod extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxEstadoDelPeriodo;
	
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnSalir;
	public JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePeriod frame = new CreatePeriod();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFormattedTextField formattedTextFieldNombreDelPeriodo;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public CreatePeriod() throws ParseException {
		setTitle("Crear Periodo");
		setBounds(100, 100, 419, 232);
		quitarBotonEsquinaIzquierdaJInternalFrame(this);
		
		JPanel panelCreatePeriod = new JPanel();
		getContentPane().add(panelCreatePeriod, BorderLayout.CENTER);
		panelCreatePeriod.setLayout(null);
		
			JLabel lblNombreDelPeriodo = new JLabel("Nombre Del Periodo");
			lblNombreDelPeriodo.setFont(new Font("SansSerif", Font.BOLD, 14));
			lblNombreDelPeriodo.setBounds(22, 15, 145, 26);
			panelCreatePeriod.add(lblNombreDelPeriodo);
			
			JLabel lblEstadoDelPeriodo = new JLabel("Estado Del Periodo");
			lblEstadoDelPeriodo.setFont(new Font("SansSerif", Font.BOLD, 14));
			lblEstadoDelPeriodo.setBounds(22, 53, 145, 26);
			panelCreatePeriod.add(lblEstadoDelPeriodo);
			
			formattedTextFieldNombreDelPeriodo = new JFormattedTextField(new MaskFormatter("####-#"));
			formattedTextFieldNombreDelPeriodo.setFocusLostBehavior(JFormattedTextField.PERSIST);
			formattedTextFieldNombreDelPeriodo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			formattedTextFieldNombreDelPeriodo.setBounds(179, 15, 112, 28);
			panelCreatePeriod.add(formattedTextFieldNombreDelPeriodo);
			
			comboBoxEstadoDelPeriodo = new JComboBox<String>();
			comboBoxEstadoDelPeriodo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Activo", "Cerrado"}));
			comboBoxEstadoDelPeriodo.setBounds(177, 54, 117, 26);
			panelCreatePeriod.add(comboBoxEstadoDelPeriodo);
			
			JPanel panelBotones = new JPanel();
			panelBotones.setLayout(null);
			panelBotones.setBounds(0, 153, 407, 48);
			panelCreatePeriod.add(panelBotones);
			
			btnNuevo = new JButton("Nuevo");
			btnNuevo.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnNuevo.setBounds(0, 11, 78, 36);
			panelBotones.add(btnNuevo);
			
			btnGuardar = new JButton("Guardar");
			btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnGuardar.setBounds(114, 11, 78, 36);
			panelBotones.add(btnGuardar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnCancelar.setBounds(224, 11, 80, 36);
			panelBotones.add(btnCancelar);
			
			btnSalir = new JButton("Salir");
			btnSalir.setFont(new Font("SansSerif", Font.BOLD, 12));
			btnSalir.setBounds(329, 11, 78, 36);
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
			panelBotones.add(btnSalir);
	}
}
