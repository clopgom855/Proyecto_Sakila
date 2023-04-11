
package metodosGenerales;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Scanner;
public class libreria {

	
/** 
* Muestra un menú con un título, una lista de opciones y un mensaje de pregunta. El usuario debe ingresar una opción para que sea validada con respecto a la lista de opciones válidas.
* @param titulo El título del menú.
* @param opciones Un ArrayList con los objetos a mostrar en el menú.
* @param opciones_validas Un ArrayList con las opciones válidas para el menú.
* @param mensajePregunta El mensaje que se muestra al usuario para que ingrese una opción.
* @return La opción seleccionada por el usuario si es válida, o nulo en caso contrario. 
*/
	public static String menu(String titulo, ArrayList<?> opciones, ArrayList<String> opciones_validas,
			String mensajePregunta) {
		// Crea un objeto Scanner para leer datos del teclado
		Scanner scanner = new Scanner(System.in);

		pintaTitulo(titulo);

		// Muestra las opciones del menú al usuario
		muestra_Objetos((ArrayList) opciones);

		// Crea una variable para almacenar la opción seleccionada por el usuario
		String opcion = "";

		// Crea un bucle para mostrar el menú y permitir al usuario seleccionar una
		// opción
		while (true) {
			// Pide al usuario que ingrese una opción
			System.out.println(mensajePregunta);
			opcion = scanner.nextLine();

			// Utiliza la función que creamos para validar la opción seleccionada
			if (Validator.validarOpcionMenu(opcion, opciones_validas)) {
				return opcion;
			} else {
				// Si la opción es inválida, muestra un mensaje de error
				System.out.println("Opción inválida");
			}
		}

	}

	public static String menu(String titulo, ArrayList<?> opciones, String opciones_validas,
			String mensajePregunta) {

		ArrayList<String> opciones_ArrayList = new ArrayList<String>();
		for (int i = 0; i < opciones_validas.length(); i++) {
			opciones_ArrayList.add(Character.toString(opciones_validas.charAt(i)));
		}

		return menu(titulo, opciones, opciones_ArrayList, mensajePregunta);

	}

	public static void pintaTitulo(String titulo) {
		System.out.println();
		// Utiliza un bucle para imprimir una línea de asteriscos por encima y por
		// debajo del título
		pintaRaya(titulo, '*');
		// Muestra el título en la línea central, rodeado por espacios
		System.out.println("* " + titulo + " *");

		// Vuelve a imprimir una línea de asteriscos debajo del título
		pintaRaya(titulo, '*');
	}

	public static void pintaRaya(String titulo, char simbolo) {

		for (int i = 0; i < titulo.length() + 4; i++) {
			System.out.print(simbolo);
		}
		System.out.println();
	}

	public static void pintaRaya(int longitud, char simbolo) {

		for (int i = 0; i < longitud; i++) {
			System.out.print(simbolo);
		}
		System.out.println();

	}

	public static void muestra_Objetos(ArrayList<Object> objetos) {
		for (Object objeto : objetos) {
			System.out.println(objeto + "\n");
		}
	}

	public static String primeraLetraMayuscula(String palabra) {
		return palabra.substring(0, 1).toUpperCase() + palabra.substring(1);
	}

