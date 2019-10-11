package com.springboot.verifycode.controller;

import com.springboot.verifycode.common.VerifyCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by hyhong Administrator on 2019/10/11.
 */

@RestController
public class TestController {
    @PostMapping("/doLogin")
    public String login() {

        return "success";
    }

    @GetMapping("/vercode")
    public void code(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        String text = vc.getText();
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("register_code", text);
        VerifyCode.output(image, httpServletResponse.getOutputStream());


    }
}
