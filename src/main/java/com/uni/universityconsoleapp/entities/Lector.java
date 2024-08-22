package com.uni.universityconsoleapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "degree", insertable = false, updatable = false)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private Degree degree;

    @Column(nullable = false)
    private BigDecimal salary;

    @ManyToMany
    @JoinTable(
            name = "department_lector",
            joinColumns = @JoinColumn(name = "lector_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private Set<Department> departments;

    public enum Degree {
        ASSISTANT, ASSOCIATE, PROFESSOR
    }
}