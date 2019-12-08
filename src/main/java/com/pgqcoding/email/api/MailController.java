package com.pgqcoding.email.api;

import com.pgqcoding.email.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@Slf4j
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/send")
    public String sendMail(@RequestParam("to") String to){
        try {
            long start = System.currentTimeMillis();
            mailService.sendSimpleMail(to, "这是一封测试邮件", "测试邮件, 请勿回复!");
            long end = System.currentTimeMillis();
            return "响应时间：" + (end - start);
        }catch (Exception e){
            log.error("邮件发送失败. {}", e);
            return "邮件发送失败";
        }
    }
}
