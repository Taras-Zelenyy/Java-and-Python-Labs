package CE304.Zelenyy.Lab6;

/**
 * Клас Barrel, який розширює CargoItem і представляє бочку на кораблі.
 */
public class Barrel extends CargoItem {
    private String content;

    public Barrel(String name, double weight, String content) {
        super(name, weight);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Barrel{" + "name='" + getName() + '\'' + ", weight=" + getWeight() + ", content='" + content + '\'' + '}';
    }
}