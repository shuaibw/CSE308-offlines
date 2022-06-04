package qms.builder;

public class Director {
    IBuilder builder;

    public Director(IBuilder builder) {
        this.builder = builder;
    }
    public void construct(String packName, int displayCount, String commChannel){
        builder.setDisplayUnits(packName, displayCount);
        builder.createApp();
        builder.setCommChannel(commChannel);
    }

    public IBuilder getBuilder() {
        return builder;
    }
}
