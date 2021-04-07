
package appsiux;

import java.io.Serializable;
import javax.swing.AbstractListModel;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ProfesorListModel extends AbstractListModel implements Serializable{
    private static final long serialVersionUID = 1L;
    private ArrayList<Profesor> listProfesor = new ArrayList<Profesor>();
    
    @Override
    public int getSize() {
        return listProfesor.size(); //devuelve el tamaño completo de elementos en el JList
    }
    @Override
    public String getElementAt(int index) {
        Profesor p = (Profesor) listProfesor.get(index);
      return p.getId()+ "  "+p.getNombre()+"  "+p.getApellidoPaterno()+ "  "+p.getApellidoMaterno()+ "  "+
             p.getCorreo()+"  "+ p.getTitulo(); // esto es lo que nos muestra la lista al agregar el objeto
    }
    
    public void addProfesor(Profesor p){
  listProfesor.add(p);
  this.fireIntervalAdded(this, getSize(), getSize()+1);
 }
    
    public void eliminarProfesor(int index0){
   listProfesor.remove(index0);
   this.fireIntervalRemoved(index0, getSize(), getSize()+1);
 }
    
 public void actualizarProfesor(int opcion, int profSeleccion){
     
    String nombre = " ",apellidop = " ",apellidom = " ",correo= " ", id= " ",titulo = " ";
      boolean x=false;
     Profesor p = listProfesor.get(profSeleccion);
     
    switch(opcion){
        case 0:
            
            nombre =JOptionPane.showInputDialog("Ingrese el nombre:");
            try{
            if(nombre.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Nombre no ingresado");
                break;
           
            }else{
                p.setNombre(nombre);
            }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
            }
        break;
         case 1:
             try{
           apellidop = JOptionPane.showInputDialog("Ingrese el apellido paterno:");
            if(apellidop.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Apellido paterno no ingresado");
                return;
           
            }else{
                p.setApellidoPaterno(apellidop);
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
                p.setApellidoMaterno(apellidom);
            }
             }catch(Exception e){
                  JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
             }
        break;
         case 3:
             try{
            correo = JOptionPane.showInputDialog("Ingrese el correo:");
             if(correo.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Correo no ingresado");
                return;
           
            }else{
             // Patrón para validar el email
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(correo);
            if (mather.find() == true){}else{ //Validamos el correo
              JOptionPane.showMessageDialog(null, "Introduce un correo electrónico válido","Error",ERROR_MESSAGE); break;}
        
                p.setCorreo(correo);
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
              for (Profesor prof : this.listProfesor) {
                 x = false;
                if (prof.getId().equals(id)){
                   x = true;
                   break;
                }else{
                    x = false;
                  
                    }
                }
              if (x == true){
               JOptionPane.showMessageDialog(null,"El ID ingresado ya existe");
              }else{
                   p.setId(id);
              }
            }
           
           }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
             }
        break;
         case 5:
            try{
            titulo = JOptionPane.showInputDialog("Ingrese el título:");
             if(titulo.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Título no ingresado");
                return;
            }else{
                p.setTitulo(titulo);
            }
             }catch(Exception e){
                  JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
             }
            break;
         default:
             JOptionPane.showMessageDialog(null,"Cancelado.");
             
                         
    }
     listProfesor.set(profSeleccion, p);
         fireContentsChanged(profSeleccion,getSize(), getSize()+1);
     }
    public Profesor getProfesor(int index){
  return (Profesor) listProfesor.get(index);
}
    public ArrayList<Profesor> getProfesorList(){
        return listProfesor;
    }
    
public void setListProfesor(ArrayList<Profesor> profesor){
    listProfesor = profesor;
  }
    
    
    
    
} 
