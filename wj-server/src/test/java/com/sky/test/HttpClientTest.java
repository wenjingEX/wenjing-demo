package com.sky.test;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@SpringBootTest
public class HttpClientTest {


    /**
     * 通过httpclient发送GET请求
     */
    @Test
    public void testGet() throws IOException {
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建请求对象
        HttpGet httpGet = new HttpGet("http://localhost:8080/user/shop/status");

        //发送请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //获取服务端返回的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("服务器返回的状态码："+statusCode);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println("服务端返回的数据为："+body);

        //关闭资源
        response.close();
        httpClient.close();


    }


    /**
     * 通过httpclient发送POST请求
     */
    @Test
    public void testPost() throws IOException, JSONException {

        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
      

        //创建请求对象
        HttpPost httpPost = new HttpPost("http://localhost:8080/admin/employee/login");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","admin");
        jsonObject.put("password","123456");


        StringEntity entity = new StringEntity(jsonObject.toString());
        //指定请求的编码方式
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        //发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);

        //解析返回结果
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("响应码为："+statusCode);

        HttpEntity entity1 = response.getEntity();


        String body = EntityUtils.toString(entity1);
        System.out.println("响应数据为："+body);

        //关闭资源
        response.close();
        httpClient.close();



    }


    @Test
    public void test(){

        System.out.println("HP:114514"+"          "+"HP:1919810");
        System.out.println("无敌喷火龙"+"          "+"热斗游侠");
        System.out.println("1:喷火   2：开摆");
        System.out.println("现在是你的回合！请选择你的技能");
        System.out.println("无敌喷火龙使用了：喷火 对热斗游侠造成了 100点伤害");

    }
}
