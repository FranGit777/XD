package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PalabraToString {

    public static void main(String[] args) {
        String rutaArchivo = "C:\\Users\\Usuario.PC-INF-PRUEBA\\IdeaProjects\\TOMAS EL PAPU.txt"; // Cambia esto por la ruta de tu archivo
        List<String> palabras = new ArrayList<>();

        // Cargar el archivo y almacenar las palabras
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabrasLinea = linea.split("[^\\p{L}]+"); // Divide por caracteres no alfabéticos
                for (String palabra : palabrasLinea) {
                    if (!palabra.isEmpty()) { // Solo agregar palabras no vacías
                        palabras.add(palabra);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        // Pedir un número al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la cantidad de letras: ");
        int cantidadLetras = scanner.nextInt();

        // Mostrar palabras con la longitud especificada y contar
        List<String> palabrasEncontradas = new ArrayList<>();
        for (String palabra : palabras) {
            if (palabra.length() == cantidadLetras) {
                palabrasEncontradas.add(palabra);
            }
        }

        // Mostrar resultados
        System.out.println("Palabras con " + cantidadLetras + " letras:");
        for (String palabra : palabrasEncontradas) {
            System.out.println(palabra);
        }

        // Contar y mostrar el número de palabras encontradas
        System.out.println("Total de palabras encontradas: " + palabrasEncontradas.size());

        // Obtener y mostrar las 5 palabras más largas
        palabras.sort(Comparator.comparingInt(String::length).reversed()); // Ordenar por longitud
        System.out.println("\nLas 5 palabras más largas son:");
        int count = Math.min(5, palabras.size()); // Para evitar IndexOutOfBounds
        for (int i = 0; i < count; i++) {
            System.out.println(palabras.get(i));
        }
    }
}