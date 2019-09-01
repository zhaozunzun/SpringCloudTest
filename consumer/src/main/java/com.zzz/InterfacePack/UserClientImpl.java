package com.zzz.InterfacePack;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;


@Component
public class UserClientImpl implements UserClient {
    @Override
    public String getaa(String id) {
        return "降级了";
    }

    @Override
    public String getbb(String id, String name) {
        return "降级了";
    }
}
