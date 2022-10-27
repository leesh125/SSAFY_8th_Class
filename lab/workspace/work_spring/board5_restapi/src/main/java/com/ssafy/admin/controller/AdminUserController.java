package com.ssafy.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@RestController
@RequestMapping("/admin")

public class AdminUserController {
	private MemberService memberService;

	public AdminUserController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> userlist() {
		try {
			List<MemberDto> list = memberService.listMember(null);
			if(list != null  && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> userDelete(@PathVariable String userId) {
		try {
			memberService.deleteMember(userId);
			List<MemberDto> list = memberService.listMember(null);
			if(list != null  && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> userView(@PathVariable String userId) {
		try {
			MemberDto memberDto = memberService.getMember(userId);
			if(memberDto != null) {
				return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> userJoin(@RequestBody MemberDto memberDto) {
		try {
			memberService.joinMember(memberDto);
			List<MemberDto> list = memberService.listMember(null);
			if(list != null  && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> userModify(@RequestBody MemberDto memberDto) {
		System.out.println("asdf");
		try {
			memberService.modifyMember(memberDto);
			List<MemberDto> list = memberService.listMember(null);
			if(list != null  && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}


	private ResponseEntity<?> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
