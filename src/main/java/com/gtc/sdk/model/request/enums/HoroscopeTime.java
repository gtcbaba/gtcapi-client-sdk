package com.gtc.sdk.model.request.enums;

public enum HoroscopeTime {

    TODAY("今天", "today"),
    NEXT_DAY("明天", "nextday"),
    WEEK("一周", "week"),
    MONTH("一个月", "month");

    private String text;
    private String value;

    HoroscopeTime(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
