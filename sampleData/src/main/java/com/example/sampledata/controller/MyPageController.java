package com.example.sampledata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.sampledata.service.BottomService;
import com.example.sampledata.service.TopService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/my-page")
@CrossOrigin
@RequiredArgsConstructor
public class MyPageController {

    private final TopService topService;
    private final BottomService bottomService;

    @GetMapping("/top-data")
    public List<Map<String, Object>> getTopData() {
        return topService.getAllCustomers();
    }

    @GetMapping("/bottom-data/{id}")
    public Map<String, Object> getBottomData(@PathVariable int id) {
        return bottomService.getCustomerById(id);
    }
}