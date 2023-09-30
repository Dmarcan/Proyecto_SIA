import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Opcion6Jframe extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    Empresa empresa;
    public Opcion6Jframe(Empresa empresa) {
        initComponents();
        this.empresa = empresa;
        modelo.addColumn("Nombre");
        modelo.addColumn("Rut");
        modelo.addColumn("Tipo");
        modelo.addColumn("Asiento");
        jTable2.setModel(modelo);
    }

    private Opcion6Jframe() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jComboBox6 = new javax.swing.JComboBox<>();

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14));
        jLabel4.setText("Estado:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14));
        jLabel5.setText("Rellene los campos");

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "General", "Estudiante", "Tercera Edad" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "General", "Estudiante", "Tercera Edad" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14));
        jLabel1.setText("LISTAR PASAJEROS");

        jLabel2.setText("Ingrese codigo viaje bus");

        jButton1.setText("Mostrar Viajes Buses");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14));
        jLabel6.setText("Estado:");

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14));
        jLabel7.setText("Rellene los campos");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jButton2.setText("Mostrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "General", "Estudiante", "Tercera Edad" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        pack();
    }

    /* Lo que hace el siguiente método consiste en que, al presionar el botón de "Mostrar Viajes Buses", emerge la ventana 
    que da a elegir entre las opciones de listar viajes de buses con o sin filtro, con la finalidad de mostrarle al usuario los
    códigos de viaje.*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Opcion3Jframe mostrarBuses = new Opcion3Jframe(empresa);
        mostrarBuses.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    /* Lo que hace el siguiente método consiste en que, al presionar el botón de "Mostrar", se almacena el texto
    ingresado en el campo de entrada de código de viaje de bus en una variable local, y verifica si el campo está vacío. 
    Si no lo está, se intentan listar todos los pasajeros de la colección de objetos Pasajero asociada al objeto ViajeBus
    respectivo, encontrado por código de viaje, mediante el uso de una excepción.*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String codigo = jTextField1.getText();

        if (codigo.isEmpty()){
            jLabel7.setText("Rellene el campo del código de viaje");
            return;
        }
        
        ViajeBus bus = empresa.getViajeBus(codigo);
        if (bus == null){
            jLabel7.setText("Codigo ingresado no existe");
        }
        else{
            jLabel7.setText("Mostrando pasajeros...");
            refrescaTabla(codigo,bus);
        }
        
    }
    private void refrescaTabla(String codigo,ViajeBus bus){
        while (modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        String tipo = jComboBox6.getSelectedItem().toString();
        if (tipo.equals("Todos")){
            ArrayList<Pasajero> listaMostrar = bus.obtenerListaPasajeros();
            if (listaMostrar.isEmpty())jLabel7.setText("No existen pasajeros");
            else{
                for (int i = 0;i < listaMostrar.size();i++){
                    Pasajero Current = listaMostrar.get(i);
                    Object a[]=new Object[4];
                    a[0] = Current.getNombrePasajero();
                    a[1] = Current.getRut();
                    a[2] = Current.getTipo();
                    a[3] = Current.getNroAsiento();
                    modelo.addRow(a);
                }
                jTable2.setModel(modelo);
            }
        }
        else{
            ArrayList<Pasajero> listaMostrar = bus.obtenerListaPasajeros(tipo);
            if (listaMostrar.isEmpty())jLabel7.setText("No existen pasajeros");
            else{
                for (int i = 0;i < listaMostrar.size();i++){
                    Pasajero Current = listaMostrar.get(i);
                    Object a[]=new Object[4];
                    a[0] = Current.getNombrePasajero();
                    a[1] = Current.getRut();
                    a[2] = Current.getTipo();
                    a[3] = Current.getNroAsiento();
                    modelo.addRow(a);
                }
                jTable2.setModel(modelo);
            }
            
        }
            
        
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Opcion6Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opcion6Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opcion6Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opcion6Jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Opcion6Jframe().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
}
