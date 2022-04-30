package com.nhnacademy.common.board;

import com.nhnacademy.common.object.dataStructure.Post;
import com.nhnacademy.common.repository.PostRepository;
import java.util.List;

public class BoardPostRepository implements PostRepository {
    private List<BoardPost> boardPostList;
    private static BoardPostRepository boardPostRepository =null;
    private BoardPostRepository(){
        throw new UnsupportedOperationException();
    }
    public BoardPostRepository getInstance(){
        if (boardPostRepository == null)
        {
            boardPostRepository = new BoardPostRepository();
        }
        return boardPostRepository;
    }
    @Override
    public long register(Post post) {
        //todo 게시물 추가시 id값 리턴 해주기
        BoardPost boardPost = (BoardPost)post;
        boardPostList.add(boardPost);
        return boardPostList.indexOf(boardPost);
    }

    @Override
    public void modify(Post post) {
        int size = boardPostList.size();
        int index = -1;
        for (int i = 0; i < size ; i++) {
            if(post.getId() == boardPostList.get(i).getId())
            {
                index = i;
                break;
            }
        }
        if(index != -1){
            boardPostList.set(index,(BoardPost)post);
        }
    }

    @Override
    public Post remove(long id) {
        Post temp = boardPostList.get((int)id);
        boardPostList.remove((int)id);
        return temp;
    }

    @Override
    public Post getPost(long id) {
        return boardPostList.get((int)id);
    }

    @Override
    public List<BoardPost> getPosts() {
        List<BoardPost> temp = boardPostList;
        return temp;
    }
}
