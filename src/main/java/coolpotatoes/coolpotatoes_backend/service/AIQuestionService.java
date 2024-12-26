package coolpotatoes.coolpotatoes_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@Service
public class AIQuestionService {
    @Autowired
    private RestTemplate restTemplate;
    public String analyze(String[] userResponses) { String url = "http://localhost:5000/predict"; Map<String, Object> requestPayload = new HashMap<>(); requestPayload.put("responses", userResponses); HttpHeaders headers = new HttpHeaders(); headers.set("Content-Type", "application/json"); HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestPayload, headers); ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class); Map<String, Object> responseBody = response.getBody(); return (String) responseBody.get("predicted_type"); }
}
