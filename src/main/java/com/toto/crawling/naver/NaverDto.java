package com.toto.crawling.naver;

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
public class NaverDto {
    /** 1. Naver Header 정보 */
    List<NaverVo.HeaderVo> naverHeaderList;

    /** 2. Naver Content 정보 */
    List<NaverVo.ContentVo> naverContentList;


}
