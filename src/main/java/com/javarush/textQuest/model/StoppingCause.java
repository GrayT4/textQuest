package com.javarush.textQuest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.isNull;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
@Slf4j
public class StoppingCause extends BaseEntity {
    public StoppingCause(int id, String text) {
        super(id, text);
        if (isNull(text)) {
            log.error("StoppingCause text is null");
            throw new IllegalArgumentException("StoppingCause text cannot be null");
        } else if (text.isBlank()) {
            log.error("Text is blank");
            throw new IllegalArgumentException("StoppingCause text cannot be blank");
        }
        if (id < 0) {
            log.error("StoppingCause ID is negative");
            throw new IllegalArgumentException("StoppingCause ID cannot be negative");
        }

        log.debug("Возникла стоп-ситуация с ID[{}]: text[{}]", id, text);
    }
}
