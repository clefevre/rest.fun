package com.clefevre.rest.fun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {

	@Autowired
	protected TestRestTemplate testRestTemplate; // available with Spring Web MVC

	@LocalServerPort
	protected Integer port;

	@Test
	void contextLoads() {
	}
}
