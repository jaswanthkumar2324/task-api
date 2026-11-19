package com.jaswanth.taskapi.controller;
import com.jaswanth.taskapi.model.CreateTaskRequest;
import com.jaswanth.taskapi.model.Task;
import com.jaswanth.taskapi.service.TaskService;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> list() {
        return service.list();
    }
    @PostMapping
    public ResponseEntity<Task> add(@RequestBody CreateTaskRequest request) {
        if (request.title() == null || request.title().isBlank()) {
            return ResponseEntity.badRequest().build();
        }    // 400
        Task created = service.add(request.title().trim());
        return ResponseEntity.status(201).body(created);         // 201 + the new task
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();           // 204
        }
        return ResponseEntity.notFound().build();                // 404
    }

    @PutMapping("/{id}/done")
    public ResponseEntity<Void> markDone(@PathVariable int id) {
        if (service.markDone(id)) {
            return ResponseEntity.ok().build();                  // 200
        }
        return ResponseEntity.notFound().build();                // 404
    }
}
