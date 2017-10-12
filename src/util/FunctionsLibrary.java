package util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * @author mitchell
 *
 */

public class FunctionsLibrary {
	
	//Funcion para que la posicion de una ventana ser en el centro de la pantalla
	public static void centrarVentana(Window ventana) 
	{
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int anchura = dimension.width;
		int altura = dimension.height;
		
		ventana.setLocation(anchura / 2 - ventana.getWidth() / 2, altura / 2 - ventana.getHeight() / 2);
	}
	
	//Funcion para que la posicion de una ventana ser en el centro del formulario
	public static void centrarVentanaInterna(JInternalFrame ventana) 
	{
		Dimension dimension = ventana.getParent().getSize();
		int anchura = dimension.width;
		int altura = dimension.height;
		
		ventana.setLocation(anchura / 2 - ventana.getWidth() / 2, altura / 2 - ventana.getHeight() / 2);
	}

	//cambia a apariencia de Nimbus
	public static void cambiarANimbus(Component componente) 
	{
		LookAndFeelInfo[] apariencias = UIManager.getInstalledLookAndFeels();
		for(LookAndFeelInfo apariencia:apariencias)
		{
			if (apariencia.getName().equals("Nimbus"))
			{
				try {
					UIManager.setLookAndFeel(apariencia.getClassName());
					SwingUtilities.updateComponentTreeUI(componente); 
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//quitar botones del sistema JInternalFrame
    public static void quitarBotonesDelSistemaJInternalFrame(JInternalFrame ventanaInternal)
    {
    	ventanaInternal.setIconifiable(false);
    	ventanaInternal.setMaximizable(false);
    	ventanaInternal.setClosable(false);
    }
	
	//Funcion para quitar el boton izquierdo de un jInternalFrame
	public static void quitarBotonEsquinaIzquierdaJInternalFrame(JInternalFrame ventanaInterna) 
	{	
		BasicInternalFrameUI interfaz = (BasicInternalFrameUI) ventanaInterna.getUI();
		Container barraTitulo = (Container) interfaz.getNorthPane();
		barraTitulo.remove(0);
		barraTitulo.validate();
	}
	
	
	//controla que solo se escriban letras en los jTextField especificado 
	public static void soloLetras(JTextField jTF)
	{
		jTF.addKeyListener(new KeyAdapter() 
		{
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if(Character.isDigit(c))
				{
					e.consume();
				}
			}
		});
	}
	
	//controla que solo se escriban numeros en los jTextField especificado 
	public static void soloNumeros(JTextField jTF)
	{
		jTF.addKeyListener(new KeyAdapter() 
		{
			public void keyTyped(KeyEvent e)
			{
				char c = e.getKeyChar();
				if(Character.isLetter(c))
				{
					e.consume();
				}
			}
		});
	}

	//limpia los campos en los textField
	public static void limpiarCampos(Container contenedor) 
	{	
		Component[] componentes = contenedor.getComponents();
		for (int i = 0; i < componentes.length; i++)
		{
			if (componentes[i] instanceof JTextField)
			{
				((JTextField)componentes[i]).setText("");
			}
		}
	}
	
	//limpia los campos en las tablas
	public static void limpiarTabla(JTable tablaActual) 
	{
		for (int i = 0; i < tablaActual.getRowCount(); i++) 
		{
			for (int j = 0; j < tablaActual.getColumnCount(); j++) 
			{
				tablaActual.getModel().setValueAt(null, i, j);				
			}
		}
	}
}






















