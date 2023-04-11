/*
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


 *
 * @author Sebastianaf
 
public class BDEmpleado {
    private Connection conexion;

    public BDEmpleado(Connection conexion){
        this.conexion = conexion;
     }

    public void insertar(Empleado empleado) {
        String sql = "INSERT INTO empleado (nombre, apellido, edad, cargo) VALUES (?, ?, ?, ?)";

        try{
             (PreparedStatement consulta = conexion.prepareStatement(sql)) {
            consulta.setString(1, empleado.getNombre());
            consulta.setString(2, empleado.getApellido());
            consulta.setInt(3, empleado.getEdad());
            consulta.setString(4, empleado.getCargo());

            consulta.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }catch(Exception e){ 
                System.out.println(e);
        }
        return 0;
    }

    public Empleado consultar(int id_empleado){
         Empleado empleado = new Empleado();
         String sql_select;
         sql_select="SELECT id_empleado, cargo_empleado, salario_empleado, email_empleado, cod_area, id_jefe, usuario_empleado, contrasena_empleado FROM empleado WHERE id_empleado ="+id_empleado+"";
          try{
             Connection conn = fachadaBD.getConnetion();
             Statement sentencia = conn.createStatement();
             ResultSet tabla = sentencia.executeQuery(sql_select);
             
             while(tabla.next()){ 
                empleado.setId(tabla.getInt(1));
                empleado.setCargo(tabla.getString(2));
                empleado.setSalario(tabla.getInt(3));
                empleado.setEmail(tabla.getString(4));  
                empleado.setArea(tabla.getInt(5));
                empleado.setJefe(tabla.getInt(6));
                empleado.setUsuario(tabla.getString(7));
                empleado.setContrasena_empleado(tabla.getString(8));
             }         
             return empleado;
          }
          catch(SQLException e){ System.out.println(e); }
          catch(Exception e){ System.out.println(e); }
         return null;
     }

    public void modificar(Empleado empleado) {
            String sql = "UPDATE empleado SET nombre=?, apellido=?, edad=?, cargo=? WHERE id=?";
      
            try (PreparedStatement consulta = conexion.prepareStatement(sql)) {
               consulta.setString(1, empleado.getNombre());
               consulta.setString(2, empleado.getApellido());
               consulta.setInt(3, empleado.getEdad());
               consulta.setString(4, empleado.getCargo());
               consulta.setInt(5, empleado.getId());
      
               consulta.executeUpdate();
            }catch(SQLException e){
               System.out.println(e); 
               }
           catch(Exception e){ 
               System.out.println(e);
           }
         }

    public void eliminar(int id_empleado){
        String sql = "DELETE FROM empleado WHERE id=?";

        try (PreparedStatement consulta = conexion.prepareStatement(sql)) {
           consulta.setInt(1, id);
  
           consulta.executeUpdate();
        }
     }catch(

    SQLException e)
    {
        System.out.println(e);
    }catch(
    Exception e)
    {
        System.out.println(e);
    }return 0;
    }

    public int loguear(String user, String pass){
         int id = 0;
         String sql_select;
         sql_select="SELECT id_empleado FROM empleado WHERE usuario_empleado ='"+user+"' AND contrasena_empleado ='"+pass+"'";
          try{
             Connection conn = fachadaBD.getConnetion();
             Statement sentencia = conn.createStatement();
             ResultSet tabla = sentencia.executeQuery(sql_select);
             
             while(tabla.next()){ 
                id = tabla.getInt(1);
             }         
             return id;
          }
          catch(SQLException e){ System.out.println(e); }
          catch(Exception e){ System.out.println(e); }
         return id;
     }

    public int cambiarContrasena(String user, String pass){
         String sql_update;
         int numFilas=0;
         sql_update="UPDATE empleado SET contrasena_empleado = '" +pass+ "' WHERE usuario_empleado ='"+user+"'";
         try{
             Connection conn = fachadaBD.getConnetion();
             Statement sentencia = conn.createStatement();
             numFilas = sentencia.executeUpdate(sql_update);
             return numFilas;          
         }
         catch(SQLException e){
             System.out.println(e); 
             }
         catch(Exception e){ 
             System.out.println(e);
         }
         return 0;
     }

    public List<Empleado> listar(){
        List<Empleado> lista = new ArrayList<>();

        String sql = "SELECT * FROM empleado";
        try {
            Statement consulta = conexion.createStatement();
            ResultSet resultado = consulta.executeQuery(sql)) {
  
           while (resultado.next()) {
              int id = resultado.getInt("id");
              String nombre = resultado.getString("nombre");
              String apellido = resultado.getString("apellido");
              int edad = resultado.getInt("edad");
              String cargo = resultado.getString("cargo");
  
              Empleado empleado = new Empleado(id, nombre, apellido, edad, cargo);
              lista.add(empleado);
           }
        }
  
        return lista;
     }
          catch(SQLException e){ System.out.println(e); }
          catch(Exception e){ System.out.println(e); }
         return listaEmpleados;
     }
}
**/