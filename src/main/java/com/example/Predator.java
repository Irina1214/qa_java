package com.example;

import java.util.List;

/**
 * Интерфейс хищник.
 *
 * @author Irina_Zakirova
 */

public interface Predator {
    /**
     * Метод употребления мяса.
     * @return Список того, что употребляет хищник в пищу.
     * @throws Exception
     */
    List<String> eatMeat() throws Exception;
}
