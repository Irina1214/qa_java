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
    void getSound_shouldReturnMeow() {
        assertEquals(MEOW, cat.getSound());
    }

    @Test
    @DisplayName("getSound всегда возвращает одинаковое значение")
    void getSound_shouldAlwaysReturnSameValue() {
        assertEquals(MEOW, cat.getSound());
        assertEquals(MEOW, cat.getSound()); // Многократный вызов
        assertEquals(MEOW, cat.getSound());
    }

    @Test
    @DisplayName("Проверка, что getFood возвращает список еды через зависимость Predator")
    void getFood_shouldReturnMeatList() throws Exception {
        when(feline.eatMeat()).thenReturn(EXPECTED_FOOD);

        List<String> actualFood = cat.getFood();

        assertEquals(EXPECTED_FOOD, actualFood);
        verify(feline).eatMeat();
    }

    @Test
    @DisplayName("Проверка, что getFood возвращает пустой список когда feline возвращает пустой список")
    void getFood_whenFelineReturnsEmptyList_shouldReturnEmptyList() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of());

        List<String> actualFood = cat.getFood();

        assertTrue(actualFood.isEmpty());
        verify(feline).eatMeat();
    }
}