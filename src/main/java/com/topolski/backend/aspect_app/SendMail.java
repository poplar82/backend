package com.topolski.backend.aspect_app;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SendMail {
    private String address = "";
    private final JavaMailSender javaMailSender;
    @Autowired
    public SendMail(final JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void setAddress(final String address) {
        this.address = address;
    }
    @After("execution(* com.topolski.backend.aspect_app.AspectController.getAspect(String))")
    private void sendMail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("lenox82@o2.pl");
        msg.setTo(address);
        msg.setSubject("Application test");
        msg.setText("Message was successfully sent");
        javaMailSender.send(msg);
    }
}
