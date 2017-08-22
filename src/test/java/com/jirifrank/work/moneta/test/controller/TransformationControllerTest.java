package com.jirifrank.work.moneta.test.controller;

import com.jirifrank.work.moneta.test.config.Application;
import com.jirifrank.work.moneta.test.dto.TransformationRequest;
import com.jirifrank.work.moneta.test.dto.TransformationResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;


@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = Application.class
)
public class TransformationControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void tranformationTestSuccess() throws URISyntaxException {
		final String input = "Ahoj, jak se máš?";
		final String expectedOutput = "?šÁm Es kAj ,jOha";

		ResponseEntity<TransformationResponse> responseEntity = restTemplate.postForEntity(new URI("/"), new TransformationRequest(input), TransformationResponse.class);

		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assert.assertEquals(expectedOutput, responseEntity.getBody().getValue());
	}

	@Test
	public void tranformationTestFail() throws URISyntaxException {
		ResponseEntity<TransformationResponse> responseEntity = restTemplate.postForEntity(new URI("/"), new TransformationRequest(""), TransformationResponse.class);

		Assert.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}
}