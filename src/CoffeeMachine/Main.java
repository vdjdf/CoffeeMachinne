package CoffeeMachine;

public class Main {
    public static void main(String[] args) {
        Coffee nescafe = new Coffee("Нескафе ГОЛД", CoffeeType.GROUND);
        Coffee nescafe2 = new Coffee("Нескафе ГОЛД", CoffeeType.BEANS);
        CoffeeMachine nespresso = new CoffeeMachine();
        System.out.println(nespresso.makeCoffee(StrongCoffeeType.MILD, 300));
        nespresso.addWatter(650);
        System.out.println(nespresso.makeCoffee(StrongCoffeeType.MILD, 300));
        nespresso.addCoffee(500, nescafe);
        nespresso.addCoffee(300, nescafe);
        System.out.println(nespresso.makeCoffee(StrongCoffeeType.MILD, 300));
        System.out.println(nespresso.getWaterResidue());
        System.out.println(nespresso.getCoffeeResidue());
        nespresso.addCoffee(100, nescafe2);
        System.out.println(nespresso.makeCoffee(StrongCoffeeType.MILD, 300));
        System.out.println(nespresso.getWaterResidue());
        System.out.println(nespresso.getCoffeeResidue());



    }
}
