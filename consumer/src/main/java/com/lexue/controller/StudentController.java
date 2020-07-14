package com.lexue.controller;

import com.lexue.feign.StudentService;
import com.lexue.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 25610 on 2020/7/14.
 * feign服务端
 * 接口定义url必须和feign客户端相同
 */
@RestController
@Slf4j
public class StudentController  implements StudentService{
    @Autowired
    private StudentService studentService;

    @Override
    @RequestMapping("/feign/student/getAll")
    public String getAll() {
        return studentService.getAll();
    }

    @Override
    @RequestMapping("/feign/student/save")
    public String save(@RequestBody Student student) {
        return studentService.save(student);
    }

    /**
     * 此处RequestParam参数id必须指定
     * @param id
     * @return
     */
    @Override
    @RequestMapping("/feign/student/getOneByid")
    public String getOneByid(@RequestParam("id") Integer id) {
        return studentService.getOneByid(id);
    }
}
