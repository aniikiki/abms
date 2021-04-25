package com.aniikiki.abms.dao.system;

import com.aniikiki.abms.dto.system.UserDto;
import com.aniikiki.abms.entity.system.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    List<UserEntity> selectByCriteria(UserDto dto);

    int insert(UserEntity user);

    int updateByPrimaryKeySelective(UserEntity user);

    UserEntity selectByPrimaryKey(@Param("userId") String userId);



}
