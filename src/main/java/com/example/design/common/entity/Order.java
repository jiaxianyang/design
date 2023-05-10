package com.example.design.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Slf4j
public class Order {

    /**
     * id 自增主键
     */
    private Long id;

    private int status;

    /**
     * jitTime jit截单时间
     */
    private LocalDateTime jitTime;

    /**
     * receiveTime 接单时间
     */
    private LocalDateTime receiveTime;

}
