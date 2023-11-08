package CE304.Zelenyy.Lab3.model;

public class Processor {
    private double speed; // in GHz
    public Processor() {
        speed = 3.5; // default speed
    }
    public Processor(double speed) {
        this.speed = speed;
    }
    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return speed + "GHz, ";
    }
}
