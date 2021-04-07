
package appsiux;

import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */

/**
 *
 * @author Melissa Puerto
 */
public class Buscar extends javax.swing.JFrame {

    static MateriaListModel materias = new MateriaListModel();
    static AlumnoListModel alumnos= new AlumnoListModel();
    static ProfesorListModel profesores = new ProfesorListModel();
    int seleccion = -1;
    public Buscar(MateriaListModel materias, ProfesorListModel profesores, AlumnoListModel alumnos) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Buscador");
        setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
        labelM.setVisible(false);
        this.materias = materias;
        this.profesores = profesores;
        this.alumnos = alumnos;
        
    }
     public Buscar() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Buscador");
        setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    public void Buscador(int seleccion, String id){
        switch(seleccion){
            case 0:  //materia
                if(materias.getListMateria().isEmpty()){
                    labelM.setVisible(false);
                    JOptionPane.showMessageDialog(null,"No hay materias en el sistema");
                }else{
            for (Materia materia : materias.getListMateria()) {
                
            if (materia.getId().equals(id))
               {
                    labelM.setVisible(false);
                  JOptionPane.showMessageDialog(null,"Materia encontrada:\n"+materia.getNombre()+"\nID: "+materia.getId());
                 
               break;
        }else {
              
               labelM.setVisible(true);
              }
           }
            
                }
            break;
            case 1: // Profesor
                if(profesores.getProfesorList().isEmpty()){
                    labelM.setVisible(false);
                    JOptionPane.showMessageDialog(null,"No hay profesores en el sistema");
                }else{
                for (Profesor prof : profesores.getProfesorList()) {
            if (prof.getId().equals(id))
               {
                   labelM.setVisible(false);
                  JOptionPane.showMessageDialog(null,"Profesor encontrado:\n"+prof.getNombre()+" "+
                          prof.getApellidoPaterno()+" "+prof.getApellidoMaterno()+"\nID: "+prof.getId()+
                          "\nCorreo: "+prof.getCorreo()+"\nTítulo: "+prof.getTitulo());
               break;
        }else{
                labelM.setVisible(true);
            }
    }
                }
                break;
            case 2: //Alumno
                if(alumnos.getListAlumno().isEmpty()){
                    labelM.setVisible(false);
                    JOptionPane.showMessageDialog(null,"No hay alumnos en el sistema");
                }else{
                    
                
                for (Alumno alum : alumnos.getListAlumno()) {
            if (alum.getId().equals(id))
               {
                   labelM.setVisible(false);
                  JOptionPane.showMessageDialog(null,"Alumno encontrado:\n"+alum.getNombre()+" "+
                          alum.getApellidoPaterno()+" "+alum.getApellidoMaterno()+"\nID: "+alum.getId()+
                          "\nCorreo: "+alum.getCorreo()+"\nEdad: "+alum.getEdad());
              break;
        }else{
                 labelM.setVisible(true);
            }
    }
                break;
                    
        }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbxBuscar = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        labelM = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Materia", "Profesor", "Alumno" }));
        jPanel1.add(cbxBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 77, 172, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 74, -1, -1));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 44, 172, -1));

        jLabel1.setText("Ingrese el ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 22, -1, -1));

        labelM.setText("Ingrese un ID existente");
        jPanel1.add(labelM, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 112, 172, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondoVentana4.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        seleccion = cbxBuscar.getSelectedIndex();
        String id = txtId.getText();
        if (seleccion != -1){
        Buscador(seleccion,id);
        }else{
            JOptionPane.showMessageDialog(null,"Seleccione el tipo de objeto a buscar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelM;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
