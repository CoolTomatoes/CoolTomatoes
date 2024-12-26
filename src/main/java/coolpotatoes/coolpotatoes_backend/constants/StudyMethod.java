package coolpotatoes.coolpotatoes_backend.constants;

public enum StudyMethod {
  KEYWORD_LISTING("키워드 나열하기"),
  SUMMARIZING("요약하기"),
  FEYNMAN_LEARNING("Feynman 학습법"),
  MIND_MAPPING("마인드맵 학습"),
  ROLE_PLAYING("롤플레잉 학습");

  private final String description;

  StudyMethod(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
