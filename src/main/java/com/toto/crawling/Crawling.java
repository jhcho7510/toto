package com.toto.crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Crawling {
    public Document getCrawlingDocument(String crawlingUri) {
        Connection connect = Jsoup.connect(crawlingUri);
        Document document = null;
        try {
            document = connect.get();
        } catch (IOException ioEx) {

        }
        return document;

    }
}
