package com.derek.stick.common.util.http;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.derek.stick.common.serialize.SerializableTool;
import com.google.common.base.Preconditions;

import okhttp3.*;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class HttpTinyTool {

    private static final Logger logger                   = LoggerFactory.getLogger(HttpTinyTool.class);

    private static final String EQUAL_SYMBOL             = "=";
    private static final String AND_SYMBOL               = "&";
    private static final String UPLOAD_FILE_FIELD        = "file";
    private static final String APPLICATION_JSON_UTF8    = "application/json; charset=utf-8";
    private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";

    private OkHttpClient        okHttpClientInner;

    private HttpConfiguration   configuration;

    public HttpTinyTool(HttpConfiguration configuration) {
        this.okHttpClientInner = buildOkHttpClient(configuration);
        this.configuration = configuration;
    }

    /**
     * GET 请求
     *
     * @param url 请求的地址
     * @param queryParams 请求的参数
     * @param configuration http 连接的相关配置
     * @return com.cy.dayu.common.utils.http.HttpResult
     * @since v1.0.0
     *
     * <PRE>
     * author: derek.wq
     * Date: 2018-09-11
     * </PRE>
     */
    public static HttpResult httpGet(String url, Map<String, String> queryParams, HttpConfiguration configuration) {
        OkHttpClient httpClient = buildOkHttpClient(configuration);
        Request request = buildGetRequest(url, queryParams);
        return request(httpClient, request);
    }

    private static Request buildGetRequest(String url, Map<String, String> queryParams) {
        return buildGetRequest(url, queryParams, null);
    }

    private static Request buildGetRequest(String url, Map<String, String> queryParams,
        Map<String, String> headersMap) {
        Preconditions.checkArgument(StringUtils.isNotBlank(url), "url is blank.");
        String queryParamsStr = encodingParams4Get(queryParams);
        String requestStr = url + (StringUtils.isBlank(queryParamsStr) ? "" : ("?" + queryParamsStr));

//        logger.info("HTTP-GET, request url: {}", requestStr);
        Request.Builder builder = new Request.Builder().url(requestStr);
        if (headersMap != null && !headersMap.isEmpty()) {
            builder.headers(Headers.of(headersMap));
        }
        return builder.build();
    }

    /**
     * GET 请求
     *
     * @param url
     * @param configuration
     * @return com.cy.dayu.common.utils.http.HttpResult
     * @since v1.0.0
     *
     * <PRE>
     * author: derek.wq
     * Date: 2018-09-11
     * </PRE>
     */
    public static HttpResult httpGet(String url, HttpConfiguration configuration) {
        return httpGet(url, null, configuration);
    }

    /**
     * POST 请求
     *
     * @param url
     * @param body
     * @param configuration
     * @return com.cy.dayu.common.utils.http.HttpResult
     * @since v1.0.0
     *
     * <PRE>
     * author: derek.wq
     * Date: 2018-09-11
     * </PRE>
     */
    public static HttpResult httpPost(String url, Object body, HttpConfiguration configuration) {
        Request request = buildPostRequest(url, body);
        OkHttpClient httpClient = buildOkHttpClient(configuration);
        return request(httpClient, request);
    }

    public static Request buildPostRequest(String url, Object body) {
        Preconditions.checkArgument(StringUtils.isNotBlank(url), "url is blank.");

        logger.info("HTTP-POST, url: {}, mediaType: {}, body: {}", url, APPLICATION_JSON_UTF8,
                    SerializableTool.serialize(body));

        MediaType mediaType = MediaType.parse(APPLICATION_JSON_UTF8);
        RequestBody requestBody = RequestBody.create(mediaType, SerializableTool.serialize(body));
        Request request = new Request.Builder().url(url).post(requestBody).build();
        return request;
    }

    public static Request buildUploadRequest(String url, String fileName, String filePath,
        Map<String, String> queryParams) {
        Preconditions.checkArgument(StringUtils.isNotBlank(url), "url is blank.");
        logger.info("HTTP-POST-UPLOAD, url: {}, mediaType: {}, file: {}", url, APPLICATION_JSON_UTF8, filePath);

        File file = new File(filePath);
        if (!file.exists()) {
            Preconditions.checkState(false, String.format("file %s ,path=%s not exist!", fileName, filePath));
        }
        RequestBody fileBody = RequestBody.create(MediaType.parse(APPLICATION_OCTET_STREAM), file);
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM)
                                                                   .addFormDataPart(UPLOAD_FILE_FIELD, fileName,
                                                                                    fileBody);
        queryParams.forEach((k, v) -> {
            builder.addFormDataPart(k, v);
        });
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        return request;
    }

    public static OkHttpClient buildOkHttpClient(HttpConfiguration configuration) {
        configuration = configuration == null ? new HttpConfiguration() : configuration;
        return new OkHttpClient.Builder().connectTimeout(configuration.getConnectTimeout(),
                                                         configuration.getTimeUnitType())
                                         .readTimeout(configuration.getReadTimeout(), configuration.getTimeUnitType())
                                         .writeTimeout(configuration.getWriteTimeout(), configuration.getTimeUnitType())
                                         .build();
    }

    public static HttpResult request(OkHttpClient okHttpClient, Request request) {
        HttpResult result;
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                result = HttpResult.build(response.code(), responseBody == null ? null : responseBody.string());
            } else {
                result = HttpResult.build(response.code(), response.message());
            }
        } catch (IOException e) {
            logger.error("http request occur EXCEPTION. ", e);
            result = HttpResult.buildFailure(e.getMessage());
        } finally {
            if (response != null) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    responseBody.close();
                }
            }
        }
        return result;
    }

    public static String encodingParams4Get(Map<String, String> queryParams) {
        if (queryParams == null || queryParams.isEmpty()) {
            return "";
        }
        Set<String> keys = queryParams.keySet();
        int size = queryParams.size();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append(EQUAL_SYMBOL).append(queryParams.get(key));
            if (++count < size) {
                sb.append(AND_SYMBOL);
            }
        }
        return sb.toString();
    }

    public HttpResult httpGet(String url) {
        Request request = buildGetRequest(url, null);
        return request(this.okHttpClientInner, request);
    }

    public HttpResult httpGet(String url, Map<String, String> queryParams) {
        Request request = buildGetRequest(url, queryParams);
        return request(this.okHttpClientInner, request);
    }

    public HttpResult httpGet(String url, Map<String, String> queryParams, Map<String, String> headers) {
        Request request = buildGetRequest(url, queryParams, headers);
        return request(this.okHttpClientInner, request);
    }

    public HttpResult httpPost(String url, Object body) {
        Request request = buildPostRequest(url, body);
        return request(this.okHttpClientInner, request);
    }

    public HttpResult upload(String url, String fileName, String filePath, Map<String, String> queryParams) {
        Request request = buildUploadRequest(url, fileName, filePath, queryParams);
        return request(this.okHttpClientInner, request);
    }

}
