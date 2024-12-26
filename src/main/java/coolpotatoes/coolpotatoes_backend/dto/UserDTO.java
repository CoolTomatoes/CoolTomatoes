package coolpotatoes.coolpotatoes_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {

    private String username;
    private String nickname;
    private String role;
}