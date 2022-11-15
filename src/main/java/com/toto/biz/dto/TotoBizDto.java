package com.toto.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Data
@EntityScan
public class TotoBizDto {
    @NotBlank(message = "이름")
    private String name;
    @NotNull(message = "나이")
    private Integer age;
}
