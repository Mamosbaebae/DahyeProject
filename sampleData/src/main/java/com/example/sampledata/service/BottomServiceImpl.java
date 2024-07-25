package com.example.sampledata.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BottomServiceImpl implements BottomService {

    private final TopService topService;

    public BottomServiceImpl(TopService topService) {
        this.topService = topService;
    }

    @Override
    public Map<String, Object> getCustomerById(int id) {
        List<Map<String, Object>> customers = topService.getAllCustomers();
        return customers.stream()
                .filter(customer -> id == (Integer) customer.get("id"))
                .findFirst()
                .orElse(null);
    }
}