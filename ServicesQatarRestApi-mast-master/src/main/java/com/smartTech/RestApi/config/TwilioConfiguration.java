package com.smartTech.RestApi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;





@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {
    private String accountSid="AC95516ef06e46bcf0cf57ff38d0e94140";
    private String authToken="AC95516ef06e46bcf0cf57ff38d0e94140";
    private String trialNumber="+16075248596";
    public TwilioConfiguration() {
    }
    public String getAccountSid() {
        return accountSid;
    }
    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }
    public String getAuthToken() {
        return authToken;
    }
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
    public String getTrialNumber() {
        return trialNumber;
    }
    public void setTrialNumber(String trialNumber) {
        this.trialNumber = trialNumber;
    }
}