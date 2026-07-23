package com.example.jpalab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Table(name = "intern_project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InternProjects {
    @EmbeddedId
    private InternProjectId id = new InternProjectId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("internId")
    @JoinColumn(name = "intern_id")
    private Intern intern;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "assinged_at")
    private LocalDateTime assignedAt;
}
