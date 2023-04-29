package com.ssd.blog.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class ResponseValidateService {

	public ResponseEntity<?> validatePost(BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			Map<String, String> validateMap = new HashMap<String, String>();

			for (FieldError error : bindingResult.getFieldErrors()) {

				validateMap.put(error.getField(), error.getDefaultMessage());

			}

			return new ResponseEntity<Map<String, String>>(validateMap, HttpStatus.BAD_REQUEST);

		}
		return null;
	}
}