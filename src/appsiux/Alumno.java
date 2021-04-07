
package appsiux;

import java.io.Serializable;
import java.util.*;
import javax.swing.JOptionPane;

public class Alumno extends Persona implements Serializable {
    
  int edad;
  HashMap<String, Float> hashCalificaciones = new HashMap<>();
  // Nuestro indice o llave para este tipo de array (HashMap) es el ID de la materia (String) y el valor
  //que almacena es la calificacion del alumno (Float) en esa materia.
  public MateriaListModel materias = new MateriaListModel();
  //Utilizamos un CustomListModel para poder tener un JList mas personalizable 
  public Alumno(String id, String nombre, String apellidoPaterno, String apellidoMaterno,
                String correo, int edad){
      super(id, nombre, apellidoPaterno, apellidoMaterno, correo);
      float f = (float)0;
      hashCalificaciones.put(" ", f);
      this.edad = edad;

  }
  public Alumno (){
      super();
      this.edad = 0;

  }
    
    public void h_addCalif(String id, Float c){
        try{
            if (c >=0 && c<=100){
        hashCalificaciones.put(id, c);  
            }else{
                JOptionPane.showMessageDialog(null, "Ingrese una calificación válida");
                
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public float h_getCalif(String id){
        return hashCalificaciones.get(id);
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public MateriaListModel getMaterias() {
        return materias;
    }

    public void setMaterias(MateriaListModel materias) {
        this.materias = materias;
    }

    public HashMap<String, Float> getHashCalif() {
        return hashCalificaciones;
    }

    public void setHashCalif(HashMap<String, Float> calif) {
        this.hashCalificaciones = calif;
    }
  
  
   
}
