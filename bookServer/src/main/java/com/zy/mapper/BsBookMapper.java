package com.zy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.pojo.BsBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @Entity com.zy.domain.BsBook
*/
@Mapper
public interface BsBookMapper extends BaseMapper<BsBook> {

        BsBook selectAllById(@Param("id") Integer id);

}
