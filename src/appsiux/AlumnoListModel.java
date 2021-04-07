
package appsiux;

import java.io.Serializable;
import javax.swing.AbstractListModel;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/*Utlizamos esta clase para crear un CustomListModel, utilizando AbstractLisModel
para asi tener un JList mas personalizable.
*/
public class AlumnoListModel extends AbstractListModel<String> implements Serializable{
  private static final long serialVersionUID = 1L;
  private ArrayList<Alumno> listAlumno = new ArrayList<Alumno>(); //ArrayList de alumnos
  //MateriaListModel objetolist = new MateriaListModel();//ArrayList de materias 
  String id;
  @Override
  public int getSize() {
    return listAlumno.size(); // devuelve el tamaño completo de elementos en el JList
  }

  @Override
  public String getElementAt(int index) {
    Alumno a = (Alumno) listAlumno.get(index);
    return a.getId()+" "+a.getNombre()+" "+a.getApellidoPaterno()+ " "+a.getApellidoMaterno()+"  "+a.getCorreo()+ " Edad: "+a.getEdad();
             // esto es lo que nos muestra la lista al agregar el objeto
  }
  
  public void setId(String id){
      this.id = id; /*asigna el valor del parametro(id) a nuestra variable local this.id, que es un ID de materia.
      Esto nos sirve para asignar una calificacion por defecto utilizando el ID como key para el
      HashMap y asi, con otro set, asignarle la calificacion al alumno, todo esto con el fin de evitar
      NullPointerException*/
      
  }
  public void addAlumno(Alumno a) {//agrega un nuevo alumno al arraylist
    listAlumno.add(a);
    this.fireIntervalAdded(this, getSize(), getSize() + 1);
  }

  public void eliminarAlumno(int index0) { //elimina el alumno seleccionado del arraylist
    listAlumno.remove(index0);
    this.fireIntervalRemoved(index0, getSize(), getSize() + 1);
  }

  public void actualizarAlumno(int opcion, int alumSeleccion){ //modifica al alumno seleccionado 
      String nombre = " ",apellidop = " ",apellidom = " ",correo= " ", id= " ";
      int edad = 0;
      boolean x=false;
     Alumno a = listAlumno.get(alumSeleccion); /*Guardamos el alumno seleccionado en un nuevo objeto
     para que toda la información guardada dentro de este no se pierda al modificar. */
     
    switch(opcion){//opciones seleccionadas en el ComboBox
        case 0:
            
            nombre =JOptionPane.showInputDialog("Ingrese el nombre:");//Guardamos el nombre en una variable
            try{
            if(nombre.isEmpty()){ /*Si no ha ingresado un nombre, le enviamos un mensaje al usuario
                y el nombre no es modificado.
                */
                 JOptionPane.showMessageDialog(null,"Nombre no ingresado");
                break;
           
            }else{/*Si el usuario ingresa un nombre, entonces se le asigna al objeto
                con un set.
                */
                a.setNombre(nombre);
            }
            }catch(Exception e){ /*Si el usuario da click en el boton Cancelar, saldra
                una excepcion NullPointerException que capturamos en el Catch.
                */
                JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
            }
        break;
        //Mismo proceso para los siguientes casos
         case 1:
             try{
           apellidop = JOptionPane.showInputDialog("Ingrese el apellido paterno:");
            if(apellidop.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Apellido paterno no ingresado");
                return;
           
            }else{
                a.setApellidoPaterno(apellidop);
            }
             }catch(Exception e){
                  JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
             }
        break;
         case 2:
             try{
            apellidom = JOptionPane.showInputDialog("Ingrese el apellido materno:");
             if(apellidom.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Apellido materno no ingresado");
                return;
           
            }else{
                a.setApellidoMaterno(apellidom);
            }
             }catch(Exception e){
                  JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
             }
        break;
         case 3: /* En este caso no solo verificamos que el correo sea ingresado o no
             tambien verificamos que tenga un formato valido utilizando Pattern y Matcher
             */
             
             try{
            correo = JOptionPane.showInputDialog("Ingrese el correo:");
             if(correo.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Correo no ingresado");
                return;
           
            }else{
             // Patrón para validar el email
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");/*
            ^ nos indica el inicio del patron
            [ ] nos indica el grupo 
            \\ nos indica que el grupo opcional
            * nos indica que es obligatorio
            $ nos indica el final del patron
            */
            Matcher mather = pattern.matcher(correo);
            if (mather.find() == true){}else{ //Validamos el correo
              JOptionPane.showMessageDialog(null, "Introduce un correo electrónico válido","Error",ERROR_MESSAGE); break;}
        
                a.setCorreo(correo);
            }
             }catch(Exception e){
                  JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
             }
        break;
         case 4:
         try{
           id = JOptionPane.showInputDialog("Ingrese el ID:");
           if(id.isEmpty()){
              JOptionPane.showMessageDialog(null,"ID no ingresado");
              return;
           }else{
              for (Alumno alum : this.listAlumno) { //recorremos todo el arraylist elemento por elemento
                 x = false;
                if (alum.getId().equals(id)){
                   x = true; //si el ID ingresado es identico a otro existente x = true
                   break;
                }else{
                    x = false; //si no, x = false
                    }
                }
              if (x == true){ //si x = true, El ID ya existe, le avisamos al usuario
               JOptionPane.showMessageDialog(null,"El ID ingresado ya existe");
              }else{
                   a.setId(id);//si x = false, El ID no existe, entonces se lo asignamos
              }
            }
           }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
             }
        break;
         case 5:
             //convertimos a entero la edad ingresada por el usuario 
         try{
            edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
             if(edad == 0){
                 JOptionPane.showMessageDialog(null,"Edad no ingresada");
                return;
           
             }else{
                a.setEdad(edad);
            }
             } catch (NumberFormatException nfe){
             JOptionPane.showMessageDialog(null,"Ingrese sólo números");
            }catch(Exception e){
              JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
             }
        break;
         default:
             JOptionPane.showMessageDialog(null,"Cancelado.");
             
                         
    }
     listAlumno.set(alumSeleccion, a);
         fireContentsChanged(alumSeleccion,getSize(), getSize()+1);//metodo para actualizar el contenido en el JList cada que es modificado
     }
  
  //Getters y setters
  public Alumno getAlumno(int index) {
      return listAlumno.get(index);
  }

  public void setListAlumnos(ArrayList<Alumno> alumnos){
    listAlumno = alumnos;
  }
  public ArrayList<Alumno> getListAlumno(){
        return listAlumno;
    }

}
