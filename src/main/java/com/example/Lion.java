package com.example;

import java.util.List;

/**
 * Класс лев.
 *
 * @author Irina_Zakirova
 */
public class Lion {
    /**
     * Определение наличия гривы у льва.
     */
    boolean hasMane;
    /**
     * Зависимость - объект класса Feline.
     */
    private Feline feline;

    /**
     * Конструктор с инъекцией зависимости.
     * @param sex - пол животного ("Самец" или "Самка").
     * @param feline -  зависимость, которая внедряется извне.
     * @throws Exception
     */
    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    /**
     * Делегирует вызов объекту Feline.
     * @return Количество котят.
     */
    public int getKittens() {
        return feline.getKittens();
    }

    /**
     * Проверка наличия гривы.
     * @return Наличие гривы.
     */
    public boolean doesHaveMane() {
        return hasMane;
    }

    /**
     * Делегирует вызов объекту feline с параметром "Хищник".
     * @return Список пищи льва.
     * @throws Exception
     */
    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
