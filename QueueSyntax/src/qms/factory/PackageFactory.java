package qms.factory;

import qms.product.display.DisplayUnit;

public abstract class PackageFactory {
    protected String packName;

    public abstract DisplayUnit getDisplayUnit();

    public String getPackageName() {
        return packName;
    }

    public static PackageFactory createFactory(String name) {
        if (name.equalsIgnoreCase("deluxe")) return new DeluxeFactory();
        else if (name.equalsIgnoreCase("optimal")) return new OptimalFactory();
        else if (name.equalsIgnoreCase("poor")) return new PoorFactory();
        else {
            System.out.println("Invalid package: default Optimal package created");
            return new OptimalFactory();
        }
    }
}
