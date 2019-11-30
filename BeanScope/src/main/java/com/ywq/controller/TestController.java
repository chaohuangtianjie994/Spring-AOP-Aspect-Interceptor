package com.ywq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * created by yangwenqiang on 2019-11-30
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @RequestMapping(value = "/scopeTest", method = RequestMethod.GET)
    public String testScope(HttpServletRequest request,
                            @RequestParam(value = "name") String name) {

        return "Hello, " + name;
    }

}
