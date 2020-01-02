package com.wangcc.resttemplate.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: BryantCong
 * @Date: 2019/12/19 10:12
 * @Description:
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }



    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        //禁止OkHttp的重定向操作，我们自己处理重定向
        OkHttpClient client = new OkHttpClient.Builder().followRedirects(false).build();
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory(client);

        return factory;
    }
}
