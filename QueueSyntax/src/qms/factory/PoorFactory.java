package qms.factory;

import qms.product.display.Display;
import qms.product.display.DisplayUnit;
import qms.product.display.LEDDisplay;
import qms.product.processor.AtMega32Processor;
import qms.product.processor.Processor;

public class PoorFactory extends PackageFactory {
    public PoorFactory() {
        packName = "Poor Package";
    }

    @Override
    public DisplayUnit getDisplayUnit() {
        Display display = new LEDDisplay();
        Processor processor = new AtMega32Processor();
        return new DisplayUnit(display, processor);
    }
}
