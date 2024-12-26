package coolpotatoes.coolpotatoes_backend.entity;

import coolpotatoes.coolpotatoes_backend.constants.StudyMethod;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

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
