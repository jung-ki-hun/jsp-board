package com.nhnacademy.common.servlet;
import com.nhnacademy.user.EndUser;
import com.nhnacademy.user.EndUserRepository;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "joinServlet", urlPatterns = "/join")
@Slf4j
public class JoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        //todo 회원가입 완료후
        try(PrintWriter out = resp.getWriter()){
            out.println("회원가입 성공인듯");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String pw = req.getParameter("password");
        String profile = req.getParameter("profile");
        if(profile == null) {
            profile = "null";
        }
        EndUser NewEndUser = new EndUser(id, pw, name, profile);
        EndUserRepository endUserRepository = EndUserRepository.getInstance();
        endUserRepository.add(NewEndUser);
        resp.sendRedirect("/index.jsp");

    }
}
