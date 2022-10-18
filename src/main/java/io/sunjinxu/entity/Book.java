package io.sunjinxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedHashMap;

@Data
@AllArgsConstructor
public class Book {
    private String id;
    private String name;
    private String author;

}
