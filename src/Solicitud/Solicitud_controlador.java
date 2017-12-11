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

public void insertarSolicitud(int idUsuario,Date fechaSalida,String personalViatico,int diasViatico,String lugarViatico,String actividadViatico,
                              String pernoctado,String statusViatico,float monto,int idEmpleado,int idVehiculo)
{
    Solicitud_modelo objetoSolicitud=new Solicitud_modelo( idUsuario, fechaSalida, personalViatico, diasViatico, lugarViatico, actividadViatico,
                               pernoctado, statusViatico, monto, idEmpleado, idVehiculo);
    objetoSolicitud.insertaSolicitud();
}




public void modificaSolicitud(int idFolio,Date fechaSalida,String personalViatico, int diasViatico,String lugarViatico,String actividadViatico,
                              String pernoctado,String statusViatico,int idUsuario,int idVehiculo,float monto,int na)
{
    Solicitud_modelo objetoSolicitud=new Solicitud_modelo(idFolio,fechaSalida,personalViatico,diasViatico,lugarViatico,actividadViatico,
                                                          pernoctado,statusViatico,idUsuario,idVehiculo,monto,na);
    objetoSolicitud.modificaSolicitud();
}

 public String [][] traerSolicitudes(String status)
    {
      Solicitud_modelo objUsuarios=new Solicitud_modelo();
      String arregloSolicitudes[][]=objUsuarios.traerSolicitudesViaticos(status);
      return arregloSolicitudes;
    }
 
  public String [][] traerSolicitudesJefe(String status,int idUsuarioJefe)
    {
      Solicitud_modelo objUsuarios=new Solicitud_modelo();
      String arregloSolicitudes[][]=objUsuarios.traerSolicitudesViaticosJefe(status,idUsuarioJefe);
      return arregloSolicitudes;
    }
 
  public String [][] traerSolicitudesSecretaria(String status)
    {
      Solicitud_modelo objUsuarios=new Solicitud_modelo();
      String arregloSolicitudes[][]=objUsuarios.traerSolicitudesViaticosSecretaria(status);
      return arregloSolicitudes;
    }
 
 public String [][] traerComisionesEmpleado(String status, int idUsuarioEmpleado)
    {
      Solicitud_modelo objModelo=new Solicitud_modelo();
      String arregloSolicitudes[][]=objModelo.traerComisionesViaticosEmpleado(status,idUsuarioEmpleado);
      return arregloSolicitudes;
    }
 
  public String [][] traerComisiones(String status)
    {
      Solicitud_modelo objModelo=new Solicitud_modelo();
      String arregloSolicitudes[][]=objModelo.traerComisiones(status);
      return arregloSolicitudes;
    }
 
 public boolean modificarStatus(int idFolio,String status,String motivo)
 {
     Solicitud_modelo objSolicitud=new Solicitud_modelo(idFolio,status);
     boolean modificado=objSolicitud.modificaStatusSolicitud(motivo);
     return modificado;
 }
 
 public void marcarRealizada(int idFolio)
 {
   Solicitud_modelo objSolicitud=new Solicitud_modelo(idFolio);
   objSolicitud.marcarRealizada();
 }
 
 public void insertarKmInicial(int idFolio,String kmInicial,String descrip,int idVehiculo)
 {
   Solicitud_modelo objSolicitud=new Solicitud_modelo(idFolio);
   objSolicitud.insertarKmInicial(kmInicial,descrip,idVehiculo);
 }
 
 public void modificarKmFinal(String kmFinal, int idDatos)
 {
    Solicitud_modelo objSolicitud=new Solicitud_modelo();
   objSolicitud.modificarKmFinal(kmFinal,idDatos); 
 }
 
 public String[] traerDatosVehiculo(int idFolio)
 {
   Solicitud_modelo objSolicitud=new Solicitud_modelo(idFolio);
   String[] datosVehiculo=objSolicitud.traerDatosVehiculo();
   return datosVehiculo;
 }
 
 public void insertarActividad(String actividad,int idFolio,int idEmpleado)
 {
  Solicitud_modelo objSolicitud=new Solicitud_modelo(idFolio);
  objSolicitud.insertarActividad(actividad,idEmpleado);
 }
 
 public String [][] traerInformes(int idUsuarioEmpleado)
 {
     Solicitud_modelo objSolicitud=new Solicitud_modelo();
     String [][] informes=objSolicitud.traerInformes(idUsuarioEmpleado);
     return informes;
 }
 
  public String [][] traerInformes()
 {
     Solicitud_modelo objSolicitud=new Solicitud_modelo();
     String [][] informes=objSolicitud.traerInformes();
     return informes;
 }
}
