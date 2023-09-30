import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/* Lo que hace el siguiente método es mostrar por pantalla una tabla con los datos de todos los viajes de bus, es decir, todos los atributos asociados a estos objetos, de forma ordenada y estructurada.*/
public class Opcion3ListarTodos extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Opcion3ListarTodos(ArrayList<ViajeBus> listaMostrar) {
        initComponents();
        
        modelo.addColumn("Chofer");
        modelo.addColumn("Codigo viaje");
        modelo.addColumn("Matricula");
        modelo.addColumn("Lugar inicio");
        modelo.addColumn("Lugar llegada");
        modelo.addColumn("Hora inicio");
        modelo.addColumn("Hora llegada");
        modelo.addColumn("Tarifa general");
        modelo.addColumn("Tarifa Estudiante");
        modelo.addColumn("Tarifa tercera edad");
        modelo.addColumn("Total asientos");
        modelo.addColumn("Cantidad pasajeros");
        modelo.addColumn("Asientos libres");
        modelo.addColumn("Rentabilidad");
        jTable1.setModel(modelo);
        while (modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        for (int i = 0;i < listaMostrar.size();i++){
            ViajeBus busCurrent = listaMostrar.get(i);
            Object a[]=new Object[14];
            a[0] = busCurrent.getNombreChofer();
            a[1] = busCurrent.getCodigo();
            a[2] = busCurrent.getMatricula();
            a[3] = busCurrent.getLugarDeInicio();
            a[4] = busCurrent.getLugarDeLlegada();
            a[5] = busCurrent.getHoraInicio();
            a[6] = busCurrent.getHoraLlegada();
            a[7] = busCurrent.getTarifaGeneral();
            a[8] = busCurrent.getTarifaEstudiante();
            a[9] = busCurrent.getTarifaTerceraEdad();
            a[10] = busCurrent.getTotalAsientos();
            a[11] = busCurrent.getCantPasajeros();
            int asieLibres = busCurrent.getTotalAsientos() - busCurrent.getCantPasajeros();
            a[12] = asieLibres;
            String rentabilidad = String.format("%.2f", busCurrent.getRentabilidad());;
            a[13] = (rentabilidad +" %");
            modelo.addRow(a);
        }
    }
            

    private Opcion3ListarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @SuppressWarnings("unchecked")
        
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel1.setText("LISTAR VIAJES BUS");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(505, 505, 505)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );

        pack();
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
            java.util.logging.Logger.getLogger(Opcion3ListarTodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opcion3ListarTodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opcion3ListarTodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opcion3ListarTodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Opcion3ListarTodos().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
