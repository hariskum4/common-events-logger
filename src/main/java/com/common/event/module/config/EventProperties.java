package com.common.event.module.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties("event")
@EnableConfigurationProperties
@Component
public class EventProperties  {

    private String exchange;
    private String orchestrationTaskRoutingKey;
    private String subscriberTrailRoutingKey;
    private String activityTrailRoutingKey;
    private String incidentRoutingKey;
    private String milestoneOrderLogRoutingKey;
    private String milestoneActivityRoutingKey;
    private String alertRoutingKey;


}