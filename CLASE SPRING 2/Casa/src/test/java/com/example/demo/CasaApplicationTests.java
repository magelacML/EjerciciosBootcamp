package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CasaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		this.mockMvc.perform(get("/10/10/1990"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Tu edad es : 30")));
	}

	@Test
	void contextLoads2() throws Exception {
		this.mockMvc.perform(get("/1/2/1990"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Tu edad es : 30")));

	}

}





//
//this.mockMvc
//		.perform(MockMvcRequestBuilders
//		.get("/"))
//		.andDo(print())
//		.andExpect(status().isOk())
//		.andExpect(content().string(containsString("Hello World")));
