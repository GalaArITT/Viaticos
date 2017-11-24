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
                              String pernoctado,String statusViatico,int idUsuario,int idVehiculo)
{
    Solicitud_modelo objetoSolicitud=new Solicitud_modelo(fechaSalida,personalViatico,diasViatico,lugarViatico,actividadViatico,
                                                          pernoctado,statusViatico,idUsuario,idVehiculo);
    objetoSolicitud.insertaSolicitud();
}

public void modificaSolicitud(int idFolio,Date fechaSalida,String personalViatico, int diasViatico,String lugarViatico,String actividadViatico,
                              String pernoctado,String statusViatico,int idUsuario,int idVehiculo)
{
    Solicitud_modelo objetoSolicitud=new Solicitud_modelo(idFolio,fechaSalida,personalViatico,diasViatico,lugarViatico,actividadViatico,
                                                          pernoctado,statusViatico,idUsuario,idVehiculo);
    objetoSolicitud.modificaSolicitud();
}

 public String [][] traerSolicitudes()
    {
      Solicitud_modelo objUsuarios=new Solicitud_modelo();
      String arregloSolicitudes[][]=objUsuarios.traerSolicitudesViaticos();
      return arregloSolicitudes;
    }
}
