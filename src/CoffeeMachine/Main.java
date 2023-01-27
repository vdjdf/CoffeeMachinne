package CoffeeMachine;


public class Main {
    public static void main(String[] args) {

        Coffee nescafe = new Coffee("Нескафе ГОЛД", CoffeeType.GROUND);
        Coffee nescafe2 = new Coffee("Нескафе ГОЛД ЗОЛОТАЯ ОБЖАРКА", CoffeeType.BEANS);
        Coffee nescafe3 = new Coffee("Нескафе ДЛЯ КАМПУСЯТ", CoffeeType.BEANS);
        Coffee nescafe4 = new Coffee("Нескафе БАРИСТО", CoffeeType.GROUND);
        CoffeeMachine nespresso = new CoffeeMachine();
        nespresso.scanner();

    }
}
