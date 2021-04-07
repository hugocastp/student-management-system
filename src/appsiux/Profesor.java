
package appsiux;

import java.io.Serializable;


public class Profesor extends Persona implements Serializable{
  
  String titulo;
  public MateriaListModel materias = new MateriaListModel();
  public Profesor(String id, String nombre, String apellidoPaterno, String apellidoMaterno,
                  String correo, String titulo){
      
      super(id, nombre,apellidoPaterno,apellidoMaterno,correo);
      this.titulo = titulo;
      /* Materia m = new Materia();
       m.nombre = "Materia Ejemplo";
       materias.addMateria(m);*/
  }
    
  public Profesor(){
      super();
     this.titulo = "Titulo";
  }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
  
  
}
