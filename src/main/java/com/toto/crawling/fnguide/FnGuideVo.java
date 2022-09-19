package com.toto.crawling.fnguide;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Fnguide crawling VO 정보
 */
@Builder
@Data
public class FnGuideVo implements Serializable {

    /** FnGuide crawling Header 정보 */
    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HeaderVo {
        private String dummy;
    }

    /** FnGuide crawling Contents 정보 */
    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContentVo {
        private String dummy;
    }

}
