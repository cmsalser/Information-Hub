package com.project.informationhub;

import com.project.informationhub.FAQ.FAQ;
import com.project.informationhub.FAQ.FAQRepository;
import com.project.informationhub.UserPreferance.UserPreferance;
import com.project.informationhub.UserPreferance.UserPreferanceRepository;
import com.project.informationhub.ContactUs.ContactUs;
import com.project.informationhub.ContactUs.ContactUsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// THIS IS MEANT TO MAKE "DUMMY DATA" FOR TESTING
// Will create 2 Data objects for FAQ everytime the system runs.

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(FAQRepository FAQRepo, ContactUsRepository ContactUsRepo, UserPreferanceRepository UserPreferanceRepo) {

    return args -> {
      log.info("Preloading " + FAQRepo.save(new FAQ("Q1", "yes")));
      
      log.info("Preloading " + ContactUsRepo.save(new ContactUs("u@gmail.com", "A contact", "9013")));

      log.info("Preloading " + UserPreferanceRepo.save(new UserPreferance(true, false)));
    };
  }
}
