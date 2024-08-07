package com.gtc.sdk.model.request;

import com.gtc.sdk.model.response.BasicResponse;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CommonRequest extends BasicRequest<Object, BasicResponse> {

    private String method;
    private String path;

    @Override
    public Class<BasicResponse> getResponseClass() {
        return BasicResponse.class;
    }

}
