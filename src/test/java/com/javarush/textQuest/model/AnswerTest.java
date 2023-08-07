package com.javarush.textQuest.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    public void answerNegativeNumbersExceptionWithId(int id) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> Answer.builder()
                        .id(id)
                        .text("Some text")
                        .build());

        assertEquals("Answer ID cannot be negative", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    public void answerNegativeNumbersExceptionWithQuestionId(int id) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> Answer.builder()
                        .id(1)
                        .text("Some text")
                        .nextQuestionId(id)
                        .build());

        assertEquals("nextQuestionID cannot be negative", e.getMessage());
    }

    @Test
    public void answerNullExceptionWithTextNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> Answer.builder()
                        .id(1)
                        .text(null)
                        .build());

        assertEquals("Answer text cannot be null", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n\n", "\t \n"})
    public void answerNullExceptionWithTextBlankParameters(String text) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> Answer.builder()
                        .id(1)
                        .text(text)
                        .build());

        assertEquals("Answer text cannot be blank", e.getMessage());
    }

}