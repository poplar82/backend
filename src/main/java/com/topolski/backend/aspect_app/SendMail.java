package com.topolski.backend.aspect_app;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SendMail {
    private String address = "";
    private JavaMailSender javaMailSender;

    public SendMail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String adress) {
        this.address = adress;
    }

    @After("execution(* com.topolski.backend.aspect_app.AspectController.getAspect(String))")
    private void sendMail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("lenox82@o2.pl");
        msg.setTo(address);
        msg.setSubject("Test aplikacji");
        msg.setText("Udało się wysłać wiadomość");
        javaMailSender.send(msg);
    }
}
