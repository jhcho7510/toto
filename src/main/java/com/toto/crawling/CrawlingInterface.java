package com.toto.crawling;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Toto Crawling 인터페이스
 */
@Component
public interface CrawlingInterface {
    /** 0. 크롤링 및 관련데이터를 반환한다. */
    public List<?> initCrawlingDataList();

    /** 1. 크롤링대상에 접속하여, DOM 객체를 반환한다.  */
    public Document connectCrawling(String crawlingUri);

}
