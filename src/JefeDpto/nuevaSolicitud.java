/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefeDpto;

import java.util.Date;
import Solicitud.Solicitud_controlador;
import Usuarios.usuarios_controlador;
import javax.swing.DefaultListModel;

/**
 *
 * @author fernando
 */
public class nuevaSolicitud {
   public void insertaSolicitud(String tipoSolicitud, String lugar, String actividad, 
        int idUsuario,int idProducto, String pernoctado, Date fechaSalida)
   {
      Solicitud_controlador objetoSolicitud=new Solicitud_controlador();
      objetoSolicitud.insertarSolicitud(tipoSolicitud, lugar, actividad, idUsuario, idProducto, pernoctado, fechaSalida);
   }
   
   public String[][] traerResponsableALista()
   {
       usuarios_controlador objUsuario=new usuarios_controlador();
       String arregloEmpleados[][]=objUsuario.traerUsuarioTipoEmpleado();
       return arregloEmpleados;
   }
   
   public DefaultListModel<String> busquedaListaResponsables(String cadenaEntrada,DefaultListModel<String> modeloResponsables)
   {
     DefaultListModel<String> resultadosBusqueda=new  DefaultListModel<String>();
     String elementoModeloResponsable="";
     
     for(int i=0;i<modeloResponsables.size();i++)
     {  
         elementoModeloResponsable=modeloResponsables.get(i);
         System.out.println("Elemento tratado "+elementoModeloResponsable);
         if(elementoModeloResponsable.contains(cadenaEntrada))
         {
           System.out.println("El elemento "+elementoModeloResponsable+" coincide con "+cadenaEntrada);
           resultadosBusqueda.addElement(modeloResponsables.get(i));
         }
     }
     
     return resultadosBusqueda;
   }
}
