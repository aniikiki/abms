package com.aniikiki.abms.dao.system;

import com.aniikiki.abms.dto.system.RoleDto;
import com.aniikiki.abms.entity.system.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleDao {

    List<RoleEntity> selectByCriteria(RoleDto dto);

    RoleEntity selectByPrimaryKey(@Param("roleId") String roleId);

    int insert(RoleEntity role);

    int updateByPrimaryKeySelective(RoleEntity role);

}
