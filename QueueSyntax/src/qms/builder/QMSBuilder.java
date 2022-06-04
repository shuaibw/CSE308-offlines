package qms.builder;

import qms.factory.CommModuleFactory;
import qms.factory.PackageFactory;
import qms.product.QMS;
import qms.product.application.Application;

public class QMSBuilder implements IBuilder {
    private QMS qms;

    public QMSBuilder() {
        qms = new QMS();
    }

    public QMS getSystem() {
        return qms;
    }

    @Override
    public void createApp() {
        qms.setApp(new Application());
    }

    @Override
    public void setCommChannel(String type) {
        CommModuleFactory factory = new CommModuleFactory();
        qms.setCommModule(factory.getCommModule(type));
    }

    @Override
    public void setDisplayUnits(String packName, int count) {
        if(count<=0){
            System.out.println("Please enter a non-negative quantity");
            return;
        }
        PackageFactory factory = PackageFactory.createFactory(packName);
        qms.setPackName(factory.getPackageName());
        for (int i = 0; i < count; i++) qms.addDisplayUnits(factory.getDisplayUnit());
    }
}
