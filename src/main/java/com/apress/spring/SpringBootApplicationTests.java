package com.apress.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplication;
import org.springframwork.test.context.junit4.SpringJUit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguation(classes = SpringBootApplication.class)
@WebAppConfiguration
public class SpringBootApplicationTests {
	
	@Test
	public void contextLoad() {
	}

}
