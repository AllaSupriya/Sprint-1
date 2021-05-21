package com.ec.onlineplantnursery.web;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {

	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : "+LocalDateTime.now();
	}
}
