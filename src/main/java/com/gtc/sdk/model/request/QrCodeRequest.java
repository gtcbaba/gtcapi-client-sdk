package com.gtc.sdk.model.request;


import com.gtc.sdk.model.request.params.QrCodeParams;
import com.gtc.sdk.model.response.BasicResponse;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class QrCodeRequest extends BasicRequest<QrCodeParams, BasicResponse> {

    @Override
    public String getPath() {
        return "/qrcode";
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
