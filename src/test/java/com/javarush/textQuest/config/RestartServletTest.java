package com.javarush.textQuest.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

class RestartServletTest extends Mockito {
    @Spy
    RestartServlet restartServlet;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession currentSession;
    AutoCloseable closeable;

    @BeforeEach
    void initServlet() {
        closeable = MockitoAnnotations.openMocks(this);
        Mockito.when(request.getSession()).thenReturn(currentSession);
    }

    @AfterEach
    void autoCloseService() throws Exception {
        closeable.close();
    }

    @Test
    void whenCallDoPostThenInvalidateSessionAndRedirectToInitServlet() throws IOException {
        when(request.getSession()).thenReturn(currentSession);
        restartServlet.doPost(request, response);

        Mockito.verify(response).sendRedirect("/start");
    }
    @Test
    void whenCallSessionInvalidateCorrect() throws IOException {
        restartServlet.doPost(request, response);

        Mockito.verify(currentSession).invalidate();
    }
}