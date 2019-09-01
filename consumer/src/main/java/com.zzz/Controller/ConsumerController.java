package com.zzz.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.zzz.InterfacePack.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cosumer")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserClient userClient;

    @RequestMapping("/{id}")
    public String getId(@PathVariable String id){
//        List<ServiceInstance> list = discoveryClient.getInstances("producerService");
//        ServiceInstance serviceInstance = list.get(0);
//        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/test/"+id;
//        System.out.println("url----------------------"+url);
//        String id1 = restTemplate.getForObject(url,String.class);
        System.out.println("----------进入客户端");
        String id1 =userClient.getaa(id);
        return id1;
    }

    @HystrixCommand(fallbackMethod = "backMethod")
    @RequestMapping("/LoadBalanced/{id}")
    public String getId1(@PathVariable String id){
        String url = "http://producerService/test/"+id;
        System.out.println("url----------------------"+url);
        String id1 = restTemplate.getForObject(url,String.class);
        return "服务端返回ID为"+id1;
    }


//    @HystrixCommand(fallbackMethod = "backMethod")
    @RequestMapping("/Feign/{id}")
    public String getId2(@PathVariable String id){
        System.out.println("----------进入客户端");
        String id1 =userClient.getbb(id,"张三");
        return "-----------"+id1;

    }

    public String backMethod(String id){
        return "服务超时";
    }

}
