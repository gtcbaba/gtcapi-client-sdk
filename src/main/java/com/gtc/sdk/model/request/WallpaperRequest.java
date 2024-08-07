package com.gtc.sdk.model.request;


import com.gtc.sdk.model.request.params.WallpaperParams;
import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class WallpaperRequest extends BasicRequest<WallpaperParams, BasicResponse> {

    @Override
    public String getPath() {
        return "/wallpaper";
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
