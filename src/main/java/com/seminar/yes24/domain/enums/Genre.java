package com.seminar.yes24.domain.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genre {
    CONCERT("concert"),
    MUSICAL("musical"),
    CLASSIC("classic"),
    EXHIBIT("exhibit"),

    ;
    private final String genreName;
}
