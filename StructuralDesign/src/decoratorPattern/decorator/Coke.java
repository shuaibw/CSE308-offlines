package decoratorPattern.decorator;

import decoratorPattern.burger.Burger;

public class Coke extends BurgerDecorator{
    Burger burger;

    public Coke(Burger burger) {
        this.burger = burger;
        this.description = burger.getDescription() + ", coke";
        this.cost = 9;
    }

    @Override
    public int getCost() {
        return burger.getCost() + cost;
    }
}
