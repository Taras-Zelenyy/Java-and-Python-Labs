package CE304.Zelenyy.Lab2;

import java.io.*;

/*
* 1) Processor, RAM, HardDrive, PrintWriter - private і в одному файлі
* 2) Хуйво побудовані конструктори
* */

/**
 * Represents a computer with basic components like processor, RAM, and hard drive.
 */
public class Computer {
    private Processor processor;
    private RAM ram;
    private HardDrive hardDrive;
    private PrintWriter fout;

    /**
     * Default constructor initializing computer with default components.
     * @throws FileNotFoundException if the log file cannot be created or opened.
     */
    // Default constructor
    public Computer() throws FileNotFoundException {
        processor = new Processor();
        ram = new RAM();
        hardDrive = new HardDrive();
        fout = new PrintWriter(new File("Log.txt"));
    }

    // Constructor with specific parameters
    public Computer(double processorSpeed, int ramSize, int hddCapacity) throws FileNotFoundException {
        processor = new Processor(processorSpeed);
        ram = new RAM(ramSize);
        hardDrive = new HardDrive(hddCapacity);
        fout = new PrintWriter(new File("Log.txt"));
    }

    // Constructor with processor and RAM specifics, default hard drive
    public Computer(double processorSpeed, int ramSize) throws FileNotFoundException {
        processor = new Processor(processorSpeed);
        ram = new RAM(ramSize);
        hardDrive = new HardDrive();
        fout = new PrintWriter(new File("Log.txt"));
    }

    public void start() {
        fout.print("Computer started.\n");
        fout.flush();
    }

    public void shutDown() {
        fout.print("Computer shut down.\n");
        fout.flush();
    }

    public void installProgram(String programName) {
        fout.print("Installing program: " + programName + "\n");
        fout.flush();
    }

    public void uninstallProgram(String programName) {
        fout.print("Uninstalling program: " + programName + "\n");
        fout.flush();
    }



    public double getProcessorSpeed() {
        return processor.getSpeed();
    }

    public int getRAMSize() {
        return ram.getSize();
    }

    public int getHardDriveCapacity() {
        return hardDrive.getCapacity();
    }

    public void dispose() {
        fout.close();
    }

    class Processor {
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
    }

    class RAM {
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
    }

    class HardDrive {
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
    }
}
