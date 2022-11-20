package com.zy.controller;

import com.zy.pojo.BsBook;
import com.zy.service.BsBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @学习小结
 */
@RestController
public class BookController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private BsBookService bsBookService;


    @RequestMapping("/book/{id}")
    public BsBook getOneBook(@PathVariable("id") Integer id ){
        BsBook bsBook = bsBookService.selectAllById(id);
        return bsBook;
    }

    @RequestMapping("/port")
    public String getPort(){
        return port;
    }

}
