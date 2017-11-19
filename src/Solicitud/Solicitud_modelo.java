/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitud;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JOptionPane;


/**
 *
 * @author oliver
 */
public class Solicitud_modelo {
    private String tipoSolicitud;
    private String lugar;
    private String actividad;
    private int idUsuario;
    private int idProducto;
    private String pernoctado;
    private java.sql.Date fechaSalida;
    
    Conexion con = new Conexion();
    Connection conn = con.getConexion();
    
    public Solicitud_modelo() {
        
    }
    public Solicitud_modelo(String tipoSolicitud, String lugar, String actividad, 
        int idUsuario,int idProducto, String pernoctado, Date fechaSalida) 
    {   
        this.tipoSolicitud=tipoSolicitud;
        this.lugar=lugar;
        this.actividad=actividad;
        this.idUsuario=idUsuario;
        this.idProducto=idProducto;
        this.pernoctado=pernoctado;
        this.fechaSalida = new java.sql.Date(fechaSalida.getTime());
    }
    
    public void insertaSolicitud()
    {
        try
        {
            String sqlSolicitud="insert into Solicitudes(tipoSolicitud,lugar,actividad,idUsuario,idProducto,"
             + "pernoctado,fechaSalida,Status_Sol,Fecha_Sol)"
                    + "values(?,?,?,?,?,?,?,'Pendiente',now())";

            PreparedStatement pst = conn.prepareStatement(sqlSolicitud); 
            
            pst.setString(1,tipoSolicitud);
            pst.setString(2,lugar);
            pst.setString(3,actividad);
            pst.setInt(4,idUsuario);
            pst.setInt(5,idProducto);
            pst.setString(6,pernoctado);
            pst.setDate(7,fechaSalida);
            pst.executeUpdate();
       }


        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            JOptionPane.showMessageDialog(null,"Datos insertados Correctamente");
        }
    }
    
}
