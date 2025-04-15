package com.common.event.module.rabbitmq;

import com.common.event.module.config.EventProperties;
import com.common.event.module.model.Event;
import com.common.event.module.model.EventType;
import com.common.event.module.utility.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(prefix = "event", name = "enabled", havingValue = "true")
public class EventProducer {

    private final RabbitTemplate rabbitTemplate;
    private final EventProperties eventProperties;

    @Autowired
    public EventProducer(RabbitTemplate rabbitTemplate, EventProperties eventProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.eventProperties = eventProperties;
    }

    public void deliverSdpEvent(Event event) throws InterruptedException {
        try {
            List<String> routingKeys = determineRoutingKeys(event);
            for (String routingKey : routingKeys) {
                rabbitTemplate.convertAndSend(eventProperties.getExchange(), routingKey, event);
            }
        } catch (Exception e) {

        }
    }

    private List<String> determineRoutingKeys(Event event) {
        List<String> routingKeys = new ArrayList<>();

        if (event.getType() == EventType.SUSCRIBER_LOG_TYPE) {
            routingKeys.add(eventProperties.getActivityTrailRoutingKey());
            routingKeys.add(eventProperties.getSubscriberTrailRoutingKey());
        } else if (event.getType() == EventType.ORCHESTRATION_TASK_OR_BPMN_TYPE) {
            routingKeys.add(eventProperties.getOrchestrationTaskRoutingKey());
        } else if (event.getTitle() != null && event.getTitle().contains(Constants.INCIDENT)) {
            routingKeys.add(eventProperties.getIncidentRoutingKey());
        } else if (event.getType() == EventType.MILESTONE_TYPE) {
            routingKeys.add(eventProperties.getMilestoneActivityRoutingKey());
            routingKeys.add(eventProperties.getMilestoneOrderLogRoutingKey());
        }
        return routingKeys;
    }
}
