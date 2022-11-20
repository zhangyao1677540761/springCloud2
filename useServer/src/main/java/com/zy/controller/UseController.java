package com.zy.controller;

import com.zy.pojo.BsBook;
import com.zy.service.BookServerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @学习小结
 */
@RestController
public class UseController {
    @Autowired
    BookServerFeignService BookServerFeignService;

    @GetMapping("/book/{id}")
    public BsBook Message(@PathVariable("id") Integer id){
        return BookServerFeignService.getBook(id);
    }

}