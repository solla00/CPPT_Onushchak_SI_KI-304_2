package lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть значення x: ");
        double x = scanner.nextDouble();

        try {
            double result = Expression.calculate(x);
            System.out.println("Результат обчислення: y = " + result);

           
            FileWriter writer = new FileWriter("result.txt");
            writer.write("x = " + x + "\n");
            writer.write("y = " + result + "\n");
            writer.close();

            System.out.println("Результат записано в файл result.txt");

        } catch (ArithmeticException e) {
            System.out.println("Помилка обчислення: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка запису в файл: " + e.getMessage());
        }
    }
}