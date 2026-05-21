package com.apress.spring;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.apress.spring.domain.Journal;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootJournalApplication.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SpringBootWebApplicationTests {
	
	private final String SPRING_BOOT_MATCH = "forget";
	private final String CLOUD_MATCH = "pledge";
	
	@SuppressWarnings("rawtypes")
	private HttpMessageConverter mappingJackson2HttpMessageConverter;
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), 
			MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		this.mappingJackson2HttpMessageConverter = Arrays.stream(converters)
				.filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
				.findAny()
				.orElse(null);
	}
	
	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getAll() throws Exception {
		mockMvc.perform(get("/journal"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", iterableWithSize(3)))
				.andExpect(jsonPath("$[0].title", containsString(SPRING_BOOT_MATCH)));
	}

	@Test
	public void findByTitle() throws Exception {
		mockMvc.perform(get("/journal/findBy/title/" + CLOUD_MATCH))
		       .andExpect(status().isOk())
		       .andExpect(jsonPath("$", iterableWithSize(1)))
		       .andExpect(jsonPath("$[0].title", containsString(CLOUD_MATCH)));
	}

	@Test
	public void add() throws Exception {
		Journal journal = new Journal("test title", "test summary", "05/22/2026");
		mockMvc.perform(post("/journal")
				.contentType(contentType)
				.content(toJsonString(journal)))
				.andExpect(status().isOk());
	}
	
	@SuppressWarnings("unchecked")
	protected String toJsonString(Object obj) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(obj, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
}