package com.journalAppp.JournalApp.controller;


import com.journalAppp.JournalApp.entity.User;
import com.journalAppp.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping("/create")
    public  void createUser(@RequestBody User user) {

        userService
                .saveNewEntry(user);
    }

}
