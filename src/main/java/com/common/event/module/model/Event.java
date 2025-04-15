package com.common.event.module.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event  {

    private String eventId;
    private EventType baseType;
    private EventType type;
    private String description;
    private String title;
    private Instant eventDate;
    private int priority;
    private List<EventAttribute> correlations;
    private List<EventAttribute> properties;
    private ReportingSystem reportingSystem;

}
