package lab1;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Лабораторна робота 1 - Варіант 16
 * Програма генерує зубчастий масив для квадратної матриці
 * @author ВашеПрізвище
 */
public class Lab1Онущаккі304 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введіть розмір матриці (непарне >= 5): ");
        int size = scanner.nextInt();
        
        System.out.print("Введіть символ для заштрихованої області: ");
        char fillChar = scanner.next().charAt(0);
        
        int center = size / 2;
        int frameSize = size / 4;
        
        
        Object[][] jaggedArray = new Object[size][];
        
        for (int i = 0; i < size; i++) {
            ArrayList<Object> row = new ArrayList<>();
            
            for (int j = 0; j < size; j++) {
                Object element = null;
                
                
                if (Math.abs(i - center) <= frameSize/2 && Math.abs(j - center) <= frameSize/2) {
                    element = '!';
                }
                
                else if (Math.abs(i - center) <= frameSize && Math.abs(j - center) <= frameSize) {
                    element = fillChar;
                }
               
                else {
                    element = '*';
                }
                
                
                if (element != null) {
                    row.add(element);
                }
            }
            
           
            jaggedArray[i] = row.toArray(new Object[row.size()]);
        }
        
        
        System.out.println("\nЗубчастий масив:");
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.printf("Рядок %d (%d елементів): ", i, jaggedArray[i].length);
            for (Object element : jaggedArray[i]) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        
        
        System.out.println("\nВигляд як повна матриця:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
        
        
        try (PrintWriter writer = new PrintWriter("output.txt")) {
            writer.println("Варіант 16 - Зубчастий масив:");
            for (int i = 0; i < jaggedArray.length; i++) {
                writer.printf("Рядок %d: ", i);
                for (Object element : jaggedArray[i]) {
                    writer.print(element + " ");
                }
                writer.println();
            }
            System.out.println("Результат збережено у файл output.txt");
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
        
        scanner.close();
    }
}