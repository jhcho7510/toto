package com.toto.coordinator.controller;

import com.toto.crawling.naver.NaverCrawling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TotoController {

	@Autowired
	private NaverCrawling naverCrawling;

	@GetMapping("/toto")
	public String toto() {
		naverCrawling.initCrawlingDataList();
		return "Toto Getin";
	}
}
 