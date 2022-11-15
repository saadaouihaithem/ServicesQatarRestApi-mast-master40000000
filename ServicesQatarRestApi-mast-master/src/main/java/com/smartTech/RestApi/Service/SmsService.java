package com.smartTech.RestApi.Service;


import com.smartTech.RestApi.constant.SmsSender;
import com.smartTech.RestApi.constant.TwilioSmsSender;
import com.smartTech.RestApi.dto.SmsRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
@org.springframework.stereotype.Service


public class SmsService {
    private final SmsSender smsSender;
    @Autowired
    public SmsService(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }
    public void sendSms(SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}