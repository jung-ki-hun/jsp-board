package com.nhnacademy.common;

import com.nhnacademy.common.object.dataStructure.Command;
//import com.nhnacademy.dispatcher.command.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            Command command  = resolveCommand(req.getServletPath(), req.getMethod());
            String view = command.execute(req, resp);

            if (view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception ex) {
            log.error("", ex);

            req.setAttribute("exception", ex);

            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;

//        if ("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//            command = new CartListController();
//        } else if ("/cart.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
//            command = new CartUpdateController();
//        } else if ("/foods.do".equals(servletPath)) {
//            command = new FoodListController();
//        } else if ("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//            command = new LoginFormController();
//        } else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
//            command = new LoginProcessingController("admin", "12345");
//        } else if ("/logout.do".equals(servletPath)) {
//            command = new LogoutController();
//        } else if ("/change-lang.do".equals(servletPath)) {
//            command = new LangController();
//        }

        return command;
    }

}
