package com.toto.cordinator.controller;

import com.sun.istack.NotNull;
import com.toto.biz.dto.TotoBizDto;
import com.toto.common.exception.TotoException;
import com.toto.cordinator.dto.TotoDto;
import com.toto.crawling.CrawlingDto;
import com.toto.crawling.naver.NaverCrawling;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/toto")
public class TotoController {

	// @Autowired
	// private NaverCrawling naverCrawling;

	//@NotNull
	//private NaverCrawling  naverCrawling;

	private final NaverCrawling naverCrawling;

	@PostMapping("/valid")
	public ResponseEntity<String> addToto(@Valid @RequestBody TotoDto dto) {
		System.out.println("11111111111111111");
		return ResponseEntity.ok("Toto is valid");
	}
	@PostMapping("/set/valid")
	public ResponseEntity<String> getToto(@Valid @RequestBody TotoDto dto) {
		System.out.println("11111111111111111----");
		return ResponseEntity.ok("None");
	}

	/**
	 * Naver Crawling 소스를 변경하였음.
	 * @return
	 */
	@GetMapping("/toto")
	public String toto() {
		naverCrawling.initCrawlingDataList();
		return "Toto Getin";
	}

	@PostMapping("/naver")
	public String getNaverFinanceList(@RequestBody CrawlingDto paramDto) {
		log.info("naver paramDto : ",paramDto);
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

	@GetMapping("/toto-exception")
	public String exceptionTest() throws Exception {
		throw new TotoException("invoke Toto Exception");
	}

	@GetMapping("/toto-exception-2")
	public String exceptionTest2() throws Exception {
		throw new ArithmeticException("숫자유형이 부적합합니다.");
	}

	@PostMapping("/validation")
	public TotoBizDto valid(@Valid @RequestBody TotoBizDto paramDto) {
		return paramDto;
	}

}
 