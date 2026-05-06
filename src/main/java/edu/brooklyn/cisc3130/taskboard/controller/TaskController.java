package edu.brooklyn.cisc3130.taskboard.controller;

import edu.brooklyn.cisc3130.taskboard.dto.TaskRequest;
import edu.brooklyn.cisc3130.taskboard.dto.TaskResponse;
import edu.brooklyn.cisc3130.taskboard.model.Task;
import edu.brooklyn.cisc3130.taskboard.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // CREATE
    @PostMapping
    public TaskResponse createTask(@Valid @RequestBody TaskRequest request) {
        Task task = taskService.createTask(request);
        return TaskResponse.fromEntity(task);
    }

    // GET ALL (non-deleted)
    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks()
                .stream()
                .map(TaskResponse::fromEntity)
                .toList();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Integer id) {
        return TaskResponse.fromEntity(taskService.getTaskById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Integer id,
                                   @Valid @RequestBody TaskRequest request) {
        Task updated = taskService.updateTask(id, request);
        return TaskResponse.fromEntity(updated);
    }

    // SOFT DELETE
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return "Task soft-deleted successfully";
    }

    // RESTORE
    @PutMapping("/{id}/restore")
    public String restoreTask(@PathVariable Integer id) {
        taskService.restoreTask(id);
        return "Task restored successfully";
    }

    // SEARCH
    @GetMapping("/search")
    public List<TaskResponse> searchTasks(@RequestParam String keyword) {
        return taskService.searchTasks(keyword)
                .stream()
                .map(TaskResponse::fromEntity)
                .toList();
    }

    // PAGINATION
    @GetMapping("/completed")
    public Page<Task> getCompletedTasks(@RequestParam int page,
                                        @RequestParam int size) {
        return taskService.getCompletedTasks(PageRequest.of(page, size));
    }
}
