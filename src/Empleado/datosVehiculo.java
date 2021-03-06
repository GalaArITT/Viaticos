/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado;

import Solicitud.Solicitud_controlador;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class datosVehiculo extends javax.swing.JPanel {
boolean primerMod=false;
boolean segundaMod=false;
int idFolio=0;
int idVehiculo=0;
int idDatos=0;
String[] arregloDatos=new String [3];
    /**
     * Creates new form datosVehiculo
     */
    public datosVehiculo() {
        initComponents();
       
    }
    
    public void cargarCampos(String vehiculo, String idFolio,String fecha,String realizada,int idVehiculo)
    {
        this.idFolio=Integer.parseInt(idFolio);
        this.idVehiculo=idVehiculo;
        Date date = new Date();
        String fechaActual= new SimpleDateFormat("yyyy-MM-dd").format(date);
        
        String[] fechaSol=fecha.split(" ");
        
        String [] fechaComIndividual=fechaSol[0].split("/");
        String [] fechaActIndividual=fechaActual.split("-");
        
        int diaActual=Integer.parseInt(fechaActIndividual[2]);
        int mesActual=Integer.parseInt(fechaActIndividual[1]);
        int anioActual=Integer.parseInt(fechaActIndividual[0]);
        
        int diaCom=Integer.parseInt(fechaComIndividual[1]);
        int mesCom=Integer.parseInt(fechaComIndividual[0]);
        int anioCom=Integer.parseInt(fechaComIndividual[2]);
        //JOptionPane.showMessageDialog(null,diaActual+" "+mesActual+" "+anioActual+"\n"+diaCom+"");
        //SI LA FECHA ACTUAL ES MENOR A LA FECHA DE SALIDA BLOQUEAR KMFNAL
        //BOTON PARA MARCAR SI SE HA REALIZADO O NO 
        if( (diaActual<=diaCom)&&(mesActual<=mesCom)&&(anioActual<=anioCom)&&realizada.equals("no"))
        {
            txtKmInicial.setEnabled(true);
            txtKmFinal.setEnabled(false);
            txtDescripcion.setEnabled(true);
            primerMod=true;
            segundaMod=false;
        }
        
        //SI LA FECHA ACTUAL ES MAYOR A LA FECHA DE SALIDA DESBLOQUEAR
        //BLOQUEAR KM INICIAL
        else
        {
         txtKmInicial.setEnabled(false);
         txtKmFinal.setEnabled(true);
         txtDescripcion.setEnabled(false);
         primerMod=false;
         segundaMod=true;
         Solicitud_controlador objControlador=new Solicitud_controlador();
         arregloDatos=objControlador.traerDatosVehiculo(this.idFolio);
         txtKmInicial.setText(arregloDatos[0]);
         txtDescripcion.setText(arregloDatos[1]);
         this.idDatos=Integer.parseInt(arregloDatos[2]);
        }
        
        lblTitulo.setText("Datos del vehiculo usado para la comision("+vehiculo+")");
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtKmInicial = new javax.swing.JTextField();
        txtKmFinal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblTitulo = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        jLabel1.setText("Kilometraje inicial");

        jLabel2.setText("Kilometraje final");

        jLabel3.setText("Descripción");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTitulo.setText("Datos del vehiculo usado para la comisión");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGuardar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKmFinal))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKmInicial)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKmInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKmFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    if(primerMod&&!segundaMod)
    {
       Solicitud_controlador objControlador =new Solicitud_controlador();
       String kmInicial=txtKmInicial.getText();
       String descrip=txtDescripcion.getText();
       if(!kmInicial.equals(""))
       {
         objControlador.insertarKmInicial(idFolio,kmInicial,descrip,idVehiculo);
       }
       else
       {
        JOptionPane.showMessageDialog(null,"El kilometraje inicial no debe estar vacio");
       }
    }
    
        if(!primerMod&&segundaMod)
        {
           Solicitud_controlador objControlador =new Solicitud_controlador();
           String kmFinal=txtKmFinal.getText();
           if(!kmFinal.equals(""))
           {
            objControlador.modificarKmFinal(kmFinal,idDatos);
           }

           else
           {
            JOptionPane.showMessageDialog(null,"El kilometraje final no debe estar vacio");
           }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtKmFinal;
    private javax.swing.JTextField txtKmInicial;
    // End of variables declaration//GEN-END:variables
}
