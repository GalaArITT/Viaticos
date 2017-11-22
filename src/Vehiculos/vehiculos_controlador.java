/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import Usuarios.usuarios_modelo;

/**
 *
 * @author oliver
 */
public class vehiculos_controlador {
    public String [][] traerProductoTipoVehiculo()
    {
      vehiculos_modelo objVehiculos=new vehiculos_modelo ();
      String arregloVehiculos[][]=objVehiculos.traerProductoTipoVehiculo();
      return arregloVehiculos;
    }
    
}
