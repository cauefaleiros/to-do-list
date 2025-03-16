package dev.farelos.todolist.service;

import dev.farelos.todolist.model.TaskModel;
import dev.farelos.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    // adicionar tasks
    public TaskModel addTasks(TaskModel tasks) {
        return taskRepository.save(tasks);
    }
    //remover tasks
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    // listar tasks
    public List<TaskModel> listTasks() {
        return taskRepository.findAll();
    }
    // buscar por id
    public TaskModel findTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found!"));
    }
    // fazer task update
    public TaskModel updateTask(Long id, TaskModel updatedTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    if (updatedTask.getTitle() != null && !updatedTask.getTitle().isEmpty()) {
                        task.setTitle(updatedTask.getTitle());
                    }
                    if (updatedTask.getDescription() != null) {
                        task.setDescription(updatedTask.getDescription());
                    }
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found!"));
    }
}
