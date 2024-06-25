/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lectorarchivos;
import java.io.*;

/**
 *
 * @author sl001
 */
public class LectorArchivos {
    public static void main(String[] args) {
        String nombreArchivo = ".txt";

        try {
            try (java.io.BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;
                
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}