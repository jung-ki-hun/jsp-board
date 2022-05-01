package com.nhnacademy.common.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
@WebServlet(name = "languageServletKor", urlPatterns ="/lang/ko")
@Slf4j
public class LanguageServletKor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
//        super.doGet(req, resp);
        
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
