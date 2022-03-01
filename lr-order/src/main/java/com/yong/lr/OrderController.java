package com.yong.lr;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    Map<Integer,List<OrderVo>> userOrderMap = new HashMap<>();

    @PostConstruct
    private void init(){
        userOrderMap.put(8001,new ArrayList<>());
        userOrderMap.put(8002,new ArrayList<>());

        userOrderMap.get(8001).add(new OrderVo(1,8001,"毕业",49));
        userOrderMap.get(8001).add(new OrderVo(2,8001,"谎言",39));
        userOrderMap.get(8001).add(new OrderVo(3,8001,"红手指",30));
        userOrderMap.get(8002).add(new OrderVo(4,2,"平凡的世界",60));
        userOrderMap.get(8002).add(new OrderVo(5,2,"人生",20));
    }

    @Value("${server.port}")
    private Integer port;

    @GetMapping(value = "/orderOfUser/{userid}")
    public List<OrderVo> orderOfUser(@PathVariable("userid")Integer userid) {
        log.info("orderOfUser.userid=" + userid);
        if(!port.equals(userid)){
            throw new RuntimeException("xxxxx: this server can only view port="+port);
        }
        return userOrderMap.get(userid);
    }

}
