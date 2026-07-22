package com.example.jpalab.repository;

import com.example.jpalab.entity.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InternRepository extends JpaRepository<Intern, Integer> {
    public Intern findByInternEmail(String internEmail);
    public List<Intern> findByTrackTrackName(String trackName);
    public List<Intern> findByMentorIsNull();
    public List<Intern> findByMentorMentorName(String mentorName);
    public List<Intern> findByInternBirthDateAfter(LocalDate date);
    public List<Intern> findByInternBirthDateBefore(LocalDate date);
}
