package lv.nixx.rest.taskmanager;

import lv.nixx.taskmanager.model.TaskDTO;
import lv.nixx.taskmanager.orm.Task;
import lv.nixx.taskmanager.orm.TaskDependency;
import lv.nixx.taskmanager.repository.TaskDependencyRepository;
import lv.nixx.taskmanager.repository.TaskRepository;
import lv.nixx.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TaskManagerController {

    private final TaskRepository taskRepository;
    private final TaskDependencyRepository taskDependencyRepository;
    private final TaskService taskService;

    public TaskManagerController(TaskRepository taskRepository, TaskDependencyRepository taskDependencyRepository, TaskService taskService) {
        this.taskRepository = taskRepository;
        this.taskDependencyRepository = taskDependencyRepository;
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public Collection<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/task/{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/task_dependencies")
    public Collection<TaskDependency> getAllDependencies() {
        return taskDependencyRepository.findAll();
    }

}
