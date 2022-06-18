package decoratorPattern.burger;

public abstract class Burger {
    protected String description = "Unknown Burger";
    protected int cost = 0;
    public String getDescription() {
        return description;
    }

    public int getCost(){
        return cost;
    }
}
