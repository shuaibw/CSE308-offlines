package qms.product.display;

import qms.product.Product;
import qms.product.processor.Processor;

public class DisplayUnit extends Product {
    private Display display;
    private Processor processor;

    public DisplayUnit(Display display, Processor processor) {
        this.display = display;
        this.processor = processor;
        price = display.getPrice() + processor.getPrice();
        type = "Display Unit";
        description = String.format("Display: %s\nProcessor: %s", display.getDescription(), processor.getDescription());
    }

    public Display getDisplay() {
        return display;
    }

    public Processor getProcessor() {
        return processor;
    }
}
