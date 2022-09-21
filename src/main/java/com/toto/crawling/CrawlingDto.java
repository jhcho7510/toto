package com.toto.crawling;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
public class CrawlingDto {
    /** crawling 대상 웹페이지 URI */
    private String crawlingUri;

    /** crawling 시작점의 태그 */
    private String pTag;

    /** crawling 시작점 태그가 포함하는 속성 */
    private String pAttribute;

    /** 열단위 접근 태그 */
    private ElementNode elementNode;

    /**
     * 행단위 접근 태그 - ex) td, th
     */
    @Builder
    @Data
    public static class ElementNode {
        private String cTag;
        private String cAttribute;
        private EntryNode entryNode;


    }
    /**
     * 텍스트값을 추출을 위해 접근하는 태그 및 속성
     */
    @Builder
    @Data
    public static class EntryNode {
        private String tag;
        private String attribute;
    }

}
