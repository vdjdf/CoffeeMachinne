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
                programMakeCoffeePage1();
                break;
            case (2):
                programAddWaterPage1();
                break;
            case (3):
                programAddCoffeePage1();
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

    private void programMakeCoffeePage1() {
        System.out.println("Выберете крепкость напитка:" +
                "\n1. " + StrongCoffeeType.MILD.getStrongCoffee() +
                "\n2. " + StrongCoffeeType.NORMAL.getStrongCoffee() +
                "\n3. " + StrongCoffeeType.STRONG.getStrongCoffee());
        int requestFromConsole = scanner.nextInt();
        switch (requestFromConsole) {
            case (1):
                strongCoffeeType = StrongCoffeeType.MILD;
                programMakeCoffeePage2();
                break;
            case (2):
                strongCoffeeType = StrongCoffeeType.NORMAL;
                programMakeCoffeePage2();
                break;
            case (3):
                strongCoffeeType = StrongCoffeeType.STRONG;
                programMakeCoffeePage2();
                break;
            default:
                System.out.println("Некорректный ввод.");
                start();
                break;
        }
    }

    private void programMakeCoffeePage2() {
        System.out.println("Введите размер кружки:");
        int requestFromConsole = scanner.nextInt();
        amountCupMl = requestFromConsole;
        programMakeCoffeePage3();
    }

    private void programMakeCoffeePage3() {
        System.out.println("Выберете тип кофе" +
                "\n1. " + CoffeeType.BEANS +
                "\n2. " + CoffeeType.GROUND);
        int requestFromConsole = scanner.nextInt();
        switch (requestFromConsole) {
            case (1):
                coffeeType = CoffeeType.BEANS;
                programMakeCoffeePage4();
                break;
            case (2):
                coffeeType = CoffeeType.GROUND;
                programMakeCoffeePage4();
                break;
            default:
                System.out.println("Некорректный ввод.");
                start();
                break;
        }
    }

    private void programMakeCoffeePage4() {
        System.out.println(coffeeMachine.makeCoffee(strongCoffeeType, amountCupMl, coffeeType));
        start();
    }

    private void programAddWaterPage1() {
        System.out.println("Сколько воды добавить?");
        int requestFromConsole = scanner.nextInt();
        if (coffeeMachine.addWatter(requestFromConsole)) {
            System.out.println("Вы успешно залили воду");
        }
        start();
    }

    private void programAddCoffeePage1() {
        System.out.println("Какой кофе вы хотите добавить?");
        Coffee.getHashMapCoffee().forEach((k, v) -> System.out.println(k + ". " + v));
        int requestFromConsole = scanner.nextInt();
        coffee = Coffee.getHashMapCoffee().get(requestFromConsole);
        programAddCoffeePage2();
    }

    private void programAddCoffeePage2() {
        System.out.println("Сколько грамм кофе вы хотите добавить?");
        int requestFromConsole = scanner.nextInt();
        if (coffeeMachine.addCoffee(requestFromConsole, coffee)) {
            System.out.println("Вы успешно добавили кофе");
        }
        start();
    }


}