package com.toto.coordinator.controller;

import com.toto.crawling.CrawlingDto;
import com.toto.crawling.naver.NaverCrawling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/naver")
	public String getNaverFinanceList(@RequestBody CrawlingDto paramDto) {
		String rtn = naverCrawling.getNaverFinanceDataList(paramDto);
		return rtn;

/**
		{
			"crawlingUri" : "https://finance.naver.com/sise/sise_market_sum.nhn?&page=1",
				"pTag" : "table.type_2 tbody tr",
				"pAttribute" : "onmouseover",
				"elementNode": {
			"cTag":"td",
					"cAttribute":"",
					"entryNode": {
				"tag":".center a",
						"attribute":"href"
			}
		}
		}
*/
	}



}
 