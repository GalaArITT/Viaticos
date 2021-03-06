

import Solicitudes.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Vales extends javax.swing.JFrame {

    private JFileChooser jfc;
    private GenerardorPDF gPDF;
    
    public Vales() {
        initComponents();
        jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));
        gPDF = new GenerardorPDF();
        
    }

    public void crearValeRec(String res,String car,String area,String tip,String mun,String loc, String filas){
        txtRecRes.setText(res);
        txtRecCar.setText(car);
        txtRecAre.setText(area);
        txtRecTip.setText(tip);
        txtRecMun.setText(mun);
        txtRecLoc.setText(loc);
        String []f = filas.split("\n");
        String []c;
        for(int i = 0; i < f.length; i++){
            c = f[i].split("\t");       
            DefaultTableModel temp = (DefaultTableModel) jtbRecoleccion.getModel();
            Object nuevo[]= {false,"","","","","",""};
            temp.addRow(nuevo);
            jtbRecoleccion.setValueAt(Boolean.parseBoolean(c[0]), i, 0);
            jtbRecoleccion.setValueAt(c[1], i, 1);
            jtbRecoleccion.setValueAt(c[2], i, 2);
            jtbRecoleccion.setValueAt(c[3], i, 3);
            jtbRecoleccion.setValueAt(c[4], i, 4);
            jtbRecoleccion.setValueAt(c[5], i, 5);
            jtbRecoleccion.setValueAt(c[6], i, 6);
        }
    }
    public void crearValeSal(String nomSol, String filas){
        txtSalNom.setText(nomSol);
        String []f = filas.split("\n");
        String []c;
        for(int i = 0; i < f.length; i++){
            c = f[i].split("\t");        
            DefaultTableModel temp = (DefaultTableModel) jtbSalida.getModel();
            Object nuevo[]= {"","",""};
            temp.addRow(nuevo);
            jtbSalida.setValueAt(c[0], i, 0);
            jtbSalida.setValueAt(c[1], i, 1);
            jtbSalida.setValueAt(c[2], i, 2);
        }
    }
    public void crearValeRes(String res,String car,String area,String tip,String mun,String loc, String filas){
        txtResResp.setText(res);
        txtResCa.setText(car);
        txtResAr.setText(area);
        txtResTi.setText(tip);
        txtResMun.setText(mun);
        txtResLoc.setText(loc);
        String []f = filas.split("\n");
        String []c;
        for(int i = 0; i < f.length; i++){
            c = f[i].split("\t");
            DefaultTableModel temp = (DefaultTableModel) jtbResguardo.getModel();
            Object nuevo[]= {"","","","","","",""};
            temp.addRow(nuevo);
            jtbResguardo.setValueAt(c[0], i, 0);
            jtbResguardo.setValueAt(c[1], i, 1);
            jtbResguardo.setValueAt(c[2], i, 2);
            jtbResguardo.setValueAt(c[3], i, 3);
            jtbResguardo.setValueAt(c[4], i, 4);
            jtbResguardo.setValueAt(c[5], i, 5);
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jtbVales = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbRecoleccion = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtRecMun = new javax.swing.JTextField();
        txtRecCar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRecAre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtRecLoc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRecTip = new javax.swing.JTextField();
        txtRecRes = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnRecGC = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbSalida = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtSalNom = new javax.swing.JTextField();
        btnSalGC = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtResMun = new javax.swing.JTextField();
        txtResCa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtResAr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtResLoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtResTi = new javax.swing.JTextField();
        txtResResp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbResguardo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnResGC = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Relacion de mobiliario, equipo de computo y vehiculos"));

        jtbRecoleccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Faltante", "No. Inventario", "No. Serie", "Descripción", "Marca", "Modelo", "Color"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtbRecoleccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtbRecoleccionKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(jtbRecoleccion);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos personales."));
        jPanel8.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N

        jLabel8.setText("Responsable");

        jLabel9.setText("Cargo");

        jLabel10.setText("Área");

        jLabel11.setText("Localidad");

        jLabel12.setText("Municipio");

        jLabel13.setText("Tipo de uso");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRecCar, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(txtRecAre)
                    .addComponent(txtRecRes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRecMun, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(txtRecTip)
                    .addComponent(txtRecLoc))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRecRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtRecTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtRecCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtRecMun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRecAre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txtRecLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Agregar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

        btnRecGC.setText("Generar vale");
        btnRecGC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRecGCMousePressed(evt);
            }
        });

        jButton7.setText("Salir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRecGC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(btnRecGC)
                    .addComponent(jButton7))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jtbVales.addTab("Recoleccion", jPanel2);

        jLabel14.setText("Nombre del usuario solicitante");

        jtbSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad (con letra)", "Autorizada", "Articulo"
            }
        ));
        jScrollPane4.setViewportView(jtbSalida);

        jButton5.setText("Agregar");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
        });

        jButton6.setText("Eliminar");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
        });

        txtSalNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalNomActionPerformed(evt);
            }
        });

        btnSalGC.setText("Generar vale");
        btnSalGC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSalGCMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSalGCMouseReleased(evt);
            }
        });
        btnSalGC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalGCActionPerformed(evt);
            }
        });

        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalGC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSalNom))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtSalNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(btnSalGC)
                    .addComponent(jButton8))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jtbVales.addTab("Salida de Almacen.", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos personales."));
        jPanel5.setFont(new java.awt.Font("Sitka Subheading", 0, 14)); // NOI18N

        jLabel1.setText("Responsable");

        jLabel2.setText("Cargo");

        jLabel3.setText("Área");

        jLabel4.setText("Localidad");

        jLabel5.setText("Municipio");

        jLabel6.setText("Tipo de uso");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtResCa, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(txtResAr)
                    .addComponent(txtResResp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtResMun, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(txtResTi)
                    .addComponent(txtResLoc))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtResResp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtResTi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtResCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtResMun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResAr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtResLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Relacion de mobiliario, equipo de computo y vehiculos"));

        jtbResguardo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Inventario", "No. Serie", "Descripción", "Marca", "Modelo", "Color"
            }
        ));
        jtbResguardo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtbResguardoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jtbResguardo);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
        );

        jButton1.setText("Agregar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        btnResGC.setText("Generar vale");
        btnResGC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnResGCMousePressed(evt);
            }
        });

        jButton9.setText("Salir");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnResGC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btnResGC)
                    .addComponent(jButton9))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jtbVales.addTab("Resguardo.", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbVales)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtbVales, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        try{
            DefaultTableModel temp = (DefaultTableModel) jtbRecoleccion.getModel();
            int []filasSelec = jtbRecoleccion.getSelectedRows();
            if(filasSelec.length == 0  && temp.getRowCount() > 0){
                temp.removeRow(temp.getRowCount()-1);
            }
            for(int i:filasSelec){
                temp.removeRow(filasSelec[0]);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            showMessageDialog(null, e, "Error.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        //Consulta c = new Consulta(this, true, btnRecGC.getText().equals("Crear solicitud")?0:1);        
        //c.setVisible(true);
        DefaultTableModel temp = (DefaultTableModel) jtbRecoleccion.getModel();
        Object nuevo[]= {false,"","","","","",""};
        temp.addRow(nuevo);
    }//GEN-LAST:event_jButton3MousePressed

    private void jtbRecoleccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbRecoleccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbRecoleccionKeyTyped

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        try{
            DefaultTableModel temp = (DefaultTableModel) jtbResguardo.getModel();
            int []filasSelec = jtbResguardo.getSelectedRows();
            if(filasSelec.length == 0 && temp.getRowCount() > 0){
                temp.removeRow(temp.getRowCount()-1);
            }
            for(int i:filasSelec){
                temp.removeRow(filasSelec[0]);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            showMessageDialog(null, e, "Error.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        //Consulta c = new Consulta(this, true, btnResGC.getText().equals("Crear solicitud")?0:1);
        //c.setVisible(true);
        //if(jtbResguardo.getRowCount() == 11){
        //    return;
        //}
        DefaultTableModel temp = (DefaultTableModel) jtbResguardo.getModel();
        Object nuevo[]= {"","","","","","",""};
        temp.addRow(nuevo);
    }//GEN-LAST:event_jButton1MousePressed

    private void jtbResguardoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbResguardoKeyTyped

    }//GEN-LAST:event_jtbResguardoKeyTyped

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        //Consulta c = new Consulta(this, true, btnSalGC.getText().equals("Crear solicitud")?0:1);
        //c.setVisible(true);
        DefaultTableModel temp = (DefaultTableModel) jtbSalida.getModel();
        Object nuevo[]= {"","","","","","",""};
        temp.addRow(nuevo); 
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
        try{
            DefaultTableModel temp = (DefaultTableModel) jtbSalida.getModel();
            int []filasSelec = jtbSalida.getSelectedRows();
            if(filasSelec.length == 0 && temp.getRowCount() > 0){
                temp.removeRow(temp.getRowCount()-1);
            }
            for(int i:filasSelec){
                temp.removeRow(filasSelec[0]);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            showMessageDialog(this, e, "Error.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6MousePressed

    private void btnResGCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResGCMousePressed
        switch(btnSalGC.getText()){
            case "Crear vale":{
                generarValeRes();
                break;
            }
            case "Crear solicitud":{
                crearSolicitudRes();
                break;
            }
        }
    }//GEN-LAST:event_btnResGCMousePressed

    private void btnSalGCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalGCMousePressed
                                  
    }//GEN-LAST:event_btnSalGCMousePressed

    private void btnRecGCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecGCMousePressed
        switch(btnRecGC.getText()){
            case "Crear vale":{
                generarValeRec();
                break;
            }
            case "Crear solicitud":{
                crearSolicitudRec();
                break;
            }
        }
    }//GEN-LAST:event_btnRecGCMousePressed

    private void btnSalGCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalGCMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalGCMouseReleased

    private void btnSalGCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalGCActionPerformed
        switch(btnSalGC.getText()){
            case "Crear vale":{
                generarValeSal();
                break;
            }
            case "Crear solicitud":{
                crearSolicitudSal();
                break;
            }
        }
    }//GEN-LAST:event_btnSalGCActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtSalNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalNomActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed
        
    public boolean valValSal(){
        String mes = "Le falto rellenar los siguientes campos:\n";
        if(txtSalNom.getText().isEmpty()){
            mes += "    Nombre del usuario solicitante.\n";
        }
        if(jtbSalida.getRowCount() == 0){
            mes +="    La tabla no tiene filas.";
        }
        if(mes.equals("Le falto rellenar los siguientes campos:\n")){
            return true;
        }
        showMessageDialog(this, mes, "Error al crear la solocitud", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public boolean valValeReco(){
        String mes = "Le falto rellenar los siguientes campos:\n";
        if(txtRecRes.getText().isEmpty()){
            mes +="    Responsable.\n";
        }
        if(txtRecCar.getText().isEmpty()){
            mes +="    Cargo.\n";
        }
        if(txtRecAre.getText().isEmpty()){
            mes +="    Area.\n";
        }
        if(txtRecTip.getText().isEmpty()){
            mes +="    Tipo de uso.\n";
        }
        if(txtRecMun.getText().isEmpty()){
            mes +="    Municipio.\n";
        }
        if(txtRecLoc.getText().isEmpty()){
            mes +="    Tipo de uso.\n";
        }
        if(jtbRecoleccion.getRowCount() == 0){
            mes +="    La tabla no tiene filas.";
        }
        if(mes.equals("Le falto rellenar los siguientes campos:\n")){
            return true;
        }
        showMessageDialog(this, mes, "Error al crear la solocitud", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public boolean valValeResg(){
        String mes = "Le falto rellenar los siguientes campos:\n";
        if(txtResResp.getText().isEmpty()){
            mes +="    Responsable.\n";
        }
        if(txtResCa.getText().isEmpty()){
            mes +="    Cargo.\n";
        }
        if(txtResAr.getText().isEmpty()){
            mes +="    Area.\n";
        }
        if(txtResTi.getText().isEmpty()){
            mes +="    Tipo de uso.\n";
        }
        if(txtResMun.getText().isEmpty()){
            mes +="    Municipio.\n";
        }
        if(txtResLoc.getText().isEmpty()){
            mes +="    Tipo de uso.\n";
        }
        if(jtbResguardo.getRowCount() == 0){
            mes +="    La tabla no tiene filas.";
        }
        if(mes.equals("Le falto rellenar los siguientes campos:\n")){
            return true;
        }
        showMessageDialog(this, mes, "Error al crear la solocitud", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public void generarValeRes(){
        if(!valValeResg()){
            return;
        }
        String r = "", c = "", a = "", t = "", m = "", l = "";
        String [][]tabla;
        r = txtResResp.getText();
        c = txtResCa.getText();
        a = txtResAr.getText();
        t = txtResTi.getText();
        m = txtResMun.getText();
        l = txtResLoc.getText();
        tabla = new String[jtbResguardo.getRowCount()][jtbResguardo.getColumnCount()];
        int resp = jfc.showSaveDialog(this);
        if (resp != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String path = jfc.getSelectedFile().getPath();
        for(int y = 0; y < tabla.length; y++){
            for(int x = 0; x < tabla[y].length; x++){
                tabla[y][x] = (String)jtbResguardo.getValueAt(y, x);
            }
        }
        if(!gPDF.generarValeResg(r, c, a, t, m, l, path, tabla)){
            showMessageDialog(this, "Error al generar archivo PDF", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        showMessageDialog(this, "Archivo PDF creado exitosamente", "PDF", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void generarValeRec(){
        if(!valValeReco()){
            return;
        }
        String r = "", c = "", a = "", t = "", m = "", l = "";
        Object [][]tabla;
        r = txtRecRes.getText();
        c = txtRecCar.getText();
        a = txtRecAre.getText();
        t = txtRecTip.getText();
        m = txtRecMun.getText();
        l = txtRecLoc.getText();
        tabla = new Object[jtbRecoleccion.getRowCount()][jtbRecoleccion.getColumnCount()];
        int resp = jfc.showSaveDialog(this);
        if (resp != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String path = jfc.getSelectedFile().getPath();
        for(int y = 0; y < tabla.length; y++){
            for(int x = 0; x < tabla[y].length; x++){
                tabla[y][x] = jtbRecoleccion.getValueAt(y, x);
            }
        }
        if(!gPDF.generarValeRec(r, c, a, t, m, l, path, tabla)){
            showMessageDialog(this, "Error al generar archivo PDF", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        showMessageDialog(this, "Archivo PDF creado exitosamente", "PDF", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void generarValeSal(){
       if(!valValSal()){
            return;
        }
        String nombre = "";
        String [][]tabla;
        nombre = txtSalNom.getText();
        tabla = new String[jtbSalida.getRowCount()][jtbSalida.getColumnCount()];
        int resp = jfc.showSaveDialog(this);
        if (resp != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String path = jfc.getSelectedFile().getPath();
        for(int y = 0; y < tabla.length; y++){
            for(int x = 0; x < tabla[y].length; x++){
                tabla[y][x] = (String)jtbSalida.getValueAt(y, x);
            }
        }
        if(!gPDF.generarSalidaAlm(nombre, path, tabla)){
            showMessageDialog(this, "Error al generar archivo PDF", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        showMessageDialog(this, "Archivo PDF creado exitosamente", "PDF", JOptionPane.INFORMATION_MESSAGE);    
    }
    
    public void crearSolicitudSal(){
        if(!valValSal()){
            return;
        }
        String desc = "Nombre:\t"+txtSalNom.getText()+"\n";
        Object [][]tabla;
        Datos_Solicitud ds = new Datos_Solicitud(this, true);
        ds.btnAsun.setText("Solicitud de Salida de Almacen");
        tabla = new Object[jtbSalida.getRowCount()][jtbSalida.getColumnCount()];
        for(int y = 0; y < tabla.length; y++){
            for(int x = 0; x < tabla[y].length; x++){
                desc += String.valueOf(jtbSalida.getValueAt(y, x))+"\t";
            }
            desc += "\n";
        }
        ds.btnDesc.setText(desc);
        ds.btnFech.setText(ds.fecha);
        ds.btnEst.setText("Solicitada");
        ds.setVisible(true);
    }
    
    public void crearSolicitudRec(){
        if(!valValeReco()){
            return;
        }
        String desc = "";
        Object [][]tabla;
        Datos_Solicitud ds = new Datos_Solicitud(this, true);
        ds.btnAsun.setText("Solicitud de Recoleccion");
        desc += "Responsable:\t"+txtRecRes.getText()+"\n";
        desc += "Cargo:\t"+txtRecCar.getText()+"\n";
        desc += "Area:\t"+txtRecAre.getText()+"\n";
        desc += "Tipo de uso:\t"+txtRecTip.getText()+"\n";
        desc += "Municipio:\t"+txtRecMun.getText()+"\n";
        desc += "Localidad:\t"+txtRecLoc.getText()+"\n";
        desc += "Mobiliario y equipo de computo\n";
        tabla = new Object[jtbRecoleccion.getRowCount()][jtbRecoleccion.getColumnCount()];
        for(int y = 0; y < tabla.length; y++){
            for(int x = 0; x < tabla[y].length; x++){
                desc += String.valueOf(jtbRecoleccion.getValueAt(y, x) != null?jtbRecoleccion.getValueAt(y, x):"")+"\t";
            }
            desc += "\n";
        }
        ds.btnDesc.setText(desc);
        ds.btnFech.setText(ds.fecha);
        ds.btnEst.setText("Solicitada");
        ds.setVisible(true);    
    }
    
    public void crearSolicitudRes(){
        if(!valValeResg()){
            return;
        }
        String desc = "";
        Object [][]tabla;
        Datos_Solicitud ds = new Datos_Solicitud(this, true);
        ds.btnAsun.setText("Solicitud de Resguardo");
        desc += "Responsable:\t"+txtResResp.getText()+"\n";
        desc += "Cargo:\t"+txtResCa.getText()+"\n";
        desc += "Area:\t"+txtResAr.getText()+"\n";
        desc += "Tipo de uso:\t"+txtResTi.getText()+"\n";
        desc += "Municipio:\t"+txtResMun.getText()+"\n";
        desc += "Localidad:\t"+txtResLoc.getText()+"\n";
        desc += "Mobiliario y equipo de computo\n";
        tabla = new Object[jtbResguardo.getRowCount()][jtbResguardo.getColumnCount()];
        for(int y = 0; y < tabla.length; y++){
            for(int x = 0; x < tabla[y].length; x++){
                desc += String.valueOf(jtbResguardo.getValueAt(y, x))+"\t";
            }
            desc += "\n";
        }
        ds.btnDesc.setText(desc);
        ds.btnFech.setText(ds.fecha);
        ds.btnEst.setText("Solicitada");
        ds.setVisible(true);      
    }
    
    public void setTextResBoton(String cad){
        btnResGC.setText(cad);
    }
    
    public void setTextSalBoton(String cad){
        btnSalGC.setText(cad);        
    }
    
    public void setTextRecBoton(String cad){
        btnRecGC.setText(cad);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecGC;
    private javax.swing.JButton btnResGC;
    public javax.swing.JButton btnSalGC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jtbRecoleccion;
    private javax.swing.JTable jtbResguardo;
    private javax.swing.JTable jtbSalida;
    public javax.swing.JTabbedPane jtbVales;
    private javax.swing.JTextField txtRecAre;
    private javax.swing.JTextField txtRecCar;
    private javax.swing.JTextField txtRecLoc;
    private javax.swing.JTextField txtRecMun;
    private javax.swing.JTextField txtRecRes;
    private javax.swing.JTextField txtRecTip;
    private javax.swing.JTextField txtResAr;
    private javax.swing.JTextField txtResCa;
    private javax.swing.JTextField txtResLoc;
    private javax.swing.JTextField txtResMun;
    private javax.swing.JTextField txtResResp;
    private javax.swing.JTextField txtResTi;
    private javax.swing.JTextField txtSalNom;
    // End of variables declaration//GEN-END:variables
}
