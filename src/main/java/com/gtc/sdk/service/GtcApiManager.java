package com.gtc.sdk.service;

import com.gtc.sdk.exception.ApiException;
import com.gtc.sdk.model.request.*;
import com.gtc.sdk.model.response.BasicResponse;
import org.springframework.web.multipart.MultipartFile;

public class GtcApiManager extends BaseService{

    public BasicResponse getSaying() throws ApiException {
        SayingRequest request = new SayingRequest();
        return request(request);
    }


    public BasicResponse getWeatherInfo(WeatherRequest request) throws ApiException {
        return request(request);
    }

    public BasicResponse getWallpaper(WallpaperRequest request) throws ApiException {
        return request(request);
    }

    public BasicResponse getBI(MultipartFile file, BIRequest request) throws ApiException {
        return request(file, request);
    }

    public BasicResponse getName(NameRequest request) throws ApiException {
        return request(request);
    }

    public BasicResponse getEnglish() throws ApiException {
        EnglishRequest request = new EnglishRequest();
        return request(request);
    }

    public BasicResponse getWyy() throws ApiException {
        WyyRequest request = new WyyRequest();
        return request(request);
    }

    public BasicResponse getPhone(PhoneRequest request) throws ApiException {
        return request(request);
    }

    public BasicResponse getDouyin() throws ApiException {
        DouyinRequest douyinRequest = new DouyinRequest();
        return request(douyinRequest);
    }

    public BasicResponse getQrCode(QrCodeRequest qrCodeRequest) throws ApiException {
        return request(qrCodeRequest);
    }

    public BasicResponse getHoroscope(HoroscopeRequest horoscopeRequest) throws ApiException {
        return request(horoscopeRequest);
    }

    public BasicResponse getAvatar(AvatarRequest avatarRequest) throws ApiException {
        return request(avatarRequest);
    }
}
