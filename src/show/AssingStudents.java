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
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;

/**
 * @author mitchell
 *
 */
public class AssingStudents extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnGuardar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssingStudents frame = new AssingStudents();
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
	public AssingStudents() {
		setTitle("Asignar Estudiantes");
		setBounds(100, 100, 780, 480);
		quitarBotonEsquinaIzquierdaJInternalFrame(this);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 768, 449);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		lblProfesor.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblProfesor.setBounds(6, 6, 65, 26);
		panel.add(lblProfesor);
		
		JLabel lblCargarProfesor = new JLabel("Aqui carga el nombre del profesor desde la base de datos");
		lblCargarProfesor.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblCargarProfesor.setBounds(83, 6, 347, 26);
		panel.add(lblCargarProfesor);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGrupo.setBounds(6, 33, 49, 26);
		panel.add(lblGrupo);
		
		JLabel lblCargaGrupo = new JLabel("Aqui Carga Codigo del Grupo, desde la base de datos");
		lblCargaGrupo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblCargaGrupo.setBounds(83, 33, 137, 26);
		panel.add(lblCargaGrupo);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(248, 33, 40, 26);
		panel.add(lblNivel);
		lblNivel.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		JLabel lblCargaNivel = new JLabel("Aqui Carga Nivel del Grupo, desde la base de datos");
		lblCargaNivel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblCargaNivel.setBounds(300, 33, 137, 26);
		panel.add(lblCargaNivel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 64, 756, 340);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
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
				{Boolean.FALSE, null, null, null},
			},
			new String[] {
				"Selecci\u00F3n", "C\u00E9dula", "Nombre(s)", "Apellido(s)"
			}
		) {
			
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setMinWidth(80);
		table.getColumnModel().getColumn(0).setMaxWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setMinWidth(120);
		table.getColumnModel().getColumn(1).setMaxWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setMinWidth(250);
		table.getColumnModel().getColumn(2).setMaxWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setMinWidth(250);
		scrollPane.setViewportView(table);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnGuardar.setBounds(582, 407, 85, 36);
		panel.add(btnGuardar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSalir.setBounds(679, 407, 85, 36);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnSalir);
	}
}
