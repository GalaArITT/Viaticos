/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author fernando
 */
public class usuarios_controlador {
    public String [][] traerUsuarioTipoEmpleado()
    {
      usuarios_modelo objUsuarios=new usuarios_modelo();
      String arregloResponsables[][]=objUsuarios.traerUsuarioTipoEmpleado();
      return arregloResponsables;
    }
    
    public boolean comprobarExistenciaUsuario(String usuario,String pass)
    {
       usuarios_modelo objUsuarios=new usuarios_modelo();
       return objUsuarios.comprobarExistenciaUsuario(usuario,pass);
    }
    
    public String tipoUsuario(String usuario)
    {
      usuarios_modelo objUsuarios=new usuarios_modelo();
      return objUsuarios.tipoUsuario(usuario); 
    }
    
    public int traerIdUsuario(String usuario,String pass)
    {
         usuarios_modelo objUsuarios=new usuarios_modelo();
        return objUsuarios.traerIdUsuario(usuario,pass);
    }
    
    
}
