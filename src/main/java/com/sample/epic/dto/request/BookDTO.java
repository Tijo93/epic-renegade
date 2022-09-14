package com.sample.epic.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookDTO {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;
}
