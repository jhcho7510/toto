package com.toto.crawling.fnguide;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Fnguide crawling DTO
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FnGuideDto {
    /** 1. FnGuide Header 정보 */
    List<FnGuideVo.HeaderVo> fnGuideHeaderList;


    /** 2. FnGuide Content 정보 */
    List<FnGuideVo.ContentVo> fnGuideContentList;


}
