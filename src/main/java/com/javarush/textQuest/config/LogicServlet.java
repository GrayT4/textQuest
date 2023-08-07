package com.javarush.textQuest.config;

import com.javarush.textQuest.model.Answer;
import com.javarush.textQuest.model.ChoiceType;
import com.javarush.textQuest.model.Question;
import com.javarush.textQuest.repository.AnswerRepository;
import com.javarush.textQuest.repository.QuestionRepository;
import com.javarush.textQuest.service.CookieUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@WebServlet(name = "LogicServlet", value = "/play")
public class LogicServlet extends HttpServlet {

    private AnswerRepository answerRepository = new AnswerRepository();
    private QuestionRepository questionRepository = new QuestionRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        if (request.getParameter("name") != null) {
            CookieUtil.setStatistics(request, response,"name", request.getParameter("name"));
        }
        if (request.getParameter("age") != null) {
            CookieUtil.setStatistics(request, response,"age", request.getParameter("age"));
        }
        if (request.getParameter("gender") != null) {
            CookieUtil.setStatistics(request, response,"gender", request.getParameter("gender"));
        }

        int questionId = 1;
        int counter = Integer.parseInt(CookieUtil.getStatistics(request, response,"counter"));
        int counterWins = Integer.parseInt(CookieUtil.getStatistics(request, response,"counterWins"));
        int counterLoses = Integer.parseInt(CookieUtil.getStatistics(request, response,"counterLoses"));

        if(request.getParameter("answerId") != null) {
            int answerId = Integer.parseInt(request.getParameter("answerId"));
            Answer answer = answerRepository.getAnswerById(answerId);
            if(answer.getChoiceType() == ChoiceType.NEXT) {
                try {
                    questionId = answer.getNextQuestionId();
                } catch (NullPointerException e) {
                    log.error("Ответ [{}] не может быть пустым", answerId);
                    request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
                    return;
                }
            } else if (answer.getChoiceType() == ChoiceType.STOP) {
                try {
                    request.setAttribute("stoppingCause", answer.getStoppingCause().getText());
                    questionId = answer.getNextQuestionId();
                } catch (NullPointerException e) {
                    log.error("Проблема с вопросом [{}] (неправильно установлено значение поля)", answer.getId());
                    request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
                    return;
                }
            } else if (answer.getChoiceType() == ChoiceType.LOSS) {
                try {
                    request.setAttribute("loosingCause", answer.getLoosingCause().getText());
                } catch (NullPointerException e) {
                    log.error("Проблема с вопросом [{}] (неправильно установлено значение поля)", answer.getId());
                    request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
                    return;
                }
                CookieUtil.setStatistics(request, response,"counter", String.valueOf(++counter));
                CookieUtil.setStatistics(request, response,"counterLoses", String.valueOf(++counterLoses));
                request.getRequestDispatcher("/looseGame.jsp").forward(request, response);
                return;
            } else if(answer.getChoiceType() == ChoiceType.WIN) {
                CookieUtil.setStatistics(request, response,"counter", String.valueOf(++counter));
                CookieUtil.setStatistics(request, response,"counterWins", String.valueOf(++counterWins));
                request.getRequestDispatcher("/winGame.jsp").forward(request, response);
                return;
            } else {
                log.error("Проблема с вопросом [{}] (неправильно установлено значение поля)", answer.getId());
                request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
                return;
            }
        }

        Question question;
        ArrayList<Answer> answers;
        try {
            question = questionRepository.getQuestionById(questionId);
            answers = question.getAnswers();
            Collections.shuffle(answers);
            request.setAttribute("question", question);
            request.setAttribute("answers", answers);
        } catch (NullPointerException e) {
            log.error("Проблема с вопросом [{}] (неправильно установлено значение поля)", questionId);
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }

        request.getRequestDispatcher("/game.jsp").forward(request, response);
    }
}