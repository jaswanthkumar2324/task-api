package com.jaswanth.taskapi.service;

import com.jaswanth.taskapi.model.Task;
import com.jaswanth.taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> list() {
        return repository.findAll();
    }

    public Task add(String title) {
        return repository.save(new Task(title));
    }

    public boolean markDone(int id) {
        Optional<Task> found = repository.findById(id);
        if (found.isEmpty()) {
            return false;
        }
        Task task = found.get();
        task.markDone();
        repository.save(task);
        return true;
    }

    public boolean delete(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}