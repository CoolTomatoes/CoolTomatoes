package coolpotatoes.coolpotatoes_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class SemesterSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int semesterSubId;

    @Column(nullable = false)
    private String subjectName;

    private int totalStudySec = 0;

    private LocalDateTime createdDate;

    private LocalDateTime lastStudyDate;

    private float subjectGrade;

    @ManyToOne
    private Member member;


}