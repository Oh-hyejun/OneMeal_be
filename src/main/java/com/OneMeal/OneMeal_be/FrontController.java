package com.OneMeal.OneMeal_be;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FrontController {

    @GetMapping("/api/string")
    public String testEndpoint() {
        return "Hello from Backend!";
    }

    @GetMapping("/api/json")
    public Map<String, Object> jsonEndpoint() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hello from Backend!");
        response.put("status", "success");
        response.put("code", 200);
        return response;
    }

}