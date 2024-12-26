package coolpotatoes.coolpotatoes_backend.entity;

import coolpotatoes.coolpotatoes_backend.constants.EnrollmentStatus;
import coolpotatoes.coolpotatoes_backend.constants.LearningType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberId;

  @Column(unique = true)
  private String studentId;

  private String name;

  private LearningType testType;

  private int point = 0;

  private EnrollmentStatus memberStatus = EnrollmentStatus.ENROLLED;

  private int memberGrade = 1;

  private float memberTotalGrade = 0.0f;

  private String memberMajor;

  @OneToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;
  
}
