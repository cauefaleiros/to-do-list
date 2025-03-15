package dev.farelos.todolist.service;

import dev.farelos.todolist.model.TaskModel;
import dev.farelos.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new RuntimeException("Task don't found!"));
    }
}
