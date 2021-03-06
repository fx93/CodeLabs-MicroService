package com.fx.microsixconsumer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MemberProfileConfiguration {

    @Autowired
    private Environment environment;

    public String getDefaultModel(){
        return environment.getProperty("vehicle.default.model");
    }

    public String getRentPeriod(){
        return environment.getProperty("member.rent.min");
    }

//    public String minRentPeriod(){
//        return environment.getProperty("member.rent.min");
//    } - bean follows naming conventions
}
