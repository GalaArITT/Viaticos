/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secretaria;

 
import JefeDpto.ModificarSolicitud;
import Solicitud.Solicitud_controlador;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Window;
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
import java.util.Date;
import javax.swing.JDialog;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
public class SolicitudRegistros extends javax.swing.JPanel {

 String[][] arregloSolicitudes;
 
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
    /**
     * Creates new form SolicitudRegistros
     */
    public SolicitudRegistros() {
        initComponents();
        btnMotCancel.setVisible(false);
         lblCancela.setVisible(false);
        traerSolicitudes("Solicitada");
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
        jButton1 = new javax.swing.JButton();
        btnEditaSolicitud = new javax.swing.JButton();
        panelMasDetalles = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbLugar = new javax.swing.JLabel();
        lbActividad = new javax.swing.JLabel();
        lbDias = new javax.swing.JLabel();
        lbTransporte = new javax.swing.JLabel();
        lbPernoctado = new javax.swing.JLabel();
        lblCancela = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFechaSalidaBusqueda = new com.toedter.calendar.JDateChooser();
        btnMostrarTodo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        btnMotCancel = new javax.swing.JButton();

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Solicitudes elaboradas");

        txtBusquedaSolicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaSolicitudKeyReleased(evt);
            }
        });

        tablaSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Fecha de salida", "Quien solicita", "Status"
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

        jButton1.setText("PDF");

        btnEditaSolicitud.setText("Editar");
        btnEditaSolicitud.setAutoscrolls(true);
        btnEditaSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaSolicitudActionPerformed(evt);
            }
        });

        jLabel13.setText("Mas detalles...");

        lblCancela.setText("Motivo de la cancelación:");

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
                    .addGroup(panelMasDetallesLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelMasDetallesLayout.setVerticalGroup(
            panelMasDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMasDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblCancela))
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

        jLabel2.setText("Filtra las solicitudes");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solicitadas", "Aprobadas", "Canceladas", "No aprobadas" }));
        cbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbStatusItemStateChanged(evt);
            }
        });

        btnMotCancel.setText("Ver motivo de la cancelación");
        btnMotCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEditaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMotCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMostrarTodo))
                    .addComponent(jScrollPane4)
                    .addComponent(panelMasDetalles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(134, 134, 134)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(txtBusquedaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaSalidaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusquedaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaSalidaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditaSolicitud)
                    .addComponent(jButton1)
                    .addComponent(btnMostrarTodo)
                    .addComponent(btnMotCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMasDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1019, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 31, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 32, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnEditaSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditaSolicitudActionPerformed

        JDialog jdModificarSol=new JDialog();
        jdModificarSol.setSize(820,491);
        ModificarSolicitud ventanaMod=new ModificarSolicitud();
        ventanaMod.cargarCamposModificar(lugar, actividad, dias, responsable, vehiculo, pernoctado, idFolio, fecha,idVehiculo,monto);
        jdModificarSol.add(ventanaMod);
        jdModificarSol.setVisible(true);
        jdModificarSol.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ventanaMod.btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jdModificarSol.dispose();
            }
        });

        ventanaMod.btnEnviar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jdModificarSol.dispose();
                jLabel13.setText("");
                datosModificados=true;
            }
        });

        for(Component component : getComponents(this))
        {
            component.setEnabled(false);
        }

        jdModificarSol.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                reactivarVentana();
            }
        });

    }//GEN-LAST:event_btnEditaSolicitudActionPerformed

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        cargaTabla(arregloSolicitudes);
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    private void cbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbStatusItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Object item = evt.getItem();
            String status="";
            if(item.equals("Solicitadas"))
            {
                status="Solicitada";
                 btnMotCancel.setVisible(false);
              lblCancela.setVisible(false);
            }

            if(item.equals("Aprobadas"))
            {
                status="Aprobada";
                 btnMotCancel.setVisible(false);
              lblCancela.setVisible(false);
            }

            if(item.equals("Canceladas"))
            {
                status="Cancelada";
                 btnMotCancel.setVisible(true);
              lblCancela.setVisible(true);
            }
            
            if(item.equals("No aprobadas"))
            {
                status="No aprobada";
                 btnMotCancel.setVisible(true);
              lblCancela.setVisible(true);
            }
            traerSolicitudes(status);
        }
    }//GEN-LAST:event_cbStatusItemStateChanged

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        if(datosModificados)
       {
           if(cbStatus.getSelectedItem().toString().equals("Solicitadas"))
                {
                    traerSolicitudes("Solicitada");
                }
                
                if(cbStatus.getSelectedItem().toString().equals("Aprobadas"))
                {
                    traerSolicitudes("Aprobada");
                }
                
                if(cbStatus.getSelectedItem().toString().equals("Canceladas"))
                {
                    traerSolicitudes("Cancelada");
                }
                
                if(cbStatus.getSelectedItem().toString().equals("No aprobadas"))
                {
                    traerSolicitudes("No aprobada");
                }
                datosModificados=false;
       }
    }//GEN-LAST:event_jPanel2MouseEntered

    private void btnMotCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotCancelActionPerformed
      mostrarCancel();
    }//GEN-LAST:event_btnMotCancelActionPerformed

    public void mostrarCancel()
    {
     Solicitud_controlador objControlador=new Solicitud_controlador();
     String motivo=objControlador.verMotivoCancelJefe(Integer.parseInt(idFolio));
    lblCancela.setText("Motivo de cancelación: "+motivo);
    }
    
    public void traerSolicitudes(String status){
       Solicitud_controlador objUsuario=new Solicitud_controlador();
       arregloSolicitudes=objUsuario.traerSolicitudesSecretaria(status); 
       jLabel13.setText("");
       cargaTabla(arregloSolicitudes);
    }
    
    public void cargaTabla(String [][] arregloSolicitudes )
    {
      ListSelectionListener eventoClic=new ListSelectionListener(){
      public void valueChanged(ListSelectionEvent event) 
      {
          try
          {
               btnMotCancel.setVisible(true);
              lblCancela.setVisible(true);
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
         String[] fechaTotal=arregloSolicitudes[i][2].split(" ");
         String folio=arregloSolicitudes[i][1];
         String fechsSalida=fechaTotal[0];
         String responsable=arregloSolicitudes[i][13];
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
        "<strong>Responsable: </strong>"+arregloSolicitudes[i][13]+"<br>"+
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
     String [][] resultadoBusqueda=new String[idsEncontrados.length][14];
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
            resultadoBusqueda[i][12]=arregloSolicitudes[j][12]; 
            resultadoBusqueda[i][13]=arregloSolicitudes[j][13];
            resultadoBusqueda[i][14]=arregloSolicitudes[j][14]; 
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEditaSolicitud;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JButton btnMotCancel;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel lblCancela;
    private javax.swing.JPanel panelMasDetalles;
    private javax.swing.JTable tablaSolicitudes;
    private javax.swing.JTextField txtBusquedaSolicitud;
    private com.toedter.calendar.JDateChooser txtFechaSalidaBusqueda;
    // End of variables declaration//GEN-END:variables
}
