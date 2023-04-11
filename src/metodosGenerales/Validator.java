package metodosGenerales;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Validator {

    public static int validarEntradaEntero(String mensaje, int minValor, int maxValor) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println(mensaje);
            try {
                opcion = scanner.nextInt();
                validarRangoNumerico(opcion, minValor, maxValor);
                valido = true;
            } catch (InputMismatchException e) {
                System.err.println("Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return opcion;
    }

    public static boolean validarRangoNumerico(int numero, int minValor, int maxValor) throws Exception {
        if (numero >= minValor && numero <= maxValor) {
            // El valor está dentro del rango
            return true;
        } else {
            // El valor está fuera del rango
            throw new Exception("El valor está fuera del rango permitido");
        }
        
    }

    public static String validarCadenaNoVacia(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        String texto = "";

        do {
            System.out.println(mensaje);
            texto = scanner.nextLine();
            if (texto.isEmpty()) {
                System.err.println("Error: Debe ingresar un valor no vacío.");
            }
        } while (texto.isEmpty());

        return texto;
    }

    public static boolean validarLongitudCadena(String cadena, int minLongitud, int maxLongitud) {
        return cadena.length() >= minLongitud && cadena.length() <= maxLongitud;
    }


    public static boolean validarDni(String dni) {
		boolean valido = false;
		int numero;
		char letra;

		if (dni.length() == 9 && Character.isLetter(dni.charAt(8))) {
			numero = Integer.parseInt(dni.substring(0, 8));
			letra = dni.charAt(8);

			int resto = numero % 23;

			char[] letrasValidas = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P',
					'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
					
			char[] letrasValidas2 = {'t', 'r', 'w', 'a', 'g', 'm', 'y', 'f', 'p', 'd', 'x', 'b', 'n', 'j', 'z', 's', 'q', 'v', 'h', 'l','c','k','e' };

			if (letrasValidas[resto] == letra || letrasValidas2[resto] == letra) {
				valido = true;
			}
		}

		return valido;
	}

	public static boolean validarNumeroTelefono(int numero) {
		String numeroString = Integer.toString(numero);
		if (numeroString.length() == 9) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarOpcionMenu(String opcion, ArrayList opciones_validas) {
		return opciones_validas.contains(opcion);
	}

    public static boolean validarChar(char esCorrecto){
        if (esCorrecto != 's' && esCorrecto != 'n' && esCorrecto != 'N' && esCorrecto != 'S')
			throw new InputMismatchException("Error: Escribe 's' para aceptar o 'n' para cancelar");
            else
            return true;
    }

    
}
