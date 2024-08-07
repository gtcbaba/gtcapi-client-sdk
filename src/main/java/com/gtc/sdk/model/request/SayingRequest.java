package com.gtc.sdk.model.request;


import com.gtc.sdk.model.request.params.WeatherParams;
import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class SayingRequest extends BasicRequest<Object, BasicResponse> {

    @Override
    public String getPath() {
        return "/loveTalk";
    }

    @Override
    public String getMethod() {
        return "GET";
    }

    @Override
    public Class<BasicResponse> getResponseClass() {
        return BasicResponse.class;
    }



}
