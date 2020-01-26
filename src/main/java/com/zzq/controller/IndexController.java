package com.zzq.controller;

import com.zzq.util.JwtHelper;
import com.zzq.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class IndexController {

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public Result getUserInfo(HttpServletRequest request) throws IOException {

        return Result.scuess(JwtHelper.getUserInfo(request));
    }

}
