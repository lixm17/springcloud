package com.lexue.config;

import com.all.ribbon.RibbonConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 25610 on 2020/7/11.
 * 针对当前服务的ribbon配置
 */
@Configuration
@RibbonClients(value = {@RibbonClient(name="consumer",configuration = RibbonConfig.class)})
public class LoadBalanceConfig {

}
