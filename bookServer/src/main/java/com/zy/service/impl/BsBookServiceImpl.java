package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zy.pojo.BsBook;
import com.zy.service.BsBookService;
import com.zy.mapper.BsBookMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;


/**
*
*/
@Service
public class BsBookServiceImpl extends ServiceImpl<BsBookMapper, BsBook>
implements BsBookService{
@Resource
BsBookMapper bsBookMapper;

    @Override
    @HystrixCommand(fallbackMethod = "LastOverMethod",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期ms
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率多少开启
    })
    public BsBook selectAllById(@Param("id") Integer id) {
        if (31 > id || id >= 60) {
            throw new  RuntimeException("....id错误,当前id是"+id);
        }
        return bsBookMapper.selectAllById(id);
    }
    //降级方法
    public BsBook LastOverMethod(@Param("id") Integer id){
        BsBook bsBook = new BsBook();
        bsBook.setTitle("请输入正确id(31-60),当前id是"+id);
        return bsBook;
    }
}
