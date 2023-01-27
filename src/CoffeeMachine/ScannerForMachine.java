package CoffeeMachine;

import java.util.Scanner;

public class ScannerForMachine {

    int amountCupMl = 0;
    StrongCoffeeType strongCoffeeType;
    Coffee coffee;
    CoffeeMachine coffeeMachine;

    public ScannerForMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void scannerCoffee() {
        Scanner scanner = new Scanner(System.in);
        int iterable;
        int lastInt;
        while (true) {
            manuLayer1();
            iterable = scanner.nextInt();
            lastInt = manuLayer2(iterable);
            if (lastInt == 777) {
                break;
            } else if (lastInt == 0) {
                continue;
            }
            iterable = scanner.nextInt();
            lastInt = manuLayer3(lastInt, iterable);
            if (lastInt == 0) {
                continue;
            }
            iterable = scanner.nextInt();
            lastInt = manuLayer4(lastInt, iterable);
            if (lastInt == 0) {
                continue;
            }
            iterable = scanner.nextInt();
            manuLayer5(lastInt, iterable);
        }
        scanner.close();
    }

    private void manuLayer1() {
        System.out.println("\nВас приветствует кофемашина , я умею:" +
                "\n1.Приготовить кофейный напиток" +
                "\n2.Добавить воды" +
                "\n3.Добавить кофе" +
                "\n4.Выключить");
    }

    private int manuLayer2(int iterable) {
        if (iterable == 1) {
            System.out.println("Выберете крепкость напитка:" +
                    "\n1. " + StrongCoffeeType.MILD.getStrongCoffee() +
                    "\n2. " + StrongCoffeeType.NORMAL.getStrongCoffee() +
                    "\n3. " + StrongCoffeeType.STRONG.getStrongCoffee());
            return 1;
        } else if (iterable == 2) {
            System.out.println(
                    "Сколько воды добавить?");
            return 2;
        } else if (iterable == 3) {
            System.out.println("Какой кофе вы хотите добавить?");
            Coffee.getHashMapCoffee().forEach((k, v) -> System.out.println(k + ". " + v));
            return 3;
        } else if (iterable == 4) {
            System.out.println("Кофемашина переходит в спящий режим");
            return 777;
        } else {
            System.out.println("Некорректный вод. введите только одну цифру, например : 2 ");
            return 0;
        }
    }

    private int manuLayer3(int lastInt, int iterable) {
        if (lastInt == 1) {
            if (iterable == 1) {
                strongCoffeeType = StrongCoffeeType.MILD;
            } else if (iterable == 2) {
                strongCoffeeType = StrongCoffeeType.NORMAL;
            } else if (iterable == 3) {
                strongCoffeeType = StrongCoffeeType.STRONG;
            }
            System.out.println("Выберете размер кружки:");
            return 1;
        } else if (lastInt == 2) {
            if (coffeeMachine.addWatter(iterable)) {
                System.out.println("Вы успешно залили воду");

            }
            return 0;

        } else if (lastInt == 3) {
            coffee = Coffee.getHashMapCoffee().get(iterable);
            System.out.println("Сколько грамм кофе вы хотите добавить?");
            return 3;
        } else {
            System.out.println("Некорректный вод. Введите число.");
            return 0;
        }
    }

    private int manuLayer4(int lastInt, int iterable) {
        if (lastInt == 1) {
            amountCupMl = iterable;
            System.out.println("Выберете тип кофе" +
                    "\n1. " + CoffeeType.BEANS +
                    "\n2. " + CoffeeType.GROUND);
            return 1;
        } else if (lastInt == 3) {
            if (coffeeMachine.addCoffee(iterable, coffee)) {
                System.out.println("Вы успешно добавили кофе");
            }
            return 0;
        } else {
            System.out.println("Некорректный вод. Введите число.");
            return 0;
        }
    }

    private int manuLayer5(int lastInt, int iterable) {
        CoffeeType coffeeType = CoffeeType.GROUND;
        if (lastInt == 1) {
            if (iterable == 1) {
                coffeeType = CoffeeType.BEANS;
            }
            System.out.println(coffeeMachine.makeCoffee(strongCoffeeType, amountCupMl, coffeeType));
        }
        return 0;
    }

}
