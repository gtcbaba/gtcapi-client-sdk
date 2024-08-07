package com.gtc.sdk.model.request.enums;

public enum HoroscopeType {
    ARIES("白羊座", "aries"),
    TAURUS("金牛座", "taurus"),
    GEMINI("双子星座", "gemini"),
    CANCER("巨蟹座", "cancer"),
    LEO("狮子座", "leo"),
    VIRGO("处女座", "virgo"),
    LIBRA("天秤座", "libra"),
    SCORPIO("天蝎座", "scorpio"),
    SAGITTARIUS("人马座", "sagittarius"),
    CAPRICORN("摩羯座", "capricorn"),
    AQUARIUS("水瓶座", "aquarius"),
    PISCES("双鱼座", "pisces");

    private String text;
    private String value;

    HoroscopeType(String text, String value) {
        this.text =text;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
