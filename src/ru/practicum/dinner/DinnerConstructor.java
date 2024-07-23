package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerList = new HashMap<>();
    HashMap<String, ArrayList<String>> randomList = new HashMap<>();
    Random random = new Random();

    void addDishType(String dishType, String dishName) {
        if (checkType(dishType)) {
            dinnerList.get(dishType).add(dishName);
        } else {
            ArrayList<String> dish = new ArrayList<>();
            dish.add(dishName);
            dinnerList.put(dishType, dish);
        }
    }

    void createKombo(ArrayList<String> typeList, int numberOfCombos) {
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо " + (i + 1));
            ArrayList<String> k1 = new ArrayList<>();
            for (String type : typeList) {
                k1.add(dinnerList.get(type).get(random.nextInt(dinnerList.get(type).size())));
            }
            randomList.put("Комбо " + (i + 1), k1);
            System.out.println(randomList.get("Комбо " + (i + 1)));
        }
    }

    boolean checkType(String type) {            //проверка наличия ключа (типа блюда)
        if (dinnerList.containsKey(type)) {
            return true;
        }
        return false;
    }
}
