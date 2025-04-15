package com.common.event.module.utility;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "event", name="enabled", havingValue = "true")
public class EventUtils {

}
