package com.yong.lr;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/usr/{userid}")
    public UserVo orderOfUser(@PathVariable("userid")long userid) {
        return new UserVo(userid,"",20);
    }


    @GetMapping(value = "/usrBook/{userid}")
    public Object usrBook(@PathVariable("userid")long userid) {
        return restTemplate.getForObject("http://GATEWAYSVC/orderserver/order/orderOfUser/"+userid,Object.class);
    }
}
