package com.gtc.sdk;


import com.gtc.sdk.client.GtcApiClient;
import com.gtc.sdk.service.GtcApiManager;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("gtcapi.client")
@ComponentScan
public class GtcApiClientConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public GtcApiClient gtcApiClient(){
        return new GtcApiClient(accessKey, secretKey);
    }

    @Bean
    public GtcApiManager gtcApiManager(GtcApiClient gtcApiClient) {
        GtcApiManager gtcApiManager = new GtcApiManager();
        gtcApiManager.setGtcApiClient(gtcApiClient);
        return gtcApiManager;
    }
}
