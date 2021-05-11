package com.aniikiki.abms.dao.system;

import com.aniikiki.abms.dto.system.UserDto;
import com.aniikiki.abms.entity.system.UserRoleRelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleRelDao {

    List<UserRoleRelEntity> selectByCriteria(@Param("userId") String userId, @Param("roleId") String roleId);

    int updateStatusByCriteria(@Param("userId") String userId, @Param("roleId") String roleId, @Param("status") String status, @Param("updateUser") String updateUser, @Param("updateTime") String updateTime);

    int insertBatch(UserDto dto);

}
