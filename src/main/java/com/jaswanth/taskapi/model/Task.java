package com.jaswanth.taskapi.model;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private boolean completed;
    private LocalDateTime createdAt;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void markDone() {
        this.completed = true;
    }
}
