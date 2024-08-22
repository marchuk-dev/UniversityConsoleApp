package com.uni.universityconsoleapp.repositories;

import com.uni.universityconsoleapp.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByNameIgnoreCase(String name);

    Optional<List<Department>> findAllByNameContainingIgnoreCase(String name);

}
