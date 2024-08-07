package com.gtc.sdk.client;

import lombok.Data;

@Data
public class GtcApiClient {

    private String accessKey;
    private String secretKey;

    public GtcApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }
}
