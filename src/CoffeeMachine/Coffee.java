package CoffeeMachine;

import java.util.HashMap;
import java.util.Objects;

public class Coffee {
    private String nameCoffee;
    private CoffeeType coffeeType;
    private static HashMap<Integer, Coffee> hashMapCoffee = new HashMap();
    private static Integer numberCoffee = 0;

    public Coffee(String nameCoffee, CoffeeType coffeeType) {
        this.nameCoffee = nameCoffee;
        this.coffeeType = coffeeType;
        numberCoffee++;
        hashMapCoffee.put(numberCoffee, this);
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

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public String getNameCoffee() {
        return nameCoffee;
    }

    public static HashMap<Integer, Coffee> getHashMapCoffee() {
        return (HashMap<Integer, Coffee>) hashMapCoffee;
    }

    @Override
    public String toString() {
        return getFullNameCoffee();
    }
}
