package com.yong.lr;


import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    EurekaClient eurekaClient;

    @GetMapping("/apps")
    public Applications getSvcs(){
        return eurekaClient.getApplications();
    }
}
