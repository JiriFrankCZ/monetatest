package com.jirifrank.work.moneta.test.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class TransformationService {

	private static final Pattern SERACH_PATTERN = Pattern.compile("[aeiou]");

	/**
	 *
	 * Normalizes String, then revers characters order and perform replacement
	 * of aeiou characters in all forms with uppercase and other with lowercase variants
	 *
	 * @param value
	 * @return transformed value or "" if blank
	 */
	public String transform(String value){
		log.debug("Transformation method called. [{}]", value);

		// if blank immediately return
		if(StringUtils.isBlank(value)){
			return StringUtils.EMPTY;
		}

		// strip whitespaces
		value = StringUtils.normalizeSpace(value);

		// reverse order
		value = StringUtils.reverse(value).toLowerCase();

		// make lowercase and transform to array
		char[] outputArray = value.toCharArray();

		// match all occurences of SEARCH_PATTERN
		Matcher matcher = SERACH_PATTERN.matcher(StringUtils.stripAccents(value));

		// itterate and replace with uppercase
		while(matcher.find()){
			outputArray[matcher.start()] = value.substring(matcher.start(), matcher.end()).toUpperCase().charAt(0);
		}

		log.debug("Transformation method returned. [{}]", outputArray);

		// build string from array
		return new String(outputArray);
	}
}