/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//package entrega_final.entrega_final;

//import com.mycompany.venta_pasajes_final.Empresa;

import java.io.*;
import java.util.ArrayList;



/**
 *
 * @author cabel
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    
    Empresa empresa;
    
    public VentanaPrincipal(Empresa empresa) {
        initComponents();
        this.empresa = empresa;
        //cargaDatosInicialesTemporal(empresa);
        importar(empresa);
    }
    
    public void cargaDatosInicialesTemporal(Empresa empresa){
        System.out.println("Cargando datos iniciales de manera temporal...");
        
        //BUS 1
        ViajeBus viajeBus = new ViajeBus("Patricio C.","29345","OPTD3472","Quillota","Valparaíso","13:40:00","15:45:00",3500,2000,1850,15000,20);
        empresa.agregarViajeBus(viajeBus);
        //AGREGAR PASAJEROS BUS 1
        
        Pasajero pasajero = new Pasajero("Ana", "12345678-9", "General", 5, "29345");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Pedro", "98765432-1", "Tercera Edad", 12, "29345");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("María", "45678901-2", "Estudiante", 20, "29345");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Juan", "56789012-3", "General", 8, "29345");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Luisa", "34567890-4", "General", 15, "29345");
        viajeBus.agregarPasajero(pasajero);
        
        //BUS 2
        viajeBus = new ViajeBus("Juan Perez","29346","LPBY-17","Santiago","Atacama","08:00:00","16:00:00",20000,15000,15000,800000,40);
        empresa.agregarViajeBus(viajeBus);
        
        //AGREGAR PASAJEROS BUS 2
        
        pasajero = new Pasajero("Fernando", "78901234-5", "General", 3, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Isabel", "89012345-6", "Tercera Edad", 9, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Gabriel", "90123456-7", "Estudiante", 15, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Sofía", "01234567-8", "General", 18, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Diego", "12345678-9", "General", 7, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Marta", "23456789-0", "General", 14, "29346");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Javier", "34567890-1", "Estudiante", 6, "29346");
        viajeBus.agregarPasajero(pasajero);
        

        //BUS 3
        viajeBus = new ViajeBus("Luis M.", "29347", "ERXG-5621", "Santiago", "Rancagua", "08:30:00", "10:45:00", 3000, 1800, 1500, 12000, 25);
        empresa.agregarViajeBus(viajeBus);

        //AGREGAR PASAJEROS BUS 3

        pasajero = new Pasajero("Fernando", "78901234-5", "General", 3, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Isabel", "89012345-6", "Tercera Edad", 9, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Gabriel", "90123456-7", "Estudiante", 15, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Sofía", "01234567-8", "General", 18, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Diego", "12345678-9", "General", 7, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Marta", "23456789-0", "General", 14, "29347");
        viajeBus.agregarPasajero(pasajero);
        
        pasajero = new Pasajero("Javier", "34567890-1", "Estudiante", 6, "29347");
        viajeBus.agregarPasajero(pasajero);

        
        //BUS 4
        viajeBus = new ViajeBus("María R.", "29348", "TYSF-9876", "Cali", "Medellín", "09:15:00", "12:30:00", 2800, 1600, 1400, 11000, 30);
        empresa.agregarViajeBus(viajeBus);
        //AGREGAR PASAJEROS BUS 4
        pasajero = new Pasajero("Juan", "98765432-1", "General", 7, "29348");
        viajeBus.agregarPasajero(pasajero);
        pasajero = new Pasajero("Ana", "45678901-2", "Tercera Edad", 12, "29348");
        viajeBus.agregarPasajero(pasajero);
        pasajero = new Pasajero("Carlos", "76543210-9", "General", 25, "29348");
        viajeBus.agregarPasajero(pasajero);
        pasajero = new Pasajero("María", "11223344-5", "Especial", 2, "29348");
        
        //BUS 5
        viajeBus = new ViajeBus("Diego Torres", "29349", "XYZ-789", "Punta Arenas", "Torres del Paine", "06:00", "15:00", 30000, 25000, 25000, 1050000,35);
        empresa.agregarViajeBus(viajeBus);
    }
    
    public void importar(Empresa empresa){
        String line; // Variable para almacenar cada línea del archivo

        try (BufferedReader br = new BufferedReader(new FileReader("buses.csv"))) {//buses
            // Leer el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Dividir la línea en campos usando el delimitador
                String[] data = line.split(",");
                
                if (!data[0].equals("nombreChofer")) {
                    ViajeBus viajeBus = new ViajeBus(data[0], data[1], data[2],  data[3], data[4], data[5],
                                                     data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8]),
                                                     Integer.parseInt(data[9]), Integer.parseInt(data[11]), Integer.parseInt(data[10]));            
                    
                    empresa.agregarViajeBus(viajeBus);
                }    
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("personas.csv"))) {//personas
            // Leer el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Dividir la línea en campos usando el delimitador
                String[] data = line.split(",");
                
                if (!data[0].equals("nombrePasajero")) {
                    Pasajero pasajero = new Pasajero(data[0], data[1], data[2],  Integer.parseInt(data[3]), data[4]);            
                    ViajeBus viajeBus = empresa.getViajeBus(data[4]);
                    viajeBus.agregarPasajero(pasajero);
                }    
                
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }
    
    public void Exportar(Empresa empresa)
    {
        String csv1 ="buses.csv";
        String csv2 ="personas.csv";
        try (FileWriter fileWriter1 = new FileWriter(csv1);FileWriter fileWriter2 = new FileWriter(csv2)) {
            // Escribir la cabecera del archivo CSV pasajeros
            fileWriter2.write("nombrePasajero,rutPasajero,tipoPasajero,numeroAsiento,codigoViaje\n");
             // Escribir la cabecera del archivo CSV buses
            fileWriter1.write("nombreChofer,codigoViaje,matricula,lugarInicio,lugarLlegada,");
            fileWriter1.write("horaInicio,horaLlegada,tarifaGeneral,tarifaTerceraEdad,tarifaEstudiante,");
            fileWriter1.write("totalAsientos,costoViaje\n");
            ArrayList<ViajeBus> listaViajeBus = empresa.obtenerTodosViajeBus();

            for (ViajeBus viajeBus : listaViajeBus) {
                fileWriter1.write(viajeBus.getNombreChofer()+","+viajeBus.getCodigo()+","+viajeBus.getMatricula()+",");
                fileWriter1.write(viajeBus.getLugarDeInicio()+","+viajeBus.getLugarDeLlegada()+","+viajeBus.getHoraInicio()+",");
                fileWriter1.write(viajeBus.getHoraLlegada()+","+viajeBus.getTarifaGeneral()+","+viajeBus.getTarifaTerceraEdad()+",");
                fileWriter1.write(viajeBus.getTarifaEstudiante()+","+viajeBus.getTotalAsientos()+","+viajeBus.getCostoTotal()+"\n");
                //guardado de personas
                
                ArrayList<Pasajero> listaDePasajeros = viajeBus.obtenerListaPasajeros();
                
                for (Pasajero pasajero : listaDePasajeros) {
                    fileWriter2.write(pasajero.getNombrePasajero()+","+pasajero.getRut()+","+pasajero.getTipo()+",");
                    fileWriter2.write(pasajero.getNroAsiento()+","+pasajero.getCodigoViajePasajero()+"\n");
                    
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    private VentanaPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton0 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setText("COMPRA Y VENTA DE PASAJES EN TERMINAL DE BUSES");

        jButton1.setText("Agregar viaje de bus en el sistema.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar viaje de bus del sistema.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Listar viajes de bus del sistema.");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Agregar pasajero a viaje de bus.");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar pasajero de viaje de bus.");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Listar pasajeros de viaje de bus.");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton0.setText("Salir");
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });

        jButton7.setText("Modificar Pasajero");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(79, 79, 79)
                        .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6))
                    .addComponent(jButton0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Opcion2Jframe op2 = new Opcion2Jframe(empresa);
        op2.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Opcion5Jframe op5 = new Opcion5Jframe(empresa);
        op5.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Opcion1Jframe op1 = new Opcion1Jframe(empresa);
        op1.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Opcion3Jframe op3 = new Opcion3Jframe(empresa);
        op3.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Opcion4Jframe op4 = new Opcion4Jframe(empresa);
        op4.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Opcion6Jframe op6 = new Opcion6Jframe(empresa);
        op6.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Opcion7Jframe op7 = new Opcion7Jframe(empresa);
        op7.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed
        // TODO add your handling code here:
        Exportar(empresa);
        System.exit(0);
        
    }//GEN-LAST:event_jButton0ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
