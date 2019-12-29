package com.lieeil.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: <br>
 *
 * @author li
 * @date 2019-12-24 16:33
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        return "啊" + "23456453";
    }

}
