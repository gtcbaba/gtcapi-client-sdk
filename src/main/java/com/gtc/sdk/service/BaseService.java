package com.gtc.sdk.service;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.gtc.sdk.client.GtcApiClient;
import com.gtc.sdk.exception.ApiException;
import com.gtc.sdk.exception.ErrorCode;
import com.gtc.sdk.exception.ErrorResponse;
import com.gtc.sdk.model.request.BasicRequest;
import com.gtc.sdk.model.response.BasicResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.gtc.sdk.utils.SignUtil.genSign;


@Slf4j
@Data
public abstract class BaseService {

    private GtcApiClient gtcApiClient;

    private static final String gatewayHost = "http://localhost:8090/api";


    public <I, O extends BasicResponse> O request(BasicRequest<I, O> request) throws ApiException {
        if (gtcApiClient == null || StringUtils.isAnyBlank(gtcApiClient.getAccessKey(), gtcApiClient.getSecretKey())) {
            throw new ApiException(ErrorCode.NO_AUTH_ERROR, "请先配置密钥AccessKey/SecretKey");
        }
        O rsp;
        try {
            Class<O> clazz = request.getResponseClass();
            rsp = clazz.newInstance();
            HttpResponse httpResponse = doRequest(request);
            //获得来自服务接口的响应
            String body = httpResponse.body();
            Map<String, Object> data = new HashMap<>();
                //如果服务接口错误返回  则只提取返回的错误信息中的code和message部分
            if (httpResponse.getStatus() != 200) {
                ErrorResponse errorResponse = JSONUtil.toBean(body, ErrorResponse.class);
                data.put("code", errorResponse.getCode());
                data.put("errorMessage", errorResponse.getMessage());
            } else {
                //如果服务接口正确返回
                try {
                    // 将返回的数据封装成BasicResponse的data类型
                    data = new Gson().fromJson(body, new TypeToken<Map<String, Object>>() {
                    }.getType());
                } catch (JsonSyntaxException e) {
                    // 解析失败，将body作为普通字符串处理
                    data.put("content", body);
                }
            }
            rsp.setData(data);
            return rsp;
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
    }

    /**
     * 执行请求
     */
    private <I, O extends BasicResponse> HttpResponse doRequest(BasicRequest<I, O> request) throws ApiException {
        if (ObjectUtils.isEmpty(request)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求参数错误");
        }
        String path = request.getPath().trim();
        String method = request.getMethod().trim().toUpperCase();
        if (StringUtils.isBlank(path)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求路径不存在");
        }
        if (ObjectUtils.isEmpty(method)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求方法不存在");
        }
        if (path.startsWith(gatewayHost)) {
            path = path.substring(gatewayHost.length());
        }
        log.info("请求方法：{}，请求路径：{}，请求参数：{}", method, path, request.getRequestParams());
        try {
            HttpRequest httpRequest;
            switch (method) {
                case "GET": {
                    //将request中的requestParams中的各个参数拼接在?后  用&连接
                    httpRequest = HttpRequest.get(joinGetRequest(request, path));
                    break;
                }
                case "POST": {
                    httpRequest = HttpRequest.post(gatewayHost + path);
                    break;
                }
                default: {
                    throw new ApiException(ErrorCode.OPERATION_ERROR, "不支持该请求");
                }
            }
            return httpRequest.addHeaders(getHeaders(JSONUtil.toJsonStr(request), gtcApiClient)).
                    body(JSONUtil.toJsonStr(request.getRequestParams())).
                    execute();
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
    }


    /**
     * 拼接Get请求
     */
    private <I, O extends BasicResponse> String joinGetRequest(BasicRequest<I, O> request, String path) {
        StringBuilder urlBuilder = new StringBuilder(gatewayHost);
        // urlBuilder最后是/结尾且path以/开头的情况下，去掉urlBuilder结尾的/
        if (urlBuilder.toString().endsWith("/") && path.startsWith("/")) {
            urlBuilder.setLength(urlBuilder.length() - 1);
        }
        urlBuilder.append(path);
        if (!request.getRequestParams().isEmpty()) {
            urlBuilder.append("?");
            for (Map.Entry<String, Object> entry : request.getRequestParams().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                urlBuilder.append(key).append("=").append(value).append("&");
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }
        log.info("GET请求路径：{}", urlBuilder);
        return urlBuilder.toString();
    }


    private Map<String, String> getHeaders(String body, GtcApiClient gtcApiClient) {
        Map<String, String> hashMap = new HashMap<>(5);
        hashMap.put("accessKey", gtcApiClient.getAccessKey());
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        String encodedBody = SecureUtil.md5(body);
        hashMap.put("body", encodedBody);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(encodedBody, gtcApiClient.getSecretKey()));
        return hashMap;
    }


















    public <I, O extends BasicResponse> O request(@RequestPart(value = "file") MultipartFile multipartFile, BasicRequest<I, O> request) throws ApiException {
        if (gtcApiClient == null || StringUtils.isAnyBlank(gtcApiClient.getAccessKey(), gtcApiClient.getSecretKey())) {
            throw new ApiException(ErrorCode.NO_AUTH_ERROR, "请先配置密钥AccessKey/SecretKey");
        }
        O rsp;
        try {
            Class<O> clazz = request.getResponseClass();
            rsp = clazz.newInstance();
            HttpResponse httpResponse = doRequest(multipartFile,request);
            //获得来自服务接口的响应
            String body = httpResponse.body();
            Map<String, Object> data = new HashMap<>();
            //如果服务接口错误返回  则只提取返回的错误信息中的code和message部分
            if (httpResponse.getStatus() != 200) {
                ErrorResponse errorResponse = JSONUtil.toBean(body, ErrorResponse.class);
                data.put("code", errorResponse.getCode());
                data.put("errorMessage", errorResponse.getMessage());
            } else {
                //如果服务接口正确返回
                try {
                    // 将返回的数据封装成BasicResponse的data类型
                    data = new Gson().fromJson(body, new TypeToken<Map<String, Object>>() {
                    }.getType());
                } catch (JsonSyntaxException e) {
                    // 解析失败，将body作为普通字符串处理
                    data.put("content", body);
                }
            }
            rsp.setData(data);
            return rsp;
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
    }

    private <I, O extends BasicResponse> HttpResponse doRequest(@RequestPart(value = "file") MultipartFile multipartFile, BasicRequest<I, O> request) throws ApiException {
        if (ObjectUtils.isEmpty(request)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求参数错误");
        }
        String path = request.getPath().trim();
        String method = request.getMethod().trim().toUpperCase();
        if (StringUtils.isBlank(path)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求路径不存在");
        }
        if (ObjectUtils.isEmpty(method)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求方法不存在");
        }
        if (path.startsWith(gatewayHost)) {
            path = path.substring(gatewayHost.length());
        }
        log.info("请求方法：{}，请求路径：{}，请求参数：{}", method, path, request.getRequestParams());
        try {
            HttpRequest httpRequest;
            switch (method) {
                case "GET": {
                    //将request中的requestParams中的各个参数拼接在?后  用&连接
                    httpRequest = HttpRequest.get(joinGetRequest(request, path));
                    break;
                }
                case "POST": {
                    httpRequest = HttpRequest.post(gatewayHost + path);
                    break;
                }
                default: {
                    throw new ApiException(ErrorCode.OPERATION_ERROR, "不支持该请求");
                }
            }
            Map<String, Object> data = request.getRequestParams();
            data.put("file",transferToFile(multipartFile));
            return httpRequest.addHeaders(getHeaders(JSONUtil.toJsonStr(request), gtcApiClient)).
                    form(data).contentType("multipart/form-data").
                    execute();
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
    }

    public File transferToFile(MultipartFile multipartFile) {
        //选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
        File file = null;
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            String fileName = originalFilename.substring(0,originalFilename.lastIndexOf("."));
            //获取文件后缀
            String prefix = originalFilename.substring(originalFilename.lastIndexOf("."));
            file = File.createTempFile(fileName, prefix);    //创建临时文件
            multipartFile.transferTo(file);
            //删除
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
