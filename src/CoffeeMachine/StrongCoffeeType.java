package CoffeeMachine;

public enum StrongCoffeeType {
    MILD(0.5),
    NORMAL(0.75),
    STRONG(1.0);
    private double strongCoffee;

    StrongCoffeeType(double strongCoffee) {
        this.strongCoffee = strongCoffee;
    }

    public double getStrongCoffee() {
        return strongCoffee;
    }
}
