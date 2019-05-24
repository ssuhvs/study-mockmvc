package com.lostvip.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: study-mockmvc
 * @Description: MockController控制层
 * @Author: Sun
 * @Create: 2019-04-22 11:17
 * @Version: 1.0
 **/
@RestController
@RequestMapping(value = "/test")
public class TestController {


    @RequestMapping(value = "/index")
    public YbfUserExtend getAuthUser(YbfUserExtend u) {
        return u;
    }
}
