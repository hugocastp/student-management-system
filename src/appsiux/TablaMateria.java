
package appsiux;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


public class TablaMateria extends javax.swing.JFrame {

     MateriaListModel listMateria;
     int seleccion;
    /**
     * Creates new form TablaMateria
     */
    
        public TablaMateria(MateriaListModel listMateria, int seleccion) {
        initComponents();
        this.listMateria = listMateria;
        this.seleccion = seleccion;
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Ver materia");
        labelMateria.setText(listMateria.getElementAt(seleccion));
        labelId.setText(listMateria.getElementAt2(seleccion));
      
        ArrayList<Profesor> arrayProf = listMateria.getMateria(seleccion).getProfesor().getProfesorList();
        ArrayList<Alumno> arrayAlum = listMateria.getMateria(seleccion).getArrayAlumno().getListAlumno();
        
        String[][] tabla; //tabla de profesores
         tabla = new String[arrayProf.size()][6];
        for (int i= 0; i < arrayProf.size();i++){
            tabla[i][0] = arrayProf.get(i).getNombre();
            tabla[i][1] = arrayProf.get(i).getApellidoPaterno();
            tabla[i][2] = arrayProf.get(i).getApellidoMaterno();
            tabla[i][3] = arrayProf.get(i).getId();
            tabla[i][4] = arrayProf.get(i).getCorreo();
            tabla[i][5] = arrayProf.get(i).getTitulo();
        }
         tablaProfesores.setModel(new javax.swing.table.DefaultTableModel(tabla, new String[]{
             "Nombre", "Apellido paterno", "Apellido materno", "ID", "Correo", "Título"
         }
         ));
         String[][] tabla2; // tabla de alumnos
         tabla2 = new String[arrayAlum.size()][7];
        for (int i= 0; i < arrayAlum.size();i++){
            tabla2[i][0] = arrayAlum.get(i).getNombre();
            tabla2[i][1] = arrayAlum.get(i).getApellidoPaterno();
            tabla2[i][2] = arrayAlum.get(i).getApellidoMaterno();
            tabla2[i][3] = arrayAlum.get(i).getId();
            tabla2[i][4] = arrayAlum.get(i).getCorreo();
            tabla2[i][5] = Integer.toString(arrayAlum.get(i).getEdad());
            tabla2[i][6] = Float.toString(arrayAlum.get(i).h_getCalif(listMateria.getMateria(seleccion).getId()));
        }
         tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(tabla2, new String[]{
             "Nombre", "Apellido paterno", "Apellido materno", "ID", "Correo", "Edad", "Calificación"
         }
         ));
         
        
    }
          public TablaMateria() {
        initComponents();
        this.listMateria = listMateria;
        this.seleccion = seleccion;
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Ver materia");
        DefaultTableModel modelo = ((DefaultTableModel) tablaProfesores.getModel());
        DefaultTableModel modelo2 = ((DefaultTableModel) tablaAlumnos.getModel());
        ArrayList<Profesor> arrayProf = listMateria.getMateria(seleccion).getProfesor().getProfesorList();
        ArrayList<Alumno> arrayAlum = listMateria.getMateria(seleccion).getArrayAlumno().getListAlumno();
        String[][] tabla;
         tabla = new String[arrayProf.size()][6];
        for (int i= 0; i < arrayProf.size();i++){
            tabla[i][0] = arrayProf.get(i).getNombre();
            tabla[i][1] = arrayProf.get(i).getApellidoPaterno();
            tabla[i][2] = arrayProf.get(i).getApellidoMaterno();
            tabla[i][3] = arrayProf.get(i).getId();
            tabla[i][4] = arrayProf.get(i).getCorreo();
            tabla[i][5] = arrayProf.get(i).getTitulo();
        }
         tablaProfesores.setModel(new javax.swing.table.DefaultTableModel(tabla, new String[]{
              "Nombre", "Apellido paterno", "Apellido materno", "ID", "Correo", "Título"
         }
         ));
         String[][] tabla2; // tabla de alumnos
         tabla2 = new String[arrayProf.size()][7];
        for (int i= 0; i < arrayAlum.size();i++){
            tabla2[i][0] = arrayAlum.get(i).getNombre();
            tabla2[i][1] = arrayAlum.get(i).getApellidoPaterno();
            tabla2[i][2] = arrayAlum.get(i).getApellidoMaterno();
            tabla2[i][3] = arrayAlum.get(i).getId();
            tabla2[i][4] = arrayAlum.get(i).getCorreo();
            tabla2[i][5] = Integer.toString(arrayAlum.get(i).getEdad());
            tabla2[i][6] = Float.toString(arrayAlum.get(i).h_getCalif(listMateria.getMateria(seleccion).getId()));
        }
         tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(tabla, new String[]{
             "Nombre", "Apellido paterno", "Apellido materno", "ID", "Correo", "Edad", "Calificación"
         }
         ));
         
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProfesores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelMateria = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonCalif = new javax.swing.JButton();
        txtCalificacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido paterno", "Apellido materno", "ID", "Correo", "Edad", "Calificación"
            }
        ));
        jScrollPane1.setViewportView(tablaAlumnos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 84, 770, 180));

        tablaProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido paterno", "Apellido materno", "ID", "Correo", "Título"
            }
        ));
        jScrollPane2.setViewportView(tablaProfesores);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 337, 770, 180));

        jLabel1.setText("Alumnos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 56, -1, -1));

        jLabel2.setText("Profesores");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 309, -1, -1));

        labelMateria.setText("MATERIA");
        jPanel1.add(labelMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 12, -1, -1));

        labelId.setText("ID");
        jPanel1.add(labelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 34, 51, -1));

        jLabel3.setText("Materia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 12, -1, -1));

        jLabel4.setText("ID:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 34, -1, -1));

        buttonCalif.setText("Modificar calificación");
        buttonCalif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalifActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCalif, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, 30));

        txtCalificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalificacionKeyTyped(evt);
            }
        });
        jPanel1.add(txtCalificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 34, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondoVentana4.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCalifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalifActionPerformed
       float calificacion = 0;
        try{
            try{
        calificacion = Float.parseFloat(txtCalificacion.getText());
            }catch(Exception e){
            System.out.println("Error:"+e); 
            }
        if (calificacion >100 ){
            JOptionPane.showMessageDialog(this,"Ingrese una calificación entre 0 y 100");
            return;
        }
       }catch(Exception e){
           System.out.println("El error es:"+e);
       }
      int selected = tablaAlumnos.getSelectedRow();
       if (selected != -1 || txtCalificacion.getText()!= null){
           listMateria.getMateria(seleccion).getArrayAlumno().getAlumno(selected).h_addCalif(listMateria.getMateria(seleccion).getId(), calificacion);
          TablaMateria actualizar = new TablaMateria(listMateria, seleccion);
           actualizar.setVisible(true);
           setVisible(false);
    
       }else{
           JOptionPane.showMessageDialog(this,"Seleccione un alumno");
       }
    }//GEN-LAST:event_buttonCalifActionPerformed

    private void txtCalificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalificacionKeyTyped
       char validar = evt.getKeyChar(); 
            if(Character.isLetter(validar)){
                getToolkit();
                evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo números", "Error", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_txtCalificacionKeyTyped

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
            java.util.logging.Logger.getLogger(TablaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelMateria;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTable tablaProfesores;
    private javax.swing.JTextField txtCalificacion;
    // End of variables declaration//GEN-END:variables
}
