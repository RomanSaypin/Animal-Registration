package ru.roman.test_task_project.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.roman.test_task_project.store.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
