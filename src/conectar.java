
 

 
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
            conectar=DriverManager.getConnection("jdbc:mysql://localhost:3306/ine_inventarios","root","");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return conectar;
    }
     
}