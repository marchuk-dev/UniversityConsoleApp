package com.uni.universityconsoleapp.services;

import com.uni.universityconsoleapp.dto.DepartmentStatistics;
import com.uni.universityconsoleapp.entities.Department;
import com.uni.universityconsoleapp.entities.Lector;
import com.uni.universityconsoleapp.exceptions.DepartmentNotFoundException;
import com.uni.universityconsoleapp.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.eclipse.collections.impl.collector.Collectors2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This service interacts with {@link DepartmentRepository} to perform operations related to departments.
 */
@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final LectorService lectorService;
    private final DepartmentRepository departmentRepo;

    /**
     * Retrieves a department by its name.
     *
     * @param departmentName the name of the department to retrieve.
     * @return the {@link Department} object corresponding to the given name.
     * @throws DepartmentNotFoundException if no department is found with the given name.
     */
    public Department getByName(String departmentName) {
        return departmentRepo.findByNameIgnoreCase(departmentName)
                .orElseThrow(() -> new DepartmentNotFoundException(departmentName));
    }

    /**
     * Retrieves a list of departments whose names contain the specified string.
     *
     * @param departmentName the string to search within department names.
     * @return a list of {@link Department} objects that match the search criteria.
     * @throws DepartmentNotFoundException if no departments are found containing the given name.
     */
    public List<Department> findByNameContaining(String departmentName) {
        return departmentRepo.findAllByNameContainingIgnoreCase(departmentName)
                .orElseThrow(() -> new DepartmentNotFoundException(departmentName));
    }

    /**
     * Calculates the total number of employees in a department.
     *
     * @param departmentName the name of the department.
     * @return the count of employees in the specified department.
     */
    public int getEmployeeCountByDepartmentName(String departmentName) {
        final Department department = getByName(departmentName);
        List<Lector> lectors = lectorService.getAllByDepartment(department);
        return lectors.size();
    }

    /**
     * Calculates the average salary of employees in a department.
     *
     * @param departmentName the name of the department.
     * @return the average salary of the employees in the specified department.
     */
    public BigDecimal getAverageSalaryByDepartmentName(String departmentName) {
        final Department department = getByName(departmentName);
        List<Lector> lectors = lectorService.getAllByDepartment(department);
        return lectors.stream()
                .map(Lector::getSalary)
                .collect(Collectors2.summarizingBigDecimal(e -> e))
                .getAverage(MathContext.DECIMAL32);
    }

    /**
     * Retrieves statistics for a department, including the count of each degree type of lectors.
     *
     * @param departmentName the name of the department.
     * @return a {@link DepartmentStatistics} object containing the statistics for the specified department.
     */
    public DepartmentStatistics getStatisticsByDepartmentName(String departmentName) {
        final Department department = getByName(departmentName);
        List<Lector> lectors = lectorService.getAllByDepartment(department);
        return countStatistics(department, lectors);
    }

    /**
     * Counts the number of lectors by their degree and sets the statistics in the {@link DepartmentStatistics}.
     *
     * @param department the {@link Department} for which statistics are being generated.
     * @param lectors    the list of {@link Lector} objects to analyze.
     * @return a {@link DepartmentStatistics} object with the counted statistics.
     */
    private DepartmentStatistics countStatistics(Department department, List<Lector> lectors) {
        DepartmentStatistics statistics = new DepartmentStatistics();
        statistics.setDepartmentName(department.getName());

        Map<Lector.Degree, Long> degreeCounts = lectors.stream()
                .collect(Collectors.groupingBy(
                        Lector::getDegree,
                        Collectors.counting()
                ));
        statistics.setCountPerDegree(degreeCounts);

        return statistics;
    }

}

