package coolpotatoes.coolpotatoes_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

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
