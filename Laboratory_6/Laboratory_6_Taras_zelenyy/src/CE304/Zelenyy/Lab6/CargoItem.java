package CE304.Zelenyy.Lab6;

/**
 * Клас, що представляє товар у трюмі корабля.
 */
public abstract class CargoItem {
    private String name;
    private double weight;

    public CargoItem(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    // Метод для отримання представлення товару як рядок.
    @Override
    public String toString() {
        return "CargoItem{" + "name='" + name + '\'' + ", weight=" + weight + '}';
    }
}