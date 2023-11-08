package CE304.Zelenyy.Lab6;

/**
 * Клас Container, який розширює CargoItem і представляє контейнер на кораблі.
 */
public class Container extends CargoItem {
    private int volume;

    public Container(String name, double weight, int volume) {
        super(name, weight);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Container{" + "name='" + getName() + '\'' + ", weight=" + getWeight() + ", volume=" + volume + '}';
    }
}
