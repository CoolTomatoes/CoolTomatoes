package coolpotatoes.coolpotatoes_backend.constants;

public enum EnrollmentStatus {
  ENROLLED("재학"),          // 재학 중
  ON_LEAVE("휴학"),          // 휴학 중
  GRADUATED("졸업");         // 졸업

  private final String description;

  EnrollmentStatus(String description) {
    this.description = description;
  }
  public String getDescription() {
    return description;
  }
}
