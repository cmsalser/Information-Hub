package com.project.informationhub.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.informationhub.entity.FAQ;
import com.project.informationhub.repository.FAQRepository;

// THIS IS MEANT TO MAKE "DUMMY DATA" FOR TESTING
// Will create 2 Data objects for FAQ everytime the system runs.

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(FAQRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new FAQ("Q1", "yes")));
      log.info("Preloading " + repository.save(new FAQ("Q2", "no")));
    };
  }
}
