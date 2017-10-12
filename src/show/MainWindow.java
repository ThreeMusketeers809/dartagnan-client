/**
 * 
 */
package show;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import static util.FunctionsLibrary.*;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author mitchell
 *
 */

public class MainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	//private JDesktopPane desktopPane;
	public static JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 * Create the frame.
	 */
	
	public MainWindow() {
		setTitle("Ingles De Inmersion UASD - Nagua");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 640);
		
		desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);	//Maximiza la ventana cuando se abre
		centrarVentana(this);	//Pone la ventana en el centro cuando se minimiza.
		cambiarANimbus(this);	//Cambia la apariencia a Nimbus
		
		/* Agregamos una barra de Menu.
		--------------------------------------------------------------------------------------------------------------------------*/
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
			
			/* Agregamos el Menu Estudiante.
			----------------------------------------------------------------------------------------------------------------------*/
			JMenu mnStudents = new JMenu("Estudiantes");
			menuBar.add(mnStudents);
			
				/* Agregamos el Menu Item que llama a la ventana que contiene el fomulario de Registro de Estudiantes.
				----------------------------------------------------------------------------------------------------------------------*/
				JMenuItem mntmAddStudent = new JMenuItem("Regristar Estudiante");
					mntmAddStudent.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent arg0) 
						{
							StudentRegistration jStudentRegistration = null;
							try 
							{
								jStudentRegistration = new StudentRegistration();
							} 
							catch (Exception e) 
							{
								e.printStackTrace();
							}
							desktopPane.add(jStudentRegistration);
							centrarVentanaInterna(jStudentRegistration);
							jStudentRegistration.setVisible(true);					
						}
					});
				mnStudents.add(mntmAddStudent);
				//----------------------------------------------------------------------------------------------------------------------
								
			/* Agregamos el Menu Administrativo.
			--------------------------------------------------------------------------------------------------------------------------*/
			JMenu mnAdministrativo = new JMenu("Administrativo");
			menuBar.add(mnAdministrativo);
			
				/* Agregamos el Menu Item que llama a la ventana que contiene el fomulario de Creacion de Grupo.
				----------------------------------------------------------------------------------------------------------------------*/
				JMenuItem mntmCrearPeriodo = new JMenuItem("Crear Periodo");
					mntmCrearPeriodo.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent arg0) 
							{
								CreatePeriod jCreatePeriod = null;
								try 
								{
									jCreatePeriod = new CreatePeriod();
								} 
								catch (Exception e) 
								{
									e.printStackTrace();
								}
								desktopPane.add(jCreatePeriod);
								centrarVentanaInterna(jCreatePeriod);
								jCreatePeriod.setVisible(true);					
							}
						});				
				mnAdministrativo.add(mntmCrearPeriodo);
				//----------------------------------------------------------------------------------------------
			
				/* Agregamos el Menu que llama a la ventana que contiene el fomulario de Registro de Empleados.
				----------------------------------------------------------------------------------------------------------------------*/
				JMenu mnEmpleados = new JMenu("Empleados");
				mnAdministrativo.add(mnEmpleados);
				
				// Agregamos el Menu Item que llama a la ventana que contiene el fomulario de Registro de Empleados.
				JMenuItem mntmAddEmpleado = new JMenuItem("Registrar Empleado");
				mnEmpleados.add(mntmAddEmpleado);
				mntmAddEmpleado.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						EmployeeRegistration jTeacherRegistration = null;
						try 
						{
							jTeacherRegistration = new EmployeeRegistration();
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}
						desktopPane.add(jTeacherRegistration);
						centrarVentanaInterna(jTeacherRegistration);
						jTeacherRegistration.setVisible(true);					
					}
				});
				
				JMenu mnGrupos = new JMenu("Grupos");
				mnAdministrativo.add(mnGrupos);
				
					/* Agregamos el Menu Item que llama a la ventana que contiene el fomulario de Crear Grupos.*/
					JMenuItem mntmCreateGroup = new JMenuItem("Crear Grupo");
					mntmCreateGroup.addActionListener(new ActionListener() 
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
							desktopPane.add(jCreateGroup);
							centrarVentanaInterna(jCreateGroup);
							jCreateGroup.setVisible(true);					
						}
					});
				mnGrupos.add(mntmCreateGroup);
				//----------------------------------------------------------------------------------------------------------------------
					
					/* Agregamos el Menu Item que llama a la ventana que contiene el fomulario de Asignar Estudiantes.*/
					JMenuItem mntmExchangeOfInformation = new JMenuItem("Intercambio De Informacion");
					mntmExchangeOfInformation.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent arg0) 
						{
							ExchangeOfInformation jExchangeOfInformation = null;
							try 
							{
								jExchangeOfInformation = new ExchangeOfInformation();
							} 
							catch (Exception e) 
							{
								e.printStackTrace();
							}
							desktopPane.add(jExchangeOfInformation);
							centrarVentanaInterna(jExchangeOfInformation);
							jExchangeOfInformation.setVisible(true);					
						}
					});
				mnGrupos.add(mntmExchangeOfInformation);
				//-----------------------------------------------------------------------------------------------------------------------
							
			/* Agregamos el Menu Usuario.
			--------------------------------------------------------------------------------------------------------------------------*/
			JMenu mnUsuario = new JMenu("Usuario");
			menuBar.add(mnUsuario);
			//--------------------------------------------------------------------------------------------------------------------------		
	}
	
	//Invoca en el metodo main del formulario la ventana interna del Login para al inicial el software no pasa hasta que no se verifica
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try
				{
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}