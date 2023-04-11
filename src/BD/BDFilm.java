package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entidades.Film;

public class BDFilm {
    private Connection conexion;

    public BDFilm(Connection conexion) {
        this.conexion = conexion;
    }

    public Film cargaFilm(Film film) throws SQLException {
        return cargaFilm(film.getFilm_id());
    }

    public Film cargaFilm(int film_id) throws SQLException {

        String sql_insert = "SELECT * FROM film WHERE film_id = " + film_id;
        try {
            Statement sentencia = this.conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(sql_insert);
            boolean encontrado = rs.next();
            if (encontrado) {
                // create film object
                Film film = new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"),
                        rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("original_language_id"),
                        rs.getInt("rental_duration"), rs.getDouble("rental_rate"), rs.getInt("length"),
                        rs.getDouble("replacement_cost"), rs.getString("rating"));
                System.out.println("Titulo: " + rs.getString("title") + " Descripcion: " + rs.getString("description"));
                return film;
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void guardaFilm(Film film) {
        try {
            Statement sentencia = this.conexion.createStatement();
            String sql_insert = "INSERT INTO film(film_id,title,description,release_year,language_id,original_language_id,rental_duration,rental_rate,length,replacement_cost,rating) VALUES ("
                    +
                    film.getFilm_id() + ", '" + film.getTitle() + "', '" + film.getDescription() + "', "
                    + film.getRelease_year() + ", " + film.getLanguage_id() + ", " + film.getOriginal_language_id()
                    + ", " + film.getRental_duration() + ", " + film.getRental_rate() + ", " + film.getLength() + ", "
                    + film.getReplacement_cost() + ", '" + film.getRating() + "')";
            sentencia.executeUpdate(sql_insert);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al insertar film");
        }
    }

    public int eliminarFilm(int film_id) throws SQLException {

        String sql_delete = "DELETE FROM actor WHERE actor_id = " + film_id;
        Statement stmt = this.conexion.createStatement();
        return stmt.executeUpdate(sql_delete);

    }

    public int eliminarFilm(Film a) throws SQLException {
        int film_id = a.getFilm_id();
        return eliminarFilm(film_id);
    }

    public void actualizarFilm(int id, String title, String desc, int year, int lang_id, int orig_lang_id,
            int rent_dur, double rent_rate, int len, double repl_cost, String rating,
            String[] spec_feat, Timestamp last_upd) {

        String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, original_language_id = ?, "
                + "rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, "
                + "special_features = ?, last_update = ? WHERE film_id = ?";

        try (PreparedStatement pstmt = this.conexion.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, desc);
            pstmt.setInt(3, year);
            pstmt.setInt(4, lang_id);
            pstmt.setInt(5, orig_lang_id);
            pstmt.setInt(6, rent_dur);
            pstmt.setDouble(7, rent_rate);
            pstmt.setInt(8, len);
            pstmt.setDouble(9, repl_cost);
            pstmt.setString(10, rating);
            pstmt.setString(11, String.join(",", spec_feat)); // convert array to comma-separated string
            pstmt.setTimestamp(12, last_upd);
            pstmt.setInt(13, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

public List<Film> listarFilms() {
    List<Film> lista = new ArrayList<>();
    String sql = "SELECT * FROM film";
    try {
        Statement consulta = this.conexion.createStatement();
        ResultSet resultado = consulta.executeQuery(sql);

        while (resultado.next()) {
            int film_id = resultado.getInt("film_id");
            String title = resultado.getString("title");
            String description = resultado.getString("description");
            int release_year = resultado.getInt("release_year");
            int language_id = resultado.getInt("language_id");
            int original_language_id = resultado.getInt("original_language_id");
            int rental_duration = resultado.getInt("rental_duration");
            double rental_rate = resultado.getDouble("rental_rate");
            int length = resultado.getInt("length");
            double replacement_cost = resultado.getDouble("replacement_cost");
            String rating = resultado.getString("rating");
            String[] special_features = resultado.getString("special_features").split(",");
            Timestamp last_update = resultado.getTimestamp("last_update");

            Film film = new Film(film_id, title, description, release_year, language_id, original_language_id,
                    rental_duration, rental_rate, length, replacement_cost, rating);
            lista.add(film);
        }

        return lista;
    } catch (SQLException e) {
        System.out.println(e);
    } catch (Exception e) {
        System.out.println(e);
    }
    return lista;
}
}
