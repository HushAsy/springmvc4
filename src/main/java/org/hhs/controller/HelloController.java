package org.hhs.controller;

import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hewater on 2017/9/2.
 */
@Controller
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("index")
    public String hello(HttpServletResponse response){
        try {
            PrintWriter pw = response.getWriter();
            pw.write("welcome to my world!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "jsp/hello";
    }
}
