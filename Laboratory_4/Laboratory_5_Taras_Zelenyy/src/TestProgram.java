import java.io.*;
import java.util.Scanner;

// Клас для обчислення виразу
class Calculation {
    static double calculate(double x) {
        if (x == 0 || Math.sin(7 * x - 1) == 0) {
            throw new IllegalArgumentException("Неможливо обчислити значення для x = " + x);
        }
        return (1 / Math.tan(x)) / Math.sin(7 * x - 1);
    }
}

// Клас для роботи з файлами
class FileManager {
    static void writeToFile(String filename, String content, boolean append) throws IOException {
        try (FileWriter fw = new FileWriter(filename, append)) {
            fw.write(content + System.lineSeparator());
        }
    }

    static void writeToBinaryFile(String filename, double content) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeDouble(content);
        }
    }

    static String readFromFile(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    static double readFromBinaryFile(String filename) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            return dis.readDouble();
        }
    }
}

// Головний клас програми для тестування
public class TestProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть значення x: ");
        double x = scanner.nextDouble();

        try {
            double result = Calculation.calculate(x);
            System.out.println("Результат обчислення: " + result);

            String textFilename = "result.txt";
            FileManager.writeToFile(textFilename, "Результат: " + result, false);
            System.out.println("Текстовий результат записано у файл: " + textFilename);

            String binaryFilename = "result.bin";
            FileManager.writeToBinaryFile(binaryFilename, result);
            System.out.println("Двійковий результат записано у файл: " + binaryFilename);

            // Читання результатів
            String readTextResult = FileManager.readFromFile(textFilename);
            System.out.println("Прочитаний текстовий файл: " + readTextResult);

            double readBinaryResult = FileManager.readFromBinaryFile(binaryFilename);
            System.out.println("Прочитаний двійковий файл: " + readBinaryResult);

        } catch (IOException e) {
            System.out.println("Помилка при роботі з файлами: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка у обчисленнях: " + e.getMessage());
        }
    }
}
