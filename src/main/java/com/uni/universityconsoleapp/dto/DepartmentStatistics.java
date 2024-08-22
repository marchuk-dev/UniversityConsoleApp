package com.uni.universityconsoleapp.dto;

import com.uni.universityconsoleapp.entities.Lector;
import lombok.Data;

import java.util.EnumMap;
import java.util.Map;

@Data
public class DepartmentStatistics {

    private String departmentName;

    Map<Lector.Degree, Long> countPerDegree = new EnumMap<>(Lector.Degree.class);

    public int getCountForDegree(Lector.Degree degree) {
        return countPerDegree.getOrDefault(degree, 0L).intValue();
    }

}
