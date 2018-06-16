package com.oauth2.example.oauthserver.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {

	@GetMapping
	public String hello(){
		return "Hello World";
	}
	
	@GetMapping("/principal")
	public Principal user(Principal principal){
		return principal;
	}
}
