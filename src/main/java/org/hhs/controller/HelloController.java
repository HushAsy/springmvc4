package org.hhs.controller;

import org.hhs.vo.Person;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("json")
    @ResponseBody
    public Object getObj(){
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 10; i++){
            Person person = new Person();
            person.setAge(String.valueOf(i));
            person.setName("name"+i);
            list.add(person);
        }
        return list;
    }
}
