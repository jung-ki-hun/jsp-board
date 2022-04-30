package com.nhnacademy.common.repository;

import com.nhnacademy.common.board.BoardPost;
import com.nhnacademy.common.object.dataStructure.Post;
import java.util.List;

public interface PostRepository {
    long register(Post post);
    void modify(Post post);
    Post remove(long id);
    Post getPost(long id);
    List<BoardPost> getPosts();
}
