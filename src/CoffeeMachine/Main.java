package CoffeeMachine;

public class Main {
    public static void main(String[] args) {
        Coffee nescafe = new Coffee("Нескафе ГОЛД",CoffeeType.GROUND);
        CoffeeMachine nespresso = new CoffeeMachine();
        System.out.println(nespresso.makeCoffee(0.777, 300));
        nespresso.addWatter(500);
        System.out.println(nespresso.makeCoffee(0.777, 300));
        nespresso.addCoffee(500, nescafe);
        System.out.println(nespresso.makeCoffee(0.777, 300));
        System.out.println(nespresso.getWaterResidue());
        System.out.println(nespresso.getCoffeeResidue());

    }
}
