package CoffeeMachine;

public class CoffeeMachine {
    private int currentAmountWatterMl;
    private static final int MAX_AMOUNT_WATTER_ML = 1000;
    private static final double COFFEE_CONSUMPTION_AT_MAX_STRONG_GR = 25.0;
    private final CoffeeContainer coffeeContainerBeans = new CoffeeContainer();
    private final CoffeeContainer coffeeContainerGround = new CoffeeContainer();
    private static int amountAllCup;
    ScannerForMachine scanner = new ScannerForMachine(this);


    public String getCoffeeResidue(CoffeeType coffeeType) {
        if (coffeeType == CoffeeType.BEANS) {
            return "Молотого кофе осталось " + coffeeContainerBeans.getCurrentAmountCoffeeGr() + "г";
        }
        return "Зернового кофе осталось " + coffeeContainerGround.getCurrentAmountCoffeeGr() + "г";
    }

    public static int getAmountAllCup() {
        return amountAllCup;
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

    public boolean addCoffee(double newCoffeeGr, Coffee coffee) {
        if (coffee.getCoffeeType() == CoffeeType.BEANS) {
            return coffeeContainerBeans.addCoffee(newCoffeeGr, coffee);
        } else return coffeeContainerGround.addCoffee(newCoffeeGr, coffee);
    }

    public String makeCoffee(StrongCoffeeType strongCoffeeType, int amountCupMl, CoffeeType coffeeType) {
        double coffeeConsumption = strongCoffeeType.getStrongCoffee() * COFFEE_CONSUMPTION_AT_MAX_STRONG_GR;
        if (amountCupMl < 0) {
            return "используйте положительные значения для объема кружки";
        }
        if (amountCupMl > currentAmountWatterMl) {
            return "Долейте воды";
        }

        if (coffeeType == CoffeeType.BEANS) {
            return forMakeCoffee(strongCoffeeType, coffeeConsumption, amountCupMl, coffeeContainerBeans);
        } else
            return forMakeCoffee(strongCoffeeType, coffeeConsumption, amountCupMl, coffeeContainerGround);

    }

    private String forMakeCoffee(StrongCoffeeType strongCoffeeType, double coffeeConsumption, int amountCupMl,
                                 CoffeeContainer coffeeContainer) {
        if (coffeeContainer.checkForMakeCoffee(coffeeConsumption)) {
            return "Досыпьте кофе";
        } else {
            coffeeContainer.removeCoffee(coffeeConsumption);
            currentAmountWatterMl -= amountCupMl;
            amountAllCup++;
            return "Готовлю " + coffeeContainer.getFullNameCoffee() +
                    " объемом " + amountCupMl + " " +
                    "крепость " + strongCoffeeType.getStrongCoffee();
        }
    }

    public void scanner() {
        scanner.scannerCoffee();
    }
}





