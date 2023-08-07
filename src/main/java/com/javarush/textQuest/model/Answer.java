package com.javarush.textQuest.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.isNull;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
@Slf4j
public class Answer extends BaseEntity {
    private ChoiceType choiceType;
    private int nextQuestionId;
    private LoosingCause loosingCause;
    private StoppingCause stoppingCause;

    @Builder
    public Answer(int id, String text, ChoiceType choiceType, int nextQuestionId, LoosingCause loosingCause, StoppingCause stoppingCause) {
        super(id, text);
        if (isNull(text)) {
            log.error("Answer text is null");
            throw new IllegalArgumentException("Answer text cannot be null");
        } else if (text.isBlank()) {
            log.error("Answer text cannot be blank");
            throw new IllegalArgumentException("Answer text cannot be blank");
        }
        if (id < 0) {
            log.error("Answer ID is negative");
            throw new IllegalArgumentException("Answer ID cannot be negative");
        }
        if (nextQuestionId < 0) {
            log.error("nextQuestionID is negative");
            throw new IllegalArgumentException("nextQuestionID cannot be negative");
        }

        this.choiceType = choiceType;
        this.nextQuestionId = nextQuestionId;
        this.loosingCause = loosingCause;
        this.stoppingCause = stoppingCause;

        log.debug("Был создан ответ с ID[{}]: text [{}], choiceType[{}], nextQuestionId[{}], loosingCause[{}]", id, text, choiceType, nextQuestionId, loosingCause);
    }
}
