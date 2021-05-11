package com.aniikiki.abms.entity.system;

import com.aniikiki.abms.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "角色菜单关联实体类")
public class RoleMenuRelEntity extends BaseEntity {

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("菜单")
    private MenuEntity menu;

}
