package com.gtc.sdk.model.request;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gtc.sdk.model.response.BasicResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有请求DTO的模板父类
 * @param <I> DTO类型
 * @param <O> VO类型
 */
public abstract class BasicRequest<I, O extends BasicResponse> {

    //负责接收参数（参数可能有0个或多个  因此用map接收）！！！
    private Map<String, Object> requestParams = new HashMap<>();

    public abstract String getMethod();

    public abstract String getPath();

    public abstract Class<O> getResponseClass();

    @JsonAnyGetter
    public Map<String, Object> getRequestParams() {
        return requestParams;
    }

    //  为什么要定义XxxParam类？
    //1.将XxxParam类set进requestParams  可以保证requestParams中都是符合规范的参数
    //2.提供服务端用XxxParam类接收  可以保证只筛选到自己需要的参数名
    public void setRequestParams(I params) {
        this.requestParams = new Gson().fromJson(JSONUtil.toJsonStr(params), new TypeToken<Map<String, Object>>() {
        }.getType());
    }
}