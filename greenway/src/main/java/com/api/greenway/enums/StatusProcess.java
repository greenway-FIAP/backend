package com.api.greenway.enums;

import lombok.Getter;

@Getter
public enum StatusProcess {
    STOPPED("0"),
    IN_PROGRESS("1"),
    FINISHED("2");

    private String value;

    StatusProcess(String value) {
        this.value = value;
    }
}
