package CoffeeMachine;

public class CoffeeMachine {
    private int currentAmountWatterMl;
    private static final int MAX_AMOUNT_WATTER_ML = 1000;
    private double currentAmountCoffeeGr;
    private static final double MAX_AMOUNT_COFFEE_GR = 1000.0;
    private static final double COFFEE_CONSUMPTION_AT_MAX_STRONG_GR = 25.0;
    private Coffee coffee;
    private StrongCoffeeType strongCoffeeType;


    public String getCoffeeResidue() {
        return "Кофе осталось " + currentAmountCoffeeGr + "г";
    }

    public String getWaterResidue() {
        return "Воды осталось " + currentAmountWatterMl + "мл";
    }

    public boolean addWatter(int newWatterMl) {
        if (newWatterMl < 0) {
            System.out.println("метод только доливает воду, используйте положительные значения ");
            return false;
        }
        if (currentAmountWatterMl == MAX_AMOUNT_WATTER_ML) {
            System.out.println("невозможно залить воды, контейнер заполнен");
            return false;
        } else if (newWatterMl + currentAmountWatterMl >= MAX_AMOUNT_WATTER_ML) {
            currentAmountWatterMl = MAX_AMOUNT_WATTER_ML;
            System.out.println("вода залита до максимума, контейнер заполнен");
            return true;
        } else {
            currentAmountWatterMl += newWatterMl;
            return true;
        }
    }
    // СТАРЫЙ УБОГИЙ МЕТОД

    //    public boolean addCoffee(double newCoffeeGr, Coffee coffee) {
//
//        if(newCoffeeGr< 0)
//
//    {
//        System.out.println("метод только досыпает кофе, используйте положительные значения");
//        return false;
//        }
//        if (currentAmountCoffeeGr == MAX_AMOUNT_COFFEE_GR) {
//            System.out.println("невозможно засыпать кофе, контейнер заполнен");
//            return false;
//        } else if (newCoffeeGr + currentAmountCoffeeGr >= MAX_AMOUNT_COFFEE_GR) {
//            this.coffee = coffee;
//            currentAmountCoffeeGr = MAX_AMOUNT_COFFEE_GR;
//            System.out.println("кофе засыпан до максимума , контейнер заполнен");
//            return true;
//        } else if (!(coffee.equals(this.coffee))) {
//            currentAmountCoffeeGr = 0;
//            if (newCoffeeGr + currentAmountCoffeeGr >= MAX_AMOUNT_COFFEE_GR) {
//                this.coffee = coffee;
//                currentAmountCoffeeGr = MAX_AMOUNT_COFFEE_GR;
//                System.out.println("кофе засыпан до максимума , контейнер заполнен");
//                return true;
//            } else {
//                this.coffee = coffee;
//                currentAmountCoffeeGr += newCoffeeGr;
//                return true;
//            }
//        } else {
//            this.coffee = coffee;
//            currentAmountCoffeeGr += newCoffeeGr;
//            return true;
//        }
//    }
    public boolean addCoffee(double newCoffeeGr, Coffee coffee) {
        if (newCoffeeGr < 0) {
            System.out.println("метод только досыпает кофе, используйте положительные значения");
            return false;
        }
        if (!(coffee.equals(this.coffee))) {
            this.coffee = coffee;
            currentAmountCoffeeGr = 0;
        }
        return this.checkingForAddCoffee(newCoffeeGr);

    }

    private boolean checkingForAddCoffee(double newCoffeeGr) {
        if (MAX_AMOUNT_COFFEE_GR == currentAmountCoffeeGr) {
            System.out.println("невозможно засыпать кофе, контейнер заполнен");
            return false;
        }
        if (newCoffeeGr + currentAmountCoffeeGr >= MAX_AMOUNT_COFFEE_GR) {
            currentAmountCoffeeGr = MAX_AMOUNT_COFFEE_GR;
            System.out.println("кофе засыпан до максимума , контейнер заполнен");
            return true;
        } else {
            currentAmountCoffeeGr += newCoffeeGr;
            return true;
        }

    }

    public String makeCoffee(StrongCoffeeType strongCoffeeType, int AmountCupMl) {
        if (AmountCupMl < 0) {
            return "используйте положительные значения для объема кружки";
        }
        double coffeeConsumption = strongCoffeeType.getStrongCoffee() * COFFEE_CONSUMPTION_AT_MAX_STRONG_GR;
        if (AmountCupMl > currentAmountWatterMl) {
            return "Долейте воды";
        } else if (coffeeConsumption > currentAmountCoffeeGr) {
            return "Досыпьте кофе";
        } else {
            currentAmountCoffeeGr -= coffeeConsumption;
            currentAmountWatterMl -= AmountCupMl;
            return "Готовлю " + coffee.getFullNameCoffee() + " объемом " + AmountCupMl + " крепость " +
                    strongCoffeeType.getStrongCoffee();
        }
    }

}

