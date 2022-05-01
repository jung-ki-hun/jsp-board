package com.nhnacademy.common.servlet;

import com.nhnacademy.user.EndUser;
import com.nhnacademy.user.EndUserRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

@WebServlet(name = "loginServlet", urlPatterns = "/login")
@Slf4j
public class LoginServlet extends HttpServlet {
    private String configId;
    private String configPwd;
    private EndUserRepository endUserRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        log.error("/login.doGet()");
        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)/* || Objects.isNull(session.getAttribute("id"))*/) {
            resp.sendRedirect("/login.jsp");
        } else {
            resp.setContentType("text/jsp");
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
        findById(id,pwd);
        if (configId.equals(id) && configPwd.equals(pwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/login.jsp");
        }
    }
    private void findById(String id, String pwd){
        List<EndUser> userlist = EndUserRepository.getInstance().getUsers();
        int size = userlist.size();
        for (int i = 0; i < size; i++) {
            if(userlist.get(i).getId().equals(id)){
                configId = userlist.get(i).getId();
                configPwd = userlist.get(i).getPassword();
                break;
            }
        }
    }

}
