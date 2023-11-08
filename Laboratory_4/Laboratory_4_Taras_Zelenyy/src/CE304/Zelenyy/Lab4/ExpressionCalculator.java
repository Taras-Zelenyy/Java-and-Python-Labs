// Знаходиться у файлі ExpressionCalculator.java в пакеті Група.Прізвище.Lab4

package CE304.Zelenyy.Lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас ExpressionCalculator для обчислення математичного виразу.
 */
public class ExpressionCalculator {

    /**
     * Обчислює вираз y = ctg(x) / sin(7x - 1).
     *
     * @param x вхідний параметр виразу.
     * @return результат обчислення виразу.
     * @throws ArithmeticException якщо виникає ділення на нуль.
     */
    public double calculateExpression(double x) throws ArithmeticException {
        double sinValue = Math.sin(7 * x - 1);
        if (sinValue == 0) {
            throw new ArithmeticException("Ділення на нуль в знаменнику виразу.");
        }
        return (1 / Math.tan(x)) / sinValue;
    }

    /**
     * Записує результат в файл.
     *
     * @param result результат для запису.
     * @param filePath шлях до файлу.
     * @throws IOException якщо виникає помилка при записі у файл.
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Результат обчислення: " + result);
        }
    }

    /**
     * Драйвер для демонстрації роботи класу.
     */
    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Будь ласка, введіть значення x: ");
            double x = scanner.nextDouble(); // Отримання значення x від користувача

            double result = calculator.calculateExpression(x); // Використання введеного значення
            calculator.writeResultToFile(result, "result.txt");
            System.out.println("Обчислення успішно завершене. Результат записано у файл.");
        } catch (InputMismatchException e) {
            System.err.println("Помилка: введено некоректне значення для x.");
        } catch (ArithmeticException e) {
            System.err.println("Помилка при обчисленні: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Помилка при записі результату у файл: " + e.getMessage());
        }
    }
}
