package com.aniikiki.abms.service.system;

import com.aniikiki.abms.dto.system.RoleDto;
import com.aniikiki.abms.entity.system.RoleEntity;
import com.aniikiki.abms.entity.system.RoleMenuRelEntity;

import java.util.List;

public interface RoleService {

    List<RoleEntity> getRoleList(RoleDto dto, Integer pageNum, Integer pageSize);

    List<RoleEntity> getRoleList(RoleDto dto);

    RoleEntity getRoleInfo(String roleId);

    int createRole(RoleEntity role);

    int updateRole(RoleEntity role);

    List<RoleEntity> getRoleListByRoleName(String excludeRoleId, String roleName);

    List<RoleMenuRelEntity> getRoleMenuList(String roleId);

    boolean assignMenu(String roleId, String[] menuIdArr, String currentUserId);

}
