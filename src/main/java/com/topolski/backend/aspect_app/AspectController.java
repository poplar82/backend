package com.topolski.backend.aspect_app;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspect")
public class AspectController {
    private final SendMail sendMail;
    @Autowired
    public AspectController(final SendMail sendMail) {
        this.sendMail = sendMail;
    }
    @CrossOrigin
    @GetMapping("/{newAddress}")
    public ResponseEntity<Response> getAspect(@PathVariable final String newAddress) {
        sendMail.setAddress(newAddress);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
