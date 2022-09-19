package com.toto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TotoController {

	@GetMapping("/toto")
	public String toto() {
		return "Toto Getin";
	}
}
 