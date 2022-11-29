package com.ssafy.whereismyhome.controller;

import java.net.URI;

import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.dto.InterestDto;
import com.ssafy.whereismyhome.service.InterestService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/interest")
public class InterestController {

	private final InterestService interestService;
	
	@PostMapping
	protected ResponseEntity<?> register(@RequestBody InterestDto interest){
		boolean res = interestService.registerInterest(interest);
		
		if(res) {
			return ResponseEntity.created(URI.create("/interest/" + interest.getUserId())).build();
		}else {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@Delete("/{no}")
	protected ResponseEntity<?> delete(@PathVariable int no){
		InterestDto interest = interestService.getInterest(no);
		
		if(interest != null) {
			boolean res = interestService.deleteInterest(no);
			if(res) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.internalServerError().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
