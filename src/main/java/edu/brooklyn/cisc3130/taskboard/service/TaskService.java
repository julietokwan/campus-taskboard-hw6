package edu.brooklyn.cisc3130.taskboard.service;

import edu.brooklyn.cisc3130.taskboard.dto.TaskRequest;
import edu.brooklyn.cisc3130.taskboard.exception.TaskNotFoundException;
import edu.brooklyn.cisc3130.taskboard.model.Task;
import edu.brooklyn.cisc3130.taskboard.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // GET BY ID
    public Task getTaskById(Integer id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    // GET ALL (non-deleted)
    public List<Task> getAllTasks() {
        return taskRepository.findByDeletedFalse();
    }

    // CREATE
    public Task createTask(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.getCompleted() != null ? request.getCompleted() : false);
        task.setPriority(Task.Priority.valueOf(request.getPriority().toUpperCase()));
        return taskRepository.save(task);
    }

    // UPDATE
    public Task updateTask(Integer id, TaskRequest request) {
        Task task = getTaskById(id);
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.getCompleted());
        task.setPriority(Task.Priority.valueOf(request.getPriority().toUpperCase()));
        return taskRepository.save(task);
    }

    // SOFT DELETE
    public void deleteTask(Integer id) {
        Task task = getTaskById(id);
        task.setDeleted(true);
        taskRepository.save(task);
    }

    // RESTORE
    public void restoreTask(Integer id) {
        Task task = getTaskById(id);
        task.setDeleted(false);
        taskRepository.save(task);
    }

    // SEARCH
    public List<Task> searchTasks(String keyword) {
        return taskRepository.searchTasks(keyword);
    }

    // PAGINATION FOR COMPLETED TASKS
    public Page<Task> getCompletedTasks(Pageable pageable) {
        return taskRepository.findByCompletedTrue(pageable);
    }
}
