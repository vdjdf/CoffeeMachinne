package CoffeeMachine;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Coffee nescafe = new Coffee("Нескафе ГОЛД", CoffeeType.GROUND);
        Coffee nescafe2 = new Coffee("Нескафе ГОЛД", CoffeeType.BEANS);
        CoffeeMachine nespresso = new CoffeeMachine();
        System.out.println(nespresso.makeCoffee(StrongCoffeeType.MILD, 300, CoffeeType.BEANS));
        nespresso.addWatter(650);
        System.out.println(nespresso.makeCoffee(StrongCoffeeType.MILD, 300, CoffeeType.BEANS));
        nespresso.addCoffee(500, nescafe2);
        nespresso.addCoffee(300, nescafe2);
        System.out.println(nespresso.makeCoffee(StrongCoffeeType.MILD, 300, CoffeeType.BEANS));
        System.out.println(nespresso.getWaterResidue());
        System.out.println(nespresso.getCoffeeResidue(CoffeeType.BEANS));
        nespresso.addCoffee(100, nescafe);
        System.out.println(nespresso.makeCoffee(StrongCoffeeType.MILD, 300, CoffeeType.GROUND));
        System.out.println(nespresso.getWaterResidue());
        System.out.println(nespresso.getCoffeeResidue(CoffeeType.GROUND));

    }
}
