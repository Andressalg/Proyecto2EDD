/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lectorarchivos;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFileChooser;

/**
 *
 * @author sl001
 */
public class LectorArchivos {
    public static void main(String[] args) throws IOException {
        JFileChooser archivo = new JFileChooser();
        archivo.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int resultado = archivo.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File seleccionado = archivo.getSelectedFile();
            String nombreArchivo = seleccionado.getAbsolutePath();

            leerArchivo(nombreArchivo);
        } else {
            System.out.println("No se seleccionó un archivo");
        }
    }

    private static void leerArchivo(String nombreArchivo) throws IOException {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            mostrarError(e);
        }
    }

    private static void mostrarError(IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }
}