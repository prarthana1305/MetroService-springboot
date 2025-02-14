package com.example.MetroService.controller;


import com.example.MetroService.dto.UserStatusDTO;
import com.example.MetroService.service.ActiveUsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/active-users")

public class ActiveUsersController {

    public ActiveUsersController(ActiveUsersService activeUsersService) {
        this.activeUsersService = activeUsersService;
    }

    private final ActiveUsersService activeUsersService;

    @GetMapping
    public ResponseEntity<List<UserStatusDTO>> getActiveUsers() {
        List<UserStatusDTO> users = activeUsersService.getActiveUsers();
        return ResponseEntity.ok(users);
    }
}

