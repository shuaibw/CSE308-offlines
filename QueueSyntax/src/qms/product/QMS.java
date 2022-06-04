package qms.product;

import qms.product.application.Application;
import qms.product.communication.CommModule;
import qms.product.display.Display;
import qms.product.display.DisplayUnit;
import qms.product.processor.Processor;

import java.util.ArrayList;

public class QMS {
    private ArrayList<DisplayUnit> displayUnits;
    private Product app;
    private Product commModule;
    private String packName;
    private double yearlyFee;

    public QMS() {
        displayUnits = new ArrayList<>();
        yearlyFee = 200;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    public void setCommModule(CommModule commModule) {
        this.commModule = commModule;
    }

    public void setPackName(String name) {
        packName = name;
    }

    public void addDisplayUnits(DisplayUnit unit) {
        displayUnits.add(unit);
    }

    public double getCost() {
        double totalCost = 0;
        totalCost += commModule.price;
        totalCost += app.price;
        for (DisplayUnit d : displayUnits) {
            totalCost += d.price;
        }
        totalCost += yearlyFee;
        return totalCost;
    }

    public void printSystemDescription() {
        DisplayUnit unit = displayUnits.get(0);
        System.out.println("Package type: " + packName);
        System.out.println("Display unit count: " + displayUnits.size());
        System.out.println(unit.getDescription());
        System.out.println("Application: " + app.getDescription());
        System.out.println("Communication module: " + commModule.getDescription());
        System.out.println("--Printing cost analysis--");
        Display display = unit.getDisplay();
        Processor processor = unit.getProcessor();
        System.out.printf("%40s = %.2f$\n", display.getDescription(), display.getPrice());
        System.out.printf("%40s = %.2f$\n", processor.getDescription(), processor.getPrice());
        double unitTotalCost = unit.getPrice() * displayUnits.size();
        System.out.printf("%40s = %.2f$\n", "Display unit total: " + unit.getPrice() + " x " + displayUnits.size(), unitTotalCost);
        System.out.printf("%40s = %.2f$\n", app.getDescription(), app.getPrice());
        System.out.printf("%40s = %.2f$\n", commModule.getDescription(), commModule.getPrice());
        System.out.printf("%40s = %.2f$\n", "Yearly Fee", yearlyFee);

    }
}
