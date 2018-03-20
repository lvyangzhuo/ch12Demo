package com.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author Lyz
 * @time 2018-3-20 11:46
 */
@Service
public class SomeHystrixService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackSome")
    public String getSome(){
        return restTemplate.getForObject("http://some/getsome",String.class);
    }

    public String fallbackSome(){
        return "some service 故障";
    }
}
