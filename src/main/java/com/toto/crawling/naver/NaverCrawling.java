package com.toto.crawling.naver;

import com.toto.crawling.Crawling;
import com.toto.crawling.CrawlingInterface;
import com.toto.crawling.CrawlingDto;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverCrawling implements CrawlingInterface {

    @Autowired
    private Crawling crawling;

    @Override
    public List<?> initCrawlingDataList() {

        // - 초기에는 단건으로 하지만, 이후 다건의 crawling 정보가 들어올 수 있다. 2022.09.19
        String stockList = "https://finance.naver.com/sise/sise_market_sum.nhn?&page=1";
        Document crawlingDocument = connectCrawling(stockList);

        String thead = getStockHeader(crawlingDocument);
        System.out.println(thead);

        // String tbody = getStockList(crawlingDocument);
        String tbody = crawling.getCrawlingDataParsing(dummyDataSetting());
        System.out.println(tbody);

        return null;
    }

    public String getNaverFinanceDataList(CrawlingDto paramDto) {
        String stockList = "https://finance.naver.com/sise/sise_market_sum.nhn?&page=1";
        Document crawlingDocument = connectCrawling(stockList);
        String thead = getStockHeader(crawlingDocument);
        System.out.println(thead);

        String tbody = crawling.getCrawlingDataParsing(paramDto);
        System.out.println(tbody);

        StringBuilder sbf = new StringBuilder();
        sbf.append(thead);
        sbf.append(System.getProperty("line.separator"));
        sbf.append(tbody);
        return sbf.toString();
    }


    public String getStockHeader(Document document) {
        StringBuilder sbf = new StringBuilder();
        /*
        Elements stockTableBody = document.select("table.type_2 thead tr");
        for (Element element : stockTableBody) {
            for (Element td : element.select("th")) {
                sb.append(td.text());
                sb.append("   ");
            }
            break;
        }*/
        String[] targetNodes = {"table.type_2 thead tr", "th"};
        return sbf.append(crawling.getParsingData(document, targetNodes)).toString();
    }

    public String getStockList(Document document) {
        Elements stockTableBody = document.select("table.type_2 tbody tr");
        StringBuilder sb = new StringBuilder();
        for (Element element : stockTableBody) {
            if (element.attr("onmouseover").isEmpty()) {
                continue;
            }

            for (Element td : element.select("td")) {
                String text;
                if(td.select(".center a").attr("href").isEmpty()){
                    text = td.text();
                }else{
                    text = "https://finance.naver.com"+td.select(".center a").attr("href");
                }
                sb.append(text);
                sb.append("   ");
            }
            sb.append(System.getProperty("line.separator")); //줄바꿈
        }
        return sb.toString();
    }


    public CrawlingDto dummyDataSetting() {
        /** step .1 : entrynode */
        CrawlingDto.EntryNode entryNode = CrawlingDto.EntryNode.builder()
                .tag(".center a")
                .attribute("href")
                .build();

        /** step .2 : elementNode */
        CrawlingDto.ElementNode elementNode = CrawlingDto.ElementNode.builder()
                .cTag("td")
                .cAttribute("")
                .entryNode(entryNode)
                .build();

        /** step .3 : elements Node */
        CrawlingDto crawlingVo = CrawlingDto.builder()
                .crawlingUri("https://finance.naver.com/sise/sise_market_sum.nhn?&page=1")
                .pTag("table.type_2 tbody tr")
                .pAttribute("onmouseover")
                .elementNode(elementNode)
                .build();

        return crawlingVo;
    }



    @Override
    public Document connectCrawling(String crawlingUri) {
        return crawling.getCrawlingDocument(crawlingUri);
    }


}
