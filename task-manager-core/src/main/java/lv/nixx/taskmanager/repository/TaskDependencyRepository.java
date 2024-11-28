package lv.nixx.taskmanager.repository;

import lv.nixx.taskmanager.orm.TaskDependency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaskDependencyRepository extends JpaRepository<TaskDependency, Long> {
}
