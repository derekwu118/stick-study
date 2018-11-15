package com.derek.stick.common;

import com.derek.stick.common.serialize.SerializableTool;
import com.derek.stick.common.util.http.HttpConfiguration;
import com.derek.stick.common.util.http.HttpResult;
import com.derek.stick.common.util.http.HttpTinyTool;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class HttpTinyToolTest {

    public static void main(String[] args) {
        HttpTinyTool httpTinyTool = new HttpTinyTool(new HttpConfiguration());
        HttpResult rs = httpTinyTool.httpGet("http://www.baidu.com");
        System.out.println(SerializableTool.serializeFormat(rs));
    }
}
