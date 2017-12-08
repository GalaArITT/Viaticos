/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitud;

import Conexion.Conexion;
import Usuarios.usuarios_modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     private int idSolicitud;
     private float monto;
     private int idEmpleado;
     
    
    Conexion con = new Conexion();
    Connection conn = con.getConexion();
    
    public Solicitud_modelo() {}
    
     public Solicitud_modelo(int idFolio) 
     {
      this.idSolicitud=idFolio;
     }
    
     public Solicitud_modelo(int idFolio,String statusViatico) 
     {
      this.idSolicitud=idFolio;
        this.statusViatico=statusViatico;
     }
     
     
    public Solicitud_modelo(int idEmpleado,Date fechaSalida,String personalViatico, int diasViatico,String lugarViatico,String actividadViatico,
                            String pernoctado,String statusViatico,int idUsuario,int idVehiculo,float monto) 
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
        this.monto=monto;
        this.idEmpleado=idEmpleado;
    }
    
    public Solicitud_modelo(int idSolicitud,Date fechaSalida,String personalViatico, int diasViatico,String lugarViatico,String actividadViatico,
                            String pernoctado,String statusViatico,int idUsuario,int idVehiculo,float monto,int na) 
    {   
        this.idSolicitud=idSolicitud;
        this.fechaSalida = new java.sql.Date(fechaSalida.getTime());
        this.personalViatico=personalViatico;
        this.diasViatico=diasViatico;
        this.lugarViatico=lugarViatico;
        this.actividadViatico=actividadViatico;
        this.pernoctado=pernoctado;
        this.statusViatico=statusViatico;
        this.idUsuario=idUsuario;
        this.idVehiculo=idVehiculo;
        this.monto=monto;
    }
    
    public int comprobarExistenciaSolicitudes()
    {
        int totalRegistros=0;
      
        try 
        {
             Conexion con=new Conexion();
             Connection conn=con.getConexion();
             Statement stm=conn.createStatement();

              String sqlBusca="SELECT count(idViaticos) as 'total' FROM solicitud_viaticos";

              ResultSet resul=stm.executeQuery(sqlBusca);

                while(resul.next())
                {
                  totalRegistros=resul.getInt("total");
                }
         } 

         catch (SQLException ex) 
         {
             Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
         }
        return totalRegistros;
    }
    
    
    public String generaFolio()
    {
        String folio="";
        int folioInt=0;
         try 
         {
             Conexion con=new Conexion();
             Connection conn=con.getConexion();
             Statement stm=conn.createStatement();

              String sql="select fol_viatico_int from Solicitud_Viaticos order by FehaSol_Viat desc limit 1";

              ResultSet resul=stm.executeQuery(sql);

                while(resul.next())
                {
                  folioInt=resul.getInt("fol_viatico_int");
                }
                
                if(folioInt==100)
                {
                   folio="0001"; 
                   folioInt=0;
                }

                else
                {
                    if(folioInt+1<=9)
                    {
                       folio="000"+String.valueOf(folioInt+1);
                    }

                    if(folioInt+1>=10 && folioInt+1<=99)
                    {
                       folio="00"+String.valueOf(folioInt+1);
                    }
                }
         } 

         catch (SQLException ex) 
         {
             Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
         }
        return folio+"-"+String.valueOf(folioInt+1);
    }
    
    public void insertaSolicitud()
    {
        String folioString="";
        int folioInt=0;
        if(comprobarExistenciaSolicitudes()==0)
        {
            folioString="0001";
            folioInt=1;
        }
        
        else
        {
            String[] folios=generaFolio().split("-");
            folioString=folios[0];
            folioInt=Integer.parseInt(folios[1]);
        }
        
        try
        {
            String sqlSol="insert into Solicitud_Viaticos("
                    + "Fol_Viat,"
                    + "fol_viatico_int,"
                    + "FehaSol_Viat,"
                    + "FechaSal_Viat,"
                    + "Personal_Viat,"
                    + "Lugar_Viat,"
                    + "Act_Viat,"
                    + "Status_Viat,"
                    + "idVehiculo_Viat,"
                    + "Permotado_Viat,"
                    + "Dias_Viat,"
                    + "monto"
                    + ")"
                    + "values(?,?,now(),?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement pst = conn.prepareStatement(sqlSol); 
            
            pst.setString(1,folioString);
            pst.setInt(2,folioInt);
            pst.setDate(3,fechaSalida);
            pst.setString(4,personalViatico);
            pst.setString(5,lugarViatico);
            pst.setString(6,actividadViatico);
            pst.setString(7,"Solicitada");
            pst.setInt(8,idVehiculo);
            pst.setString(9,pernoctado);
            pst.setInt(10,diasViatico);
            pst.setFloat(11,monto);
            
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            insertaUsuarioViatico();
            //insertarSolicitudDetalles();
            //insertarUsuarioDetalle();
            JOptionPane.showMessageDialog(null,"Solicitud enviada para su revisión");
        }
    }
    
    public void modificaSolicitud()
    {
        try
        {
            
            String sqlModSol="update Solicitud_Viaticos set "
                    + "Lugar_Viat=?,"
                    + "Act_Viat=?,"
                    + "idVehiculo_Viat=?,"
                    + "Permotado_Viat=?,"
                    + "FechaSal_Viat=?,"
                    + "Personal_Viat=?,"
                    + "Dias_Viat=?,"
                    + "monto=?"
                    + " where idViaticos=?";
            
            PreparedStatement pst = conn.prepareStatement(sqlModSol); 
            
            pst.setString(1,lugarViatico);
            pst.setString(2,actividadViatico);
            pst.setInt(3,idVehiculo);
            pst.setString(4,pernoctado);
            pst.setDate(5,fechaSalida);
            pst.setString(6,personalViatico);
             pst.setInt(7,diasViatico);
             pst.setFloat(8,monto);
            pst.setInt(9,idSolicitud);
            
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            JOptionPane.showMessageDialog(null,"Solicitud modificada exitosamente");
        }
    }
    
    public boolean modificaStatusSolicitud()
    {
        try
        {
            
            String sqlModSol="update Solicitud_Viaticos set "
                    + "Status_Viat=?"
                    + " where idViaticos=?";
            
            PreparedStatement pst = conn.prepareStatement(sqlModSol); 
            
            pst.setString(1,statusViatico);
            pst.setInt(2,idSolicitud);
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            JOptionPane.showMessageDialog(null,"Solicitud "+statusViatico);
            return true;
        }
    }
    
        
    public void insertarSolicitudDetalles()
    {
        try
        {
            String sqlSol="insert into Solicitudes("
                    + "Status_Sol,"
                    + "Fecha_Sol,"
                    + "Tipo_Sol,"
                    + "idUsuario_Sol,"
                    + "Descripcion_Sol"
                    + ")"
                    + "values(?,now(),?,?,?)";
            
            PreparedStatement pst = conn.prepareStatement(sqlSol); 
            
            pst.setString(1,"Solicitada");
            pst.setString(2,"Viatico");
            pst.setInt(3,idUsuario);
            pst.setString(4,lugarViatico+" "+actividadViatico);
           
             
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
          
        }
    }
    
    public void insertarUsuarioDetalle()
    {
        try
        {
            int idSolicitud=obtenIdSolicitud();
            String sqlSol="insert into Usr_Solc("
                    + "Solicitudes_idSolicitudes,"
                    + "Usuario_idUsuario"
                    + ")"
                    + "values(?,?)";
            
            PreparedStatement pst = conn.prepareStatement(sqlSol); 
            
            pst.setInt(1,idSolicitud);
            pst.setInt(2,idUsuario);
           
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
         
        }
    }
    
     public void insertaUsuarioViatico()
    {
        try
        {
            int idViatico=obtenIdViatico();
          
            String sqlSol="insert into usr_viaticos("
                    + "Usuario_idUsuario,"
                    + "Solicitud_Viaticos_idViaticos"
                    + ")"
                    + "values(?,?)";
            
            PreparedStatement pst = conn.prepareStatement(sqlSol); 
            
         
            pst.setInt(1,idUsuario);
             pst.setInt(2,idViatico);
           
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
         
        }
    }
    
    public int obtenIdSolicitud()
    {
        int idSolicitud=0;
        try 
        {
             Conexion con=new Conexion();
             Connection conn=con.getConexion();
             Statement stm=conn.createStatement();

              String sqlBusca="SELECT idSolicitudes FROM Solicitudes order by Fecha_Sol desc limit 1";

              ResultSet resul=stm.executeQuery(sqlBusca);

                while(resul.next())
                {
                  idSolicitud=resul.getInt("idSolicitudes");
                }
         } 

         catch (SQLException ex) 
         {
             Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
         }

        return idSolicitud;
    }
    
    public int obtenIdViatico()
    {
        int idViatico=0;
        try 
        {
             Conexion con=new Conexion();
             Connection conn=con.getConexion();
             Statement stm=conn.createStatement();

              String sqlBusca="SELECT idViaticos FROM solicitud_viaticos order by FehaSol_Viat desc limit 1";

              ResultSet resul=stm.executeQuery(sqlBusca);

                while(resul.next())
                {
                  idViatico=resul.getInt("idViaticos");
                }
         } 

         catch (SQLException ex) 
         {
             Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
         }

        return idViatico;
    }
    
    
     public String [][] traerSolicitudesViaticos(String status)
    {
       int filas=obtenerCantidadSolicitudes(status);
       
        String arregloSolicitudes[][]=new String[filas][13];
        try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
            String sql="select idViaticos,Fol_Viat,FechaSal_Viat,Personal_Viat," +
            "Dias_Viat,Lugar_Viat,Act_Viat,Permotado_Viat,Status_Viat," +
            "usr_viaticos.Usuario_idUsuario,nom_prod,idVehiculo_Viat,monto" +
            " from Solicitud_Viaticos " +
            " inner join productos ON productos.idProductos=Solicitud_Viaticos.idVehiculo_Viat" +
            " inner join usr_viaticos on usr_viaticos.Solicitud_Viaticos_idViaticos=solicitud_viaticos.idViaticos"
                    + " where Status_Viat='"+status+"'";
           
             ResultSet resul=stm.executeQuery(sql);
             DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

               while(resul.next())
      {        
               int fila=resul.getRow()-1;
               int idSolViatico=resul.getInt("idViaticos");
               String folViatico=resul.getString("Fol_Viat");
               Date fechaSalidaViatico=resul.getDate("FechaSal_Viat");
               String personalViatico=resul.getString("Personal_Viat");
               int diasViatico=resul.getInt("Dias_Viat");
               String lugarViatico=resul.getString("Lugar_Viat");
               String actividadViatico=resul.getString("Act_Viat");
               String pernoctado=resul.getString("Permotado_Viat");
               String statusViatico=resul.getString("Status_Viat");
               int idUsuario=resul.getInt("Usuario_idUsuario");
               String nom_prod=resul.getString("nom_prod");
               int idVehiculo=resul.getInt("idVehiculo_Viat");
               float monto=resul.getFloat("monto");
         
               arregloSolicitudes[fila][0]=String.valueOf(idSolViatico);
               arregloSolicitudes[fila][1]=String.valueOf(folViatico);
               arregloSolicitudes[fila][2]=df.format(fechaSalidaViatico);
               arregloSolicitudes[fila][3]=personalViatico;
               arregloSolicitudes[fila][4]=String.valueOf(diasViatico);
               arregloSolicitudes[fila][5]=lugarViatico;
               arregloSolicitudes[fila][6]=actividadViatico;
               arregloSolicitudes[fila][7]=pernoctado;
               arregloSolicitudes[fila][8]=statusViatico;
               arregloSolicitudes[fila][9]=String.valueOf(idUsuario);
               arregloSolicitudes[fila][10]=nom_prod;
               arregloSolicitudes[fila][11]=String.valueOf(idVehiculo);
               arregloSolicitudes[fila][12]=String.valueOf(monto);
            
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return arregloSolicitudes;
    }
    
    public int obtenerCantidadSolicitudes(String status)
    {
       int cantidadSol=0;
       try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
             String sql="select count(*) as cantidad from Solicitud_Viaticos where Status_Viat='"+status+"'";
            
             ResultSet resul=stm.executeQuery(sql);
             
               while(resul.next())
      {
         cantidadSol=resul.getInt("cantidad");
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
       return cantidadSol;
    }
    
    
    public int obtenerCantidadComisiones(String status)
    {
       int cantidadSol=0;
       try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
             String sql="select count(*) as cantidad from Solicitud_Viaticos where realizada='"+status+"'";
            
             ResultSet resul=stm.executeQuery(sql);
             
               while(resul.next())
      {
         cantidadSol=resul.getInt("cantidad");
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
       return cantidadSol;
    }
    
    public void marcarRealizada()
    {
        try
        {
            
            String sqlModSol="update Solicitud_Viaticos set "
                    + "realizada=?"
                    + " where idViaticos=?";
            
            PreparedStatement pst = conn.prepareStatement(sqlModSol); 
            
            pst.setString(1,"si");
            pst.setInt(2,idSolicitud);
            
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            JOptionPane.showMessageDialog(null,"Comisión marcada como realizada");
        }
    }
    
    public String [][] traerComisionesViaticos(String status)
    {
       int filas=obtenerCantidadComisiones(status);
       
        String arregloSolicitudes[][]=new String[filas][13];
        try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
            String sql="select idViaticos,Fol_Viat,FechaSal_Viat,Personal_Viat," +
            "Dias_Viat,Lugar_Viat,Act_Viat,Permotado_Viat,realizada," +
            "usr_viaticos.Usuario_idUsuario,nom_prod,idVehiculo_Viat,monto" +
            " from Solicitud_Viaticos " +
            " inner join productos ON productos.idProductos=Solicitud_Viaticos.idVehiculo_Viat" +
            " inner join usr_viaticos on usr_viaticos.Solicitud_Viaticos_idViaticos=solicitud_viaticos.idViaticos"
                    + " where realizada='"+status+"'";
            
           
             ResultSet resul=stm.executeQuery(sql);
             DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

               while(resul.next())
      {        
               int fila=resul.getRow()-1;
               int idSolViatico=resul.getInt("idViaticos");
               String folViatico=resul.getString("Fol_Viat");
               Date fechaSalidaViatico=resul.getDate("FechaSal_Viat");
               String personalViatico=resul.getString("Personal_Viat");
               int diasViatico=resul.getInt("Dias_Viat");
               String lugarViatico=resul.getString("Lugar_Viat");
               String actividadViatico=resul.getString("Act_Viat");
               String pernoctado=resul.getString("Permotado_Viat");
               String statusViatico=resul.getString("realizada");
               int idUsuario=resul.getInt("Usuario_idUsuario");
               String nom_prod=resul.getString("nom_prod");
               int idVehiculo=resul.getInt("idVehiculo_Viat");
               float monto=resul.getFloat("monto");
               
               arregloSolicitudes[fila][0]=String.valueOf(idSolViatico);
               arregloSolicitudes[fila][1]=String.valueOf(folViatico);
               arregloSolicitudes[fila][2]=df.format(fechaSalidaViatico);
               arregloSolicitudes[fila][3]=personalViatico;
               arregloSolicitudes[fila][4]=String.valueOf(diasViatico);
               arregloSolicitudes[fila][5]=lugarViatico;
               arregloSolicitudes[fila][6]=actividadViatico;
               arregloSolicitudes[fila][7]=pernoctado;
               arregloSolicitudes[fila][8]=statusViatico;
               arregloSolicitudes[fila][9]=String.valueOf(idUsuario);
               arregloSolicitudes[fila][10]=nom_prod;
               arregloSolicitudes[fila][11]=String.valueOf(idVehiculo);
               arregloSolicitudes[fila][12]=String.valueOf(monto);
            
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return arregloSolicitudes;
    }
    
    public void insertarKmInicial(String kmInicial,String descrip,int idVehiculo)
    {
        try
        {
            String sqlSol="insert into Datos_Vehiculo("
                    + "KmInicial,"
                    + "Descripcion,"
                    + "IdProducto,"
                    + "IdViaticos"
                    + ")"
                    + "values(?,?,?,?)";
            
            PreparedStatement pst = conn.prepareStatement(sqlSol); 
            
            pst.setString(1,kmInicial);
            pst.setString(2,descrip);
            pst.setInt(3,idVehiculo);
            pst.setInt(4,idSolicitud);
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            JOptionPane.showMessageDialog(null,"Kilometraje inicial agregado");
        }
    }
            
    public String[] traerDatosVehiculo()
    {
     String arregloDatosV[]=new String[3];
        try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
            String sql="select KmInicial,Descripcion,IdDatos from datos_vehiculo where IdViaticos="+idSolicitud;
           
             ResultSet resul=stm.executeQuery(sql);
            
             while(resul.next())
             {        
                String KmInicial=resul.getString("KmInicial");
                String Descripcion=resul.getString("Descripcion");
                int IdDatos=resul.getInt("IdDatos");
           
               arregloDatosV[0]=KmInicial;
               arregloDatosV[1]=Descripcion;
               arregloDatosV[2]=String.valueOf(IdDatos);
           }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return arregloDatosV;
    }
    
    public void modificarKmFinal(String kmFinal, int idDatos)
    {
        try
        {
            String sqlSol="update datos_vehiculo set"
                    + " KmFinal=?"
                    + " where idDatos=?";
            
            PreparedStatement pst = conn.prepareStatement(sqlSol); 
            
            pst.setString(1,kmFinal);
            pst.setInt(2,idDatos);
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            JOptionPane.showMessageDialog(null,"Kilometraje final agregado");
        }
    }
    
    public void insertarActividad(String actividad)
    {
        try
        {
            if(existenciaInforme()==0)
            {
            String sqlSol="insert into informes(Viaticos_idViaticos,Actividad_Infor,Status_Infor,Fecha_Infor)"
               + " values(?,?,?,now())";
            
            PreparedStatement pst = conn.prepareStatement(sqlSol); 
            
            pst.setInt(1,idSolicitud);
            pst.setString(2,actividad);
            pst.setString(3,"Disponible");
            pst.executeUpdate();
            }
            
            else
            {
            String sqlSol="update informes set Actividad_Infor=? where Viaticos_idViaticos=?";
            
            PreparedStatement pst = conn.prepareStatement(sqlSol); 
            
            pst.setString(1,actividad);
            pst.setInt(2,idSolicitud);
           
            pst.executeUpdate();
            }
           
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            JOptionPane.showMessageDialog(null,"Actividades agregadas al informe");
        }
    }
    
    public int existenciaInforme()
    {
       int existencia=0;
       try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
             String sql="select  COUNT(idInformes) as cantidad from informes where Viaticos_idViaticos ="+idSolicitud;
            
             ResultSet resul=stm.executeQuery(sql);
             
      while(resul.next())
      {
         existencia=resul.getInt("cantidad");
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
       return existencia;
    }
    
    public String[][] traerInformes()
    {
        int filas=obtenerCantidadInformes();
        
        String arregloSolicitudes[][]=new String[filas][3];
        try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
            String sql="select Viaticos_IdViaticos,Fecha_Infor,Actividad_Infor from informes";
           
             ResultSet resul=stm.executeQuery(sql);
             DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

               while(resul.next())
      {        
               int fila=resul.getRow()-1;
               int idSolViatico=resul.getInt("Viaticos_IdViaticos");
               String actividad=resul.getString("Actividad_Infor");
               Date fechaInfor=resul.getDate("Fecha_Infor");
              
         
               arregloSolicitudes[fila][0]=String.valueOf(idSolViatico);
               arregloSolicitudes[fila][1]=df.format(fechaInfor);
               arregloSolicitudes[fila][2]=String.valueOf(actividad);   
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return arregloSolicitudes;
    }
    
    public int obtenerCantidadInformes()
    {
       int cantidadSol=0;
       try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
             String sql="select count(*) as cantidad from informes";
            
             ResultSet resul=stm.executeQuery(sql);
             
               while(resul.next())
      {
         cantidadSol=resul.getInt("cantidad");
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
       return cantidadSol;
    }
}
