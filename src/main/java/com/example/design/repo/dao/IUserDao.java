package com.example.design.repo.dao;

import com.example.design.repo.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface IUserDao {

    int insert(@Param("user") UserPo userPo);

    UserPo selectUserByUserId(@Param("userId") Long userId);

    Long selectMinId();

    List<Long> selectRangeId(@Param("minId") Long minId, @Param("maxId") Long maxId);

    UserPo selectUserById(@Param("id") Long id);

    Long selectCount();
}
