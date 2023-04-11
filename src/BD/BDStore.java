package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entidades.Film;
import entidades.Store;

public class BDStore {
    
    private Connection conexion;

    public BDStore(Connection conexion) {
        this.conexion = conexion;
    }
/*
    public Store cargaStore(Store store) throws SQLException {
        return cargaStore(store.getStoreId());
    }
    
    public Store cargaStore(int store_id) throws SQLException {
        String sql_select = "SELECT * FROM store WHERE store_id = " + store_id;
        try {
            Statement statement = this.conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql_select);
            boolean encontrado = rs.next();
            if (encontrado) {
                // create store object
                Store store = new Store(rs.getInt("store_id"), rs.getInt("manager_staff_id"), rs.getInt("address_id"), rs.getTimestamp("last_update"));
                
                // load films for the store
                List<Film> films = new ArrayList<>();
                String sql_films = "SELECT * FROM film WHERE film_id IN (SELECT film_id FROM inventory WHERE store_id = " + store_id + ")";
                ResultSet rs_films = statement.executeQuery(sql_films);
                while (rs_films.next()) {
                    Film film = cargaFilm(rs_films.getInt("film_id"));
                    films.add(film);
                }
                store.setFilms(films);
                
                return store;
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
     */
    public void guardaStore(Store store) {
        try {
            Statement sentencia = this.conexion.createStatement();
            String sql_insert = "INSERT INTO store(store_id,manager_staff_id,address_id,last_update) VALUES (" 
                + store.getStoreId() + ", " + store.getManagerStaffId() + ", " + store.getAddressId() + ", " 
                + "TIMESTAMP '" + store.getLastUpdate() + "')";
            sentencia.executeUpdate(sql_insert);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al insertar store");
        }
    }


    public int eliminarStore(int store_id) throws SQLException {
        String sql_delete = "DELETE FROM store WHERE store_id = " + store_id;
        Statement stmt = this.conexion.createStatement();
        return stmt.executeUpdate(sql_delete);
    }

    public void actualizarStore(int storeId, int managerStaffId, int addressId, Timestamp lastUpdate) {
        // Crear la consulta SQL para actualizar los datos de la tienda
        String sql = "UPDATE store SET manager_staff_id = ?, address_id = ?, last_update = ? WHERE store_id = ?";
    
        // Crear un objeto PreparedStatement para ejecutar la consulta
        try (PreparedStatement pstmt = this.conexion.prepareStatement(sql)) {
            // Establecer los valores de los parámetros en la consulta
            pstmt.setInt(1, managerStaffId);
            pstmt.setInt(2, addressId);
            pstmt.setTimestamp(3, lastUpdate);
            pstmt.setInt(4, storeId);
    
            // Ejecutar la consulta
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Manejar cualquier excepción que pueda ocurrir
            e.printStackTrace();
        }
    }

    public List<Store> listarStore() {
        List<Store> lista = new ArrayList<>();
        String sql = "SELECT * FROM store";
        try {
            Statement consulta = this.conexion.createStatement();
            ResultSet resultado = consulta.executeQuery(sql);
            
            while (resultado.next()) {
                int store_id = resultado.getInt("store_id");
                int manager_staff_id = resultado.getInt("manager_staff_id");
                int address_id = resultado.getInt("address_id");
                Timestamp last_update = resultado.getTimestamp("last_update");
                
                Store store = new Store(store_id, manager_staff_id, address_id, last_update);
                lista.add(store);
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
