package com.javarush.textQuest.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LoosingCauseTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    public void loosingCausenNegativeNumbersExceptionWithId(int id) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new LoosingCause(id, "Some text"));

        assertEquals("LoosingCause ID cannot be negative", e.getMessage());
    }


    @Test
    public void loosingCauseNullExceptionWithTextNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new LoosingCause(1, null));

        assertEquals("LoosingCause text cannot be null", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n\n", "\t \n"})
    public void loosingCauseNullExceptionWithTextBlankParameters(String text) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new LoosingCause(1, text));

        assertEquals("LoosingCause text cannot be blank", e.getMessage());
    }
}