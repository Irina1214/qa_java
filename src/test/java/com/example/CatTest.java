package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    private static final String MEOW = "Мяу";
    private static final List<String> EXPECTED_FOOD = List.of("Животные", "Птицы", "Рыба");

    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat(feline);
    }

    @Test
    @DisplayName("Проверка, что getSound возвращает 'Мяу'")
    void getSoundShouldReturnMeow() {
        assertEquals(MEOW, cat.getSound());
    }

    @Test
    @DisplayName("Проверка, что getSound всегда возвращает одинаковое значение")
    void getSoundShouldAlwaysReturnSameValue() {
        assertEquals(MEOW, cat.getSound());
        assertEquals(MEOW, cat.getSound());
        assertEquals(MEOW, cat.getSound());
    }

    @Test
    @DisplayName("Проверка, что getFood возвращает корректный список еды")
    void getFoodShouldReturnCorrectFoodList() throws Exception {
        when(feline.eatMeat()).thenReturn(EXPECTED_FOOD);

        List<String> actualFood = cat.getFood();

        assertEquals(EXPECTED_FOOD, actualFood);
    }

    @Test
    @DisplayName("Проверка, что getFood вызывает метод eatMeat у зависимости Predator")
    void getFoodShouldCallEatMeatMethod() throws Exception {
        when(feline.eatMeat()).thenReturn(EXPECTED_FOOD);

        cat.getFood();

        verify(feline).eatMeat();
    }

    @Test
    @DisplayName("Проверка, что getFood возвращает пустой список когда feline возвращает пустой список")
    void getFoodWhenFelineReturnsEmptyListShouldReturnEmptyList() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of());

        List<String> actualFood = cat.getFood();

        assertTrue(actualFood.isEmpty());
        verify(feline).eatMeat();
    }
}