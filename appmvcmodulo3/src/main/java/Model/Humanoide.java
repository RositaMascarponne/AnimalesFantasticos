/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Rosita
 */
public class Humanoide {
   // 1.ATRIBUTOS----------------------------------------------------------------------------------
    private String nombre;
    private int id;

    
    //2.CONSTRUCTRORES-----------------------------------------------------------------------------
       public Humanoide() {
           
    }
    
    public Humanoide(String nombre) {
        this.nombre = nombre;
      
    }
    
    public Humanoide(int id) {
        this.id = id;
        
    }
    
        
    public Humanoide(int id, String nombre){
          this.id=id;
          this.nombre=nombre;
      }

      
 //3.GETTERS Y SETTERS---------------------------------------------------------------------------------   
    
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
   public void setId(int id){
        this.id=id;
    }

}
