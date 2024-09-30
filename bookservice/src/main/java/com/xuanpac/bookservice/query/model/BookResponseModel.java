package com.xuanpac.bookservice.query.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseModel {
    private String id;

    private String name;
    private String author;
    private Boolean isReady;
}
