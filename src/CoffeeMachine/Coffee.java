package CoffeeMachine;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(nameCoffee, coffee.nameCoffee) && coffeeType == coffee.coffeeType;
    }

}
//        ВТОРОЙ ВАРИАНТ
//        return nameCoffee.equals(coffee.nameCoffee) && coffeeType.getDescription().equals(coffee.coffeeType.getDescription());