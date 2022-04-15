package com.clefevre.rest.fun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class BaseIntegrationTest {

	@Autowired
	public RestTemplate restTemplate;

	@Test
	void contextLoads() {
	}
}
