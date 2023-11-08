package CE304.Zelenyy.Lab3;

import CE304.Zelenyy.Lab3.model.Computer;
import CE304.Zelenyy.Lab3.model.DesktopComputer;
import CE304.Zelenyy.Lab3.model.Laptop;
import CE304.Zelenyy.Lab3.model.interfaces.IComputer;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                displayMenu();

                int command = parseCommand();
                switch (command) {
                    case 0:
                        System.exit(0);
                    case 1:
                        new DesktopComputer();
                        break;
                    case 2:
                        new Laptop();
                        break;
                    case 3:
                        printAllComputers();
                        break;
                    case 4:
                        if (!printAllComputers()) {
                            System.out.println("\u001B[31mYou cannot enable a computer because there are no computers created.\u001B[0m");
                            break;
                        }
                        handleComputerOperations();
                        break;
                    default:
                        System.out.println("\u001B[31mInvalid command.\u001B[0m");
                        break;
                }
            } catch (NumberFormatException | FileNotFoundException e) {
                System.out.println("\u001B[31mPlease enter a valid number for the command.\u001B[0m");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Choose command: " +
                "\n0 - Exit" +
                "\n1 - Create desktop computer" +
                "\n2 - Create laptop" +
                "\n3 - Print existing computers" +
                "\n4 - Start computer" +
                "\nEnter command: ");
    }

    private static int parseCommand() {
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static boolean printAllComputers() {
        List<IComputer> computers = Computer.getComputers();
        if (computers.isEmpty()) {
            return false;
        }
        for (IComputer computer : computers) {
            System.out.println(computer);
        }
        return true;
    }

    private static IComputer getComputerByName(String name) {
        return Computer.getComputers()
                .stream()
                .filter(computer -> computer.toString().contains(name))
                .findFirst()
                .orElse(null);
    }

    private static String getProgramName() {
        System.out.println("Enter program name: ");
        return scanner.nextLine().trim();
    }

    private static void handleComputerOperations() {
        System.out.println("Enter computer name: ");
        String name = scanner.nextLine().trim();

        IComputer targetComputer = getComputerByName(name);
        if (targetComputer != null) {
            targetComputer.start();
            System.out.printf("Computer %s started.\n", name);

            while (true) {
                try {
                    System.out.println("Choose command: " +
                            "\n0 - Shut down" +
                            "\n1 - Installing program" +
                            "\n2 - Uninstalling program" +
                            "\n3 - Display all installed programs" +
                            "\nEnter command: ");

                    int command = parseCommand();

                    switch (command) {
                        case 0:
                            targetComputer.shutDown();
                            System.out.printf("Computer %s shut down.\n", name);
                            return;
                        case 1:
                            String programName = getProgramName();
                            targetComputer.installProgram(programName);
                            System.out.printf("Program %s installed.\n", programName);
                            break;
                        case 2:
                            programName = getProgramName();
                            targetComputer.uninstallProgram(programName);
                            System.out.printf("Program %s uninstalled.\n", programName);
                            break;
                        case 3:
                            targetComputer.displayAllInstalledPrograms();
                            break;
                        default:
                            System.out.println("\u001B[31mInvalid command.\u001B[0m");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\u001B[31mPlease enter a valid number for the command.\u001B[0m");
                }
            }
        } else {
            System.out.println("\u001B[31mComputer not found.\u001B[0m");
        }
    }
}
