package qms.factory;

import qms.product.display.Display;
import qms.product.display.DisplayUnit;
import qms.product.display.LEDDisplay;
import qms.product.processor.ArduinoMegaProcessor;
import qms.product.processor.Processor;

public class OptimalFactory extends PackageFactory {
    public OptimalFactory() {
        packName = "Optimal Package";
    }

    @Override
    public DisplayUnit getDisplayUnit() {
        Display display = new LEDDisplay();
        Processor processor = new ArduinoMegaProcessor();
        return new DisplayUnit(display, processor);
    }
}
