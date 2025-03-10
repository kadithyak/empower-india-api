package com.andhraempower.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StatusChangePublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public StatusChangePublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishStatusChange(StatusChangeEvent statusChangeEvent){
      log.debug("Received status change event {}", statusChangeEvent);
      if(statusChangeEvent != null) {
          applicationEventPublisher.publishEvent(statusChangeEvent);
      }
    }
}
