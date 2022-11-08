package pers.machimedes.DataNavi.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.Enumeration;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/create")
    public void createSession(@RequestBody String body) throws Exception {
    }
}