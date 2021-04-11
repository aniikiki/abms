package com.aniikiki.abms.dao;

import com.aniikiki.abms.dto.UserDto;
import com.aniikiki.abms.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    List<UserEntity> selectByCriteria(UserDto dto);

    int updateByPrimaryKeySelective(UserDto dto);

}
