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
public void insertarSolicitud(Date fechaSalida,String personalViatico, int diasViatico,String lugarViatico,String actividadViatico,
                              String pernoctado,String statusViatico,int idUsuario,int idVehiculo,float monto)
{
    Solicitud_modelo objetoSolicitud=new Solicitud_modelo(fechaSalida,personalViatico,diasViatico,lugarViatico,actividadViatico,
                                                          pernoctado,statusViatico,idUsuario,idVehiculo,monto);
    objetoSolicitud.insertaSolicitud();
}

public void modificaSolicitud(int idFolio,Date fechaSalida,String personalViatico, int diasViatico,String lugarViatico,String actividadViatico,
                              String pernoctado,String statusViatico,int idUsuario,int idVehiculo)
{
    Solicitud_modelo objetoSolicitud=new Solicitud_modelo(idFolio,fechaSalida,personalViatico,diasViatico,lugarViatico,actividadViatico,
                                                          pernoctado,statusViatico,idUsuario,idVehiculo);
    objetoSolicitud.modificaSolicitud();
}

 public String [][] traerSolicitudes(String status)
    {
      Solicitud_modelo objUsuarios=new Solicitud_modelo();
      String arregloSolicitudes[][]=objUsuarios.traerSolicitudesViaticos(status);
      return arregloSolicitudes;
    }
 
 public boolean modificarStatus(int idFolio,String status)
 {
     Solicitud_modelo objSolicitud=new Solicitud_modelo(idFolio,status);
     boolean modificado=objSolicitud.modificaStatusSolicitud();
     return modificado;
 }
}
