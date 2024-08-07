package com.gtc.sdk.model.request;


import com.gtc.sdk.model.request.params.HoroscopeParams;
import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class HoroscopeRequest extends BasicRequest<HoroscopeParams, BasicResponse> {

    @Override
    public String getPath() {
        return "/horoscope";
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
