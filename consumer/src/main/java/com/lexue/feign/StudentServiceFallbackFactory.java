package com.lexue.feign;

import com.lexue.vo.Student;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * Created by 25610 on 2020/7/14.
 * Feign的服务降级
 * 当调用客户端出现异常时，则会调用下面的create方法，最终会调到客户端对应方法上
 */
@Slf4j
@Component
public class StudentServiceFallbackFactory implements FallbackFactory<StudentService>{
    @Override
    public StudentService create(Throwable throwable) {
        if (throwable==null){
            return null;
        }
        String message = throwable.getMessage();
        log.info("exception :"+message);

        return new StudentService() {
            @Override
            public String getAll() {
                log.info("exception,getAll()"+message);
                return message;
            }

            @Override
            public String save(Student student) {
                log.info("exception,save()"+message);
                return message;
            }

            @Override
            public String getOneByid(Integer id) {
                log.info("exception,getOneByid()"+message);
                return message;
            }
        };
    }
}
