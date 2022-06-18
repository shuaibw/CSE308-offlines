package decoratorPattern.decorator;

import decoratorPattern.burger.Burger;

public abstract class BurgerDecorator extends Burger {
    public abstract int getCost();
}
