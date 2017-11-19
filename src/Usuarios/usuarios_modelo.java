/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Conexion.Conexion;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class usuarios_modelo {

    public usuarios_modelo() {
    }
    
    public String [][] traerUsuarioTipoEmpleado()
    {
       int filas=obtenerNumeroResponsables();
        String arregloResponsables[][]=new String[filas][2];
        try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
             String sql="SELECT CONCAT(Nombre_Per,\" \",Ape_Pat_Per,\" \",Ape_Mat_Per,\" \") as 'responsable' ,idUsuario  FROM Persona\n" +
                    "INNER JOIN Empleado ON Empleado.Persona_idPersona = Persona.idPersona\n" +
                    "INNER JOIN Usuario ON Usuario.Empleado_RFC_Emp=Empleado.RFC_Emp";
            
             ResultSet resul=stm.executeQuery(sql);
             
               while(resul.next())
      {
          
          for(int fila=0;fila<arregloResponsables.length;fila++)
          {
              String responsable=resul.getString("responsable");
              String idResposable=String.valueOf(resul.getInt("idUsuario"));
               arregloResponsables[fila][0]=responsable;
               arregloResponsables[fila][1]=idResposable;
          }
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return arregloResponsables;
    }
    
    public int obtenerNumeroResponsables()
    {  int numeroResp=0;
        try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
             String sql="select count(*) as cantidad from empleado";
            
             ResultSet resul=stm.executeQuery(sql);
             
               while(resul.next())
      {
         numeroResp=resul.getInt("cantidad");
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numeroResp;
    }
}
