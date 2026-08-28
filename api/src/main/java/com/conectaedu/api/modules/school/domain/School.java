package com.conectaedu.api.modules.school.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "school")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;

    private String director;

    private String address;

    private double latitude;

    private double longitude;

    @NotNull
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
