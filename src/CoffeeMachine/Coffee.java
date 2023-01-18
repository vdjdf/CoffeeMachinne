package CoffeeMachine;

public class Coffee {
    private String nameCoffee;
    private CoffeeType coffeeType;

    public Coffee(String nameCoffee, CoffeeType coffeeType) {
        this.nameCoffee = nameCoffee;
        this.coffeeType = coffeeType;
    }

    public String getFullNameCoffee() {
        return nameCoffee + " " + coffeeType.getDescription();
    }

}
