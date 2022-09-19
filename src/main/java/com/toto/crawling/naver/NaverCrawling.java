package com.toto.crawling.naver;

import com.toto.crawling.Crawling;
import com.toto.crawling.CrawlingInterface;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NaverCrawling implements CrawlingInterface {

    @Autowired
    private Crawling crawling;

    @Override
    public List<?> initCrawlingDataList() {

        // - 초기에는 단건으로 하지만, 이후 다건의 crawling 정보가 들어올 수 있다. 2022.09.19
        String stockList = "https://finance.naver.com/sise/sise_market_sum.nhn?&page=1";
        Document crawlingDocument = connectCrawling(stockList);


        return null;
    }

    @Override
    public Document connectCrawling(String crawlingUri) {
        return crawling.getCrawlingDocument(crawlingUri);
    }


}
