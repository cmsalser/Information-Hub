package com.project.informationhub.integrationTests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import com.project.informationhub.model.Event;
import com.project.informationhub.model.user.User;
import com.project.informationhub.repository.EventRepository;
import com.project.informationhub.repository.UserRepository;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles("test")

public class EventIntegrationTest {

	@Autowired
    UserRepository userRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
    private MockMvc mvc;

	String sampleRequest;

	@Test
	public void showTest() throws Exception {
		User creator = new User();
		creator.setFirstname("Edis");
		creator.setLastname("Emin");
		creator.setEmail("edis.emin@hotmail.co.uk");
		creator = userRepository.save(creator);

		User attendee = new User();
		attendee.setFirstname("James");
		attendee.setLastname("Holden");
		attendee.setEmail("james.holden@gmail.com");
		attendee = userRepository.save(attendee);

		Set<User> creators = new HashSet<>();
		creators.add(creator);

		Set<User> attendees = new HashSet<>();
		attendees.add(attendee);

//		Event event = new Event(creators, attendees, new Date(2021,4,8), "Covid 19 Vaccination", "www.covid19.world.org/vaccination/join");

//		event = eventRepository.save(event);
//
//		mvc.perform(get("/events/"+ event.getId()).contentType(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$.description").value("Covid 19 Vaccination"));

	}

	@Test
	public void indexTest() throws Exception {
		User creator = new User();
		creator.setFirstname("Edis");
		creator.setLastname("Emin");
		creator.setEmail("edis.emin@hotmail.co.uk");
		creator = userRepository.save(creator);

		User attendee = new User();
		attendee.setFirstname("James");
		attendee.setLastname("Holden");
		attendee.setEmail("james.holden@gmail.com");
		attendee = userRepository.save(attendee);

		Set<User> creators = new HashSet<>();
		creators.add(creator);

		Set<User> attendees = new HashSet<>();
		attendees.add(attendee);

		Event event1 = new Event(creators, attendees, "Title" ,new Date(2021,4,8, 0, 0), new Date(2021, 4, 8, 0,15), "Covid 19 Vaccination", "www.covid19.world.org/vaccination/join");

		event1 = eventRepository.save(event1);

		Event event2 = new Event(creators, attendees, "Title", new Date(2021,4,15, 0, 0), new Date(2021, 4, 15, 0, 15), "Covid 19 Awareness Event", "www.covid19.world.org/awareness/join");

		event2 = eventRepository.save(event2);

		mvc.perform(get("/events/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].description").value("Covid 19 Vaccination"));
	}

	@Test
	public void deleteTest() throws Exception {
		User creator = new User();
		creator.setFirstname("Edis");
		creator.setLastname("Emin");
		creator.setEmail("edis.emin@hotmail.co.uk");
		creator = userRepository.save(creator);

		User attendee = new User();
		attendee.setFirstname("James");
		attendee.setLastname("Holden");
		attendee.setEmail("james.holden@gmail.com");
		attendee = userRepository.save(attendee);

		Set<User> creators = new HashSet<>();
		creators.add(creator);

		Set<User> attendees = new HashSet<>();
		attendees.add(attendee);

		Event event = new Event(creators, attendees, "Title", new Date(2021,4,8, 0, 0), new Date(2021, 4, 8, 0, 15), "Covid 19 Vaccination", "www.covid19.world.org/vaccination/join");

		event = eventRepository.save(event);

		mvc.perform(delete("/events/"+event.getId()).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());

		try {
			mvc.perform(get("/events/"+ event.getId()).contentType(MediaType.APPLICATION_JSON));
		}catch(Exception ex) {
			assertTrue(ex instanceof NestedServletException);
		}

	}

	@Test
	public void acceptInvitationTest() throws Exception {
		User creator = new User();
		creator.setFirstname("Edis");
		creator.setLastname("Emin");
		creator.setEmail("edis.emin@hotmail.co.uk");
		creator = userRepository.save(creator);

		User attendee = new User();
		attendee.setFirstname("James");
		attendee.setLastname("Holden");
		attendee.setEmail("james.holden@gmail.com");
		attendee = userRepository.save(attendee);

		Set<User> creators = new HashSet<>();
		creators.add(creator);

		Set<User> attendees = new HashSet<>();
		attendees.add(attendee);

		Event event = new Event(creators, attendees, "Title", new Date(2021,4,8, 0, 0), new Date(2021, 4, 8, 0, 15), "Covid 19 Vaccination", "www.covid19.world.org/vaccination/join");

		event = eventRepository.save(event);

		mvc.perform(patch("/events/request/"+event.getId()+"/"+attendee.getId()+"/"+true).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());

	}

	@Test
	public void rejectInvitationTest() throws Exception {
		User creator = new User();
		creator.setFirstname("Edis");
		creator.setLastname("Emin");
		creator.setEmail("edis.emin@hotmail.co.uk");
		creator = userRepository.save(creator);

		User attendee = new User();
		attendee.setFirstname("James");
		attendee.setLastname("Holden");
		attendee.setEmail("james.holden@gmail.com");
		attendee = userRepository.save(attendee);

		Set<User> creators = new HashSet<>();
		creators.add(creator);

		Set<User> attendees = new HashSet<>();
		attendees.add(attendee);

		Event event = new Event(creators, attendees, "Title", new Date(2021,4,8, 0, 0), new Date(2021, 4, 8, 0, 15), "Covid 19 Vaccination", "www.covid19.world.org/vaccination/join");

		event = eventRepository.save(event);

		mvc.perform(patch("/events/request/"+event.getId()+"/"+attendee.getId()+"/"+false).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());

	}

	@Test
	public void createEventRequestTest() throws Exception {
		User creator = new User();
		creator.setFirstname("Edis");
		creator.setLastname("Emin");
		creator.setEmail("edis.emin@hotmail.co.uk");
		creator = userRepository.save(creator);

		User attendee = new User();
		attendee.setFirstname("James");
		attendee.setLastname("Holden");
		attendee.setEmail("james.holden@gmail.com");
		attendee = userRepository.save(attendee);

		Set<User> creators = new HashSet<>();
		creators.add(creator);

		Set<User> attendees = new HashSet<>();
		attendees.add(attendee);

		Event event = new Event(creators, attendees, "Title", new Date(2021,4,8, 0, 0), new Date(2021, 4, 8, 0, 15), "Covid 19 Vaccination", "www.covid19.world.org/vaccination/join");

		event = eventRepository.save(event);

		User newAttendee = new User();
		newAttendee.setFirstname("Vincent");
		newAttendee.setLastname("Vega");
		newAttendee.setEmail("vincent.vega@gmail.com");
		newAttendee = userRepository.save(newAttendee);
		mvc.perform(post("/events/request/"+event.getId()+"/"+newAttendee.getId()).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk());

	}

}
