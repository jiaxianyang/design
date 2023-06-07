package com.example.design.repo.dao;

import com.example.design.repo.po.PersonPo;
import com.example.design.repo.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IPersonDao {

    PersonPo selectPersonById(@Param("id") Long id);

    Long selectCount();
}
