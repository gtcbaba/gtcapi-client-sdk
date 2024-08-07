package com.gtc.sdk.model.request.enums;

public enum AvatarType {
    ANIME("动漫","dm"),
    NICHE("小众", "xz"),
    BOY("男生", "boy"),
    GIRL("女生", "girl"),
    RECOMMEND("推荐", "recommend");


    private String text;
    private String value;

    AvatarType(String text, String value) {
        this.text =text;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
