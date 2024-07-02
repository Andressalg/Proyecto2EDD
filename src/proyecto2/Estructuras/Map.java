/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package proyecto2.Estructuras;


/**
 *
 * @author Buste
 */
class Map {
    
 private HashNodo[] datos;
 public Map(){
     datos = new HashNodo[100];
     
 }
 
 public void put(String key, String value){
     int hash = Math.abs(key.hashCode() % datos.length);
     datos[hash] = new HashNodo(key, value);
 }
 
 public Object get(String key){
      int hash = Math.abs(key.hashCode() % datos.length);
      if(datos[hash]!= null && datos[hash].key.equals((key))){
          return datos[hash].value;
      }else{
          return null;
      }
      
 }
 
 public void remove(String key){
     int hash = Math.abs(key.hashCode() % datos.length);
     if(datos[hash] != null && datos[hash].key.equals(key)){
         datos[hash] = null;
 }
 
}
    
    }
