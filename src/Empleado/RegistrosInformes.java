/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado;

import Solicitud.Solicitud_controlador;
import java.awt.Component;
import java.awt.Container;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fernando
 */
public class RegistrosInformes extends javax.swing.JPanel {
String[][] arregloSolicitudes;
int idUsuarioEmpleado;
 boolean datosModificados=false;
    /**
     * Creates new form RegistrosInformes
     */
    public RegistrosInformes(int idUsuarioEmpleado) {
        initComponents();
        this.idUsuarioEmpleado=idUsuarioEmpleado;
        traerInformes();
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtFechaSalidaBusqueda.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    if ("date".equals(e.getPropertyName())) {
                       String startDateString = dateFormat.format( txtFechaSalidaBusqueda.getDate());
                       System.out.print(startDateString);
                      String resultadosBusqueda[][]=busquedaEnTabla(startDateString);
                      cargaTabla(resultadosBusqueda);
                    }
                }
            });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtBusquedaSolicitud = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaSolicitudes = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        panelMasDetalles = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbLugar = new javax.swing.JLabel();
        lbActividad = new javax.swing.JLabel();
        lbDias = new javax.swing.JLabel();
        lbTransporte = new javax.swing.JLabel();
        lbPernoctado = new javax.swing.JLabel();
        btnMostrarTodo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFechaSalidaBusqueda = new com.toedter.calendar.JDateChooser();

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Informes realizados");

        txtBusquedaSolicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaSolicitudKeyReleased(evt);
            }
        });

        tablaSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Fecha de creación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaSolicitudes);

        jLabel11.setText("Busca un informe por folio, responsable o status");

        jLabel12.setText("Selecciona un informe de la tabla para ver sus detalles");

        jLabel13.setText("Mas detalles...");

        btnMostrarTodo.setText("Mostrar todo");
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMasDetallesLayout = new javax.swing.GroupLayout(panelMasDetalles);
        panelMasDetalles.setLayout(panelMasDetallesLayout);
        panelMasDetallesLayout.setHorizontalGroup(
            panelMasDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMasDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMasDetallesLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMostrarTodo))
                    .addGroup(panelMasDetallesLayout.createSequentialGroup()
                        .addGroup(panelMasDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMasDetallesLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(lbTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMasDetallesLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(panelMasDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbDias, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelMasDetallesLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(lbPernoctado, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 270, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelMasDetallesLayout.setVerticalGroup(
            panelMasDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMasDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnMostrarTodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbActividad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTransporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbPernoctado)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setText("Busca un folio por fecha");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(panelMasDetalles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtBusquedaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaSalidaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(txtBusquedaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaSalidaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(panelMasDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

     public void traerInformes(){
       Solicitud_controlador objControlador=new Solicitud_controlador();
       arregloSolicitudes=objControlador.traerInformes(idUsuarioEmpleado); 
       cargaTabla(arregloSolicitudes);
    }
     public void cargaTabla(String [][] arregloSolicitudes )
    {
      ListSelectionListener eventoClic=new ListSelectionListener(){
      public void valueChanged(ListSelectionEvent event) 
      {
          try
          {
               cargaInfoAdicionalTabla(tablaSolicitudes.getValueAt(tablaSolicitudes.getSelectedRow(), 0).toString());
          }
          
          catch(Exception e)
          {
            
          }
      }
    };
     DefaultTableModel model=(DefaultTableModel) tablaSolicitudes.getModel();
    tablaSolicitudes.getSelectionModel().removeListSelectionListener(eventoClic);
     borrarDatoaTabla(model);
     
     for(int i=0;i<arregloSolicitudes.length;i++)
     {
         String fechsSalida=arregloSolicitudes[i][1];
         String folio=arregloSolicitudes[i][0];
        

         model.addRow(new Object[]{folio,fechsSalida}); 
     }
   
    tablaSolicitudes.getSelectionModel().addListSelectionListener(eventoClic);
   }
   
     public  void borrarDatoaTabla(final DefaultTableModel model) 
   {
        for( int i = model.getRowCount() - 1; i >= 0; i-- ) 
        {
            model.removeRow(i);
        }
    }
   
    public void cargaInfoAdicionalTabla(String folio)
    {
     for(int i=0;i<arregloSolicitudes.length;i++)
     {
         if(arregloSolicitudes[i][0].equals(folio))
         {
          jLabel13.setText("<html>Mas detalles...<br>"
	+"<strong>Informe: </strong>"+arregloSolicitudes[i][2]+"<br>"+
	"</html>");
          }
     }
    }
    
  public String[][] busquedaEnTabla(String cadenaEntrada)
   {
    String resultadoBusquedaId="";
    
    for(int i=0;i<arregloSolicitudes.length;i++)
    {
       if(arregloSolicitudes[i][0].toLowerCase().contains(cadenaEntrada.toLowerCase())
          ||arregloSolicitudes[i][1].contains(cadenaEntrada))
       {
          resultadoBusquedaId=resultadoBusquedaId+arregloSolicitudes[i][0]+"-";
       }
    }
    String[] idsEncontrados=resultadoBusquedaId.split("-");
    String [][] resultadoBusqueda=new String[idsEncontrados.length][3];
    for(int i=0;i<idsEncontrados.length;i++)
    {
      for(int j=0;j<arregloSolicitudes.length;j++)
        {
          if(idsEncontrados[i].equals(arregloSolicitudes[j][0]))
          {
            resultadoBusqueda[i][0]=arregloSolicitudes[j][0];
            resultadoBusqueda[i][1]=arregloSolicitudes[j][1];
            resultadoBusqueda[i][2]=arregloSolicitudes[j][2];
          }
        }
    } 
    
    return resultadoBusqueda;
   }
        private Component[] getComponents(Component container) {
        ArrayList<Component> list = null;

        try {
            list = new ArrayList<Component>(Arrays.asList(
                  ((Container) container).getComponents()));
            for (int index = 0; index < list.size(); index++) {
                for (Component currentComponent : getComponents(list.get(index))) {
                    list.add(currentComponent);
                }
            }
        } catch (ClassCastException e) {
            list = new ArrayList<Component>();
        }

        return list.toArray(new Component[list.size()]);
        }
    
        public void reactivarVentana()
        {
            for(Component component : getComponents(this)) 
              {
                component.setEnabled(true);
              }
        }

    private void txtBusquedaSolicitudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaSolicitudKeyReleased
        String cadenaEntrada=txtBusquedaSolicitud.getText();
        if(!cadenaEntrada.equals(""))
        {
            String resultadosBusqueda[][]=busquedaEnTabla(cadenaEntrada);
            cargaTabla(resultadosBusqueda);
        }

        else
        {
            cargaTabla(arregloSolicitudes);
        }
    }//GEN-LAST:event_txtBusquedaSolicitudKeyReleased

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        cargaTabla(arregloSolicitudes);
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        if(datosModificados)
        {
            //            if(cbStatus.getSelectedItem().toString().equals("Solicitadas"))
            //            {
                //                traerSolicitudes("Solicitada");
                //            }
            //
            //            if(cbStatus.getSelectedItem().toString().equals("Aprobadas"))
            //            {
                //                traerSolicitudes("Aprobada");
                //            }
            //
            //            if(cbStatus.getSelectedItem().toString().equals("Canceladas"))
            //            {
                //                traerSolicitudes("Cancelada");
                //            }
            //
            //            if(cbStatus.getSelectedItem().toString().equals("No aprobadas"))
            //            {
                //                traerSolicitudes("No aprobada");
                //            }
            datosModificados=false;
        }
    }//GEN-LAST:event_jPanel2MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbActividad;
    private javax.swing.JLabel lbDias;
    private javax.swing.JLabel lbLugar;
    private javax.swing.JLabel lbPernoctado;
    private javax.swing.JLabel lbTransporte;
    private javax.swing.JPanel panelMasDetalles;
    private javax.swing.JTable tablaSolicitudes;
    private javax.swing.JTextField txtBusquedaSolicitud;
    private com.toedter.calendar.JDateChooser txtFechaSalidaBusqueda;
    // End of variables declaration//GEN-END:variables
}
