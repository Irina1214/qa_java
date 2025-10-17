package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FelineParameterizedTest {
    Feline feline = new Feline();

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "5, 5",
            "100, 100"
    })
    @DisplayName("Проверка конкретных значений getKittens")
    void testGetKittensWithSpecificValues(int input, int expected) {
        assertEquals(expected, feline.getKittens(input));
    }
}
