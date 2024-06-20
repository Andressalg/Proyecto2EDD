/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2.Estructuras;

/**
 *
 * @author Buste
 */
public class Colas {
   private int MaxSize;
   private int[] ColasArray;
   private int frente;
   private int trasero;
   private int numObjetos;
   
   public Colas(int s){
       MaxSize = s;
       ColasArray = new int[s];
       frente = 0;
       trasero = 1;
       numObjetos = 0;
      
   }
   
   public int peekFrente(){
       return ColasArray[frente];
       
   
   }
   
   public int peekTrasero(){
        return ColasArray[trasero];
    }
   
   public boolean checkEmpty(){
       return numObjetos == 0;
       
   }
   
   public boolean checkFull() {
       return numObjetos == MaxSize;
   }
   
   public void PonerEnCola(int item) {
       if(checkFull()){
           System.out.println("Cola llena");
       }else{
           trasero++;
           ColasArray[trasero] = item;
           numObjetos++;
   
       }
     
   }
       public void QuitarEnCola(){
        if(checkEmpty()){
            System.out.println("Cola Vacia");
        }else{
            frente++;
            numObjetos--;
        }
    }
}
