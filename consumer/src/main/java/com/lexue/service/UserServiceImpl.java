package com.lexue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 25610 on 2020/7/3.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final String SERVICE_NAME="producer";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getUser() {

        String forObject = restTemplate.getForObject("http://"+SERVICE_NAME+"/getUser", String.class);

        return forObject;
    }
}
