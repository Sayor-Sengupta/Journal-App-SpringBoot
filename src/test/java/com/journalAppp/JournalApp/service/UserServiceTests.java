package com.journalAppp.JournalApp.service;

import com.journalAppp.JournalApp.Repository.UserRepo;
import com.journalAppp.JournalApp.entity.User;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepo userRepo;



    @Test
    public void testFindByUser() {
        assertEquals(3, 1 + 2);
        User user = userRepo.findByUsername("sayor1");
        assertTrue(!user.getJournalEntries().isEmpty());
    }

}
