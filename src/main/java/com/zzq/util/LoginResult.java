package com.zzq.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

public class LoginResult {

    public static void fail(HttpServletResponse response, String msg) throws IOException {
        response.sendRedirect("/static/login.html?msg=" + URLEncoder.encode(msg, "utf-8"));
    }

    public static void success(HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.html");
    }

    public static void success(HttpServletResponse response, Map<String, String> map) throws IOException {
        StringBuffer sb = new StringBuffer();
        for (String s : map.keySet()) {
            sb.append(s).append("=").append(map.get(s)).append("&");
        }

        response.sendRedirect("/index.html?&" + sb);
    }

    public static void successRedict(HttpServletRequest request, HttpServletResponse response, Map<String, String> param, String useAgent) throws IOException {
        response.setHeader("User-Agent", useAgent);

        String referer = request.getHeader("Referer");
        if (StringUtils.isNotBlank(referer)) {
            String key = "backurl=";
            if (referer.contains("backurl")) {
                response.sendRedirect(referer.substring(referer.indexOf(key) + key.length()));
            }
        } else {
            response.sendRedirect("/index.html");
        }
    }

}
