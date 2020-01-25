package com.zzq.controller;

import com.zzq.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/getUserInfo")
    public Result getUserInfo() {
        return Result.scuess("你好，我是张子强");
    }

}
