package com.zxb.xunzu.web.controller;

import com.zxb.xunzu.common.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xuery on 2018/5/10.
 */
@Controller
public class HomeController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping(value = "/404")
    public String notFoundPage() {
        return "404";
    }

    @GetMapping(value = "/403")
    public String accessError() {
        return "403";
    }

    @GetMapping(value = "/500")
    public String internalError() {
        return "500";
    }

    @GetMapping(value = "/logout/page")
    public String logoutPage() {
        return "logout";
    }

    @GetMapping(value = "/sms/code")
    @ResponseBody
    public ApiResponse smsCode(@RequestParam("telephone") String telephone) {
        //todo xuery
        return null;
    }
}
