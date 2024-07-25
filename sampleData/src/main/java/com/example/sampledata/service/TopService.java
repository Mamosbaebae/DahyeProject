package com.example.sampledata.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface TopService {
    List<Map<String, Object>> getAllCustomers();
}