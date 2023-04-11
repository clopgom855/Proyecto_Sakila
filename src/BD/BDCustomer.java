package BD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entidades.Customer;

public class BDCustomer {

        private Connection conexion;
    
    public BDCustomer(Connection conexion) {
        this.conexion = conexion;
    }

    public Customer cargaCustomer(Customer customer) throws SQLException {
        return cargaCustomer(customer.getCustomer_id());
    }
    
    public Customer cargaCustomer(int customer_id) throws SQLException {
        String sql_insert = "SELECT * FROM customer WHERE customer_id = " + customer_id;
        try {
            Statement sentencia = this.conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(sql_insert);
            boolean encontrado = rs.next();
            if (encontrado) {
                // create customer object
                Customer customer = new Customer(rs.getInt("customer_id"), rs.getInt("store_id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email"), rs.getInt("address_id"), rs.getBoolean("active"),
                        rs.getDate("create_date"), rs.getTimestamp("last_update"));
                System.out.println("Nombre: " + rs.getString("first_name") + " " + rs.getString("last_name"));
                return customer;
            }
            return null;
        } catch (Exception e) {
            System.out.println("error");
        }
        return null;
    }
    
    //Asumiendo que las clases Customer y Address ya estén definidas y que la conexión a la base de datos sea correcta.
    public void guardaCustomer(Customer customer) {
        try {
            Statement sentencia = this.conexion.createStatement();
            String sql_insert = "INSERT INTO customer(customer_id, store_id, first_name, last_name, email, address_id, active, create_date, last_update) VALUES ("
                    + customer.getCustomer_id() + ", " + customer.getStore_id() + ", '" + customer.getFirst_name() + "', '"
                    + customer.getLast_name() + "', '" + customer.getEmail() + "', " + customer.getAddress_id() + ", "
                    + customer.isActive() + ", DATE '" + new java.sql.Date(customer.getCreate_date().getTime()) + "', TIMESTAMP '"
                    + customer.getLast_update() + "')";
            sentencia.executeUpdate(sql_insert);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al insertar customer");
        }
    }


    public int eliminarCustomer(int customer_id) throws SQLException {
        String sql_delete = "DELETE FROM customer WHERE customer_id = " + customer_id;
        Statement stmt = this.conexion.createStatement();
        return stmt.executeUpdate(sql_delete);
    }
    
    public int eliminarCustomer(Customer customer) throws SQLException {
        int customer_id = customer.getCustomer_id();
        return eliminarCustomer(customer_id);
    }

    public void actualizarCustomer(int customer_id, String first_name, String last_name, String email, boolean active) {
        // Crear la consulta SQL para actualizar los datos del cliente
        String sql = "UPDATE customer SET first_name = ?, last_name = ?, email = ?, active = ? WHERE customer_id = ?";
    
        // Crear un objeto PreparedStatement para ejecutar la consulta
        try (PreparedStatement pstmt = this.conexion.prepareStatement(sql)) {
            // Establecer los valores de los parámetros en la consulta
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setBoolean(4, active);
            pstmt.setInt(5, customer_id);
    
            // Ejecutar la consulta
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Manejar cualquier excepción que pueda ocurrir
            e.printStackTrace();
        }
    }
    
    
    //Esta función recibe como parámetros el id del cliente (`customer_id`), el nombre (`first_name`), el apellido (`last_name`), el correo electrónico (`email`) y un indicador de si el cliente está activo o no (`active`). A continuación, crea una consulta SQL para actualizar los datos del cliente en base a los parámetros proporcionados y luego la ejecuta con un objeto `PreparedStatement` en la conexión a la base de datos.
    
    public List<Customer> listarCustomer() {
        List<Customer> lista = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try {
            Statement consulta = this.conexion.createStatement();
            ResultSet resultado = consulta.executeQuery(sql);
    
            while (resultado.next()) {
                int customer_id = resultado.getInt("customer_id");
                int store_id = resultado.getInt("store_id");
                String first_name = resultado.getString("first_name");
                String last_name = resultado.getString("last_name");
                String email = resultado.getString("email");
                int address_id = resultado.getInt("address_id");
                boolean active = resultado.getBoolean("active");
                Date create_date = resultado.getDate("create_date");
                Timestamp last_update = resultado.getTimestamp("last_update");
    
                Customer customer = new Customer(customer_id, store_id, first_name, last_name, email, address_id, active, create_date, last_update);
                lista.add(customer);
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
