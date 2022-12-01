/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Pilas.Pila;
import Controlador.Utilidades.Utilidades;
import Modelo.Expresion;
import javax.swing.JOptionPane;

/**
 *
 * @author vivic
 */
public class frmInicio extends javax.swing.JFrame implements Runnable {

    Expresion expresiones[] = new Expresion[20];
    ModeloTabla modeloTabla = new ModeloTabla();
    ModeloTablaStack modeloTablaSimulacion = new ModeloTablaStack();
    Integer counter = 0;
    Expresion expresion = null;
    Thread hilo;

    /**
     * Creates new form frmInicio
     */
    public final void startView() {
        initComponents();
        this.setLocationRelativeTo(null);
        limpiarCampos();
        counter = Utilidades.cargar(expresiones);
    }

    public frmInicio() {
        startView();
    }

    private void cargarTablaExpresiones() {
        modeloTabla.setExpresions(expresiones);
        tblExpresiones.setModel(modeloTabla);
        tblExpresiones.updateUI();
        jScrollPane1.setVisible(true);
    }

    private void cargarTablaSimulacion() {
        Integer selectedRow = tblExpresiones.getSelectedRow();
        // System.out.println(selectedRow);

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione una fila de la tabla para simular",
                    "Seleccionar item",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        expresion = expresiones[selectedRow];

        hilo = new Thread(this);
        hilo.start();
    }

    private void limpiarCampos() {
        txtExpresion.setText("");
        cargarTablaExpresiones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtExpresion = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpresiones = new javax.swing.JTable();
        btnSimularExpresion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSimulacion = new javax.swing.JTable();
        btnSimularTodo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Crear expresión");

        jLabel2.setText("Ingrese expresión:");

        btnCrear.setText("Crear expresión");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrear)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tblExpresiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tblExpresiones);

        btnSimularExpresion.setText("Simular Expresion");
        btnSimularExpresion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularExpresionActionPerformed(evt);
            }
        });

        tblSimulacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblSimulacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(tblSimulacion);

        btnSimularTodo.setText("Simular todo");
        btnSimularTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimularTodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimularExpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSimularTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimularExpresion)
                    .addComponent(btnSimularTodo))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        crearExpresion();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnSimularExpresionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularExpresionActionPerformed
        // TODO add your handling code here:
        cargarTablaSimulacion();
    }//GEN-LAST:event_btnSimularExpresionActionPerformed

    private void btnSimularTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimularTodoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new frmSimulacion().setVisible(true);
    }//GEN-LAST:event_btnSimularTodoActionPerformed

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
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicio().setVisible(true);
            }
        });
    }

    public void crearExpresion() {
        try {
            System.out.println("Counter: " + counter + " Length: " + expresiones.length);

            if (counter >= expresiones.length) {
                JOptionPane.showMessageDialog(
                        null,
                        "Se ha superado el límite de expresiones",
                        "Tabla llena",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            String strExpresion = txtExpresion.getText().trim();

            if ("".equals(strExpresion)) {
                JOptionPane.showMessageDialog(
                        null,
                        "El campo expresión es requerido!",
                        "Información incompleta",
                        JOptionPane.ERROR_MESSAGE
                );
            } else {
                Expresion expresion = new Expresion();
                expresion.setExpresion(strExpresion);
                expresiones[counter] = expresion;
                counter++;

                // y guardo en el JSON
                Utilidades.guardar(expresiones);
            }
            limpiarCampos();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnSimularExpresion;
    public javax.swing.JButton btnSimularTodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tblExpresiones;
    public javax.swing.JTable tblSimulacion;
    public javax.swing.JTextField txtExpresion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Pila pasos = new Pila(25);
        String restExpresion = expresion.getExpresion();

        try {
            // System.out.println("En run");
            Boolean terminado = false;
            while (!terminado) {
                terminado = expresion.obtenerPilaValidacionPorPasos(pasos, restExpresion);
                // System.out.println("Rest expretion: " + restExpresion + "   -> terminado: " + terminado);
                if (terminado) {
                    break;
                }
                modeloTablaSimulacion.setPasos(pasos.toArray());
                modeloTablaSimulacion.setExpresion(expresion);
                tblSimulacion.setModel(modeloTablaSimulacion);
                tblSimulacion.updateUI();
                jScrollPane1.setVisible(true);
                restExpresion = restExpresion.substring(1, restExpresion.length());
                Thread.sleep(900);
            }

            String result = "La expresión es ";
            result += expresion.getEsValida() ? "VALIDA" : "NO VALIDA";

            JOptionPane.showMessageDialog(null, result);
        } catch (Exception ex) {
            System.out.println(ex);
            ex.printStackTrace();
        }
    }
}
