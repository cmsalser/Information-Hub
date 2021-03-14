package com.project.informationhub;

import com.project.informationhub.repository.ThreadRepository;
import com.project.informationhub.repository.UserRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, ThreadRepository.class})
public class InformationhubApplication {
	public static void main(String[] args) {
		SpringApplication.run(InformationhubApplication.class, args);
	}
}