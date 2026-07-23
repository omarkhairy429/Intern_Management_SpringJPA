package com.example.jpalab.repository;

import com.example.jpalab.entity.InternProjectId;
import com.example.jpalab.entity.InternProjects;
import com.example.jpalab.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InternProjectsRepository extends JpaRepository<InternProjects, InternProjectId> {
    List<InternProjects> findByAssignedAtAfter(LocalDateTime localDateTime);
}
