/**
 * 
 */
package util;

import javax.swing.JOptionPane;

/**
 * @author mitchell
 *
 */
public class ValidateCedula {
		
	public static boolean validarCedula(String cedula) 
	{
		boolean valorDeRetorno = false;
		if (cedula.length() == 11) 
		{
			try 
			{
				int sumatoria = 0;

				for (int i = 1; i < cedula.length() - 1; i += 2) {
					Integer numeroActual = Integer.parseInt("" + cedula.charAt(i)) * 2;

					if (numeroActual >= 10) {
						numeroActual = (numeroActual / 10) + (numeroActual % 10);
					}
					
					sumatoria += Integer.parseInt("" + cedula.charAt(i - 1)) + numeroActual;
				}

				System.out.println("Sumatoria o Numero Esperado:" + sumatoria * 9 % 10);
				System.out.println("Integer.parseInt(cedula.charAt(10)) o Numero recibido:" + Integer.parseInt("" + cedula.charAt(10)));

				if (sumatoria * 9 % 10 == Integer.parseInt("" + cedula.charAt(10)))
				{
					valorDeRetorno = true;
					JOptionPane.showMessageDialog(null,"Es un numero de cedula Valido");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"No es un numero de cedula valido.");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"No es un numero de cedula valido. \n\nContiene caracteres no numericos");
			}
		} 
		else 
		{
			JOptionPane.showMessageDialog(null,"No es un numero de cedula valido, debe tener 11 numeros");
		}
		return valorDeRetorno;
	}

	public static void main(String[] args) {
		
		System.out.println(validarCedula("0710052876"));
	}

}
