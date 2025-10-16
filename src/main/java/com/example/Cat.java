package com.example;

import java.util.List;

/**
 * Класс кошка.
 *
 * @author Irina_Zakirova
 */
public class Cat {
    /**
     * Поле типа Predator (интерфейс).
     */
    Predator predator;

    /**
     * Конструктор с параметром feline.
     * @param feline
     */
    public Cat(Feline feline) {
        this.predator = feline;
    }

    /**
     * Получение звука кошки
     * @return "Мяу".
     */
    public String getSound() {
        return "Мяу";
    }

    /**
     * Получение списка пищи.
     * @return Спсок пищи для хищников.
     * @throws Exception
     */
    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}
