package com.aniikiki.abms.dao.system;

import com.aniikiki.abms.dto.system.RoleDto;
import com.aniikiki.abms.entity.system.RoleMenuRelEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMenuRelDao {

    List<RoleMenuRelEntity> selectByCriteria(@Param("roleId") String roleId, @Param("menuId") String menuId);

    int updateStatusByCriteria(@Param("roleId") String roleId, @Param("menuId") String menuId, @Param("status") String status, @Param("updateUser") String updateUser, @Param("updateTime") String updateTime);

    int insertBatch(RoleDto dto);

}
