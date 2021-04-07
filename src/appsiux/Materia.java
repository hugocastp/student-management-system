
package appsiux;

import java.io.Serializable;
import java.util.*;

public class Materia implements Serializable {
    String id;
    String nombre;

    public AlumnoListModel alumnos = new AlumnoListModel(); // la materia puede tener varios alumnos
    public ProfesorListModel profesor = new ProfesorListModel();//la materia puede tener varios profesores
  //Dentro de nuestras clases personalizadas (AlumnoListModel,ProfesorListModel) se encuentran nuestros
  //ArrayList Alumno y Profesor respectivamente, para poder tener un JList mas personalizable.

    public Materia(String nombre, String id) {
        this.id = id;
        this.nombre = nombre;
       
    }
    

    public Materia() {
       
    }
// Getters y setters
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

    public AlumnoListModel getAlumnosList() {
        return alumnos;
    }

    public void setAlumno(ArrayList<Alumno> alumno) {
        this.alumnos.setListAlumnos(alumno);
    }

    public ProfesorListModel getProfesor() {
        return profesor;
    }
    public AlumnoListModel getArrayAlumno() {
        return alumnos;
    }

}
