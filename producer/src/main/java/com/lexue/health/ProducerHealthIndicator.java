package com.lexue.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 25610 on 2020/7/6.
 */
@Configuration
public class ProducerHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        //此处可以连接第三方接口，db，reids等连接是否ok
        if (true){
            return new Health.Builder(Status.UP).build();
        }else {
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
