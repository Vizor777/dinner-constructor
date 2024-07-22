package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static Random random;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        random = new Random();

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
                    return;
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

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
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
        dc.createKombo(komboListtype, random, numberOfCombos);
    }
}
