package com.toto.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * <pre>
 * Filename : TotoError.java
 * Class : TotoError
 * Comment : TotoError 정보
 * History : 2022. 11. 14. P179352, ver 1.0.0 처음 작성
 * </pre>
 * @version 1.0.0
 * @author P179352
 * @since 2022. 11. 14.
 * @see “”
 *
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotoError {
	private String fieldName;
	private String errorMessage;
}
