package com.javarush.textQuest.repository;

import com.javarush.textQuest.model.Answer;
import com.javarush.textQuest.model.ChoiceType;
import com.javarush.textQuest.model.LoosingCause;
import com.javarush.textQuest.model.StoppingCause;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
@Slf4j
@ToString
public class AnswerRepository {

    private final HashMap<Integer, Answer> answerHashMap = new HashMap<>();

    private final Answer answer1a, answer1b, answer1c, answer1d;
    private final Answer answer2a, answer2b, answer2c;
    private final Answer answer3a, answer3b, answer3c;
    private final Answer answer4a, answer4b, answer4c;
    private final Answer answer5a, answer5b, answer5c;
    private final Answer answer6a, answer6b;
    private final Answer answer7a, answer7b, answer7c;
    private final Answer answer8a, answer8b, answer8c;
    private final Answer answer9a, answer9b;
    private final Answer answer10a, answer10b, answer10c;
    private final Answer answer11a, answer11b, answer11c;
    private final Answer answer12a, answer12b, answer12c;
    private final Answer answer13a, answer13b, answer13c;
    private final Answer answer14a, answer14b;
    private final Answer answer15a, answer15b;
    private final Answer answer16a, answer16b;

    {
        answer1a = Answer.builder()
                .id(1)
                .text("Позвать на помощь")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(1, "ты жалобно кричишь и зовешь на помощь, но никто тебя не слышит. Спустя некоторое время ты слышишь вой волков. Волки приближаются к тебе со всех сторон. К сожалению, тебе не спастись."))
                .build();
        answer1b = Answer.builder()
                .id(2)
                .text("Проверить свои карманы")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(2)
                .build();
        answer1c = Answer.builder()
                .id(3)
                .text("Бежать как сумасшедший в случайном направлении")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(1, "ты начинаешь бежать как сумасшедший и не видишь куда бежишь. Вдруг, неподалеку, ты слышишь рев и что-то мягкое бьет тебя по голове. " +
                        "Ты падаешь и в темноте тебе кажется, что ты видишь морду медведя, которая медленно склоняется над твоей головой. Ты теряешь сознание и засыпаешь."))
                .build();
        answer1d = Answer.builder()
                .id(4)
                .text("Осмотреть местность")
                .choiceType(ChoiceType.STOP)
                .stoppingCause(new StoppingCause(1, "На улице так темно, что ты ничего не видишь дальше своей вытянутой руки."))
                .nextQuestionId(1)
                .build();

        answer2a = Answer.builder()
                .id(5)
                .text("Следовать по следам шин")
                .choiceType(ChoiceType.STOP)
                .stoppingCause(new StoppingCause(2, "Ты следовал по следам и пришел на то же место откуда начал."))
                .nextQuestionId(2)
                .build();
        answer2b = Answer.builder()
                .id(6)
                .text("Идти по тропинке")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(3)
                .build();
        answer2c = Answer.builder()
                .id(7)
                .text("Подобрать мертвую мышь")
                .choiceType(ChoiceType.STOP)
                .stoppingCause(new StoppingCause(2, "Ох, зачем тебе она нужна? Ты решаешь оставить мертвую мышь там, где она есть."))
                .nextQuestionId(2)
                .build();

        answer3a = Answer.builder()
                .id(8)
                .text("Выйти по тропинке из пещеры")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(3, "тебя заметили летучие мыши и раскромсали тебе все лицо. Ты теряешь сознание и засыпаешь."))
                .build();
        answer3b = Answer.builder()
                .id(9)
                .text("Приблизиться к медведю")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(4)
                .build();
        answer3c = Answer.builder()
                .id(10)
                .text("Помахать медведю рукой")
                .choiceType(ChoiceType.STOP)
                .stoppingCause(new StoppingCause(3, "Ты начинаешь махать медведю рукой. Эта ситуация выглядит настолько нелепо, что тебе лучше не повторять ее."))
                .nextQuestionId(3)
                .build();

        answer4a = Answer.builder()
                .id(11)
                .text("Попытаться отобрать руль у медведя")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(4, "ты бросаешься на медведя и пытаешься отобрать у него руль. Медведь с легкостью расправляется с тобой. Что тобой двигало в этот момент?"))
                .build();
        answer4b = Answer.builder()
                .id(12)
                .text("Бросить фонарь рядом с медведем")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(5)
                .build();
        answer4c = Answer.builder()
                .id(13)
                .text("Выйти по тропинке из пещеры")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(4, "тебя заметили летучие мыши и раскромсали тебе все лицо. Ты теряешь сознание и засыпаешь."))
                .build();

        answer5a = Answer.builder()
                .id(14)
                .text("Осторожно поднять руль, забрать фонарик и выйти по тропинке из пещеры")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(5, "ты поднимаешь руль и пытаешься забрать у медведя фонарик. Медведь не в восторге от этой сцены и бьет тебя своими лапами." +
                        "Ты теряешь сознание и засыпаешь. Что ж, жадность - это плохое качество."))
                .build();
        answer5b = Answer.builder()
                .id(15)
                .text("Осторожно поднять руль и выйти по тропинке из пещеры")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(6)
                .build();
        answer5c = Answer.builder()
                .id(16)
                .text("Выйти по тропинке из пещеры")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(5, "тебя заметили летучие мыши и раскромсали тебе все лицо. Ты теряешь сознание и засыпаешь."))
                .build();

        answer6a = Answer.builder()
                .id(17)
                .text("Проигнорировать машину и идти по тропинке к дому пешком")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(6, "ты идешь по тропинке в кромешной темноте ориентируясь только на свет от дома." +
                        "Спустя некоторое время ты слышишь вой волков. Волки приближаются к тебе со всех сторон. Ты пробуешь отбиваться от них рулем от машины, но нет, к сожалению, тебе не спастись."))
                .build();
        answer6b = Answer.builder()
                .id(18)
                .text("Проверить машину")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(7)
                .build();

        answer7a = Answer.builder()
                .id(19)
                .text("Попробовать завести машину")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(7, "машина долгое время не заводится. Шум от двигателя привлекает внимание медведя. Он подбегает к машине и обнаруживает в ней тебя. К сожалению, тебе не спастись."))
                .build();
        answer7b = Answer.builder()
                .id(20)
                .text("Открыть и проверить багажник")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(8)
                .build();
        answer7c = Answer.builder()
                .id(21)
                .text("Почитать журнал")
                .choiceType(ChoiceType.STOP)
                .stoppingCause(new StoppingCause(7, "Ты включаешь фонарик, читаешь журнал и находишь там забавную статью. Тебе становится весело, но ненадолго."))
                .nextQuestionId(7)
                .build();

        answer8a = Answer.builder()
                .id(22)
                .text("Попробовать зайти в коттедж")
                .choiceType(ChoiceType.STOP)
                .stoppingCause(new StoppingCause(8, "Ты дергаешь дверь за ручку. Заперто. Ты стучишься в дверь. Тишина. Никто тебе не отвечает."))
                .nextQuestionId(8)
                .build();
        answer8b = Answer.builder()
                .id(23)
                .text("Проверить коттедж снаружи")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(9)
                .build();
        answer8c = Answer.builder()
                .id(24)
                .text("Посигналить из машины")
                .choiceType(ChoiceType.STOP)
                .stoppingCause(new StoppingCause(8, "Свет горит, но никто не обращает на тебя внимания."))
                .nextQuestionId(8)
                .build();
        // задний двор коттеджа
        answer9a = Answer.builder()
                .id(25)
                .text("Подняться по лестнице на второй этаж")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(10)
                .build();
        answer9b = Answer.builder()
                .id(26)
                .text("Пройти к пристани")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(13)
                .build();
        // второй этаж коттеджа
        answer10a = Answer.builder()
                .id(27)
                .text("Попробовать зайти в коттедж")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(11)
                .build();
        answer10b = Answer.builder()
                .id(28)
                .text("Спуститься вниз")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(9)
                .build();
        answer10c = Answer.builder()
                .id(29)
                .text("Постучать в дверь")
                .choiceType(ChoiceType.STOP)
                .stoppingCause(new StoppingCause(10, "Ты стучишься в дверь. Тишина. Никто тебе не отвечает."))
                .nextQuestionId(10)
                .build();
        // внутри коттеджа, 2 этаж
        answer11a = Answer.builder()
                .id(30)
                .text("Отобрать ключи у кота")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(11, "ты пытаешься отобрать ключи у кота, но он царапает тебе лицо. Ты теряешь сознание и засыпаешь."))
                .build();
        answer11b = Answer.builder()
                .id(31)
                .text("Спуститься на первый этаж")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(12)
                .build();
        answer11c = Answer.builder()
                .id(32)
                .text("Выйти из коттеджа наружу")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(10)
                .build();
        // внутри коттеджа, 1 этаж
        answer12a = Answer.builder()
                .id(33)
                .text("Разбудить человека")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(12, "мужчина просыпается и с испугу стреляет в тебя из ружья. Ты теряешь сознание и засыпаешь."))
                .build();
        answer12b = Answer.builder()
                .id(34)
                .text("Поискать еду")
                .choiceType(ChoiceType.LOSS)
                .loosingCause(new LoosingCause(12, "в поисках еды, ты случайно задеваешь веревку, которая была привязана к звонку. Мужчина просыпается и с испугу стреляет в тебя из ружья. Ты теряешь сознание и засыпаешь."))
                .build();
        answer12c = Answer.builder()
                .id(35)
                .text("Ничего не трогать и подняться обратно на второй этаж")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(11)
                .build();
        // пристань
        answer13a = Answer.builder()
                .id(36)
                .text("Осмотреть лодку")
                .choiceType(ChoiceType.STOP)
                .stoppingCause(new StoppingCause(13, "Лодка целая, чтобы на ней уплыть нужны ключи."))
                .nextQuestionId(13)
                .build();
        answer13b = Answer.builder()
                .id(37)
                .text("Зайти в сарай")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(14)
                .build();
        answer13c = Answer.builder()
                .id(38)
                .text("Вернуться на задний двор коттеджа")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(9)
                .build();
        // сарай
        answer14a = Answer.builder()
                .id(39)
                .text("Отрезать кусок веревки и вернуться на второй этаж коттеджа")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(15)
                .build();
        answer14b = Answer.builder()
                .id(40)
                .text("Выйти из сарая")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(13)
                .build();
        // внутри коттеджа, 2 этаж (с веревкой)
        answer15a = Answer.builder()
                .id(41)
                .text("Скрутить из веревки клубок и кинуть котику")
                .choiceType(ChoiceType.NEXT)
                .nextQuestionId(16)
                .build();
        answer15b = Answer.builder()
                .id(42)
                .text("Подразнить котика веревкой")
                .choiceType(ChoiceType.STOP)
                .nextQuestionId(15)
                .stoppingCause(new StoppingCause(15, "Ты играешься с котиком, но спустя время тебе становится скучно."))
                .build();
        // у пристани с ключами
        answer16a = Answer.builder()
                .id(43)
                .text("Сесть в лодку и уплыть домой")
                .choiceType(ChoiceType.WIN)
                .build();
        answer16b = Answer.builder()
                .id(44)
                .text("Любоваться рассветом")
                .choiceType(ChoiceType.STOP)
                .nextQuestionId(16)
                .stoppingCause(new StoppingCause(16, "Ты любуешься рассветом и радуешься, что вскоре вернешься домой."))
                .build();
    }

    public AnswerRepository() {
        answerHashMap.put(answer1a.getId(), answer1a);
        answerHashMap.put(answer1b.getId(), answer1b);
        answerHashMap.put(answer1c.getId(), answer1c);
        answerHashMap.put(answer1d.getId(), answer1d);
        answerHashMap.put(answer2a.getId(), answer2a);
        answerHashMap.put(answer2b.getId(), answer2b);
        answerHashMap.put(answer2c.getId(), answer2c);
        answerHashMap.put(answer3a.getId(), answer3a);
        answerHashMap.put(answer3b.getId(), answer3b);
        answerHashMap.put(answer3c.getId(), answer3c);
        answerHashMap.put(answer4a.getId(), answer4a);
        answerHashMap.put(answer4b.getId(), answer4b);
        answerHashMap.put(answer4c.getId(), answer4c);
        answerHashMap.put(answer5a.getId(), answer5a);
        answerHashMap.put(answer5b.getId(), answer5b);
        answerHashMap.put(answer5c.getId(), answer5c);
        answerHashMap.put(answer6a.getId(), answer6a);
        answerHashMap.put(answer6b.getId(), answer6b);
        answerHashMap.put(answer7a.getId(), answer7a);
        answerHashMap.put(answer7b.getId(), answer7b);
        answerHashMap.put(answer7c.getId(), answer7c);
        answerHashMap.put(answer8a.getId(), answer8a);
        answerHashMap.put(answer8b.getId(), answer8b);
        answerHashMap.put(answer8c.getId(), answer8c);
        answerHashMap.put(answer9a.getId(), answer9a);
        answerHashMap.put(answer9b.getId(), answer9b);
        answerHashMap.put(answer10a.getId(), answer10a);
        answerHashMap.put(answer10b.getId(), answer10b);
        answerHashMap.put(answer10c.getId(), answer10c);
        answerHashMap.put(answer11a.getId(), answer11a);
        answerHashMap.put(answer11b.getId(), answer11b);
        answerHashMap.put(answer11c.getId(), answer11c);
        answerHashMap.put(answer12a.getId(), answer12a);
        answerHashMap.put(answer12b.getId(), answer12b);
        answerHashMap.put(answer12c.getId(), answer12c);
        answerHashMap.put(answer13a.getId(), answer13a);
        answerHashMap.put(answer13b.getId(), answer13b);
        answerHashMap.put(answer13c.getId(), answer13c);
        answerHashMap.put(answer14a.getId(), answer14a);
        answerHashMap.put(answer14b.getId(), answer14b);
        answerHashMap.put(answer15a.getId(), answer15a);
        answerHashMap.put(answer15b.getId(), answer15b);
        answerHashMap.put(answer16a.getId(), answer16a);
        answerHashMap.put(answer16b.getId(), answer16b);
    }

    public Answer getAnswerById(int id) {
        Answer answer = answerHashMap.get(id);
        if (answer != null) {
            return answer;
        } else {
            log.error("Не существует ответа с ID[{}]", id);
            throw new NullPointerException("Ответа с нужным индексом не существует");
        }
    }
}
