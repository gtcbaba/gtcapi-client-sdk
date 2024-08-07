package com.gtc.sdk.model.request;


import com.gtc.sdk.model.request.params.WeatherParams;
import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class WeatherRequest extends BasicRequest<WeatherParams, BasicResponse> {

    @Override
    public String getPath() {
        return "/weather";
    }


    @Override
    public Class<BasicResponse> getResponseClass() {
        return BasicResponse.class;
    }


    @Override
    public String getMethod() {
        return "GET";
    }
}
