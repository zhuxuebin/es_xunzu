package com.zxb.xunzu.web.controller.temp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuery on 2018/5/11.
 * https://blog.csdn.net/qq_21251983/article/details/53034425
 */
@Controller
public class AntPathMatcherController {

    @GetMapping("/index/{username:[a-b]+}")
    @ResponseBody
    public String index(@PathVariable("username") String username) {
        System.out.println("username:" + username);
        return username;
    }
}
