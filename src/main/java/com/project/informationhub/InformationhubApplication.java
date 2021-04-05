package com.project.informationhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.informationhub.repository.ThreadRepository;
import com.project.informationhub.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class, ThreadRepository.class})
@ComponentScan("com.project")
public class InformationhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationhubApplication.class, args);
	}
}