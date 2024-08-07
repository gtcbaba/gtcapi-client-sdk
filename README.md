<div align=center>
  <img src="http://101.34.252.118:9000/img/gif/jisoo.gif" loop=true/>
</div>

<h2 align="center">Gong-API 接口调用SDK</h2>

### 😀快速开始😀
#### 1.引入依赖坐标
```xml
<dependency>
    <groupId>io.github.gtcbaba</groupId>
    <artifactId>gtcapi-client-sdk</artifactId>
    <version>0.0.2</version>
</dependency>
```
#### 2.前往Gong-API开放平台获取开发者秘钥
链接：<a target="_blank" href="http://101.34.252.118/account/center">个人中心</a>
#### 3.通过配置文件注入对象
```yml
# 配置如下
gtcapi:
  client:
    access-key: xxx
    secret-key: xxx
```
#### 4.得到Manager对象
```java
@Resource
private GtcApiManager gtcApiManager;
```
#### 5.调用接口
- 示例：手机号所属地区
```java
PhoneParams phoneParams = new PhoneParams();
phoneParams.setPhone("13337702413");
PhoneRequest phoneRequest = new PhoneRequest();
phoneRequest.setRequestParams(phoneParams);
BasicResponse phone = gtcApiManager.getPhone(phoneRequest);
System.out.println(phone.getData());
```

- 更多示例和接口详见：<a target="_blank" href="http://101.34.252.118:9000/">Gong-API开发者文档</a>😋

