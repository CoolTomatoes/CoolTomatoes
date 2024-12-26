package coolpotatoes.coolpotatoes_backend.constants;

public enum LearningType {
  DIVERGING("발산자형"),
  ASSIMILATING("동화자형"),
  CONVERGING("수렴자형"),
  ACCOMMODATING("조절자형");

  private final String description;

  LearningType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
