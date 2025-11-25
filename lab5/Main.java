package lab5;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter the value of x: ");
            double x = scanner.nextDouble();

            
            Calculate calculate = new Calculate();

        
            double y = calculate.calculate(x);

            
            writeResultToText("result.txt", x, y);
            writeResultToBinary("result.dat", x, y);

            System.out.println("Computation result written to result.txt and result.dat");

            
            readFromTextFile("result.txt");

           
            readFromBinaryFile("result.dat");

        } catch (IOException e) {
            System.out.println("An error occurred while handling files: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }

    public static void writeResultToText(String fileName, double x, double y) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write("Input: " + x + "\n");
            writer.write("Result: " + y + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static void writeResultToBinary(String fileName, double x, double y) throws IOException {
        DataOutputStream outputStream = null;
        try {
            outputStream = new DataOutputStream(new FileOutputStream(fileName));
            outputStream.writeDouble(x);
            outputStream.writeDouble(y);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static void readFromTextFile(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from text file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the reader: " + e.getMessage());
            }
        }
    }

    public static void readFromBinaryFile(String fileName) {
        DataInputStream inputStream = null;
        try {
            inputStream = new DataInputStream(new FileInputStream(fileName));
            double x = inputStream.readDouble();
            double y = inputStream.readDouble();
            System.out.println("Read from binary file - x: " + x + ", y: " + y);
        } catch (IOException e) {
            System.out.println("Error reading from binary file: " + e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the input stream: " + e.getMessage());
            }
        }
    }
}
