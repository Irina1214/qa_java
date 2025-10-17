package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FelineTest {

    private Feline feline;

    @Spy
    private Feline spyFeline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    @DisplayName("Проверка получения мяса для хищника")
    void testEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood, "Еда для хищника должна соответствовать ожидаемой");
    }

    @Test
    @DisplayName("Проверка вызова getFood с валидным параметром при eatMeat")
    void testEatMeatCallsGetFoodWithCorrectParameter() throws Exception {
        spyFeline.eatMeat();
        verify(spyFeline).getFood("Хищник");
    }

    @Test
    @DisplayName("Проверка получения семейства кошачьих")
    void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily(), "Семейство должно быть 'Кошачьи'");
    }

    @Test
    @DisplayName("Проверка получения котят по умолчанию")
    void testGetKittensWithoutParameters() {
        assertEquals(1, feline.getKittens(), "Количество котят по умолчанию должно быть 1");
    }

    @Test
    @DisplayName("Проверка получения котят с параметром")
    void testGetKittensWithParameter() {
        int expectedCount = 5;
        assertEquals(expectedCount, feline.getKittens(expectedCount), "Количество котят должно соответствовать переданному параметру");
    }

    @Test
    @DisplayName("Проверка получения еды через getFood для хищника")
    void testGetFoodForPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.getFood("Хищник");
        assertEquals(expectedFood, actualFood, "Еда для хищника должна возвращаться через getFood");
    }

    @Test
    @DisplayName("Проверка реализации интерфейса Predator")
    void testImplementsPredatorInterface() {
        assertNotNull(feline, "Feline должен реализовывать интерфейс Predator");
    }

    @Test
    @DisplayName("Проверка связи между getKittens() и getKittens(int)")
    void testGetKittensRelationship() {
        int defaultKittens = feline.getKittens();
        int explicitKittens = feline.getKittens(1);
        assertEquals(defaultKittens, explicitKittens, "getKittens() должен быть эквивалентен getKittens(1)");
    }

    @Test
    @DisplayName("Проверка вызова getFood только с параметром 'Хищник'")
    void testEatMeatCallsGetFoodOnlyWithPredator() throws Exception {
        spyFeline.eatMeat();
        verify(spyFeline).getFood("Хищник");

    }

    @Test
    @DisplayName("Проверка, что getFamily всегда возвращает 'Кошачьи'")
    void testGetFamilyConsistency() {
        String firstCall = feline.getFamily();
        String secondCall = feline.getFamily();
        assertEquals(firstCall, secondCall, "getFamily должен всегда возвращать одинаковое значение");
        assertEquals("Кошачьи", firstCall, "getFamily должен всегда возвращать 'Кошачьи'");
    }
}