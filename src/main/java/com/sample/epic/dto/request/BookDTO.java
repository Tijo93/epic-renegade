package com.sample.epic.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BookDTO {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;
}
