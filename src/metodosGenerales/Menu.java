package metodosGenerales;
import java.util.ArrayList;



/**
 * Esta clase representa el menú de la tienda.
 * @author 
 * @version 1.0
 */
public class Menu {

    /** 
     * Muestra el menú principal de opciones del programa. 
     */ 
 
     public static String menuPrincipal(){
        String titulo="Menu Principal";
        ArrayList<String> opciones = new ArrayList<String>();
        String opc_val="123";
        opciones.add("1. Muestra actor:");
        opciones.add("2. Muestra pelicula:");
        opciones.add("3. Salir");
        String mensajePregunta="¿Que opcion desea hacer?";

    return libreria.menu(titulo, opciones, opc_val, mensajePregunta);
    }

    public static String menuActor() {
            String titulo="Menu Actor";
            ArrayList<String> opciones = new ArrayList<String>();
            String opc_val="1234567";
            opciones.add("1. Muestra actor:");
            opciones.add("2. Inserta un Actor .");
            opciones.add("3. Elimina un Actor .");
            opciones.add("4. Actualiza los datos de un Actor .");
            opciones.add("5. Obtener la lista de todos los Actores.");
            opciones.add("6. Obtener la peliculas de un Actor .");
            opciones.add("7. Salir");
            String mensajePregunta="¿Que opcion desea hacer?";
    
        return libreria.menu(titulo, opciones, opc_val, mensajePregunta);
    }

    public static String menuFilm() {
        String titulo="Menu Actor";
            ArrayList<String> opciones = new ArrayList<String>();
            String opc_val="123456";
            opciones.add("1. Muestra Pelicula:");
            opciones.add("2. Inserta una Pelicula .");
            opciones.add("3. Elimina una Pelicula .");
            opciones.add("4. Actualiza los datos de una Pelicula .");
            opciones.add("5. Obtener la lista de todos los Pelicula.");
            opciones.add("6. Salir");
            String mensajePregunta="¿Que opcion desea hacer?";
    
        return libreria.menu(titulo, opciones, opc_val, mensajePregunta);
    }


}
