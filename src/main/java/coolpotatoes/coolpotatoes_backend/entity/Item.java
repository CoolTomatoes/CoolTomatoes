package coolpotatoes.coolpotatoes_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long itemId;

  private LocalDateTime purchaseTime;

  private Boolean isOwned = false;

  private Boolean isEquipped = false;

  private int itemPrice;

  private float totalGrade = 0.0f;

  private int studentGrade = 1;

  private String major;

  @OneToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;
}
