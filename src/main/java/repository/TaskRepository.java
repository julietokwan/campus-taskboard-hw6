package edu.brooklyn.cisc3130.taskboard.repository;

import edu.brooklyn.cisc3130.taskboard.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByDeletedFalse();

    List<Task> findByDeletedTrue();

    @Query("SELECT t FROM Task t WHERE " +
            "(LOWER(t.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(t.description) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND t.deleted = false")
    List<Task> searchTasks(@Param("keyword") String keyword);


    // Pagination example
    Page<Task> findByCompletedTrue(Pageable pageable);

    // Count tasks by priority
    long countByPriority(Task.Priority priority);
}
