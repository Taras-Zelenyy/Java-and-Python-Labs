package CE304.Zelenyy.Lab3.model;

import CE304.Zelenyy.Lab3.model.interfaces.IComputer;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public abstract class Computer implements IComputer {
    private static ArrayList<IComputer> computers = new ArrayList<>();
    private ArrayList<String> instaledprogram = new ArrayList<>();
    private String name;
    private Processor processor;
    private RAM ram;
    private HardDrive hardDrive;
    private PrintWriter fout;

    public Computer() throws FileNotFoundException {
        super();
        name = "User " + UUID.randomUUID().toString().substring(0, 10);
        computers.add(this);
        processor = new Processor();
        ram = new RAM();
        hardDrive = new HardDrive();
        fout = new PrintWriter(new File("Log.txt"));
    }

    public static ArrayList<IComputer> getComputers() {
        if (computers.isEmpty()) {
            System.out.println("No computers created.");
        }
        return computers;
    }


    @Override
    public void start() {
        fout.print("Computer started " + name + "\n");
        fout.flush();
    }

    @Override
    public void shutDown() {
        fout.println("Computer shut down " + name);
        fout.flush();
    }

    @Override
    public void installProgram(String programName) {
        instaledprogram.add(programName);
        fout.println("Installing program: " + programName + " in computer " + name);
        fout.flush();
    }

    @Override
    public void uninstallProgram(String programName) {
        instaledprogram.remove(programName);
        fout.println("Uninstalling program: " + programName + " in computer " + name);
        fout.flush();
    }

    public void  displayAllInstalledPrograms()
    {
        fout.println("Displaying all installed programs in computer " + name);
        System.out.println("Displaying all installed programs in computer " + name);
        fout.flush();
        for (String s: instaledprogram) {
            fout.println(s);
            System.out.println(s);
            fout.flush();
        }
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", processor=" + processor +
                ", ram=" + ram +
                ", hardDrive=" + hardDrive;
    }
}
