/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author SUSANA
 */
public class Ejercicio2Basico {
    public static void main(String[] args) {
        String imagenOrigen = "files/imagen.png";
        String imagenCopia = "files/imagen_copia.png";
        // Creamos el objeto File origen y destino
        File file = new File(imagenOrigen);
        File fileCopy = new File(imagenCopia);
        // Streams para leer y escribir
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            System.out.println("Haciendo la copia...");

            // Creamos los streams de entrada y de salida
            fis = new FileInputStream(file);
            fos = new FileOutputStream(fileCopy);

            // Vamos leyendo de un fichero y escribiendo en el otro, byte a byte
            int temp = fis.read();
            while (temp != -1) {
                fos.write(temp);
                temp = fis.read();
            }

            System.out.println("Ficheros copiados");

        } catch (FileNotFoundException ex) {
            System.out.println("Ficheros no encontrados");
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException ex) {
                System.out.println("Error cerrando ficheros");
            }
        }
    }
}
