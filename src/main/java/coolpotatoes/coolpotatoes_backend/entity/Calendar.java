package coolpotatoes.coolpotatoes_backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Calendar {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int studyCalendarId;

  private LocalDateTime date;
  private Boolean isChecked = false;

  @ManyToOne
  private Member member;


}