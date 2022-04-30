package com.nhnacademy.common.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "loginServlet", urlPatterns = "/login", initParams = {
    @WebInitParam(name = "id", value = "dongmyo"),
    @WebInitParam(name = "pwd", value = "12345")
})
@Slf4j
public class LoginServlet extends HttpServlet {
    private String configId;
    private String configPwd;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // <servlet>
        //     <init-param>
        configId = config.getInitParameter("id");
        configPwd = config.getInitParameter("pwd");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        log.error("/login.doGet()");
        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)/* || Objects.isNull(session.getAttribute("id"))*/) {
            resp.sendRedirect("/login.html");
        } else {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            try (PrintWriter out = resp.getWriter()) {
                out.println("Login Success: " + session.getAttribute("id") + "<br />");
                out.println("<a href='/logout'>Logout</a>");
            } catch (IOException ex) {
                log.error("", ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if (configId.equals(id) && configPwd.equals(pwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);

            // NOTE: RequestDispatcher를 사용하면 POST method로 다시 요청이 들어온다.
            //       GET Method로 새로운 요청이 시작되어야 하므로 sendRedirect 사용.
            resp.sendRedirect("/login");
        } else {
            // NOTE: 정적 리소스의 경우 RequestDispatcher보단 sendRedirect 사용 권장.
            resp.sendRedirect("/login.html");
        }
    }

}
