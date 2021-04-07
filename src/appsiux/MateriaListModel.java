package appsiux;

import java.io.Serializable;
import javax.swing.AbstractListModel;
import java.util.*;
import javax.swing.JOptionPane;

/*
Clase para manejar el ArrayList de Materias
*/
public class MateriaListModel extends AbstractListModel<String> implements Serializable{
    private static final long serialVersionUID = 1L;
    private ArrayList<Materia> listMateria = new ArrayList<Materia>();
    
    @Override
    public int getSize() {
        return listMateria.size(); //devuelve el tamaño completo de elementos en el JList
    }
    @Override
    public String getElementAt(int index) {
      return listMateria.get(index).nombre; // esto es lo que nos muestra la lista al agregar el objeto
    }
     public String getElementAt2(int index) {//mismo metodo que devuelve el ID
      return listMateria.get(index).id; // esto es lo que nos muestra la lista al agregar el objeto
    }
    
    public void addMateria(Materia m){
  listMateria.add(m);
  this.fireIntervalAdded(this, getSize(), getSize()+1);
 }
    
    public void eliminarMateria(int index0){
   listMateria.remove(index0);
   this.fireIntervalRemoved(index0, getSize(), getSize()+1);
 }
    
    public Materia getMateria(int index){
  return listMateria.get(index);
}

    public void actualizarMateria(int index, int selec){
          boolean x = false;
          Materia m = listMateria.get(index);
          String nombre = " ",id = " ";
        switch (selec){
        
                case 0:
                   
            try{
                nombre = JOptionPane.showInputDialog("Ingrese el nombre de la materia");
            if(nombre.isEmpty()){ /*Si no ha ingresado un nombre, le enviamos un mensaje al usuario
                y el nombre no es modificado.
                */
                 JOptionPane.showMessageDialog(null,"Nombre no ingresado");
               
           
            }else{/*Si el usuario ingresa un nombre, entonces se le asigna al objeto
                con un set.
                */
                m.setNombre(nombre);
                 listMateria.set(index, m);
            }
            }catch(Exception e){ /*Si el usuario da click en el boton Cancelar, saldra
                una excepcion NullPointerException que capturamos en el Catch.
                */
                JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
                
            }
            break;
                case 1:
          try{
           id = JOptionPane.showInputDialog("Ingrese el ID de la materia");
           if(id.isEmpty()){
              JOptionPane.showMessageDialog(null,"ID no ingresado");
              return;
           }else{
              for (Materia mat : this.listMateria) { //recorremos todo el arraylist elemento por elemento
                 x = false;
                if (mat.getId().equals(id)){
                   x = true; //si el ID ingresado es identico a otro existente x = true
                   break;
                }else{
                    x = false; //si no, x = false 
                    }
                }
              if (x == true){ //si x = true, El ID ya existe, le avisamos al usuario
               JOptionPane.showMessageDialog(null,"El ID ingresado ya existe");
              }else{
                   m.setId(id);//si x = false, El ID no existe, entonces se lo asignamos
                    listMateria.set(index, m);
              }
            }
           }catch(Exception e){
               JOptionPane.showMessageDialog(null,"Cancelado","Mensaje",JOptionPane.INFORMATION_MESSAGE); 
             }    
     }
        fireContentsChanged(index,getSize(), getSize()+1);   
    }
    public Object mostrarMateria(int index){
          Materia m = listMateria.get(index);
         
          return m.getNombre();    
    }

    public ArrayList<Materia> getListMateria() {
        return listMateria;
    }

    public void setListMateria(ArrayList<Materia> listMateria) {
        this.listMateria = listMateria;
    }
    
}