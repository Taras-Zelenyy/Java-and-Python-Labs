// Файл: Main.java
package CE304.Zelenyy.Lab6;

/**
 * Драйвер клас для демонстрації роботи класу CargoHold.
 */
public class Main {
    public static void main(String[] args) {
        CargoHold<CargoItem> cargoHold = new CargoHold<>();

        cargoHold.addItem(new Container("Container1", 500.0, 100));
        cargoHold.addItem(new Barrel("Barrel1", 300.0, "Oil"));

        System.out.println("Max item in the cargo hold: " + cargoHold.findMaxItem());
        System.out.println("All items in the cargo hold:\n" + cargoHold.getAllItemsInfo());
    }
}