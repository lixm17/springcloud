package com.lexue.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * Created by 25610 on 2020/7/11.
 */
@Service
public class TicketServiceImpl implements TicketService {
    /**
     * 开启服务隔离功能
     */
    @HystrixCommand
    @Override
    public void getTicket() {
        System.out.println("---------ticket---------");
    }
}
