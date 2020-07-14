package com.lexue.feign;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by 25610 on 2020/7/14.
 * feign的异常过滤器，是对我们异常的再封装，把feign的异常信息封装成我们系统里面的通用异常对象
 * 过滤器把异常方法返回后，feign前面定义的降级方法就会调到create方法
 */
@Configuration
public class FeignErrMessageFilter {

    @Bean
    public ErrorDecoder errorDecoder(){
        return new FeignErrorDecoder();
    }

    class FeignErrorDecoder implements ErrorDecoder{
        private Logger logger= LoggerFactory.getLogger(FeignErrorDecoder.class);

        @Override
        public Exception decode(String s, Response response) {
            RuntimeException runtimeException=null;
            try {
                String retMsg=Util.toString(response.body().asReader());
                logger.info(retMsg);

                runtimeException=new RuntimeException(retMsg);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return runtimeException;
        }
    }
}
