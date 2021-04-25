package com.aniikiki.abms.service.system;

import com.aniikiki.abms.dto.system.RoleDto;
import com.aniikiki.abms.entity.system.RoleEntity;

import java.util.List;

public interface RoleService {

    List<RoleEntity> getRoleList(RoleDto dto, Integer pageNum, Integer pageSize);

    RoleEntity getRoleInfo(String roleId);

    int createRole(RoleEntity role);

    int updateRole(RoleEntity role);

    List<RoleEntity> getRoleListByRoleName(String excludeRoleId, String roleName);

}
