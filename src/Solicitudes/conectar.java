package Solicitudes;


 

 
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Charlie
 */
public class conectar {
     Connection conectar=null;//conectar es el estatus de la conexión con la base de datos.
    //La función conectar es para hacer la conexión con la base de datos.
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ine_inventarios","root","");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return conectar;
    }
    
    public ResultSet getSolicitudes(String usr){
        Statement s;
        ResultSet r;
        String subQuery = "SELECT idUsuario FROM Usuario WHERE Empleado_RFC_Emp = "+usr;
        String query = "SELECT Status_Sol, Fecha_Sol, Tipo_Sol, Descripcion_Sol FROM Solicitudes"
                + " WHERE idUsuario_Sol = "+subQuery;
        try{
            s = conexion().createStatement();
            r = s.executeQuery(query);
        }catch(SQLException err){
            return null;
        }
        return r;
    }
    
}