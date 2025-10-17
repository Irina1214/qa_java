package com.example;

import java.util.List;

/**
 * Класс животное.
 *
 * @author Irina_Zakirova
 */
public class Animal {

    /**
     * Получение списка пищи.
     * @param animalKind
     * @return Вид пищи.
     * @throws Exception
     */
    public List<String> getFood(String animalKind) throws Exception {
        if ("Травоядное".equals(animalKind)) {
            return List.of("Трава", "Различные растения");
        } else if ("Хищник".equals(animalKind)) {
            return List.of("Животные", "Птицы", "Рыба");
        } else {
            throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }

    /**
     * Информация о семействах.
     * @return Семейства животных.
     */
    public String getFamily() {
        return "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    }
}