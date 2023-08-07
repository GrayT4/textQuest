package com.javarush.textQuest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Objects.isNull;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
@Slf4j
public class Question extends BaseEntity {
    private final ArrayList<Answer> answers = new ArrayList<>();

    public Question(int id, String text, Answer... answers) {
        super(id, text);
        if (isNull(text)) {
            log.error("Text is null");
            throw new IllegalArgumentException("Question text cannot be null");
        } else if (text.isBlank()) {
            log.error("Text is blank");
            throw new IllegalArgumentException("Question text cannot be blank");
        }
        if (id < 0) {
            log.error("Question ID is negative");
            throw new IllegalArgumentException("Question ID cannot be negative");
        }

        this.answers.addAll(Arrays.asList(answers));
    }
}
