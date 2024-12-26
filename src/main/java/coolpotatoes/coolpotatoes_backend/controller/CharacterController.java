package coolpotatoes.coolpotatoes_backend.controller;

import coolpotatoes.coolpotatoes_backend.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Calendar;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;
//    @GetMapping("/member")
//    public Character getCharacterByMember(@RequestParam Long memberId){
//        return characterService.getCharacterByMember(memberId);
//    }
}
