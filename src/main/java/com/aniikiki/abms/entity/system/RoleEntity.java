package com.aniikiki.abms.entity.system;

import com.aniikiki.abms.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "角色实体类")
public class RoleEntity extends BaseEntity {

    @ApiModelProperty("主键")
    private String roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleDesc;

}
