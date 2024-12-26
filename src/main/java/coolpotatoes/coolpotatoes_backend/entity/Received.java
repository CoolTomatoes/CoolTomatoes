package coolpotatoes.coolpotatoes_backend.entity;

import coolpotatoes.coolpotatoes_backend.constants.AchievementType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Received {
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
