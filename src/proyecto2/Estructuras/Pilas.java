/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2.Estructuras;

/**
 *
 * @author Buste
 */
public class Pilas {
    private int MaxSize;
    private int[] PilaArray;
    private int top;
    
    public Pilas (int s) {
        MaxSize = s;
        PilaArray = new int[s];
        top = -1;
    }
    
    public void push(int item){
        if(top == MaxSize - 1){
            System.out.println("Stack is full");
        }else{
            top++;
            PilaArray[top] = item;
        }
    }
  
    public void pop(){
        if(top ==-1) {
            System.out.println("Stack is full");
        }else{
            top--;
        }
    }
    
    public int peek(){
        return PilaArray[top];
    }
}
