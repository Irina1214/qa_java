package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    @DisplayName("Создание льва-самца, проверка наличия гривы")
    void createMaleLion_ShouldHaveMane() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    @DisplayName("Создание льва-самки, проверка отсутствия гривы")
    void createFemaleLion_ShouldNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    @DisplayName("Получение количества котят через Feline")
    void getKittens_ShouldDelegateToFeline() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);

        int kittens = lion.getKittens();

        assertEquals(3, kittens);
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    @DisplayName("Получение еды через Feline с корректным аргументом")
    void getFood_ShouldDelegateToFelineWithPredator() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", felineMock);
        List<String> food = lion.getFood();

        assertEquals(expectedFood, food);
        verify(felineMock, times(1)).getFood("Хищник");
    }

    @Test
    @DisplayName("Проверка исключения от Feline.getFood")
    void getFood_WhenFelineThrowsException_ShouldPropagateException() throws Exception {

        when(felineMock.getFood("Хищник")).thenThrow(new Exception("Ошибка получения еды"));
        Lion lion = new Lion("Самец", felineMock);

        Exception exception = assertThrows(Exception.class, lion::getFood);
        assertEquals("Ошибка получения еды", exception.getMessage());
    }
}