package com.project.informationhub.configuration;

import com.project.informationhub.model.Thread;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.LocalDateTime;

// THIS IS MEANT TO MAKE "DUMMY DATA" FOR TESTING
// Will create 2 Data objects for FAQ everytime the system runs.

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository user, ThreadRepository threadRepository, FAQRepository FAQRepo, ContactUsRepository ContactUsRepo, UserPreferenceRepository UserPreferenceRepo) {

    return args -> {
//      log.info("Preloading " + threadRepository.save(new Thread(1, "Title", "Description", "new desc", false,
//      false)));

//      log.info("Preloading " + user.save(new User("username", "firstname", "lastname", "password", "email", "phoneNumber")));

//       log.info("Preloading " + FAQRepo.save(new FAQ("Q1", "yes")));
      
      // log.info("Preloading " + ContactUsRepo.save(new ContactUs("u@gmail.com", "A contact", "9013")));

      // log.info("Preloading " + UserPreferenceRepo.save(new UserPreferance(true, false)));
    };
  }
}
