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
public class LoosingCause extends BaseEntity {
    public LoosingCause(int id, String text) {
        super(id, text);
        if (isNull(text)) {
            log.error("LoosingCause text is null");
            throw new IllegalArgumentException("LoosingCause text cannot be null");
        } else if (text.isBlank()) {
            log.error("Text is blank");
            throw new IllegalArgumentException("LoosingCause text cannot be blank");
        }
        if (id < 0) {
            log.error("LoosingCause ID is negative");
            throw new IllegalArgumentException("LoosingCause ID cannot be negative");
        }

        log.debug("Возникла проигрышная ситуация с ID[{}]: text[{}]", id, text);
    }
}
