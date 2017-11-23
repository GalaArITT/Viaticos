/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefeDpto;

import Solicitud.Solicitud_controlador;

/**
 *
 * @author fernando
 */
public class registrosSolicitud {
    public String[][] traerSolicitudes()
   {
       Solicitud_controlador objUsuario=new Solicitud_controlador();
       String arregloSolicitudes[][]=objUsuario.traerSolicitudes();
       return arregloSolicitudes;
   }
    
   public String[][] busquedaEnTabla(String cadenaEntrada,String arregloSolicitudesGeneral[][])
   {
    String [][] resultadoBusqueda=new String[1][12];
    
    for(int i=0;i<arregloSolicitudesGeneral.length;i++)
    {
       if(arregloSolicitudesGeneral[i][0].equals(cadenaEntrada))
       {
          resultadoBusqueda[0][0]=arregloSolicitudesGeneral[i][0];
          resultadoBusqueda[0][1]=arregloSolicitudesGeneral[i][1];
          resultadoBusqueda[0][2]=arregloSolicitudesGeneral[i][2];
          resultadoBusqueda[0][3]=arregloSolicitudesGeneral[i][3];
          resultadoBusqueda[0][4]=arregloSolicitudesGeneral[i][4];
          resultadoBusqueda[0][5]=arregloSolicitudesGeneral[i][5];
          resultadoBusqueda[0][6]=arregloSolicitudesGeneral[i][6];
          resultadoBusqueda[0][7]=arregloSolicitudesGeneral[i][7];
          resultadoBusqueda[0][8]=arregloSolicitudesGeneral[i][8];
          resultadoBusqueda[0][9]=arregloSolicitudesGeneral[i][9];
          resultadoBusqueda[0][10]=arregloSolicitudesGeneral[i][10];
          resultadoBusqueda[0][11]=arregloSolicitudesGeneral[i][11];
       }
    }
    return resultadoBusqueda;
   }
  
}
