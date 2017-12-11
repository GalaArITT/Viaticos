/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleado;

import Conexion.Conexion;
import Solicitud.Solicitud_controlador;
import com.mysql.jdbc.Connection;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author oliver
 */
public class SolicitudRegistros extends javax.swing.JPanel {

 String[][] arregloSolicitudes;
 int idUsuarioEmpleado;
 int idResponsable=0;
 int idVehiculo=0;
 String lugar="";
 String actividad="";
 String dias="";
 String responsable="";
 String vehiculo="";
 String pernoctado="";
 String fecha="";
 String idFolio;
 boolean datosModificados=false;
 float monto;
 String realizada="si";
    /**
     * Creates new form SolicitudRegistros
     */
    public SolicitudRegistros(int idUsuarioEmpleado) {
        initComponents();
        this.idUsuarioEmpleado=idUsuarioEmpleado;
        traerComisiones("no");
        //        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
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
        btnIngresaInforme = new javax.swing.JButton();
        btnDatosVehiculo = new javax.swing.JButton();
        panelMasDetalles = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbLugar = new javax.swing.JLabel();
        lbActividad = new javax.swing.JLabel();
        lbDias = new javax.swing.JLabel();
        lbTransporte = new javax.swing.JLabel();
        lbPernoctado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFechaSalidaBusqueda = new com.toedter.calendar.JDateChooser();
        btnMostrarTodo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbFiltroComision = new javax.swing.JComboBox<>();
        btnRealizada = new javax.swing.JButton();

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Tus comisiones");

        txtBusquedaSolicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaSolicitudKeyReleased(evt);
            }
        });

        tablaSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Fecha de salida", "Responsable", "Realizada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaSolicitudes);

        jLabel11.setText("Busca una solicitud por folio, responsable o status");

        jLabel12.setText("Selecciona una solicitud de la tabla para editar, cancelar o imprimir PDF");

        btnIngresaInforme.setText("Ingresa informe");
        btnIngresaInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresaInformeActionPerformed(evt);
            }
        });

        btnDatosVehiculo.setText("Ingresa datos de vehiculo");
        btnDatosVehiculo.setAutoscrolls(true);
        btnDatosVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosVehiculoActionPerformed(evt);
            }
        });

        jLabel13.setText("Mas detalles...");

        javax.swing.GroupLayout panelMasDetallesLayout = new javax.swing.GroupLayout(panelMasDetalles);
        panelMasDetalles.setLayout(panelMasDetallesLayout);
        panelMasDetallesLayout.setHorizontalGroup(
            panelMasDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasDetallesLayout.createSequentialGroup()
                .addContainerGap()
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
                        .addComponent(lbPernoctado, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMasDetallesLayout.setVerticalGroup(
            panelMasDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
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

        jLabel1.setText("Busca una solicitud por fecha");

        btnMostrarTodo.setText("Mostrar todo");
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });

        jButton2.setText("PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtra las comisiones");

        cbFiltroComision.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comisiones pendientes", "Comisiones realizadas" }));
        cbFiltroComision.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFiltroComisionItemStateChanged(evt);
            }
        });

        btnRealizada.setText("Marcar como realizada");
        btnRealizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizadaActionPerformed(evt);
            }
        });

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
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRealizada, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDatosVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIngresaInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMostrarTodo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addGap(0, 489, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbFiltroComision, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtBusquedaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaSalidaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))))
                .addContainerGap())
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
                            .addComponent(jLabel11)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaSalidaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFiltroComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMostrarTodo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDatosVehiculo)
                            .addComponent(btnIngresaInforme)
                            .addComponent(jButton2)
                            .addComponent(btnRealizada))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMasDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void traerComisiones(String status){
       Solicitud_controlador objControlador=new Solicitud_controlador();
       arregloSolicitudes=objControlador.traerComisionesEmpleado(status,idUsuarioEmpleado); 
         lbLugar.setText("");
         lbActividad.setText("");
         lbDias.setText("");
         lbTransporte.setText("");
         lbPernoctado.setText("");
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
         String[] fechaTotal = null;
         try
         {
           fechaTotal=arregloSolicitudes[i][2].split(" ");  
         }
         
         catch(Exception e)
         {
             fechaTotal=new String [2];
             fechaTotal[0]="";
         }
         
         String folio=arregloSolicitudes[i][1];
         String fechsSalida=fechaTotal[0];
         String responsable=arregloSolicitudes[i][3];
         String status=arregloSolicitudes[i][8];
         model.addRow(new Object[]{folio,fechsSalida,responsable,status}); 
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
         if(arregloSolicitudes[i][1].equals(folio))
         {
          jLabel13.setText("<html>Mas detalles...<br>"
	+"<strong>Lugar: </strong>"+arregloSolicitudes[i][5]+"<br>"+
	"<strong>Actividad: </strong>"+arregloSolicitudes[i][6]+"<br>"+
	"<strong>Dias: </strong>"+arregloSolicitudes[i][4]+"<br>"+
	"<strong>Transporte: </strong>"+arregloSolicitudes[i][10]+"<br>"+
	"<strong>Pernoctado: </strong>"+arregloSolicitudes[i][7]+"<br>"+
	"<strong>Monto: </strong>"+arregloSolicitudes[i][12]+"</html>");
          
          lugar=arregloSolicitudes[i][5];
          actividad=arregloSolicitudes[i][6];
          dias=arregloSolicitudes[i][4];
          responsable=arregloSolicitudes[i][3];
          vehiculo=arregloSolicitudes[i][10];
          pernoctado=arregloSolicitudes[i][7];
          fecha=arregloSolicitudes[i][2];
          idFolio=arregloSolicitudes[i][0];
          idVehiculo=Integer.parseInt(arregloSolicitudes[i][11]);
          monto=Float.parseFloat(arregloSolicitudes[i][12]);
          realizada=arregloSolicitudes[i][8];
          }
     }
    }
    
  public String[][] busquedaEnTabla(String cadenaEntrada)
   {
    String resultadoBusquedaId="";
    
    for(int i=0;i<arregloSolicitudes.length;i++)
    {
       if(arregloSolicitudes[i][1].toLowerCase().contains(cadenaEntrada.toLowerCase())
               ||arregloSolicitudes[i][8].toLowerCase().contains(cadenaEntrada.toLowerCase())
               ||arregloSolicitudes[i][3].toLowerCase().contains(cadenaEntrada.toLowerCase())
               ||arregloSolicitudes[i][2].contains(cadenaEntrada))
       {
          resultadoBusquedaId=resultadoBusquedaId+arregloSolicitudes[i][0]+"-";
       }
    }
    String[] idsEncontrados=resultadoBusquedaId.split("-");
     String [][] resultadoBusqueda=new String[idsEncontrados.length][12];
    for(int i=0;i<idsEncontrados.length;i++)
    {
      for(int j=0;j<arregloSolicitudes.length;j++)
        {
          
          if(idsEncontrados[i].equals(arregloSolicitudes[j][0]))
          {
            resultadoBusqueda[i][0]=arregloSolicitudes[j][0];
            resultadoBusqueda[i][1]=arregloSolicitudes[j][1];
            resultadoBusqueda[i][2]=arregloSolicitudes[j][2];
            resultadoBusqueda[i][3]=arregloSolicitudes[j][3];
            resultadoBusqueda[i][4]=arregloSolicitudes[j][4];
            resultadoBusqueda[i][5]=arregloSolicitudes[j][5];
            resultadoBusqueda[i][6]=arregloSolicitudes[j][6];
            resultadoBusqueda[i][7]=arregloSolicitudes[j][7];
            resultadoBusqueda[i][8]=arregloSolicitudes[j][8];
            resultadoBusqueda[i][9]=arregloSolicitudes[j][9];
            resultadoBusqueda[i][10]=arregloSolicitudes[j][10];
            resultadoBusqueda[i][11]=arregloSolicitudes[j][11];  
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

    private void btnDatosVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosVehiculoActionPerformed

        JDialog jdDatosVehiculo=new JDialog();
        jdDatosVehiculo.setSize(470,315);
        datosVehiculo ventanaVehiculo=new datosVehiculo();
        ventanaVehiculo.cargarCampos(vehiculo,idFolio,fecha,realizada,idVehiculo);
        jdDatosVehiculo.add(ventanaVehiculo);
        jdDatosVehiculo.setVisible(true);
        jdDatosVehiculo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        for(Component component : getComponents(this))
        {
            component.setEnabled(false);
        }
        
        
        ventanaVehiculo.btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jdDatosVehiculo.dispose();
            }
        });

        jdDatosVehiculo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                reactivarVentana();
            }
        });
    }//GEN-LAST:event_btnDatosVehiculoActionPerformed

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

    private void btnIngresaInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresaInformeActionPerformed
        JDialog jdInforme=new JDialog();
        jdInforme.setSize(575,290);
        Informe ventanaInforme=new Informe();
        ventanaInforme.cargarCampos(idFolio,idUsuarioEmpleado);
        jdInforme.add(ventanaInforme);
        jdInforme.setVisible(true);
        jdInforme.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        for(Component component : getComponents(this))
        {
            component.setEnabled(false);
        }
        
        ventanaInforme.btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jdInforme.dispose();
            }
        });

        jdInforme.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                reactivarVentana();
            }
        });
    }//GEN-LAST:event_btnIngresaInformeActionPerformed

    private void btnRealizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizadaActionPerformed
      Solicitud_controlador objControlador= new Solicitud_controlador();
      objControlador.marcarRealizada(Integer.parseInt(idFolio));
    }//GEN-LAST:event_btnRealizadaActionPerformed

    private void cbFiltroComisionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFiltroComisionItemStateChanged
          if (evt.getStateChange() == ItemEvent.SELECTED) {
          Object item = evt.getItem();
          String status="";
          if(item.equals("Comisiones pendientes"))
          {
             status="no";
          }
          
          if(item.equals("Comisiones realizadas"))
          {
              status="si"; 
          }
          //JOptionPane.showMessageDialog(null,status);
          traerComisiones(status);
       }
    }//GEN-LAST:event_cbFiltroComisionItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                    try {
           //int leer = Integer.parseInt(txtbuscar.getText());
            // TODO add your handling code here:
            Conexion con = new Conexion();
            Connection conn = (Connection) con.getConexion();
            
            JasperReport reporte = null;
            ///src/ejemploreportes/
            //String path = "src/ejemploreportes/municipios.jasper";
            String path = "src//Reportes//reporteComision.jasper";
            
            Map parametro = new HashMap();
            parametro.put("id_estado", 1);
            
            //reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            //JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);
            
            JasperViewer view = new JasperViewer(jprint,false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
        } catch (JRException ex) {
            //Logger.getLogger(SolicitudRegistro.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDatosVehiculo;
    private javax.swing.JButton btnIngresaInforme;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JButton btnRealizada;
    private javax.swing.JComboBox<String> cbFiltroComision;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
