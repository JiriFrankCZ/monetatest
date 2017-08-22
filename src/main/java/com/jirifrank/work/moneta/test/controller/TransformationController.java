package com.jirifrank.work.moneta.test.controller;

import com.jirifrank.work.moneta.test.dto.TransformationRequest;
import com.jirifrank.work.moneta.test.dto.TransformationResponse;
import com.jirifrank.work.moneta.test.service.TransformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
public class TransformationController {

	@Autowired
	private TransformationService transformationService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<TransformationResponse> transformation(@RequestBody @Valid  TransformationRequest request, BindingResult bindingResult) {
		log.debug("REST/Transformation({}) [GET] call started.", request.getValue());

		if(bindingResult.hasErrors()){
			log.warn("Bad input provided.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}else {
			String transformationResult = transformationService.transform(request.getValue());

			log.debug("REST/Transformation [GET] call ended ({}).", transformationResult);
			return ResponseEntity.status(HttpStatus.OK).body(new TransformationResponse(transformationResult));
		}
	}
}