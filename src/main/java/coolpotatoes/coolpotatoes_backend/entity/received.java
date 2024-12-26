package coolpotatoes.coolpotatoes_backend.entity;

import coolpotatoes.coolpotatoes_backend.constants.AchievementType;
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
public class received {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int receivedId;

  private String certificateName;

  private LocalDateTime expiryDate;

  private AchievementType achievementType;

  private String feeling;

  private LocalDateTime getCertification;

  @ManyToOne
  private Member member;

}
