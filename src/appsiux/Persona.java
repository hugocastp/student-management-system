
package appsiux;

import java.io.Serializable;


public abstract class Persona implements Serializable{
    
   String id;
   String nombre;
   String apellidoPaterno;
   String apellidoMaterno;
   String correo;
   
   public Persona(String id, String nombre, String apellidoPaterno,
           String apellidoMaterno, String correo ){
       this.id = id;
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.correo = correo;
            
   }
   
   public Persona(){
       this.id = "XXXXXXX";
       this.nombre = "Nombre";
       this.apellidoPaterno = "apellidoPaterno";
       this.apellidoMaterno = "apellidoMaterno";
       this.correo = "correo";
       
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
   
   
}