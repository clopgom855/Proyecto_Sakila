package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import entidades.Actor;
import entidades.Film;

public class BDActor {
    private Connection conexion;

    public BDActor(Connection conexion) {
        this.conexion = conexion;
    }

    public Actor cargaActor(Actor actor) throws SQLException {
        return cargaActor(actor.getActor_id());
    }

    public Actor cargaActor(int actor_id) throws SQLException {

        String sql_insert = "SELECT * FROM actor";
        try {
            Statement sentencia = this.conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(sql_insert);
            boolean encontrado = rs.next();
            if (encontrado) {
                System.out.println("Nombre: " + rs.getString("first_name") + " Apellido: " + rs.getString("last_name"));
                // guardamos en dos variables de trabajo los datos y creamos un actor.
            }

            return null;
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }

    public void guardaActor(Actor actor) {

        try {
            /*
             * String sql_insert =
             * "INSERT INTO actor(actor_id,first_name,last_name,last_update) VALUES (?, ?, ?, ?)"
             * ;
             * PreparedStatement pstmt = conn.prepareStatement(sql_insert);
             * pstmt.setInt(1, actor.getActor_id());
             * pstmt.setString(2, actor.getFirst_name());
             * pstmt.setString(3, actor.getLast_name());
             * pstmt.setTimestamp(4, actor.getLast_update());
             * int rowsAffected = pstmt.executeUpdate();
             */
            Statement sentencia = this.conexion.createStatement();

            String sql_insert = "INSERT INTO actor(actor_id,first_name,last_name,last_update) VALUES (" +
                    actor.getActor_id() + ", '" + actor.getFirst_name() + "', '" + actor.getLast_name() + "', '"
                    + actor.getLast_update() + "')";
            sentencia.executeUpdate(sql_insert);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al insertar actor");
        }
    }

    public int eliminarActor(int actor_id) throws SQLException {
        /*
         * String sql_delete = "DELETE FROM actor WHERE actor_id = ?";
         * PreparedStatement pstmt = conn.prepareStatement(sql_delete);
         * pstmt.setInt(1, actor.getActor_id());
         * int rowsAffected = pstmt.executeUpdate();
         */

        String sql_delete = "DELETE FROM actor WHERE actor_id = " + actor_id;
        Statement stmt = this.conexion.createStatement();
        return stmt.executeUpdate(sql_delete);

    }

    public int eliminarActor(Actor a) throws SQLException {
        int actor_id = a.getActor_id();
        return eliminarActor(actor_id);
    }

    public void actualizarActor(int actorId, String firstName, String lastName) {
        // Crear la consulta SQL para actualizar los datos del actor
        String sql = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";

        // Crear un objeto PreparedStatement para ejecutar la consulta
        try (PreparedStatement pstmt = this.conexion.prepareStatement(sql)) {
            // Establecer los valores de los parámetros en la consulta
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, actorId);

            // Ejecutar la consulta
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Manejar cualquier excepción que pueda ocurrir
            e.printStackTrace();
        }
    }

    public ArrayList<Actor> listar() {

        ArrayList<Actor> lista = new ArrayList<>();

        String sql = "SELECT * FROM actor";

        try {
            Statement consulta = this.conexion.createStatement();
            ResultSet resultado = consulta.executeQuery(sql);

            while (resultado.next()) {
                int actor_id = resultado.getInt("actor_id");
                String nombre = resultado.getString("first_name");
                String apellido = resultado.getString("last_name");

                Actor actor = new Actor(actor_id, nombre, apellido, null);

                lista.add(actor);
            }

            return lista;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    public List<Film> getFilmsByActor(int actorId) throws SQLException {

        List<Film> films = new ArrayList<>();
        String query = "SELECT Film.* FROM Film " +
                    "JOIN Film_actor ON Film.filmId = Film_actor.filmId " +
                    "JOIN Actor ON Actor.actorId = Film_actor.actorId " +
                    "WHERE Actor.actorId = ?";
                    
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setInt(1, actorId);
            ResultSet rs = stmt.executeQuery();
            Film film = null;
            while (rs.next()) {
                // Crea una nueva instancia de Film y agrega sus atributos
                // desde el ResultSet
                film = new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"),
                rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("orginal_language_id"), rs.getInt("rental_duration"), rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"), rs.getString("rating"));
                    film.setFilm_id(rs.getInt("filmID"));
        
                films.add(film);
            }

        return films;

        }
}
