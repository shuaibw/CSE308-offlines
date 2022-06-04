package qms.factory;

import qms.product.display.Display;
import qms.product.display.DisplayUnit;
import qms.product.display.LCDDisplay;
import qms.product.processor.Processor;
import qms.product.processor.RaspberryProcessor;

public class DeluxeFactory extends PackageFactory {
    public DeluxeFactory() {
        packName = "Deluxe Package";
    }

    @Override
    public DisplayUnit getDisplayUnit() {
        Display display = new LCDDisplay();
        Processor processor = new RaspberryProcessor();
        return new DisplayUnit(display, processor);
    }
}
