package coolpotatoes.coolpotatoes_backend.controller;

import coolpotatoes.coolpotatoes_backend.service.AIQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api") public class AIQuestionController { @Autowired
private AIQuestionService aiQuestionService; @PostMapping("/analyze") public ResponseEntity<Map<String, Object>> analyzeQuestion(@RequestBody Map<String, Object> request) { String[] userResponses = ((List<String>) request.get("responses")).toArray(new String[0]); String analysisResult = aiQuestionService.analyze(userResponses); Map<String, Object> response = new HashMap<>(); response.put("result", analysisResult); return ResponseEntity.ok(response); } }
