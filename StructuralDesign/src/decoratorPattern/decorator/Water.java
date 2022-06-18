package decoratorPattern.decorator;

import decoratorPattern.burger.Burger;

public class Water extends BurgerDecorator{
    Burger burger;

    public Water(Burger burger) {
        this.burger = burger;
        this.description = burger.getDescription() + ", water";
        this.cost = 7;
    }

    @Override
    public int getCost() {
        return burger.getCost() + cost;
    }
}
