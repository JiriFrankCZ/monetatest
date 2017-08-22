package com.jirifrank.work.moneta.test.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransformationServiceTest {

	private TransformationService transformationService;

	@Before
	public void setUp() {
		transformationService = new TransformationService();
	}

	@Test
	public void transformTest() {
		transform("Ahoj, jak se máš?", "?šÁm Es kAj ,jOha");
		transform("Je     mi   fajn.", ".njAf Im Ej");
	}

	private void transform(String input, String output){
		final String result = transformationService.transform(input);

		Assert.assertEquals(output, result);
	}
}