	public static void muestra_Objetos_enCajas(ArrayList<Object> objetos, int longitud, char simbolo) {

		for (Object objeto : objetos) {

			pintaRaya(longitud, simbolo);

			System.out.println(objeto);

			pintaRaya(longitud, simbolo);

		}
	}

	

	
/**
 * Crea un ArrayList con los tipos de dato de los atributos de una clase, incluyendo los de la superclase.
 * @param clase La clase a la que se le quiere obtener los tipos de dato.
 * @return Un ArrayList con los tipos de dato de los atributos.
 */ 
	public static ArrayList<Class<?>> creaArrayList_Tipos_de_dato(Class<?> clase) {

		ArrayList<Class<?>> tiposDeAtributos = new ArrayList<>();

		Class<?> superClase = clase.getSuperclass();

		java.lang.reflect.Field[] atributosSuperClase = superClase.getDeclaredFields();
		for (java.lang.reflect.Field atributo : atributosSuperClase) {
			tiposDeAtributos.add(atributo.getType());
		}

		java.lang.reflect.Field[] atributos = clase.getDeclaredFields();
		for (java.lang.reflect.Field atributo : atributos) {
			tiposDeAtributos.add(atributo.getType());
		}

		return tiposDeAtributos;
	}
/**
 * Crea un ArrayList con los nombres de los atributos de una clase, incluyendo los de la superclase. 
 * @param clase La clase a la que se le quiere obtener los nombres de atributos. 
 * @return Un ArrayList con los nombres de los atributos. 
 */ 
	public static ArrayList<String> creaArrayList_nombres_atributos(Class<?> clase) {
		ArrayList<String> nombresAtributos = new ArrayList<String>();

		Class<?> superClase = clase.getSuperclass();

		java.lang.reflect.Field[] atributosSuperClase = superClase.getDeclaredFields();
		for (java.lang.reflect.Field atributo : atributosSuperClase) {
			nombresAtributos.add(atributo.getName());
		}

		java.lang.reflect.Field[] atributos = clase.getDeclaredFields();
		for (java.lang.reflect.Field atributo : atributos) {
			nombresAtributos.add(atributo.getName());
		}

		return nombresAtributos;
	}

	
/**
 * Metodo que permite la creación de un objeto de una clase especifica, a partir de una lista de preguntas y respuestas.
 * @param preguntas Lista de preguntas que se le harán al usuario para la creación del objeto.
 * @param clase Clase del objeto a crear.
 * @return Objeto creado con las respuestas dadas por el usuario.
 */ 
	public static Object alta(ArrayList<String> preguntas, Class<?> clase) {
		Scanner entrada = new Scanner(System.in);

		ArrayList<Object> respuestas = new ArrayList<>();

		ArrayList<Class<?>> tipos = creaArrayList_Tipos_de_dato(clase);

		ArrayList<String> nombres = creaArrayList_nombres_atributos(clase);

		//muestra_Objetos((ArrayList) nombres);

		for (int i = 0; i < preguntas.size(); i++) {
			System.out.print(preguntas.get(i) /*+ tipos.get(i)*/ + " ");
			String respuesta = entrada.nextLine();

			if (tipos.get(i).getTypeName().equals("java.lang.String") && nombres.get(i).equals("dni")) {
				if (Validator.validarDni(respuesta)){
					respuestas.add(respuesta);
					System.out.println("Correcto");
				}
				else {
					i--;
				}
			}else if (tipos.get(i).getTypeName().equals("java.lang.String")) {
				respuestas.add(respuesta);
			} else if (tipos.get(i).getTypeName().equals("int") && nombres.get(i).equals("telefono")) {
				if(Validator.validarNumeroTelefono(Integer.parseInt(respuesta))){
					respuestas.add(Integer.parseInt(respuesta));
					System.out.println("Correcto");
				}else 
					i--;

			}else if (tipos.get(i).getTypeName().equals("int")) {
						respuestas.add(Integer.parseInt(respuesta));
			} else if (tipos.get(i).getTypeName().equals("double")) {
				respuestas.add(Double.parseDouble(respuesta));
			} else if (tipos.get(i).getTypeName().equals("char")) {
				respuestas.add(respuesta.charAt(0));
			}

		}
		return altaObjeto(respuestas, tipos, clase);

	}

	
/**
 * Crea un objeto de la clase especificada con los parámetros dados. 
 * 
 * @param respuestas Un ArrayList de objetos que contiene los parámetros para la creación del objeto.
 * @param tipos Un ArrayList de Class<?> que contiene los tipos de dato de los parámetros. 
 * @param clase La clase a partir de la cual se creará el objeto. 
 * @return El objeto creado, o null si no se pudo crear. 
 */
	public static Object altaObjeto(ArrayList<Object> respuestas, ArrayList<Class<?>> tipos, Class<?> clase) {
		Constructor<?> constructor;

		Object objeto = null;

		try {
			constructor = clase.getConstructor(tipos.toArray(new Class<?>[tipos.size()]));
			objeto = constructor.newInstance(respuestas.toArray());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objeto;
	}

}