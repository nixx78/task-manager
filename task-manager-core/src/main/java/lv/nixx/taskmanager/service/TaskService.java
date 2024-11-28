package lv.nixx.taskmanager.service;

import lv.nixx.taskmanager.model.TaskDTO;
import lv.nixx.taskmanager.orm.Task;
import lv.nixx.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO getTaskById(Long taskId) {
        Task task = taskRepository.findByIdWithDependencies(taskId).orElseThrow(() -> new IllegalArgumentException("Task with ID [" + taskId + "] not found"));

        Collection<String> dependentTask = task.getDependentTasks().stream().map(t -> t.getTask().getName()).toList();
        Collection<String> dependencies = task.getDependencies().stream().map(t -> t.getTask().getName()).toList();

        return TaskDTO.builder()
                .taskId(task.getTaskId())
                .name(task.getName())
                .description(task.getDescription())
                .dependentTasks(dependentTask)
                .dependencies(dependencies)
                .build();
    }

}
