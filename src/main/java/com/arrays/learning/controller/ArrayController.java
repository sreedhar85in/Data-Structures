package com.arrays.learning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arrays.learning.service.ArrayService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class ArrayController {
	
	@Autowired
	ArrayService arrayService;
	
	@PostMapping("/reverseString")
	public ResponseEntity reverseString(@ApiParam(example = "Sreedhar")@RequestParam String name) {
		
		String name2 = arrayService.reverse(name);
		
		return new ResponseEntity(name2,HttpStatus.OK);
	}

}
