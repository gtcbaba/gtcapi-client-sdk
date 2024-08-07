package com.gtc.sdk.model.request;


import com.gtc.sdk.model.request.params.BIParams;
import com.gtc.sdk.model.request.params.WallpaperParams;
import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class BIRequest extends BasicRequest<BIParams, BasicResponse> {

    @Override
    public String getPath() {
        return "/BI";
    }


    @Override
    public Class<BasicResponse> getResponseClass() {
        return BasicResponse.class;
    }


    @Override
    public String getMethod() {
        return "POST";
    }
}
