package com.journalAppp.JournalApp.controller;

import com.journalAppp.JournalApp.Repository.UserRepo;
import com.journalAppp.JournalApp.api.response.WeatherResponse;
import com.journalAppp.JournalApp.entity.User;
import com.journalAppp.JournalApp.service.UserService;
import com.journalAppp.JournalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WeatherService weatherService;


    @GetMapping("/users")
     public  List<User> getAllUsers() {
        return userService.getAll();
    }



    @PutMapping("")
    public ResponseEntity<?> updateUser(@RequestBody User user) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDb = userService.findByUsername(username);
        if (userInDb != null) {
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userService.saveNewEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }
    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepo.deleteByUsername(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<?> greetings() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("kolkata");
        String greeting = "";
        if(weatherResponse != null){
            greeting = "Weather feels like" + weatherService.getWeather("kolkata").getCurrent().getFeelslike();

        }
        return new ResponseEntity<>("hi" + authentication.getName() , HttpStatus.OK);
    }

}
