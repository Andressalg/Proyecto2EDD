/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author salom
 */
public class ResumenExtractor {
    
    public static String leerArchivoTexto(File archivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString();
    }
    
    /**
     * Metodo para extraer el titulo del resumen y 
     * @param texto
     * @return 
     */
    public static String extraerTitulo(String texto) {
    String[] lineas = texto.split("\n");
    StringBuilder tituloBuilder = new StringBuilder();
    for (String linea : lineas) {
        if (linea.startsWith("Autor:")) {
            break;
        }
        tituloBuilder.append(linea).append("\n");
    }
    return tituloBuilder.toString().trim();
}

    /**
     * Metodo para extraer el o los autores
     * @param texto
     * @return 
     */
    public static String[] extraerAutor(String texto) {
    String[] lineas = texto.split("\n");
    StringBuilder autorBuilder = new StringBuilder();
    boolean encontroAutor = false;
    for (String linea : lineas) {
        if (linea.startsWith("Autor:")) {
            if (encontroAutor) {
                autorBuilder.append("\n");
            }
            autorBuilder.append(linea.substring(6).trim());
            encontroAutor = true;
        }
    }
    return autorBuilder.toString().split("\n");
    }
    
    /**
     * Metodo para extraer resumen
     * @param texto
     * @return 
     */
    public static String extraerResumen(String texto) {
    String[] lineas = texto.split("\n");
    boolean encontroResumen = false;
    StringBuilder resumenBuilder = new StringBuilder();
    for (String linea : lineas) {
        if (linea.startsWith("Resumen")) {
            encontroResumen = true;
            continue;
        }
        if (encontroResumen) {
            resumenBuilder.append(linea).append("\n");
        }
    }
    return resumenBuilder.toString().trim();
}
    
    /**
     * Metodo para extraer palabras clave
     * @param texto
     * @return 
     */
    public static String[] extraerPalabrasClave(String texto) {
        String[] lineas = texto.split("\n");
        for (String linea : lineas) {
            if (linea.startsWith("Palabras clave:")) {
                return linea.substring(15).trim().split(",");
            }
        }
        return new String[0];
    }
    
    /**
     * Metodo para crear el objeto Articulo
     * @param archivo
     * @return
     * @throws IOException 
     */
    public static Articulo crearArticulo_Archivo(File archivo) throws IOException {
        String texto = leerArchivoTexto(archivo);
        String titulo = extraerTitulo(texto);
        String[] autores = extraerAutor(texto);
        String resumen = extraerResumen(texto);
        String[] palabrasClave = extraerPalabrasClave(texto);
        return new Articulo(titulo, autores, resumen, palabrasClave);
    }
    
     public static Articulo crearArticuloDesdeTextAreas(String titulo, String[] autores, String resumen, String[] palabrasClave) 
     {
        Articulo articulo = new Articulo(titulo, autores, resumen, palabrasClave);
        return articulo;
     }
}
