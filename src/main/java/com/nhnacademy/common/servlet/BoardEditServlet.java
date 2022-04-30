package com.nhnacademy.common.servlet;

import com.nhnacademy.common.board.BoardPost;
import com.nhnacademy.common.board.BoardPostRepository;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name = "boardEditServlet", urlPatterns = "/list/edit")
@Slf4j
public class BoardEditServlet extends HttpServlet {
    BoardPostRepository boardPostRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
//        super.doGet(req, resp);
        //todo 조회 한개만 열어주기~~ ㅎㅎ
        BoardPost boardPost = (BoardPost)boardPostRepository.getPost(Long.parseLong(req.getParameter("id")));
        boardPost.increaseViewCount();
        req.setAttribute("choiceBoard",boardPost);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
//        super.doPost(req, resp);
        //todo 추가

        long idVlaue = boardPostRepository.getPosts().size();
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String writerUserId = req.getParameter("WriterUser");
        LocalDateTime writerTime =  LocalDateTime.now();
        int viewCount = 1;
        BoardPost boardPost = new BoardPost(idVlaue,title,content,writerUserId,writerTime,viewCount);
        long number = boardPostRepository.register(boardPost);
        log.info("id = {} success!!",number);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
