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
//        JFileChooser archivo = new JFileChooser();
//        archivo.setCurrentDirectory(new File(System.getProperty("user.dir")));
//        int resultado = archivo.showOpenDialog(null);
//
//        if (resultado == JFileChooser.APPROVE_OPTION) {
//            File seleccionado = archivo.getSelectedFile();
//            String nombreArchivo = seleccionado.getAbsolutePath();
//            leerArchivo(nombreArchivo);
//        } else {
//            System.out.println("No se seleccionó un archivo");
//        }
          leerArchivo("../Archivos/FndCompl.txt");
          leerArchivo("../Archivos/GraphQLREST.txt");
          leerArchivo("../Archivos/gridconfig.txt");
          leerArchivo("../Archivos/i18n.txt");

          //Leer archivo deberia retornar el objeto que creen de Articulo Cientifico
          // y luego lo insertan en la estructura de datos que utilicen
    }

    public static void leerArchivo(String nombreArchivo) throws IOException {
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            String titulo = "";
            String autores = "";
            String resumen = "";
            String palabras_clave;
            int modo = 1;
            while ((linea = lector.readLine()) != null) {
                if(linea.equals("Autores")){
                    modo = 2;
                }else if(linea.equals("Resumen")){
                    modo = 3;
                }else if(linea.toLowerCase().contains("palabras clave")){
                    linea = linea.toLowerCase().replace("palabras clave:", resumen);
                    palabras_clave = linea;
                    break;
                }
                
                else if(modo == 1){
                    if(!linea.isBlank()){
                        titulo += linea;
                    }
                }else if (modo == 2){
                    autores += linea + ",";
                }else if (modo ==3){
                    resumen += linea;
                }
                System.out.println(linea);
            }
            //CREAR EL OBJETO DE ARTICULO
        } catch (IOException e) {
            mostrarError(e);
        }
    }

    private static void mostrarError(IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }
}