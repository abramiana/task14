package com.example.task14;

public class Note {
    private static int nextId = 1;

    private long id;
    private String title;
    private String content;

    public Note(String title, String content) {
        this.id = nextId++;
        this.title = title;
        this.content = content;
    }


    public long getId() {
        return id;
    }

    public long setId(long id) {
        this.id = id;
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
