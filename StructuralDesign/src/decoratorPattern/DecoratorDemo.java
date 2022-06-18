package decoratorPattern;

import decoratorPattern.burger.BeefBurger;
import decoratorPattern.burger.Burger;
import decoratorPattern.burger.VegetableBurger;
import decoratorPattern.decorator.*;

public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("-----Example 1------");
        Burger burger = new BeefBurger();
        burger = new Cheese(burger);
        burger = new FrenchFry(burger);
        invoice(burger);
        System.out.println("-----Example 2------");
        burger = new VegetableBurger();
        burger = new OnionRings(burger);
        burger = new Water(burger);
        invoice(burger);
        System.out.println("-----Example 3------");
        burger = new VegetableBurger();
        burger = new FrenchFry(burger);
        burger = new Coke(burger);
        invoice(burger);
        System.out.println("-----Example 4------");
        burger = new VegetableBurger();
        burger = new OnionRings(burger);
        burger = new Coffee(burger);
        burger = new Water(burger);
        invoice(burger);
        System.out.println("-----Example 5------");
        burger = new BeefBurger();
        invoice(burger);
    }

    public static void invoice(Burger burger){
        System.out.println("You ordered: " + burger.getDescription());
        System.out.println("Total cost: " + burger.getCost() + " BDT");
    }
}
