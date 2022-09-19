package com.toto.crawling.naver;

import com.toto.crawling.CrawlingInterface;
import org.jsoup.nodes.Document;

import java.util.List;

public class NaverCrawling implements CrawlingInterface {

    @Override
    public List<?> initCrawlingDataList() {
        String stockList = "https://finance.naver.com/sise/sise_market_sum.nhn?&page=1";
        Document crawlingDocument = connectCrawling(stockList);



        return null;
    }

    @Override
    public Document connectCrawling(String crawlingUri) {
        return null;
    }


}
