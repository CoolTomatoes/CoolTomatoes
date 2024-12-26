package coolpotatoes.coolpotatoes_backend.controller;

import coolpotatoes.coolpotatoes_backend.dto.AuthUserDTO;
import coolpotatoes.coolpotatoes_backend.dto.UserResponse;
import coolpotatoes.coolpotatoes_backend.entity.Member;
import coolpotatoes.coolpotatoes_backend.jwt.JWTUtil;
import coolpotatoes.coolpotatoes_backend.service.SejongAuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final JWTUtil jwtUtil;
    private final SejongAuthService sejongAuthService;

    /**
     * 프론트에서 API 로그인 후 서버측으로 user 전달 (아이디, 비밀번호, 이름, 학과, 학년, 재학/휴학/수료 상태)
     * /users/login post 요청시 http body에 있는 user data를 통해 token 발급
     */
    /* 로그인 */
    @PostMapping("/login")
    @Operation(summary = "로그인", description = "세종대 인증을 받은 사용자 로그인")
    public UserResponse login(@RequestBody AuthUserDTO authUserDTO, HttpServletResponse response) {
        Member findMember = sejongAuthService.saveUser(authUserDTO);

        String token = jwtUtil.createAccessToken(findMember.getStudentId());

        response.addHeader("Authorization", "Bearer " + token);

        return new UserResponse(findMember.getStudentId(), findMember.getName(), findMember.getTestType(), findMember.getPoint(),findMember.getRegistrationStatus(),
                findMember.getMemberGrade(),findMember.getMemberTotalGrade(),findMember.getMajor());
    }

    /* Id 값으로 유저 정보 조회 */
    @Operation(summary = "Id를 통해 유저 조회", description = "유저 id값을 통해 특정 유저 정보를 조회합니다.")
    @GetMapping("/id/{id}")
    public UserResponse findUser(@PathVariable("id") Long id) {
        return sejongAuthService.findMember(id);
    }

    /* 학번으로 유저 정보 조회 */
    @Operation(summary = "학번으로 유저 조회", description = "유저 학번을 통해 유저 정보를 조회합니다.")
    @GetMapping("/studentId/{studentId}")
    public UserResponse findByUsername(@PathVariable("studentId") String studentId) {
        return sejongAuthService.findByStudentId(studentId);
    }



}
