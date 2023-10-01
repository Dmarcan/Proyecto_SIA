package Ventanas;

import Clases.ViajeBus;
import javax.swing.table.DefaultTableModel;

public class Opcion4JframeMostrarAsientos extends javax.swing.JFrame {
    ViajeBus bus;
    DefaultTableModel modelo = new DefaultTableModel();
    public Opcion4JframeMostrarAsientos(ViajeBus bus) {
        initComponents();
        this.bus = bus;
        initTable(bus);
        
    }

    /*Comentario pendiente*/
    /*Esta función se encarga de inicializar una tabla gráfica que representa los asientos del bus.
    Los asientos ocupados se marcan con "X" y los disponibles con sus números correspondientes.
    La disposición de los asientos en la tabla está controlada por las variables 'cont' y 'asiento'*/
    
    public void initTable(ViajeBus bus) {
        
        modelo.addColumn("");
        modelo.addColumn("");
        modelo.addColumn("PASILLO");
        modelo.addColumn("");
        modelo.addColumn("");
        jTable1.setModel(modelo);
        while (modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        
        byte cont = -1;
        byte asiento = 1;
        int cantidadAsientos = bus.getTotalAsientos();
        Object a[] = new Object[5];
        for (int i = 0 ; i < cantidadAsientos ; i++){
            cont++;
            if (cont == 0)
            {
                if (!bus.estaDisponible(asiento)) a[0] = "X";
                else a[0] = asiento;
            }
            
            if (cont == 1)
            {
               if (!bus.estaDisponible(asiento)) a[1] = "X";
               else a[1] = asiento;
            }
            
            if (cont == 2)
            {
                asiento--;
                cantidadAsientos++;
            }
            
            if (cont == 3)
            {
                if (!bus.estaDisponible(asiento)) a[3] = "X";
                else a[3] = asiento;
            }
            
            if (cont == 4)
            {
                if (!bus.estaDisponible(asiento)) a[4] = "X";
                else a[4] = asiento;
                modelo.addRow(a);
                cont = -1;
            }
            asiento++;
        }
    }
    
    private Opcion4JframeMostrarAsientos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Asientos Disponibles");

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
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
            java.util.logging.Logger.getLogger(Opcion4JframeMostrarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opcion4JframeMostrarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opcion4JframeMostrarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opcion4JframeMostrarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Opcion4JframeMostrarAsientos().setVisible(true);
            }
        });
    }
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
