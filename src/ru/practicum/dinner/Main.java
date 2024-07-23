package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;


    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Завершение работы программы.");
                    return;
                default:
                    System.out.println("Введена неверная команда. Повторите ввод.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addDishType(dishType, dishName);// добавьте новое блюдо
        System.out.println(dc.dinnerList);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        if (dc.dinnerList.isEmpty()) {
            System.out.println("Список блюд пуст. Необходимо выполнить команду №1.\n");
            return;
        }

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();

        boolean checkNumberOfCombos = true;
        while (checkNumberOfCombos) {
            if (numberOfCombos < 1) {
                System.out.println("Введено неверное количество наборов блюд. Повторите ввод. \n");
                numberOfCombos = scanner.nextInt();
            } else {
                checkNumberOfCombos = false;
            }
        }

        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        ArrayList<String> komboListtype = new ArrayList<>();
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                komboListtype.add(nextItem);
                nextItem = scanner.nextLine();
            } else {
                System.out.println("Данный тип  отсутствует в списке, повторите ввод.");
                nextItem = scanner.nextLine();
            }
        }

        // сгенерируйте комбинации блюд и выведите на экран
        dc.createKombo(komboListtype, numberOfCombos);
    }
}
