/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import Conexion.Conexion;
import Usuarios.usuarios_modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oliver
 */
public class vehiculos_modelo {

    public vehiculos_modelo() {
    }
    public String [][] traerProductoTipoVehiculo(){
        int filas=obtenerNumeroVehiculos();
        String arregloVehiculos[][]=new String[filas][2];
                try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
             String sql="select Nom_Prod as vehiculo, idProductos from productos "
                     + "inner join clasificacion on (productos.Clasificacion_idClasificacion=clasificacion.idClasificacion) "
                     + "where productos.Estado_idEstado=1 AND clasificacion.Nom_Clas=\"Equipo de transporte\"";
            
             ResultSet resul=stm.executeQuery(sql);
             
               while(resul.next())
      {
          
          int fila=resul.getRow()-1;
         
              String vehiculo=resul.getString("vehiculo");
              //me dice que Column 'idProductos' not found.
              String idProductos=String.valueOf(resul.getInt("idProductos"));
               arregloVehiculos[fila][0]=vehiculo;
               arregloVehiculos[fila][1]=idProductos;
          
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(vehiculos_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return arregloVehiculos;
    }
    public int obtenerNumeroVehiculos(){
        int numeroVehi=0;
        try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
             String sql="select COUNT(p.Nom_Prod) as vehiculo from productos as p "
                     + "inner join clasificacion as cl on (p.Clasificacion_idClasificacion=cl.idClasificacion) "
                     + "where p.Estado_idEstado=1 AND cl.Nom_Clas=\"Equipo de transporte\"";
            
             ResultSet resul=stm.executeQuery(sql);
             
               while(resul.next())
      {
         numeroVehi=resul.getInt("vehiculo");
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numeroVehi;
        
    }
}
