package decoratorPattern.decorator;

import decoratorPattern.burger.Burger;

public class Coffee extends BurgerDecorator{
    Burger burger;

    public Coffee(Burger burger) {
        this.burger = burger;
        this.description = burger.getDescription() + ", coffee";
        this.cost = 13;
    }

    @Override
    public int getCost() {
        return burger.getCost() + cost;
    }
}
