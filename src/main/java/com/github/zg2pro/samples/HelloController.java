package com.github.zg2pro.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private MapUpdatesService service;

    @RequestMapping("/hello")
    public String hello() {
        return (String) service.getMap().get("123");
    }

    @RequestMapping("/update")
    public void update(@RequestParam(name = "val") String val) {
        service.getMap().put("123", val);
    }
}
