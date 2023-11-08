package CE304.Zelenyy.Lab3.model;

public class RAM {
    private int size; // in GB

    public RAM() {
        size = 16; // default size
    }

    public RAM(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return size + "GB, ";
    }
}
