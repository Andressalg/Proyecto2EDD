/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Clases.LectorArchivos;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author salom
 */
public class Ventana1 extends javax.swing.JFrame {

    /**
     * Creates new form Ventana1
     */
    public Ventana1() {
        initComponents();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Iniciar_btn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Iniciar_btn.setBackground(new java.awt.Color(253, 130, 4));
        Iniciar_btn.setForeground(new java.awt.Color(253, 130, 4));
        Iniciar_btn.setText("       .");
        Iniciar_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Iniciar_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Iniciar_btnMouseClicked(evt);
            }
        });
        getContentPane().add(Iniciar_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 160, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Portada proyecto 500x500.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Iniciar_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Iniciar_btnMouseClicked
        boolean archivosCargados = true;
        LectorArchivos lectorArchivo = new LectorArchivos();
        try{
            LectorArchivos.leerArchivo("../Archivos/FndCompl.txt");
            LectorArchivos.leerArchivo("../Archivos/GraphQLREST.txt");
            LectorArchivos.leerArchivo("../Archivos/gridconfig.txt");
            LectorArchivos.leerArchivo("../Archivos/i18n.txt");
        } catch (IOException e) {
            archivosCargados = false;
            return;
        }
        
        if(archivosCargados){
            Ventana2 v2 = new Ventana2();
            v2.setLocationRelativeTo(null);
            v2.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_Iniciar_btnMouseClicked

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
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Iniciar_btn;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
