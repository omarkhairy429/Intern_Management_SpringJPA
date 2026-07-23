package com.example.jpalab.repository;

import com.example.jpalab.entity.Project;
import com.example.jpalab.enums.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public List<Project> findByProjectStatus(ProjectStatus projectStatus);
    public List<Project> findByProjectName(String projectName);
    public Integer countByProjectStatus(ProjectStatus projectStatus);
    public List<Project> findByInternProjects_Intern_InternName(String internName);
}
