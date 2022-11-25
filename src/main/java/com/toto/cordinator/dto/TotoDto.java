package com.toto.cordinator.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotoDto {
	@NotBlank(message = "이름은 필수 입력 입니다.") private String name;
	@NotBlank(message = "EMAIL은 필수 입력 입니다.") private String email;
	
	
	
}
