package coolpotatoes.coolpotatoes_backend.constants;

public enum AchievementType {

  CERTIFICATE("자격증"),
  AWARD("수상경력"),
  BOOTCAMP("부트캠프"),
  OTHER("기타");

  private final String description;

  AchievementType(String description) {
    this.description = description;
  }
  public String getDescription() {
    return description;
  }
}
