package com.javarush.textQuest.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


class InitServletTest extends Mockito {
    @Spy
    InitServlet initServlet;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    AutoCloseable closeable;

    @BeforeEach
    void initServlet() {
        closeable = MockitoAnnotations.openMocks(this);
        when(request.getRequestDispatcher("/game.jsp")).thenReturn(dispatcher);
    }

    @AfterEach
    void autoCloseService() throws Exception {
        closeable.close();
    }

    @Test
    void whenCallDoGetThenServletReturnGamePage() throws ServletException, IOException {
        initServlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher("/game.jsp");
        verify(dispatcher).forward(request,response);
    }
}