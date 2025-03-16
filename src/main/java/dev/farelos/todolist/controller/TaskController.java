package dev.farelos.todolist.controller;

import dev.farelos.todolist.model.TaskModel;
import dev.farelos.todolist.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    // adicionar
    @PostMapping
    public TaskModel addTask(@RequestBody TaskModel tasks) {
        return taskService.addTasks(tasks);
    }
    // deletar
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    // listar
    @GetMapping
    public List<TaskModel> listTasks() {
        return taskService.listTasks();
    }
    // buscar por id
    @GetMapping("/{id}")
    public TaskModel findTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }
    @PatchMapping("{id}")
    public TaskModel updateTask(@PathVariable Long id, @RequestBody TaskModel updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }
}

