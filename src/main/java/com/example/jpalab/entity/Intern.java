package com.example.jpalab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "intern")
@Getter
@Setter
@NoArgsConstructor
public class Intern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer internId;

    @Column(name = "email", nullable = false, unique = true)
    private String internEmail;

    @Column(name = "name", nullable = false, length = 100)
    private String internName;

    @Column(name = "faculty", nullable = false, length = 100)
    private String internFaculty;

    @Column(name = "birth_date", nullable = false)
    private LocalDate internBirthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id", nullable = false)
    private Track track;

    @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InternProjects> internProjects = new ArrayList<>();


}
