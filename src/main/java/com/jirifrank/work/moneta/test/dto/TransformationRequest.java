package com.jirifrank.work.moneta.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransformationRequest {

	@NotBlank(message = "validation.notBlank")
	private String value;
}