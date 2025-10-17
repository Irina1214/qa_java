package com.example;

import java.util.List;

/**
 * Класс кошачьих.
 *
 * @author Irina_Zakirova
 */
public class Feline extends Animal implements Predator {
    /**
     * Питание мясом.
     * @return Список: ["Животные", "Птицы", "Рыба"].
     * @throws Exception
     */
    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    /**
     * Получение семейства.
     * @return "Кошачьи" (вместо общего списка семейств из родительского класса).
     */
    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    /**
     * Метод получения количества котят.
     * @return 1
     */
    public int getKittens() {
        return getKittens(1);
    }

    /**
     * Метод получения количества котят.
     * @param kittensCount
     * @return Переданное количество.
     */
    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}
