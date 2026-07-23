package com.example.jpalab.service;

import com.example.jpalab.entity.Intern;
import com.example.jpalab.entity.Mentor;
import com.example.jpalab.repository.InternRepository;
import com.example.jpalab.repository.MentorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class InternService {
    InternRepository internRepository;
    MentorRepository mentorRepository;

    public InternService(InternRepository internRepository, MentorRepository mentorRepository) {
        this.internRepository = internRepository;
        this.mentorRepository = mentorRepository;
    }

    @Transactional
    public void changingInternMentor(String internEmail, Integer newMentorId) {
        Intern intern = internRepository.findByInternEmail(internEmail);
        System.out.println("Mentor before: " + intern.getMentor().getMentorName());
        Mentor newMentor = mentorRepository.findById(newMentorId).orElse(null);
        intern.setMentor(newMentor);
        System.out.println("Mentor After: " + intern.getMentor().getMentorName());
    }
}
