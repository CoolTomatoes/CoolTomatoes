package coolpotatoes.coolpotatoes_backend.controller;

import coolpotatoes.coolpotatoes_backend.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import java.util.Calendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class CalendarController {
    private final CalendarService calendarService;
//    @GetMapping("/day/member")
//    public Calendar getCalendarByDateAndMember(@RequestParam("day") LocalDate date,
//                                             @RequestParam Long memberId){
//        return calendarService.getCalendarByDateAndMember(date,memberId);
//    }
//    @GetMapping("")
//    public List<Calendar> getAllCalendarsByMember(@RequestParam Long memberId){
//
//        return calendarService.getAllCalendarsByMember(memberId);
//    }
}
