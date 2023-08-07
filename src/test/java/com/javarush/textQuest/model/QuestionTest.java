package com.javarush.textQuest.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    public void questionNegativeNumbersExceptionWithId(int id) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Question(id, "Some text"));

        assertEquals("Question ID cannot be negative", e.getMessage());
    }


    @Test
    public void questionNullExceptionWithTextNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Question(1, null));

        assertEquals("Question text cannot be null", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n\n", "\t \n"})
    public void questionNullExceptionWithTextBlankParameters(String text) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Question(1, text));

        assertEquals("Question text cannot be blank", e.getMessage());
    }

}