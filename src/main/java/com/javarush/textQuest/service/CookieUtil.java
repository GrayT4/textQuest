package com.javarush.textQuest.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static String getStatistics(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        String cookieValue = null;

        Cookie[] cookies = request.getCookies();

        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    cookieValue = cookie.getValue();
                    break;
                }
            }
        }

        if (cookieValue == null) {
            Cookie cookie = new Cookie(cookieName, "0");
            cookieValue = "0";
            response.addCookie(cookie);
        }

        return cookieValue;
    }

    public static void setStatistics(HttpServletRequest request, HttpServletResponse response, String cookieName, String value) {
        String cookieValue = null;

        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    cookie.setValue(String.valueOf(value));
                    cookieValue = value;
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        if (cookieValue == null) {
            Cookie cookie = new Cookie(cookieName, "0");
            cookie.setValue(String.valueOf(value));
            response.addCookie(cookie);
        }
    }
}
