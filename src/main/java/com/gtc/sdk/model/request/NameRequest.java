package com.gtc.sdk.model.request;


import com.gtc.sdk.model.request.params.NameParams;
import com.gtc.sdk.model.request.params.WallpaperParams;
import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;


@Accessors(chain = true)
public class NameRequest extends BasicRequest<Object, BasicResponse> {

    @Override
    public String getPath() {
        return "/name";
    }


    @Override
    public Class<BasicResponse> getResponseClass() {
        return BasicResponse.class;
    }


    @Override
    public String getMethod() {
        return "GET";
    }

    public void setName(String name){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        this.setRequestParams(map);
    }
}
