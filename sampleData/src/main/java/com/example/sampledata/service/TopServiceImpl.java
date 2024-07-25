package com.example.sampledata.service;


import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class TopServiceImpl implements TopService {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Map<String, Object>> getAllCustomers() {
        try {
            Map<String, List<Map<String, Object>>> data = objectMapper.readValue(
                    new ClassPathResource("customers.json").getInputStream(),
                    new TypeReference<Map<String, List<Map<String, Object>>>>() {}
            );
            return data.get("customers");
        } catch (IOException e) {
            throw new RuntimeException("error", e);
        }
    }
}