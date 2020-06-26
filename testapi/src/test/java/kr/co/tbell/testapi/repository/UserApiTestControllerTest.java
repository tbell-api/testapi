package kr.co.tbell.testapi.repository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.CharacterEncodingFilter;

import kr.co.tbell.testapi.controller.UserApiTestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(
			webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
		)
@Transactional
@AutoConfigureMockMvc
public class UserApiTestControllerTest {

	private MockMvc mockMvc; 
	
	@Autowired
	private UserApiTestController userApiTestController;
	
	protected Object controller() {
		return this.userApiTestController;
	}
	
	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller())
								.addFilters(new CharacterEncodingFilter("UTF-8", true))
								.alwaysDo(print())
								.build();
	}
	
	@Test
	public void create() throws Exception {

		log.info("Junit Test Start");
		log.info("User Create Method Test");
		
		String content = "{name=newUser, age=28}"; 
		
		this.mockMvc.perform(
							post("/api/test/user")
							.content(content))
						.andExpect(status().isOk());
	}
	
	@Test
	public void read() throws Exception {

		log.info("Junit Test Start");
		log.info("User Read Method Test");
		
		this.mockMvc.perform(
							get("/api/test/user/1"))
						.andExpect(status().isOk());
	}
	
	@Test
	public void update() throws Exception {

		log.info("Junit Test Start");
		log.info("User Update Method Test");
		
		String content = "{name=newUser, age=28}"; 
		
		this.mockMvc.perform(
							put("/api/test/user")
							.content(content))
						.andExpect(status().isOk());
	}
	
	@Test
	public void deleteUser() throws Exception {

		log.info("Junit Test Start");
		log.info("User Delete Method Test");
		
		this.mockMvc.perform(
							delete("/api/test/user/1"))
					.andExpect(status().isOk());
	}
}
