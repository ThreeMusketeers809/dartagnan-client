/**
 * 
 */
package show;

import java.awt.EventQueue;
import static util.FunctionsLibrary.*;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.border.LineBorder;

/**
 * @author mitchell
 *
 */
public class ExchangeOfInformation extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> comboBoxPeriodo;
	private JTable table;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExchangeOfInformation frame = new ExchangeOfInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public ExchangeOfInformation() throws PropertyVetoException {
		setTitle("Intercambio De Informacion");
		setBounds(100, 100, 780, 480);
		quitarBotonEsquinaIzquierdaJInternalFrame(this);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 768, 449);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPeriodo.setBounds(48, 15, 65, 26);
		panel.add(lblPeriodo);
		
		JLabel lblProfesor = new JLabel("Profesor");
		lblProfesor.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblProfesor.setBounds(281, 15, 65, 26);
		panel.add(lblProfesor);
		
		comboBoxPeriodo = new JComboBox<String>();
		comboBoxPeriodo.setBounds(111, 15, 144, 26);
		panel.add(comboBoxPeriodo);
		
		JComboBox<String> comboBoxProfesor = new JComboBox<String>();
		comboBoxProfesor.setBounds(347, 15, 252, 26);
		panel.add(comboBoxProfesor);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 64, 756, 340);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
			JMenuBar menuBar = new JMenuBar();
			menuBar.setFont(new Font("SansSerif", Font.PLAIN, 14));
			menuBar.setBounds(0, 0, 758, 23);
			panel_1.add(menuBar);
			
				JMenu mnNuevo = new JMenu("Nuevo");
				mnNuevo.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnNuevo);
				
					JMenuItem mntmNuevoGrupo = new JMenuItem("Nuevo Grupo");
					mntmNuevoGrupo.setFont(new Font("SansSerif", Font.PLAIN, 12));
						mntmNuevoGrupo.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent arg0) 
							{
								CreateGroup jCreateGroup = null;
								try 
								{
									jCreateGroup = new CreateGroup();
								} 
								catch (Exception e) 
								{
									e.printStackTrace();
								}
								
								MainWindow.desktopPane.add(jCreateGroup);
								centrarVentanaInterna(jCreateGroup);
								jCreateGroup.setVisible(true);
							}
						});
					mnNuevo.add(mntmNuevoGrupo);
				
				JMenu mnAcciones = new JMenu("Acciones");
				mnAcciones.setFont(new Font("SansSerif", Font.PLAIN, 13));
				menuBar.add(mnAcciones);
				
					JMenuItem mntmAsignarEstudiantes = new JMenuItem("Asignar Estudiantes");
					mntmAsignarEstudiantes.setFont(new Font("SansSerif", Font.PLAIN, 12));
						mntmAsignarEstudiantes.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent arg0) 
							{
								AssingStudents jAssingStudents = null;
								try 
								{
									jAssingStudents = new AssingStudents();
								} 
								catch (Exception e) 
								{
									e.printStackTrace();
								}
								MainWindow.desktopPane.add(jAssingStudents);
								centrarVentanaInterna(jAssingStudents);
								jAssingStudents.setVisible(true);
								/*Funciona
								btnSalir.doClick(DISPOSE_ON_CLOSE); //cierra el formulario de INTERCAMBIO DE INFORMACION
								*/
							}
						});
					mnAcciones.add(mntmAsignarEstudiantes);
					
					JMenuItem mntmModificarGrupo = new JMenuItem("Modificar Grupo");
					mntmModificarGrupo.setFont(new Font("SansSerif", Font.PLAIN, 12));
					mnAcciones.add(mntmModificarGrupo);
					
					JMenuItem mntmImprimir = new JMenuItem("Imprimir Listado de Estudiantes");
					mntmImprimir.setFont(new Font("SansSerif", Font.PLAIN, 12));
					mnAcciones.add(mntmImprimir);
					
					JMenuItem mntmEliminarGrupo = new JMenuItem("Eliminar Grupo");
					mntmEliminarGrupo.setFont(new Font("SansSerif", Font.PLAIN, 12));
					mnAcciones.add(mntmEliminarGrupo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		scrollPane.setBounds(-2, 20, 760, 322);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFont(new Font("SansSerif", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Grupo", "C\u00F3digo", "Nivel", "Profesor"
			}
		) {
			
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().moveColumn(0, 0);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(0).setMinWidth(120);
		table.getColumnModel().getColumn(0).setMaxWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(1).setMaxWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
		table.getColumnModel().getColumn(2).setMinWidth(135);
		table.getColumnModel().getColumn(2).setMaxWidth(135);
		table.getColumnModel().getColumn(3).setPreferredWidth(400);
		table.getColumnModel().getColumn(3).setMinWidth(400);
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBuscar.setBounds(620, 10, 85, 36);
		panel.add(btnBuscar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSalir.setBounds(679, 407, 85, 36);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		panel.add(btnSalir);
	}
}
