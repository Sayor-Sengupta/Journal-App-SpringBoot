package com.journalAppp.JournalApp.Scheduler;


import com.journalAppp.JournalApp.Repository.UserRepoImpli;
import com.journalAppp.JournalApp.entity.User;
import com.journalAppp.JournalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepoImpli userRepoImpli;


    @Scheduled(cron = "0 0 9 * * SUN")
    public void fetchUsersAndSentimentMail() {

        List<User> users = userRepoImpli.getUsersForSentimentAnalysis();


    }

}
