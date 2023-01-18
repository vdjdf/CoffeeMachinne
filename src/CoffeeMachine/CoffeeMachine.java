package CoffeeMachine;

public class CoffeeMachine {
    private int currentAmountWatterMl;
    private final int MAX_AMOUNT_WATTER_ML = 1000;
    private double currentAmountCoffeeGr;
    private final double MAX_AMOUNT_COFFEE_GR = 1000.0;
    private final double COFFEE_CONSUMPTION_AT_MAX_STRONG_GR = 300.0;
    private Coffee coffee;


    public String getCoffeeResidue() {
        return "Кофе осталось " + currentAmountCoffeeGr + "г";
    }

    public String getWaterResidue() {
        return "Воды осталось " + currentAmountWatterMl + "мл";
    }

    public void addWatter(int newWatterMl) {
        if (newWatterMl < 0) {
            System.out.println("метод только доливает воду, используйте положительные значения ");
            return;
        }
        if (currentAmountWatterMl == MAX_AMOUNT_WATTER_ML) {
            System.out.println("невозможно залить воды, контейнер заполнен");

        } else if (newWatterMl + currentAmountWatterMl >= MAX_AMOUNT_WATTER_ML) {
            currentAmountWatterMl = MAX_AMOUNT_WATTER_ML;
            System.out.println("вода залита до максимума, контейнер заполнен");
        } else {
            currentAmountWatterMl += newWatterMl;
        }
    }

    public void addCoffee(double newCoffeeGr, Coffee coffee) {

        if (newCoffeeGr < 0) {
            System.out.println("метод только досыпает кофе, используйте положительные значения");
            return;
        }
        if (currentAmountCoffeeGr == MAX_AMOUNT_COFFEE_GR) {
            System.out.println("невозможно засыпать кофе, контейнер заполнен");
        } else if (newCoffeeGr + currentAmountCoffeeGr >= MAX_AMOUNT_COFFEE_GR) {
            this.coffee = coffee;
            currentAmountCoffeeGr = MAX_AMOUNT_COFFEE_GR;
            System.out.println("кофе засыпан до максимума , контейнер заполнен");
        } else {
            this.coffee = coffee;
            currentAmountCoffeeGr += newCoffeeGr;
        }
    }

    public String makeCoffee(double strongCoffee, int AmountCupMl) {
        if (strongCoffee < 0 || strongCoffee > 1) {
            return "метод принимает параметры крепость напитка (от 0 до 1)";
        }
        if (AmountCupMl < 0) {
            return "используйте положительные значения для объема кружки";
        }
        double coffeeConsumption = strongCoffee * COFFEE_CONSUMPTION_AT_MAX_STRONG_GR;
        if (AmountCupMl > currentAmountWatterMl) {
            return "Долейте воды";
        } else if (coffeeConsumption > currentAmountCoffeeGr) {
            return "Досыпьте кофе";
        } else {
            currentAmountCoffeeGr -= coffeeConsumption;
            currentAmountWatterMl -= AmountCupMl;
            return "Готовлю " + coffee.getFullNameCoffee() + " объемом " + AmountCupMl + " крепость " + strongCoffee;
        }
    }

}

