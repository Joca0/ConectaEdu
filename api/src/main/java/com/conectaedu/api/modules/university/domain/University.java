package com.conectaedu.api.modules.university.domain;

import com.conectaedu.api.shared.domain.Address;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "universities")
@Getter
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    /** Identifica a instituicao. Nao muda depois do cadastro. */
    @Column(name = "cnpj", nullable = false, length = 14, unique = true, updatable = false)
    private String cnpj;

    @Column(name = "coordinator", length = 200)
    private String coordinator;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "university_courses", joinColumns = @JoinColumn(name = "university_id"))
    @Column(name = "course", nullable = false, length = 150)
    private Set<String> courses = new LinkedHashSet<>();

    @Embedded
    private Address address;

    /** Identidade visual do tenant: logo no cabecalho, exigida na especificacao. */
    @Column(name = "logo_url", length = 500)
    private String logoUrl;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    protected University() {
    }

    public University(String name, String cnpj, String coordinator, Address address, String logoUrl) {
        this.name = name;
        this.cnpj = cnpj;
        this.coordinator = coordinator;
        this.address = address;
        this.logoUrl = logoUrl;
    }

    public void update(String name, String coordinator, Address address, String logoUrl) {
        this.name = name;
        this.coordinator = coordinator;
        this.address = address;
        this.logoUrl = logoUrl;
        this.updatedAt = LocalDateTime.now();
    }

    public void replaceCourses(Set<String> newCourses) {
        courses.clear();
        if (newCourses != null) {
            newCourses.stream()
                    .filter(course -> course != null && !course.isBlank())
                    .map(String::trim)
                    .forEach(courses::add);
        }
        this.updatedAt = LocalDateTime.now();
    }

    public void deactivate() {
        this.active = false;
        this.updatedAt = LocalDateTime.now();
    }

    public void activate() {
        this.active = true;
        this.updatedAt = LocalDateTime.now();
    }

    public Set<String> getCourses() {
        return Set.copyOf(courses);
    }
}