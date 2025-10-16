package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class LionParameterizedTest {

    @Mock
    private Feline felineMock;

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    @DisplayName("Проверка наличия гривы")
    void doesHaveMane_WithDifferentSexes_ReturnsCorrectValue(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Неизвестно", "Male", "Female", "123", "Сам ец", "Мужской"})
    @DisplayName("Создание льва с недопустимым полом выбрасывает исключение")
    void createLionWithInvalidSex_ShouldThrowException(String wrongSex) {

        Exception exception = assertThrows(Exception.class, () ->
                new Lion(wrongSex, felineMock));

        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Создание льва с null или пустым полом выбрасывает исключение")
    void createLionWithNullOrEmptySex_ShouldThrowException(String wrongSex) {

        Exception exception = assertThrows(Exception.class, () ->
                new Lion(wrongSex, felineMock));

        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }
}