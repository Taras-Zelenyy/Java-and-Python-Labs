package CE304.Zelenyy.Lab2;

import static java.lang.System.out;
import java.io.*;

/**
 * This class serves as a driver to demonstrate the functionality of the Computer class.
 */
public class ComputerApp {
    public static void main(String[] args) {
        try {
            Computer computer = new Computer();
            computer.start();
            out.print("Processor speed: " + computer.getProcessorSpeed() + " GHz\n");
            out.print("RAM size: " + computer.getRAMSize() + " GB\n");
            out.print("Hard drive capacity: " + computer.getHardDriveCapacity() + " GB\n");
            computer.installProgram("MS Office");
            computer.uninstallProgram("MS Office");
            computer.shutDown();
            computer.dispose(); // Ensure the file resources are properly closed
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
