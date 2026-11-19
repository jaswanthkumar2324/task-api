package com.jaswanth.taskapi.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.jaswanth.taskapi.model.Task;

@Service
public class TaskService {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task add(String title) {
        Task task = new Task(nextId, title);
        nextId++;
        tasks.add(task);
        return task;
    }

    public ArrayList<Task> list() {
        return tasks;
    }

    public boolean markDone(int id) {
        Task task = findById(id);
        if (task == null) {
            return false;
        }
        task.markDone();
        return true;
    }

    public boolean delete(int id) {
        Task task = findById(id);
        if (task == null) {
            return false;
        }
        tasks.remove(task);
        return true;
    }

    public Task findById(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
