package com.yong.lr;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @LoadBalanced // 标注此注解后，RestTemplate就具有了客户端负载均衡能力
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
