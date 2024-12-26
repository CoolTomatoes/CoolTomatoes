package coolpotatoes.coolpotatoes_backend.dto;

import coolpotatoes.coolpotatoes_backend.constants.LearningType;
import coolpotatoes.coolpotatoes_backend.constants.RegistrationStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class UserResponse {

    /* 아이디 */
    @Schema(description = "학번", defaultValue = "22011315")
    private String studentId;

    /* 이름 (실명) */
    @Schema(description = "이름", defaultValue = "백지훈")
    private String name;

    /*유형별*/
    @Schema(description = "발산자형 어쩌고",defaultValue = "발산자형")
    private LearningType testType;

    /*포인트*/
    @Schema(description = "포인트",defaultValue = "0")
    private int point;

    /* 재학/휴학/졸업 상태 */
    @Schema(description = "재학/휴학/졸업 상태", defaultValue = "TAKEOFFSCHOOL")
    private RegistrationStatus registrationStatus;

    /* 학년 */
    @Schema(description = "학년", defaultValue = "2")
    private int memberGrade;

    /*전체*/
    @Schema(description = "전체 학점",defaultValue = "0.0f")
    private float memberTotalGrade;

    /* 학과 */
    @Schema(description = "학과", defaultValue = "컴퓨터공학과")
    private String major;









}