package com.toto.crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

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

    public String getParsingData(Document document, String... nodes) {
        StringBuilder sbf = new StringBuilder();

        Elements parentElement = document.select(nodes[0]);
        for(Element targetElement :parentElement.select(nodes[1])) {
            String text = "";
            text = targetElement.text();
            sbf.append(text).append("|");
        }
        sbf.append(System.getProperty("line.separator"));
        return sbf.toString();

    }

    public String getCrawlingDataParsing(CrawlingDto crawlingVo) {
        StringBuilder sbf = new StringBuilder();

        String pTag = crawlingVo.getPTag();
        String pAttribute = crawlingVo.getPAttribute();

        Document document = getCrawlingDocument(crawlingVo.getCrawlingUri());
        Elements elements = document.select(pTag);

        int idx = 0;
        for(Element pElement :elements) {
            if(pElement.attr(pAttribute).isEmpty()) continue;

            CrawlingDto.ElementNode elementNodeVo = crawlingVo.getElementNode();

            for(Element cElement :pElement.select(elementNodeVo.getCTag())) {
                CrawlingDto.EntryNode entryNode =  elementNodeVo.getEntryNode();
                String txt = "";
                if(cElement.select(entryNode.getTag()).isEmpty()) {
                    txt = cElement.text();
                }
                else {
                    txt = cElement.select(entryNode.getTag()).attr(entryNode.getAttribute());
                }
                sbf.append(txt).append(" ");
            }
            sbf.append(System.getProperty("line.separator"));

        }



        return sbf.toString();
    }

}
