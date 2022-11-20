package com.zy.feignDao;

import com.zy.pojo.BsBook;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @学习小结
 */
@FeignClient("bookServer")
public interface BookServerFeign {

    @RequestMapping("/book/{id}")//必须和被调用的controller保持一致
    public BsBook getOneBook(@PathVariable("id") Integer id );
}
