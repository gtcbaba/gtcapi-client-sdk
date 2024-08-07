package com.gtc.sdk.model.request;


import com.gtc.sdk.model.request.params.AvatarParams;
import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class AvatarRequest extends BasicRequest<AvatarParams, BasicResponse> {

    @Override
    public String getPath() {
        return "/avatar";
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
