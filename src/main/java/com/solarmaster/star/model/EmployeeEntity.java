package com.solarmaster.star.model;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private OffsetDateTime joiningDate = OffsetDateTime.now(ZoneOffset.UTC);
    private Boolean isActive;

    @CreatedDate
    @Column(updatable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now(ZoneOffset.UTC);

    @LastModifiedDate
    private OffsetDateTime updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
}
