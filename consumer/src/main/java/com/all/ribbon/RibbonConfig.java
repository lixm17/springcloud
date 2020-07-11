package com.all.ribbon;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.netflix.ribbon.RibbonClientName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 25610 on 2020/7/11.
 * config 配置
 *
 * 此类不能被@ComponentScan扫描到，如果被扫描到则改配置类就是所有服务公用的配置
 * @SpringBootApplication(scanBasePackages = "com.lexue")不可以被它扫描到
 * 是LoadBalanceConfig通过configuration导入进来的
 */
@Configuration
public class RibbonConfig
{
    @RibbonClientName
    private String name="consumer";

    @Bean
    @ConditionalOnClass
    public IClientConfig defaultClientConfigImpl(){
        DefaultClientConfigImpl config=new DefaultClientConfigImpl();
        config.loadProperties(name);
        config.set(CommonClientConfigKey.MaxAutoRetries,2);
        config.set(CommonClientConfigKey.MaxAutoRetriesNextServer,2);
        config.set(CommonClientConfigKey.ConnectTimeout,2000);
        config.set(CommonClientConfigKey.ReadTimeout,4000);
        config.set(CommonClientConfigKey.OkToRetryOnAllOperations,true);
        return config;
    }

    /**
     * 在调用之前先判定服务是否存活，默认不会进行ping操作
     * 不建议使用
     * @return
     */
//    @Bean
    public IPing iPing(){
        //这个实现类会去调用服务来判定服务是否存活
        return new PingUrl();
    }
    @Bean
    public IRule ribbonRule(){

        //线性轮询
        new RoundRobinRule();

        //可重试轮询
        new RetryRule();

        //根据运行情况来计算权重
        new WeightedResponseTimeRule();

        //过滤掉故障示例，获取请求最小的
        new BestAvailableRule();

        //随机访问
        return new RandomRule();
    }
}
