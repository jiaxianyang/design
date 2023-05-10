package com.example.design.spring.event.listener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApplicationEvent(topicKey = "notification.topic.create")
public class CreateUserHandleEvent extends CommonEvent{
    private Long id;
    private Long msgId;
    private String eventMsg;
}