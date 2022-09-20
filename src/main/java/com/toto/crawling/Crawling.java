package com.toto.crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
/**
 * Crawling
 */
public class Crawling {
    /**
     * Crawling 페이지 접속이후, 해당 페이지의 DOM객체를 반환한다.
     * @param crawlingUri
     * @return
     */
    public Document getCrawlingDocument(String crawlingUri) {
        Connection connect = Jsoup.connect(crawlingUri);
        Document document = null;
        try {
            document = connect.get();
        } catch (IOException ioEx) {

        }
        return document;
    }

    public String getParsingData(Document document,String... targetNodes) {
        StringBuilder sbf = new StringBuilder();

        Elements parentElement = document.select(targetNodes[0]);

        for(Element childElement :parentElement) {

            for(Element targetElement :parentElement.select(targetNodes[1])) {
                String text = "";

                if (targetNodes.length > 2) {

                } else {
                    text = targetElement.text();

                }

                sbf.append(text).append("|");
            }
            sbf.append(System.getProperty("line.separator"));
        }

        return sbf.toString();
    }
}
