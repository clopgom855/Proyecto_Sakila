package BD;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * PARA CONECTAR CON UNA BASE DE DATOS NECESITO 4 COSAS:
 * 1. La base de datos tiene que tener soporte para java con un driver.
 * 2. Decirle a la conexion que driver tiene que usar y donde está la base de datos (tipicamente esto es la ip del servidor + puerto)
 * 3. A que database quiero acceder
 * 4. Pasarle las credenciales
 * (El objeto conexion ya abre la tubería para conectarse es decir una Conexion)
 * 5. STATEMENT : Objeto que me permite mandar sentencias SQL a traves de la conexion creada
 * 6. En el caso de que la sentencia sea un SELECT hay que hacer un ResulSet
 */
public class BDGeneral {
    public static Connection conexion = null;
    public static final String url = "jdbc:mysql://localhost:3306/sakila";
    public static final String username = "root";
    public static final String password = "root";

    public static Connection conectarMySQL() {

        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conexion;
        } else {
            return conexion;
        }
    }
}
