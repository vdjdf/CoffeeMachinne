package CoffeeMachine;

public class CoffeeContainer {
    private double currentAmountCoffeeGr;
    public static final double MAX_AMOUNT_COFFEE_GR = 1000.0;
    Coffee coffee;

    public double getCurrentAmountCoffeeGr() {
        return currentAmountCoffeeGr;
    }

    public boolean addCoffee(double newCoffeeGr, Coffee coffee) {
        if (newCoffeeGr < 0) {
            System.out.println("метод только досыпает кофе, используйте положительные значения");
            return false;
        }
        if (!(coffee.equals(this.coffee))) {
            this.coffee = coffee;
            currentAmountCoffeeGr = 0;
        }
        return checkingForAddCoffee(newCoffeeGr, coffee);
    }


    private boolean checkingForAddCoffee(double newCoffeeGr, Coffee coffee) {
        if (MAX_AMOUNT_COFFEE_GR == currentAmountCoffeeGr) {
            System.out.println("невозможно засыпать кофе, контейнер заполнен");
            return false;
        } else if (newCoffeeGr + currentAmountCoffeeGr >= MAX_AMOUNT_COFFEE_GR) {
            currentAmountCoffeeGr = CoffeeContainer.MAX_AMOUNT_COFFEE_GR;
            System.out.println("кофе засыпан до максимума , контейнер заполнен");
            this.coffee = coffee;
            return true;
        } else {
            currentAmountCoffeeGr += newCoffeeGr;
            this.coffee = coffee;
            return true;
        }
    }

    public void removeCoffee(double coffeeConsumption) {
        currentAmountCoffeeGr -= coffeeConsumption;
    }

    public boolean checkForMakeCoffee(double coffeeConsumption) {
        return coffeeConsumption > currentAmountCoffeeGr;
    }

    public String getFullNameCoffee() {
        return coffee.getFullNameCoffee();
    }

}
