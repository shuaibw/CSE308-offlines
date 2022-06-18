package decoratorPattern.decorator;

import decoratorPattern.burger.Burger;

public class FrenchFry extends BurgerDecorator{
    Burger burger;

    public FrenchFry(Burger burger) {
        this.burger = burger;
        this.description = burger.getDescription() + ", French Fry";
        this.cost = 55;
    }

    @Override
    public int getCost() {
        return burger.getCost() + cost;
    }
}
