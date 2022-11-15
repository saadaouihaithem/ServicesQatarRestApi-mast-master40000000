package com.smartTech.RestApi.Controller;


import com.smartTech.RestApi.Service.SmsService;
import com.smartTech.RestApi.dto.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/sms")
public class SmsController {
    private final SmsService smsService;
    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }
    @PostMapping
    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest);
    }
}