package com.nhnacademy.common.servlet;

import com.nhnacademy.common.board.BoardPostRepository;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
@WebServlet(name = "boardServlet",urlPatterns = "/list")
@Slf4j
public class BoardListServlet extends HttpServlet {

    BoardPostRepository boardPostRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setAttribute("boardList",  boardPostRepository.getInstance().getPosts());
    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);

    }
}
