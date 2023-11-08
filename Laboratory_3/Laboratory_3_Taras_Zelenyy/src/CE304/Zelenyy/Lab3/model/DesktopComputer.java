package CE304.Zelenyy.Lab3.model;

import CE304.Zelenyy.Lab3.model.interfaces.IDesktopComputer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DesktopComputer extends Computer implements IDesktopComputer {

    private int numberOfMonitors = 1;
    private String graphicsCardModel = "Generic Model";
    private String rgbLightingColor = "White";

    public DesktopComputer() throws FileNotFoundException {
        super();
    }

    public DesktopComputer(int numberOfMonitors, String graphicsCardModel, String rgbLightingColor) throws FileNotFoundException {
        super();
        this.numberOfMonitors = numberOfMonitors;
        this.graphicsCardModel = graphicsCardModel;
        this.rgbLightingColor = rgbLightingColor;
    }

    @Override
    public void addExternalMonitor() {
        this.numberOfMonitors++;
        System.out.println("External monitor added. Total monitors: " + numberOfMonitors);
    }

    @Override
    public void upgradeGraphicsCard() {
        this.graphicsCardModel = "Upgraded Model";
        System.out.println("Graphics card upgraded to: " + graphicsCardModel);
    }

    @Override
    public void setRGBLightingColor(String color) {
        this.rgbLightingColor = color;
        System.out.println("RGB lighting color set to: " + rgbLightingColor);
    }

    public int getNumberOfMonitors() {
        return this.numberOfMonitors;
    }

    public String getGraphicsCardModel() {
        return this.graphicsCardModel;
    }

    public String getRgbLightingColor() {
        return this.rgbLightingColor;
    }

    public void setNumberOfMonitors(int numberOfMonitors) {
        if (numberOfMonitors > 0){
            this.numberOfMonitors = numberOfMonitors;
        }
        else{
            System.out.println("Invalid number of monitors. Please choose a value greater than 0.");
        }

    }

    public void setGraphicsCardModel(String graphicsCardModel) {
        this.graphicsCardModel = graphicsCardModel;
    }

    public void setRgbLightingColor(String rgbLightingColor) {
        this.rgbLightingColor = rgbLightingColor;
    }

    @Override
    public String toString() {

        return "DesktopComputer{" +
                super.toString() +
                "numberOfMonitors=" + numberOfMonitors +
                ", graphicsCardModel='" + graphicsCardModel + '\'' +
                ", rgbLightingColor='" + rgbLightingColor + '\'' +
                '}';
    }
}
