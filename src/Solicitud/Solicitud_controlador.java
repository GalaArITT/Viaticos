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
public class Solicitud_controlador {
public void insertarSolicitud(String tipoSolicitud, String lugar, String actividad, 
        int idUsuario,int idProducto, String pernoctado, Date fechaSalida)
{
    Solicitud_modelo objetoSolicitud=new Solicitud_modelo(tipoSolicitud,lugar,actividad,idUsuario,idProducto,pernoctado,fechaSalida);
    objetoSolicitud.insertaSolicitud();
}
}
