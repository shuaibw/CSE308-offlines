package qms.builder;

public interface IBuilder {
    void createApp();
    void setCommChannel(String type);
    void setDisplayUnits(String name, int count);
}
