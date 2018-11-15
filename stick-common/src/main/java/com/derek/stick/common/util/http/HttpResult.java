package com.derek.stick.common.util.http;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class HttpResult {

    private int    code;
    private String content;

    private HttpResult(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public static HttpResult build(int code, String content) {
        return new HttpResult(code, content);
    }

    public static HttpResult buildFailure(String errMsg) {
        return new HttpResult(-1, errMsg);
    }

    public boolean isSuccessful() {
        return code >= 200 && code < 300;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }

}
