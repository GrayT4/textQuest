package com.javarush.textQuest.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StoppingCauseTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    public void stoppingCauseNegativeNumbersExceptionWithId(int id) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new StoppingCause(id, "Some text"));

        assertEquals("StoppingCause ID cannot be negative", e.getMessage());
    }


    @Test
    public void stoppingCauseNullExceptionWithTextNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new StoppingCause(1, null));

        assertEquals("StoppingCause text cannot be null", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\n\n", "\t \n"})
    public void stoppingCauseNullExceptionWithTextBlankParameters(String text) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new StoppingCause(1, text));

        assertEquals("StoppingCause text cannot be blank", e.getMessage());
    }
}