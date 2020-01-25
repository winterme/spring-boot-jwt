package com.zzq.controller;

import com.zzq.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> param = ControllerUtil.getParam(request);
        String useAgent = request.getHeader("User-Agent");

        if (param.containsKey("username") && param.containsKey("password")) {
            String token = JwtHelper.generateJWT(param.get("username"), param.get("password"), useAgent);
            response.addCookie(new Cookie("User-Token", token));
            response.setHeader("User-Token", token);
        } else {
            LoginResult.fail(response, "请输入争取的用户名和密码！");
            return;
        }

        LoginResult.successRedict(request, response, param, useAgent);

    }

    @RequestMapping("/get")
    @ResponseBody
    public Result get(HttpServletRequest request) throws IOException {
        Map<String, String> param = ControllerUtil.getParam(request);

        return Result.scuess(param);
    }

}
