package CE304.Zelenyy.Lab3.model.interfaces;

public interface IComputer {
    void start();
    void shutDown();
    void installProgram(String programName);
    void uninstallProgram(String programName);
    void  displayAllInstalledPrograms();
}
