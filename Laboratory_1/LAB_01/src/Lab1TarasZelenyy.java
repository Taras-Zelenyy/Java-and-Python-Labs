import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Клас <code>Lab1TarasZelenyy</code> створений для демонстрації роботи із зубчастими масивами
 * та запису результатів у файл.
 *
 * @author Taras Zelenyy
 * @version 1.0
 */
public class Lab1TarasZelenyy {

    /**
     * Основний метод для виконання програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір масиву: ");
        n = scanner.nextInt();
        scanner.nextLine();  // Очищення буфера

        System.out.print("Введіть символ для заповнення (лише один символ): ");
        String symbol = scanner.nextLine();

        if (symbol.length() != 1) {
            System.out.println("Введено некоректний символ. Програма завершує роботу.");
            return;
        }

        String[][] array = constructTriangleArray(n, symbol);

        // Виведення масиву
        displayArray(array);

        // Запис масиву в текстовий файл
        saveArrayToFile(array);
    }

    /**
     * Конструює зубчастий масив у формі трикутника за заданими параметрами.
     *
     * @param n розмір масиву
     * @param symbol символ для заповнення
     * @return зубчастий масив у формі трикутника
     */
    private static String[][] constructTriangleArray(int n, String symbol) {
        String[][] array = new String[n][];

        int mid = (n % 2 == 0) ? n / 2 : (n / 2) + 1;

        for (int i = 0; i < mid; i++) {
            array[i] = new String[i + 1];
            for (int j = 0; j <= i; j++) {
                array[i][j] = symbol;
            }
        }

        for (int i = mid; i < n; i++) {
            array[i] = new String[n - i];
            for (int j = 0; j < n - i; j++) {
                array[i][j] = symbol;
            }
        }

        return array;
    }

    /**
     * Відображає заданий масив на екран.
     *
     * @param array масив для відображення
     */
    private static void displayArray(String[][] array) {
        for (String[] row : array) {
            for (String element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    /**
     * Зберігає заданий масив у текстовий файл.
     *
     * @param array масив для збереження
     */
    private static void saveArrayToFile(String[][] array) {
        try {
            PrintWriter writer = new PrintWriter(new File("output.txt"));
            for (String[] row : array) {
                for (String element : row) {
                    writer.print(element);
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Помилка при запису у файл: " + e.getMessage());
        }
    }
}