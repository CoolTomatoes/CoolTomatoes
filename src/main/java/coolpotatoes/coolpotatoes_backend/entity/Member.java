package coolpotatoes.coolpotatoes_backend.entity;

import coolpotatoes.coolpotatoes_backend.constants.LearningType;
import coolpotatoes.coolpotatoes_backend.constants.RegistrationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberId;

  @Column(unique = true)
  private String studentId;

  private String name;

  private LearningType testType;

  private int point = 0;

  private RegistrationStatus registrationStatus = RegistrationStatus.ATTENDING;

  private int memberGrade = 1;

  private float memberTotalGrade = 0.0f;

  private String major;

  @OneToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;
  
}
