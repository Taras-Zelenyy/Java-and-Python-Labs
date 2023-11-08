package CE304.Zelenyy.Lab6;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Клас CargoHold, який представляє трюм корабля.
 */
public class CargoHold<T extends CargoItem> {
    private ArrayList<T> items;

    public CargoHold() {
        this.items = new ArrayList<>();
    }

    // Метод додавання елементу в трюм
    public void addItem(T item) {
        items.add(item);
    }

    // Метод видалення елементу з трюму
    public boolean removeItem(T item) {
        return items.remove(item);
    }

    // Метод пошуку максимального елементу в трюмі
    public T findMaxItem() {
        return items.stream().max(Comparator.comparingDouble(CargoItem::getWeight)).orElse(null);
    }

    // Метод отримання інформації про всі предмети в трюмі
    public String getAllItemsInfo() {
        StringBuilder info = new StringBuilder();
        for (T item : items) {
            info.append(item.toString()).append("\n");
        }
        return info.toString();
    }

    // Метод отримання кількості предметів в трюмі
    public int getItemCount() {
        return items.size();
    }
}

