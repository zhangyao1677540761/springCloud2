package com.zy.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zy.feignDao.BookServerFeign;
import com.zy.pojo.BsBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @学习小结
 */
@Service
public class BookServerFeignService {
    @Autowired
    BookServerFeign BookServerFeign;


    public BsBook getBook(Integer id) {
        BsBook oneBook = BookServerFeign.getOneBook(id);
        return oneBook;
    }
}
