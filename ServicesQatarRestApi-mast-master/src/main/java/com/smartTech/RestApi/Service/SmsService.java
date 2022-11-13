package com.smartTech.RestApi.Service;

import com.smartTech.RestApi.Model.SmsPojo;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component
public class SmsService {


    private final String ACCOUNT_SID ="ACc132980e139f674b0d63b76ff8b84572";

    private final String AUTH_TOKEN = "1a9ef729681e80e5fc8c5f1ddbca2ef1";

    private final String FROM_NUMBER = "+19016573886";

    public void send(SmsPojo sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }

}