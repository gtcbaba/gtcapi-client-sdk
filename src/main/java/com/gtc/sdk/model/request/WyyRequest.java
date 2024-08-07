package com.gtc.sdk.model.request;


import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class WyyRequest extends BasicRequest<Object, BasicResponse> {

    @Override
    public String getPath() {
        return "/wyy";
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
