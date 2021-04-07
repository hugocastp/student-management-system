
package appsiux;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.WindowConstants;



public class AltaProfesores extends javax.swing.JFrame {
    static MateriaListModel list_model = new MateriaListModel();
    MateriaListModel listMateria;
    ProfesorListModel listProfesor;
    int seleccionProf;
     
 public AltaProfesores(int seleccionProf, MateriaListModel listMateria, ProfesorListModel listProfesor) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Materias");
        setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
        this.seleccionProf= seleccionProf;
        this.listMateria = listMateria;
        this.listProfesor  = listProfesor;
        
        list_model = listProfesor.getProfesor(seleccionProf).getMaterias(); //pasamos el MateriaListModel que es atributo del alumno
        listCarga.setModel(list_model);// le asignamos el materialistmodel a nuestra lista de materias propia del alumno
        listMateria2.setModel(listMateria);
     }
   
    public AltaProfesores() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Materias");
        setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
    }
     int contador = 0;
    
    public void verificar(int seleccionMateria){
              
    for (Materia m : list_model.getListMateria()) {
        if (m.getId().equals(listMateria.getMateria(seleccionMateria).getId())) {
             contador++;
            JOptionPane.showMessageDialog(null, "Ya está dado de alta en esta materia", "Error",ERROR_MESSAGE);
           break;
        }
    }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listCarga = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listMateria2 = new javax.swing.JList<>();
        buttonBaja = new javax.swing.JButton();
        buttonAlta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(380, 280));
        setMinimumSize(new java.awt.Dimension(380, 280));
        setPreferredSize(new java.awt.Dimension(380, 280));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listCarga.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listCarga);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 38, 130, 140));

        listMateria2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listMateria2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 38, 130, 140));

        buttonBaja.setText("Dar de baja");
        buttonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBajaActionPerformed(evt);
            }
        });
        getContentPane().add(buttonBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 203, -1, -1));

        buttonAlta.setText("Dar de alta");
        buttonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAltaActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 203, -1, -1));

        jLabel1.setText("Cargadas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setText("Disponibles");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondoVentana4.jpg"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(380, 280));
        jLabel3.setMinimumSize(new java.awt.Dimension(380, 280));
        jLabel3.setPreferredSize(new java.awt.Dimension(380, 280));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAltaActionPerformed
    contador = 0;
    int seleccionMateria = listMateria2.getSelectedIndex();// guardamos la materia seleccionada en el JList    
  if (seleccionMateria != -1){//si  tienes una materia seleccionada
      verificar(seleccionMateria);//verificamos que la materia no esta dada de alta
      if (contador ==0){ //Si la materia no es repetida
            Materia m = listMateria.getMateria(seleccionMateria);// obtemeos la materia en la posicion seleccionada
            list_model.addMateria(m);       // agregamos la materia seleccionada al nuevo arrayList del alumno
            Profesor p = listProfesor.getProfesor(seleccionProf); //ahora buscamos el alumno seleccionado y lo guardamos en otra variable
            listMateria.getMateria(seleccionMateria).getProfesor().addProfesor(p); //agregamos el alumno a la materia
  }else{
      JOptionPane.showMessageDialog(null, "Seleccione un profesor");
  }
        }
    }//GEN-LAST:event_buttonAltaActionPerformed

    private void buttonBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBajaActionPerformed
        int index = -1;
        int index2 = -1;
        int seleccionMateria = listCarga.getSelectedIndex();
     
        Profesor p = listProfesor.getProfesor(seleccionProf);
      
        if (seleccionMateria != -1){
            Materia m = list_model.getMateria(seleccionMateria);
            list_model.eliminarMateria(seleccionMateria);
            for (Materia materia : listMateria.getListMateria()) {
                 if (materia.getNombre().equals(m.getNombre())
                    && materia.getId().equals(m.getId())) {
                    index = listMateria.getListMateria().indexOf(materia); //guardamos el indice de la materia
                     for (Profesor profesor : listProfesor.getProfesorList()) {
                          if (profesor.getNombre().equals(p.getNombre())
                    && profesor.getId().equals(p.getId())) {
                              index2 = listProfesor.getProfesorList().indexOf(profesor);//guardamos el indice del alumno
                              listMateria.getMateria(index).getProfesor().eliminarProfesor(index2);
                              
                          }
                    
                    
                } 
                } 
        
            } 
       JOptionPane.showMessageDialog(null,"El profesor "+ listProfesor.getProfesor(seleccionProf).getNombre()+"\n "+
               "se ha dado de baja correctamente de "+listMateria.getMateria(index).getNombre(), "Mensaje",INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_buttonBajaActionPerformed

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
            java.util.logging.Logger.getLogger(AltaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaProfesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaProfesores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAlta;
    private javax.swing.JButton buttonBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listCarga;
    private javax.swing.JList<String> listMateria2;
    // End of variables declaration//GEN-END:variables
}
