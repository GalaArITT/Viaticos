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
import javax.swing.JOptionPane;


/**
 *
 * @author oliver
 */
public class Solicitud_modelo {

     private java.sql.Date fechaSalida;
     private String personalViatico;
     private int diasViatico;
     private String lugarViatico;
     private String actividadViatico;
     private String pernoctado;
     private String statusViatico;
     private int idUsuario;
     private int idVehiculo;
     
     
    
    Conexion con = new Conexion();
    Connection conn = con.getConexion();
    
    public Solicitud_modelo() {
        
    }
    public Solicitud_modelo(Date fechaSalida,String personalViatico, int diasViatico,String lugarViatico,String actividadViatico,
                            String pernoctado,String statusViatico,int idUsuario,int idVehiculo) 
    {   
        this.fechaSalida = new java.sql.Date(fechaSalida.getTime());
        this.personalViatico=personalViatico;
        this.diasViatico=diasViatico;
        this.lugarViatico=lugarViatico;
        this.actividadViatico=actividadViatico;
        this.pernoctado=pernoctado;
        this.statusViatico=statusViatico;
        this.idUsuario=idUsuario;
        this.idVehiculo=idVehiculo;
        
        
    }
    
    public void insertaSolicitud()
    {
        try
        {
            String sqlSolicitud="insert into Solicitudes(tipoSolicitud,lugar,actividad,idUsuario,idProducto,"
             + "pernoctado,fechaSalida,Status_Sol,Fecha_Sol)"
                    + "values(?,?,?,?,?,?,?,'Pendiente',now())";
            
            String sqlSol="insert into solicitudes_viaticos("
                    + "fechaSolViatico,"
                    + "fechaSalidaViatico,"
                    + "personalViatico,"
                    + "diasViatico,"
                    + "lugarViatico,"
                    + "actividadViatico,"
                    + "pernoctado,"
                    + "statusViatico,"
                    + "idUsuario,"
                    + "idVehiculo"
                    + ")"
                    + "values(now(),?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sqlSol); 
            
            pst.setDate(1,fechaSalida);
            pst.setString(2,personalViatico);
            pst.setInt(3,diasViatico);
            pst.setString(4,lugarViatico);
            pst.setString(5,actividadViatico);
            pst.setString(6,pernoctado);
            pst.setString(7,statusViatico);
            pst.setInt(8,idUsuario);
            pst.setInt(9,idVehiculo);
            
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            JOptionPane.showMessageDialog(null,"Solicitud enviada para su revisión");
        }
    }
    
}
