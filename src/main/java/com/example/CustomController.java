package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomController {
    private final CustomService service;

    public CustomController(CustomService service) {
        this.service = service;
    }

    @GetMapping("/entity")
    public List<Dto> findAll() {
        return service.findAll();
    }

    @PostMapping("/entity")
    public Dto insert(@ModelAttribute Dto dto) {
        return service.insert(dto);
    }

    @PutMapping("/entity")
    public Dto update(@ModelAttribute Dto dto) {
        return service.update(dto);
    }
}
