package com.nhnacademy.common.board;

import com.nhnacademy.common.object.dataStructure.Post;
import java.time.LocalDateTime;

public class BoardPost implements Post {
    private long id;//게시물 넘버링 사용자 id (x)
    private String Title;
    private String Content;
    private String WriterUserId;
    private LocalDateTime WriterTime;
    private int ViewCount;

    public BoardPost(long id, String title, String content, String writerUserId,
                     LocalDateTime writerTime, int viewCount) {
        this.id = id;
        Title = title;
        Content = content;
        WriterUserId = writerUserId;
        WriterTime = writerTime;
        ViewCount = viewCount;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return this.Title;
    }

    @Override
    public void setTitle(String title) {
        this.Title = title;
    }

    @Override
    public String getContent() {
        return this.Content;
    }

    @Override
    public void setContent(String content) {
        this.Content = content;
    }

    @Override
    public String getWriterUserId() {
        return this.WriterUserId;
    }

    @Override
    public void setWriterUserId(String writerUserId) {
        this.WriterUserId = writerUserId;
    }

    @Override
    public LocalDateTime getWriteTime() {
        return this.WriterTime;
    }

    @Override
    public void setWriteTime(LocalDateTime writerTime) {
        this.WriterTime = writerTime;
    }

    @Override
    public int getViewCount() {
        return this.ViewCount;
    }

    @Override
    public void increaseViewCount() {
        this.ViewCount ++;
    }
}
