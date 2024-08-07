package com.gtc.sdk.model.request;


import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class EnglishRequest extends BasicRequest<Object, BasicResponse> {

    @Override
    public String getPath() {
        return "/english";
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
