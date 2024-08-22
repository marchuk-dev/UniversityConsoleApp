package com.uni.universityconsoleapp.services;

import com.uni.universityconsoleapp.entities.Department;
import com.uni.universityconsoleapp.entities.Lector;
import com.uni.universityconsoleapp.exceptions.LectorNotFoundException;
import com.uni.universityconsoleapp.repositories.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service interacts with {@link LectorRepository} to perform operations related to lectors.
 */
@Service
@RequiredArgsConstructor
public class LectorService {

    private final LectorRepository lectorRepository;

    /**
     * Retrieves all lectors associated with a given department.
     *
     * @param department the {@link Department} for which lectors are to be retrieved.
     * @return a list of {@link Lector} objects associated with the specified department.
     * @throws LectorNotFoundException if no lectors are found for the given department.
     */
    public List<Lector> getAllByDepartment(Department department) {
        return lectorRepository.findByDepartments(department)
                .orElseThrow(() -> new LectorNotFoundException(department));
    }

    /**
     * Retrieves a list of lectors whose names contain the specified string.
     *
     * @param lectorName the string to search within lector names.
     * @return a list of {@link Lector} objects that match the search criteria.
     * @throws LectorNotFoundException if no lectors are found containing the given name.
     */
    public List<Lector> findByNameContaining(String lectorName) {
        return lectorRepository.findAllByNameContainingIgnoreCase(lectorName)
                .orElseThrow(() -> new LectorNotFoundException(lectorName));
    }

}