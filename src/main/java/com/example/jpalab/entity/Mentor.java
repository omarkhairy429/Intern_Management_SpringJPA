package com.example.jpalab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mentors")
@Getter
@Setter
@NoArgsConstructor
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_id", nullable = false)
    private Integer mentorId;

    @Column(name = "name", nullable = false, length = 100)
    private String mentorName;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String mentorEmail;

}
