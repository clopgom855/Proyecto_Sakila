package UI;

import java.sql.Timestamp;
import java.util.Scanner;

import entidades.Actor;
import entidades.Film;
import metodosGenerales.Validator;

public class PideDatos {

    public static Actor pideActor(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el ID del actor: ");
        int actor_id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea 
        
        System.out.print("Ingrese el primer nombre del actor: ");
        String first_name = scanner.nextLine();
        
        System.out.print("Ingrese el apellido del actor: ");
        String last_name = scanner.nextLine();
        
        Timestamp last_update = new Timestamp(System.currentTimeMillis()); // Establecer la última actualización como el tiempo actual
        
        Actor actor = new Actor(actor_id, first_name, last_name, last_update);
        
        return actor;
        
    }

    public static Film pideFilm(){
        
  Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID de la película:");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume la nueva línea pendiente

        System.out.println("Ingrese el título de la película:");
        String title = scanner.nextLine();

        System.out.println("Ingrese la descripción de la película:");
        String desc = scanner.nextLine();

        System.out.println("Ingrese el año de la película:");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume la nueva línea pendiente

        System.out.println("Ingrese el ID del idioma:");
        int lang_id = scanner.nextInt();
        scanner.nextLine(); // consume la nueva línea pendiente

        System.out.println("Ingrese el ID del idioma original:");
        int orig_lang_id = scanner.nextInt();
        scanner.nextLine(); // consume la nueva línea pendiente

        System.out.println("Ingrese la duración del alquiler de la película:");
        int rent_dur = scanner.nextInt();
        scanner.nextLine(); // consume la nueva línea pendiente

        System.out.println("Ingrese la tarifa de alquiler de la película:");
        double rent_rate = scanner.nextDouble();
        scanner.nextLine(); // consume la nueva línea pendiente

        System.out.println("Ingrese la duración de la película:");
        int len = scanner.nextInt();
        scanner.nextLine(); // consume la nueva línea pendiente

        System.out.println("Ingrese el costo de reemplazo de la película:");
        double repl_cost = scanner.nextDouble();
        scanner.nextLine(); // consume la nueva línea pendiente

        System.out.println("Ingrese el rating de la película:");
        String rating = scanner.nextLine();

        Film myFilm = new Film(id, title, desc, year, lang_id, orig_lang_id, rent_dur, rent_rate, len, repl_cost, rating);

        return myFilm;
    }


    public static <T> T solicitaDato(String mensaje, Class<T> claseDato) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
    
        if (claseDato == int.class) {
            return (T) (Integer.valueOf(scanner.nextInt()));
        } else if (claseDato == double.class) {
            return (T) (Double.valueOf(scanner.nextDouble()));
        } else if (claseDato == String.class) {
            return (T) scanner.nextLine();
        } else {
            throw new Exception("Tipo de dato no compatible: " + claseDato.getName());
        }
    }
/* 
    public static int insertaID() throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserta el id: ");

        int id = scanner.nextInt();

        return id;
    }

    public static String insertaString(String mensaje) throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.println(mensaje);

        String string = scanner.nextLine();

        return string;
    }
    */
}
