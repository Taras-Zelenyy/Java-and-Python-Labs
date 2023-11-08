package CE304.Zelenyy.Lab3.model;

public class HardDrive {
    private int capacity; // in GB

    public HardDrive() {
        capacity = 512; // default capacity
    }

    public HardDrive(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return capacity + "GB, ";
    }
}
