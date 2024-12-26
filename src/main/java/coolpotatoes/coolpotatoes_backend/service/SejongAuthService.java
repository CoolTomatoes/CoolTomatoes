package coolpotatoes.coolpotatoes_backend.service;

import coolpotatoes.coolpotatoes_backend.dto.AuthUserDTO;
import coolpotatoes.coolpotatoes_backend.dto.UserResponse;
import coolpotatoes.coolpotatoes_backend.entity.Member;
import coolpotatoes.coolpotatoes_backend.entity.Pet;
import coolpotatoes.coolpotatoes_backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SejongAuthService {

    private final MemberRepository memberRepository;

    /* 로그인 로직 */
    /* 프론트에서 넘어온 유저 데이터 DB에 저장 */
    @Transactional
    public Member saveUser(AuthUserDTO authUserDTO) {
        /* DB에 저장된 회원이 아닌경우 */

        if (!memberRepository.existsByStudentId(authUserDTO.getStudentId())) {
            Pet  pet= new Pet();
            pet.setExp(0);
            pet.setLevel(1);
            pet.setResetDate(LocalDateTime.now());
            Member member = Member.builder()
                    .studentId(authUserDTO.getStudentId())
                    .name(authUserDTO.getName())
                    .testType(authUserDTO.getTestType())
                    .major(authUserDTO.getMajor())
                    .memberGrade(authUserDTO.getMemberGrade())
                    .registrationStatus(authUserDTO.getRegistrationStatus())
                    .point(0)
                    .memberTotalGrade(authUserDTO.getMemberTotalGrade())
                    .pet(pet)
                    .build();
            memberRepository.save(member);

            return member;
        }
        return memberRepository.findByStudentId(authUserDTO.getStudentId());
    }

    /* Id 값으로 특정 유저 조회 로직 */
    @Transactional
    public UserResponse findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();

        return getUserResponse(member);
    }

    /* 학번으로 특정 유저 조회 로직 */
    @Transactional
    public UserResponse findByStudentId(String studentId) {
        Member member = memberRepository.findByStudentId(studentId);

        return getUserResponse(member);
    }




    /* User 객체를 UserResponse 객체로 변환하는 메서드 */
    private UserResponse getUserResponse(Member member) {

        return new UserResponse( member.getStudentId(), member.getName(),member.getTestType(),member.getPoint(),member.getRegistrationStatus(),member.getMemberGrade(),member.getMemberTotalGrade(), member.getMajor());
    }
}
