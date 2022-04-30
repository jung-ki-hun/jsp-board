package com.nhnacademy.common.servlet;

import com.nhnacademy.common.board.BoardPostRepository;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
@WebServlet(name = "boardRemoveServlet", urlPatterns = "/list/remove")
@Slf4j
public class BoardRemoveServlet extends HttpServlet {
    BoardPostRepository boardPostRepository;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        boardPostRepository.getInstance().remove(id);
    }
}
