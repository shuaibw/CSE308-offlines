package decoratorPattern.decorator;

import decoratorPattern.burger.Burger;

public class OnionRings extends BurgerDecorator{
    Burger burger;

    public OnionRings(Burger burger) {
        this.burger = burger;
        this.cost = 45;
        this.description = burger.getDescription() + ", Onion Rings";
    }

    @Override
    public int getCost() {
        return burger.getCost() + cost;
    }
}
