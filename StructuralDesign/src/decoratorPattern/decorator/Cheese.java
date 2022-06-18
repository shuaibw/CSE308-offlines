package decoratorPattern.decorator;

import decoratorPattern.burger.Burger;

public class Cheese extends BurgerDecorator{
    Burger burger;
    public Cheese(Burger burger) {
        this.burger = burger;
        this.cost = 25;
        this.description = burger.getDescription() + ", Cheese";
    }

    @Override
    public int getCost() {
        return burger.getCost() + cost;
    }
}
