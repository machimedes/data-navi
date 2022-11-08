package pers.machimedes.DataNavi.controller;


import com.google.common.base.Joiner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EchoController {

    @RequestMapping("/echo")
    public void echo(HttpServletRequest request) throws Exception {
        ContentCachingRequestWrapper cachedRequest = new ContentCachingRequestWrapper(request);
        System.out.println("----- echo http request -----");
        System.out.println(cachedRequest.getMethod() + "\t" + cachedRequest.getRequestURI());
        Enumeration<String> parameterNames = cachedRequest.getParameterNames();
        List<String> parameters = new ArrayList<>();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            parameters.add(parameterName + "=" + cachedRequest.getParameter(parameterName));
        }
        System.out.println(String.join("&", parameters));
        Enumeration<String> headerNames = cachedRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + cachedRequest.getHeader(headerName));
        }
        BufferedReader reader = cachedRequest.getReader();
        String body = reader.lines().collect(Collectors.joining("\n"));
        System.out.println(body);
        System.out.println("----- echo http request -----");
    }
}