/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitud;

import java.util.Date;

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
    private Date fechaSalida;
    
    public Solicitud_modelo() {
        
    }
    public Solicitud_modelo(String tipoSolicitud, String lugar, String actividad, 
        int idUsuario,int idProducto, String pernoctado, Date fechaSalida) {   
        this.tipoSolicitud=tipoSolicitud;
        this.lugar=lugar;
        this.actividad=actividad;
        this.idUsuario=idUsuario;
        this.idProducto=idProducto;
        this.pernoctado=pernoctado;
        this.fechaSalida=fechaSalida;
    }
    
    public void insertaSolicitud(){
        
    }
    
}
