package com.toto.crawling.fnguide;

import com.toto.crawling.CrawlingInterface;
import org.jsoup.nodes.Document;

import java.util.List;

/**
 * FnGuide Crawling.
 */
public class FnGuideCrawling implements CrawlingInterface {
    @Override
    public List<?> initCrawlingDataList() {
        // 0. crawling 대상 URI를 확보한다.
        // 1. fnguide에 접속한다.
        // 2. srim에서 사용할 기초데이터를 수집한다.
        // 3. 연도별 재무정보를 수집한다.
        return null;
    }

    @Override
    public Document connectCrawling(String crawlingUri) {
        return null;
    }



}
