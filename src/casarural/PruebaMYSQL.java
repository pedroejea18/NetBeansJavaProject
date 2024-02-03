package casarural;


import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Clase de prueba de conexión con una base de datos MySQL
 */
public class PruebaMYSQL {
    
    /** 
     * Crea una instancia de la clase MySQL y realiza todo el código 
     * de conexión, consulta y muestra de resultados.
     */
    
    //String cadena;
    public PruebaMYSQL(String cadena,String tipoConsulta) 
    {
        // Se mete todo en un try por los posibles errores de MySQL
        try
        {
            // Se registra el Driver de MySQL
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/clientes","root", "");
            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            
            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
            ResultSet rs = s.executeQuery ("select * from usuarios where NIF='"+cadena+"'");
            
            // Si encuentra resultado muestra mensaje y si no avisa al usuario
            if (rs.next()){
                if (tipoConsulta=="recordar"){                 
                    JOptionPane.showMessageDialog(null, "NIF: "+rs.getString("NIF")+"\nContraseña: "+rs.getString("clave"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado ese NIF");
            }
            
            // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public PruebaMYSQL(String cadena, String pass, String tipoConsulta) 
    {
        // Se mete todo en un try por los posibles errores de MySQL
        try
        {
            // Se registra el Driver de MySQL
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            Connection conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/clientes","root", "");
            
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();
            
            // Se realiza la consulta. Los resultados se guardan en el 
            // ResultSet rs
            ResultSet rs = s.executeQuery ("select * from usuarios where NIF='"+cadena+"' and clave='"+pass+"'");
            
            // Si encuentra resultado muestra mensaje y si no avisa al usuario
            if (rs.next()){
                if (tipoConsulta=="ingresar"){                 
                    JOptionPane.showMessageDialog(null, "Bienvenido " + rs.getString("nombre"));
                }
            }else{
                JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            }
            
            // Se cierra la conexión con la base de datos.
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public PruebaMYSQL(String nif, String clave, String nombre, String apellido, String localidad, String telefono, String tipoConsulta) {
        try {
            // Registrar el Driver de MySQL
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost/clientes", "root", "");

            // Crear una PreparedStatement para la inserción
            String insertQuery = "INSERT INTO usuarios (NIF, clave, nombre, apellido, localidad, telefono) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(insertQuery);
            ps.setString(1, nif);
            ps.setString(2, clave);
            ps.setString(3, nombre);
            ps.setString(4, apellido);
            ps.setString(5, localidad);
            ps.setString(6, telefono);

            // Ejecutar la inserción y verificar si se realizó con éxito
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                if ("insertar".equals(tipoConsulta)) {
                    JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar registrarse");
            }

            // Cerrar la conexión con la base de datos
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos");
        }
    }

    
}