package com.uni.universityconsoleapp.repositories;

import com.uni.universityconsoleapp.entities.Department;
import com.uni.universityconsoleapp.entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    Optional<List<Lector>> findByDepartments(Department department);

    Optional<List<Lector>> findAllByNameContainingIgnoreCase(String name);
}
