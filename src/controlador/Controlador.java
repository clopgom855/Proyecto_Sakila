package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BD.BDActor;
import BD.BDFilm;
import entidades.Actor;
import entidades.Film;

public class Controlador {
    /*
     * Esta clase obtiene los datos proporcionados por el usuario y les devuelve el resultado que le proporciona la llamada al modelo (la conexion con la bd).
     */
    
    private BDActor bdActor;
    private BDFilm  bdFilm;

    public Controlador(BDActor bdActor, BDFilm bdFilm) {
        this.bdActor = bdActor;
        this.bdFilm = bdFilm;
    }

    public void cargaActor(int actor_id) throws SQLException {
        // Llamar al método correspondiente en la clase BDActor para ver los datos de un actor en la base de datos
        bdActor.cargaActor(actor_id);
    }

    public void cargaActor(Actor a) throws SQLException {
        // Llamar al método correspondiente en la clase BDActor para ver los datos de un actor en la base de datos
        bdActor.cargaActor(a);
    }

    public void guardaActor(Actor a) {
        // Llamar al método correspondiente en la clase BDActor para agregar un nuevo
        // actor a la base de datos
        bdActor.guardaActor(a);
    }

    public void eliminarActor(int actorId) throws SQLException {
        // Llamar al método correspondiente en la clase BDActor para eliminar un actor
        // de la base de datos
        bdActor.eliminarActor(actorId);
    }

    public void actualizarActor(int actorId, String firstName, String lastName) {
        // Llamar al método correspondiente en la clase BDActor para actualizar los datos de un actor en la base de datos
        bdActor.actualizarActor(actorId, firstName, lastName);
    }

    public ArrayList<Object> obtenerActores() {
        // Llamar al método correspondiente en la clase BDActor para recuperar la lista
        // de actores de la base de datos
        return (ArrayList) bdActor.listar();
    }

    public List<Film> obtener_films_from_Actor(int actorId) throws SQLException{
        return bdActor.getFilmsByActor(actorId);
    }



    /**
     *  Métodos para películas
     * @throws SQLException
     * 
     *   */


    public void cargarPelicula(int film_id) throws SQLException{
        bdFilm.cargaFilm(film_id);
    }

    public void agregarPelicula(Film film) {
        bdFilm.guardaFilm(film);
    }

    public void actualizarPelicula(int filmId, String title, String description, int releaseYear) {
        bdFilm.actualizarFilm(filmId, title, description, releaseYear, releaseYear, releaseYear, releaseYear, releaseYear, releaseYear, releaseYear, description, null, null);
    }

    public void eliminarPelicula(int filmId) throws SQLException {
        bdFilm.eliminarFilm(filmId);
    }

    public List<Film> obtenerPeliculas() {
        return bdFilm.listarFilms();
    }

    // Agregar más métodos para otras entidades según sea necesario
   
}
