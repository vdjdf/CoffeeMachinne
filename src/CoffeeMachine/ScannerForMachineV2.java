package CoffeeMachine;

import java.util.Scanner;

public class ScannerForMachineV2 {
    private int amountCupMl;
    private StrongCoffeeType strongCoffeeType;
    private Coffee coffee;
    private CoffeeType coffeeType;
    private CoffeeMachine coffeeMachine;
    Scanner scanner = new Scanner(System.in);

    public ScannerForMachineV2(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void start() {
        mainManu();
    }

    private void mainManu() {

        System.out.println("\nВас приветствует кофемашина , я умею:" +
                "\n1.Приготовить кофейный напиток" +
                "\n2.Добавить воды" +
                "\n3.Добавить кофе" +
                "\n4.Выключить");
        int requestFromConsole = scanner.nextInt();
        switch (requestFromConsole) {
            case (1):
                pageStrongCoffeeType();
                break;
            case (2):
                pageAddWater();
                break;
            case (3):
                pageAddCoffee();
                break;
            case (4):
                System.out.println("Кофемашина переходит в спящий режим");
                scanner.close();
                break;
            default:
                System.out.println("Некорректный ввод.");
                start();
                break;
        }
    }

    private void pageStrongCoffeeType() {
        System.out.println("Выберете крепкость напитка:" +
                "\n1. " + StrongCoffeeType.MILD.getStrongCoffee() +
                "\n2. " + StrongCoffeeType.NORMAL.getStrongCoffee() +
                "\n3. " + StrongCoffeeType.STRONG.getStrongCoffee());
        int requestFromConsole = scanner.nextInt();
        switch (requestFromConsole) {
            case (1):
                strongCoffeeType = StrongCoffeeType.MILD;
                pageAmountCup();
                break;
            case (2):
                strongCoffeeType = StrongCoffeeType.NORMAL;
                pageAmountCup();
                break;
            case (3):
                strongCoffeeType = StrongCoffeeType.STRONG;
                pageAmountCup();
                break;
            default:
                System.out.println("Некорректный ввод.");
                start();
                break;
        }
    }

    private void pageAmountCup() {
        System.out.println("Введите размер кружки:");
        int requestFromConsole = scanner.nextInt();
        amountCupMl = requestFromConsole;
        pageCoffeeType();
    }

    private void pageCoffeeType() {
        System.out.println("Выберете тип кофе" +
                "\n1. " + CoffeeType.BEANS +
                "\n2. " + CoffeeType.GROUND);
        int requestFromConsole = scanner.nextInt();
        switch (requestFromConsole) {
            case (1):
                coffeeType = CoffeeType.BEANS;
                pageMakeCoffee();
                break;
            case (2):
                coffeeType = CoffeeType.GROUND;
                pageMakeCoffee();
                break;
            default:
                System.out.println("Некорректный ввод.");
                start();
                break;
        }
    }

    private void pageMakeCoffee() {
        System.out.println(coffeeMachine.makeCoffee(strongCoffeeType, amountCupMl, coffeeType));
        start();
    }

    private void pageAddWater() {
        System.out.println("Сколько воды добавить?");
        int requestFromConsole = scanner.nextInt();
        if (coffeeMachine.addWatter(requestFromConsole)) {
            System.out.println("Вы успешно залили воду");
        }
        start();
    }

    private void pageAddCoffee() {
        System.out.println("Какой кофе вы хотите добавить?");
        Coffee.getHashMapCoffee().forEach((k, v) -> System.out.println(k + ". " + v));
        int requestFromConsole = scanner.nextInt();
        if (requestFromConsole > Coffee.getHashMapCoffee().size() || requestFromConsole <= 0) {
            System.out.println("Некорректный ввод.");
            start();
           return;
        }
        coffee = Coffee.getHashMapCoffee().get(requestFromConsole);
        pageAddCoffeeGram();
    }

    private void pageAddCoffeeGram() {
        System.out.println("Сколько грамм кофе вы хотите добавить?");
        int requestFromConsole = scanner.nextInt();
        if (coffeeMachine.addCoffee(requestFromConsole, coffee)) {
            System.out.println("Вы успешно добавили кофе");
        }
        start();
    }


}