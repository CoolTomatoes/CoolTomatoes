package coolpotatoes.coolpotatoes_backend.entity;

import coolpotatoes.coolpotatoes_backend.constants.StudyMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class DailySubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dailySubId;

    private String subjectName;
    private int period;

    private Boolean isReviewedToday = false;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<StudyMethod> studyMethodList;

    private LocalDateTime studyDate;

    @ManyToOne
    private Calendar calendar;

    @ManyToOne
    private SemesterSubject semesterSub;

}