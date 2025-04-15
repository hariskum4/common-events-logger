package com.common.event.module.model;

import lombok.Getter;

@Getter
public enum EventType {

    MILESTONE_TYPE("Milestone"),
    MILESTONE_BASE_EVENT_TYPE("ActivityLifeCycle"),
    SUSCRIBER_LOG_TYPE("SubscriberLog"),
    SUSCRIBER_LOG_BASE_EVENT_TYPE("Alert"),
    USER_ACTION_TYPE("UserEvent"),
    USER_ACTION_BASE_EVENT_TYPE("ActivityLog"),
    ORCHESTRATION_TASK_OR_BPMN_TYPE("BPMNTask"),
    ORCHESTRATION_TASK_OR_BPMN_BASE_EVENT_TYPE("ProcessLifeCycle"),
    ACTIVATION_TYPE("ActivationEvent"),
    ACTIVATION_BASE_EVENT_TYPE("ActivityTrail"),
    ALERT_TYPE("Alert"),
    ALERT_BASE_EVENT_TYPE("Alert");



    private final String name;

    EventType(String name) {
        this.name = name;
    }
}