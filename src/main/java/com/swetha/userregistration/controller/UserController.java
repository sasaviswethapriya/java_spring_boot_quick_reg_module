package com.swetha.userregistration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/demo")
    String demo() {
        return "Welcome to course registration api";
    }
}
