package com.zzz.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class producerController {
    @RequestMapping("/{id}")
    public String getStringTest(@PathVariable String id){
        System.out.println("访问8087");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "ID 为"+id;
    }

    @RequestMapping("/param")
    public String getStringparam(@RequestParam("id")String id, @RequestParam("name")String name){
        System.out.println("访问8087");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "ID 为"+id +"-------------name "+name;
    }
}
