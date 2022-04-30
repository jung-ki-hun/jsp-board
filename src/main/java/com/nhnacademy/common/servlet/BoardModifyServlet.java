package com.nhnacademy.common.servlet;

import com.nhnacademy.common.board.BoardPost;
import com.nhnacademy.common.board.BoardPostRepository;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "boardModifyServlet", urlPatterns = "/list/modify")
@Slf4j
public class BoardModifyServlet extends HttpServlet {
    BoardPostRepository boardPostRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        long boardId = Long.parseLong(req.getParameter("id"));
        BoardPost getBoardPost = (BoardPost) boardPostRepository.getPost(boardId);
        String content = req.getParameter("content");
        String title = req.getParameter("title");
        String writerUserId = getBoardPost.getWriterUserId();
        LocalDateTime writerTime = LocalDateTime.now();
        int viewCount = getBoardPost.getViewCount()+1;
        BoardPost boardPost =new BoardPost(boardId, title, content, writerUserId, writerTime, viewCount);

        boardPostRepository.modify(boardPost);


    }
}
