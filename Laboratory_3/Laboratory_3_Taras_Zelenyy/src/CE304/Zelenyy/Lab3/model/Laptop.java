package CE304.Zelenyy.Lab3.model;

import CE304.Zelenyy.Lab3.model.interfaces.ILaptop;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Laptop extends Computer implements ILaptop {


    private boolean batterySaverMode;
    private int touchpadSensitivityLevel;
    private boolean isSleeping;

    public Laptop(boolean batterySaverMode, int touchpadSensitivityLevel, boolean isSleeping) throws FileNotFoundException {
        super();
        this.batterySaverMode = batterySaverMode;
        this.touchpadSensitivityLevel = touchpadSensitivityLevel;
        this.isSleeping = isSleeping;
    }

    public Laptop(boolean batterySaverMode, int touchpadSensitivityLevel) throws FileNotFoundException {
        super();
        this.batterySaverMode = batterySaverMode;
        this.touchpadSensitivityLevel = touchpadSensitivityLevel;
    }

    public Laptop() throws FileNotFoundException {
        super();
        this.batterySaverMode = false;
        this.touchpadSensitivityLevel = 5;
        this.isSleeping = false;
    }

    @Override
    public void setBatterySaverMode(boolean enabled) {
        this.batterySaverMode = enabled;
        if (enabled) {
            System.out.println("Battery saver mode enabled.");
        } else {
            System.out.println("Battery saver mode disabled.");
        }
    }

    @Override
    public void setTouchpadSensitivity(int level) {
        if (level >= 1 && level <= 10) {
            this.touchpadSensitivityLevel = level;
            System.out.println("Touchpad sensitivity set to level: " + level);
        } else {
            System.out.println("Invalid sensitivity level. Please choose a value between 1 and 10.");
        }
    }

    @Override
    public void sleep() {
        this.isSleeping = true;
        System.out.println("Laptop is now in sleep mode.");
    }

    public boolean isBatterySaverMode() {
        return batterySaverMode;
    }

    public int getTouchpadSensitivityLevel() {
        return touchpadSensitivityLevel;
    }

    public void setTouchpadSensitivityLevel(int touchpadSensitivityLevel) {
        this.touchpadSensitivityLevel = touchpadSensitivityLevel;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean sleeping) {
        isSleeping = sleeping;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                super.toString() +
                "batterySaverMode=" + batterySaverMode +
                ", touchpadSensitivityLevel=" + touchpadSensitivityLevel +
                ", isSleeping=" + isSleeping +
                '}';
    }
}
