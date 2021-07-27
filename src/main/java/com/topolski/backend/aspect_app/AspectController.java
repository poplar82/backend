package com.topolski.backend.aspect_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aspect")
public class AspectController {
    SendMail sendMail;
    public AspectController(SendMail sendMail) {
        this.sendMail = sendMail;
    }
    @CrossOrigin
    @GetMapping("/aspect/{newAddress}")
    public ResponseEntity getAspect(@PathVariable String newAddress){
        sendMail.setAddress(newAddress);
        return new ResponseEntity(HttpStatus.OK);
    }
}
