package com.gtc.sdk.model.request;


import com.gtc.sdk.model.request.params.PhoneParams;
import com.gtc.sdk.model.request.params.WeatherParams;
import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class PhoneRequest extends BasicRequest<PhoneParams, BasicResponse> {

    @Override
    public String getPath() {
        return "/phone";
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
