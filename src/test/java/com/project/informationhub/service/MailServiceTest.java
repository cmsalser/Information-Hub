package com.project.informationhub.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class MailServiceTest {
	
	@Autowired
	private MailService mailService;
	
	@Test
	public void sendEmail() {
	
		mailService.sendEmail("edisemin@gmail.co.uk", "Project report", "Hi, Please find attached report , Regards, Edis");
	}
	
	@Test
	public void sendEmailToMultipleReceipients() {
		
		List<String> to = new ArrayList<>();
		to.add("edisemin@gmail.co.uk");
		to.add("edisemin@hotmail.co.uk");
		mailService.sendEmail(to, "Project report", "Hi, Please find attached report , Regards, Edis");
	}

}
