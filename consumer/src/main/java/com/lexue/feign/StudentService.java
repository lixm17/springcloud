package com.lexue.feign;

import com.lexue.vo.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 25610 on 2020/7/14.
 * feign客户端，没有默认降级方法
 * name = "student",path = "/feign"
 */
@FeignClient(name = "student",path = "/feign",fallbackFactory = StudentServiceFallbackFactory.class)
public interface StudentService {

    @GetMapping("/student/getAll")
    String getAll();

    @PostMapping("/student/save")
    String save(@RequestBody Student student);

    @GetMapping("/student/getOneByid")
    String getOneByid(@RequestParam("id") Integer id);

}
