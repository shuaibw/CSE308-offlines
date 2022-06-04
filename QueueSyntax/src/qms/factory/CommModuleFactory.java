package qms.factory;

import qms.product.communication.CommModule;
import qms.product.communication.SIMModule;
import qms.product.communication.WiFiModule;

public class CommModuleFactory {
    public CommModuleFactory() {
    }

    public CommModule getCommModule(String type) {
        if (type.equalsIgnoreCase("sim")) return new SIMModule();
        else if (type.equalsIgnoreCase("wifi")) return new WiFiModule();
        else {
            System.out.println("Invalid Communication Module. Creating default SIM module");
            return new SIMModule();
        }
    }
}
