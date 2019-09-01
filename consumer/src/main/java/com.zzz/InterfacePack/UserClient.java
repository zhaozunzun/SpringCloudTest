package com.zzz.InterfacePack;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="producerService" ,fallback = UserClientImpl.class)
public interface UserClient {
    @GetMapping("/test/{id}")
    public String getaa(@PathVariable("id") String id);

    @GetMapping("/test/param")
    public String getbb(@RequestParam("id") String id, @RequestParam("name") String name);
}
