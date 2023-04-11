package UI;

import java.sql.Connection;
import BD.*;
import controlador.Controlador;
import metodosGenerales.Menu;
import metodosGenerales.libreria;

public class ConsoleInterface {

    /*
     * Esta clase proporciona una interfaz de consola para la aplicacion
     * 
     * El código es un menú de consola que utiliza una base de datos MySQL para realizar operaciones CRUD en dos tablas: Actores y Películas. 
     * 
     * El menú tiene tres opciones principales:
     * 
     * La opción 1 es para manejar los datos de los actores. 
     * La opción 2 es para manejar los datos de las películas. 
     * La opción 3 sirve para salir del programa. 

     El código instancia una conexión a la base de datos y luego crea objetos para trabajar con cada una de las dos tablas. 
     También crea un objeto Controlador que sirve como intermediario entre los objetos de base de datos y el menú de consola. 
     
     El código utiliza clases adicionales (como Menu.java y PideDatos.java) que definen métodos para mostrar menús y solicitar entradas al usuario. 
     

     Finalmente, el código utiliza un bucle while para mantener el menú activo hasta que el usuario decida salir del programa.
     
     */

    public static void run() {
        try {
            Connection conexion = BDGeneral.conectarMySQL();
            BDActor actor = new BDActor(conexion);
            BDFilm film = new BDFilm(conexion);
            Controlador control = new Controlador(actor, film);
            String opcionMenu_Principal;
            String opcionMenu_Actor;
            String opcionMenu_Film;
            //Film filmaso = new Film(2, "Título de prueba", "Descripción de prueba", 2021, 1, 1, 7, 2.99, 90, 14.99, "PG");

            switch (opcionMenu_Principal = Menu.menuPrincipal()) {
                case "1":
                    do {
                        switch (opcionMenu_Actor = Menu.menuActor()) {
                            case "1":
                                control.cargaActor(PideDatos.solicitaDato("Inserta el ID: ", int.class));
                                break;
                            case "2":
                                control.guardaActor(PideDatos.pideActor());
                                break;
                            case "3":
                                control.eliminarActor(PideDatos.solicitaDato("Inserta el ID: ", int.class));
                                break;
                            case "4":
                                control.actualizarActor(PideDatos.solicitaDato("Inserta el ID: ", int.class),
                                        PideDatos.solicitaDato("Inserta el nombre: ", String.class),
                                        PideDatos.solicitaDato("Inserta el apellido: ", String.class));
                                break;
                            case "5":
                                libreria.muestra_Objetos(control.obtenerActores());
                                break;
                            case "6":
                                control.obtener_films_from_Actor(PideDatos.solicitaDato("Inserta el ID del actor: ", int.class));

                            break;
                            case "7":
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (!opcionMenu_Actor.equals("7"));
                    break;
                case "2":
                    do {
                        switch (opcionMenu_Film = Menu.menuFilm()) {
                            case "1":
                                System.out.println("Obtener una Pelicula.");
                                control.cargarPelicula(PideDatos.solicitaDato("Inserta el ID: ", int.class));
                                break;
                            case "2":
                                System.out.println("Inserta un Pelicula.");
                                control.agregarPelicula(PideDatos.pideFilm());
                                break;
                            case "3":
                                System.out.println("Elimina un Pelicula.");
                                control.eliminarPelicula(PideDatos.solicitaDato("Inserta el ID: ", int.class));
                                break;
                            case "4":
                                System.out.println("Actualiza los datos de una Pelicula .");
                                control.actualizarPelicula(
                                        PideDatos.solicitaDato("Ingrese el ID de la película: ", int.class),
                                        PideDatos.solicitaDato("Ingrese el título de la película:", String.class),
                                        PideDatos.solicitaDato("Ingrese la descripción de la película:", String.class),
                                        PideDatos.solicitaDato("Ingrese el año de la película:", int.class));
                                break;
                            case "5":
                                System.out.println("Obtener la lista de todos las peliculas.");
                                control.obtenerPeliculas();
                                break;
                            case "6":
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida");
                                break;

                        }
                    } while (!opcionMenu_Film.equals("6"));
                    break;
                case "3":
                    System.out.println("Hasta luego!");
                    System.out.println("Saliendo del programa y guardando datos");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }while (!opcionMenu_Principal.equals("3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

