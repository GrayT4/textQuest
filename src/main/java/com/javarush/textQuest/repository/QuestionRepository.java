package com.javarush.textQuest.repository;

import com.javarush.textQuest.model.Question;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
@Slf4j
@ToString
public class QuestionRepository {

    private final AnswerRepository answerRepository = new AnswerRepository();
    private final HashMap<Integer, Question> questionHashMap = new HashMap<>();

    private final Question question1, question2, question3, question4, question5,
            question6, question7, question8, question9, question10, question11,
            question12, question13, question14, question15, question16;


    {
        question1 = new Question(1, """
                Ты просыпаешься в лесу на сырой земле в окружении деревьев.
                На улице темно, у тебя сильно болит спина.
                Твое сердце начинает колотиться в груди все быстрее и быстрее.
                """, answerRepository.getAnswerById(1), answerRepository.getAnswerById(2), answerRepository.getAnswerById(3), answerRepository.getAnswerById(4));
        question2 = new Question(2, """
                Роясь у себя в карманах, ты находишь разбитый телефон, фонарик, резиновую утку и большую медную трубку.
                Ты включаешь фонарик и выбрасываешь остальные вещи.
                Ты светишь фонариком вокруг и замечаешь, что находишься в лесу на поляне.
                Замечаешь возле дерева следы автомобильных шин, которые ведут в одну сторону, и тропинку, которая ведет в другую сторону, а на траве возле тебя находится мертвая мышь.
                 """, answerRepository.getAnswerById(5), answerRepository.getAnswerById(6), answerRepository.getAnswerById(7));
        question3 = new Question(3, """
                Тропинка привела в пещеру.
                Ты осторожно осматриваешь пещеру и замечаешь в углу медведя, который сидит и что-то держит в лапах.
                Внутри пещеры ты замечаешь еще одну тропинку, которая куда-то ведет.
                Над этой тропинкой кружатся летучие мыши.
                """, answerRepository.getAnswerById(8), answerRepository.getAnswerById(9), answerRepository.getAnswerById(10));
        question4 = new Question(4, """
                Ты приближаешься к медведю и замечаешь, что он держит в руке руль от машины.
                Медведь, видя тебя, начинает рычать.
                """, answerRepository.getAnswerById(11), answerRepository.getAnswerById(12), answerRepository.getAnswerById(13));
        question5 = new Question(5, """
                Медведь заинтересовался светящейся штуковиной и бросил руль на землю. Теперь все его внимание приковано к фонарю.
                """, answerRepository.getAnswerById(14), answerRepository.getAnswerById(15), answerRepository.getAnswerById(16));
        question6 = new Question(6, """
                Ты осторожно продвигаешься по тропинке отбиваясь от летучих мышей рулем (да уж, круче сцены не придумать).
                Фонарь возле медведя немного освещает тебе дорогу.
                Ты целым добираешься до выхода из пещеры и идешь по тропинке дальше.
                Вдалеке ты еле замечаешь исходящий свет от какого-то дома.
                Недалеко от пещеры ты замечаешь старую ржавую машину на колесах. Возможно она на ходу, стоит ее проверить.
                """, answerRepository.getAnswerById(17), answerRepository.getAnswerById(18));
        question7 = new Question(7, """
                Ты залезаешь внутрь машины и обнаруживаешь, что руль, который ты отобрал у медведя, идеально к ней подходит.
                Ты начинаешь рыться в бардачке машины и находишь там несколько вещей: головной фонарик, ключи от машины, потрепанный журнал.
                Ты смотришь на приборы и замечаешь, что бак машины пустой.
                """, answerRepository.getAnswerById(19), answerRepository.getAnswerById(20), answerRepository.getAnswerById(21));
        question8 = new Question(8, """
                Роясь в багажнике ты находишь канистру с бензином и заправляешь автомобиль.
                После заправки ты заводишь машину и едешь по дороге к дому.
                По дороге никто и ничто тебе не мешает. Ты подъезжаешь к дому и останавливаешься.
                Перед тобой симпатичный белый коттедж. Его освещают уличные фонари.
                """, answerRepository.getAnswerById(22), answerRepository.getAnswerById(23), answerRepository.getAnswerById(24));
        question9 = new Question(9, """
                На заднем дворе находится пристань с лодкой и маленький сарай на берегу реки.
                Также на заднем дворе находится лестница, которая ведет на второй этаж.
                """, answerRepository.getAnswerById(25), answerRepository.getAnswerById(26));
        question10 = new Question(10, """
                Ты поднимаешься по лестнице на второй этаж и обнаруживаешь приоткрытую дверь.
                """, answerRepository.getAnswerById(27), answerRepository.getAnswerById(28), answerRepository.getAnswerById(29));
        question11 = new Question(11, """
                Ты оказываешься в роскошной комнате. В которой обнаруживаешь лестницу на первый этаж, а в углу комнаты в кресле сидит большой кот и играет с ключами от лодки.
                """, answerRepository.getAnswerById(30), answerRepository.getAnswerById(31), answerRepository.getAnswerById(32));
        question12 = new Question(12, """
                На первом этаже ты обнаруживаешь мужчину, который сидит в кресле и спит. В руках он держит ружье.
                """, answerRepository.getAnswerById(33), answerRepository.getAnswerById(34), answerRepository.getAnswerById(35));
        question13 = new Question(13, """
                Возле пристани ты обнаруживаешь моторную лодку. Возле тебя находится маленький сарай с открытой дверью.
                """, answerRepository.getAnswerById(36), answerRepository.getAnswerById(37), answerRepository.getAnswerById(38));
        question14 = new Question(14, """
                Зайдя в сарай, ты обнаруживаешь на полу длинную веревку и ножницы рядом с ней.
                Возможно веревка тебе пригодится, стоит отрезать себе кусочек.
                """, answerRepository.getAnswerById(39), answerRepository.getAnswerById(40));
        question15 = new Question(15, """
                Ты оказываешься в роскошной комнате. В которой обнаруживаешь лестницу на первый этаж, а в углу комнаты в кресле сидит большой кот и играет с ключами от лодки.
                """, answerRepository.getAnswerById(41), answerRepository.getAnswerById(42));
        question16 = new Question(16, """
                Котику понравился такой подарок и он заинтересовался им.
                Тем временем ты берешь ключи от лодки и спускаешься к пристани.
                Уже виднеется рассвет и перед тобой открывается замечательный вид на лес и реку.
                """, answerRepository.getAnswerById(43), answerRepository.getAnswerById(44));
    }

    public QuestionRepository() {
        questionHashMap.put(question1.getId(), question1);
        questionHashMap.put(question2.getId(), question2);
        questionHashMap.put(question3.getId(), question3);
        questionHashMap.put(question4.getId(), question4);
        questionHashMap.put(question5.getId(), question5);
        questionHashMap.put(question6.getId(), question6);
        questionHashMap.put(question7.getId(), question7);
        questionHashMap.put(question8.getId(), question8);
        questionHashMap.put(question9.getId(), question9);
        questionHashMap.put(question10.getId(), question10);
        questionHashMap.put(question11.getId(), question11);
        questionHashMap.put(question12.getId(), question12);
        questionHashMap.put(question13.getId(), question13);
        questionHashMap.put(question14.getId(), question14);
        questionHashMap.put(question15.getId(), question15);
        questionHashMap.put(question16.getId(), question16);
    }

    public Question getQuestionById(int id) {
        Question question = questionHashMap.get(id);
        if (question != null) {
            return question;
        } else {
            log.error("Не существует вопроса с ID[{}]", id);
            throw new NullPointerException("Вопроса с нужным индексом не существует");
        }
    }
}
