import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaPrincipal extends javax.swing.JFrame {
    Empresa empresa;
    
    public VentanaPrincipal(Empresa empresa) throws ViajeBusExisteException, ViajeBusAsientoOcupadoException, PasajeroExisteException{
        initComponents();
        this.empresa = empresa;
        importar(empresa);
    }
    
    public void importar(Empresa empresa) throws ViajeBusExisteException, ViajeBusAsientoOcupadoException{
        String line; // Variable para almacenar cada línea del archivo

        try (BufferedReader br = new BufferedReader(new FileReader("buses.csv"))) {//buses
            // Leer el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Dividir la línea en campos usando el delimitador
                String[] data = line.split(",");
                
                if (!data[0].equals("nombreChofer")) {
                    ViajeBus viajeBus = new ViajeBus(data[0], data[1], data[2],  data[3], data[4], data[5],
                                                     data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8]),
                                                     Integer.parseInt(data[9]), Double.parseDouble(data[11]), Integer.parseInt(data[10]));            
                    
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
        } catch (PasajeroExisteException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @SuppressWarnings("unchecked")
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
        jButton8 = new javax.swing.JButton();

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

        jButton1.setText("Agregar viaje de bus en el sistema");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar viaje de bus del sistema");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Listar viajes de bus del sistema");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Agregar pasajero a viaje de bus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar pasajero de viaje de bus");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Listar pasajeros de viaje de bus");
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

        jButton8.setText("Generar reporte de colecciones");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
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
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(79, 79, 79)
                        .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Opcion2Jframe op2 = new Opcion2Jframe(empresa);
        op2.setVisible(true);
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        Opcion5Jframe op5 = new Opcion5Jframe(empresa);
        op5.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Opcion1Jframe op1 = new Opcion1Jframe(empresa);
        op1.setVisible(true);
        
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        Opcion3Jframe op3 = new Opcion3Jframe(empresa);
        op3.setVisible(true);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        Opcion4Jframe op4 = new Opcion4Jframe(empresa);
        op4.setVisible(true);
        
    }

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        Opcion6Jframe op6 = new Opcion6Jframe(empresa);
        op6.setVisible(true);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        Opcion7Jframe op7 = new Opcion7Jframe(empresa);
        op7.setVisible(true);
    }

    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {
        Exportar(empresa);
        System.exit(0);
        
    }
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt){
        Opcion8Jframe op8 = new Opcion8Jframe(empresa);
        op8.setVisible(true);
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
}
